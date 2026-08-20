package com.taoye.labor_dispatch.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;
import com.taoye.labor_dispatch.service.JobParseService;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class JobParseServiceImpl implements JobParseService {

    private final OpenAiChatModel openAiChatModel;
    private final ObjectMapper objectMapper;

    public JobParseServiceImpl(OpenAiChatModel openAiChatModel, ObjectMapper objectMapper) {
        this.openAiChatModel = openAiChatModel;
        this.objectMapper = objectMapper;
    }

    @Override
    public IntialDescriptionVo parseJobInfo(String  req) {
        return extractJobFromText(req);
    }

    /**
     * 【核心提炼方法】根据招聘原始文本提炼结构化招聘数据
     * @param rawText 原始招聘文案
     * @return 结构化对象
     */
    public IntialDescriptionVo extractJobFromText(String rawText) {
        String systemPrompt = """
                                你是招聘信息提取器。
                                输入一段招聘文案，严格输出纯JSON，不要任何解释、不要markdown、不要```标记。
                                字段说明：
                                jobName：岗位名称，没有填空字符串
                                companyName：公司名称，没有填空字符串
                                salary：薪资范围，没有填空
                                location：工作地点，多个地点用逗号分隔
                                experience：经验要求，例如：1‑3年、不限
                                education：学历，大专/本科/硕士/不限
                                duty：岗位职责，把多条职责合并成一段文本
                                requirement：任职要求，合并为一段
                                welfare：福利待遇，没有填空
                                contact：联系人
                                phone：电话
                                
                                规则：
                                1. 所有字段没有识别到就返回""，不要null
                                2. 禁止编造原文不存在信息
                                3. 只输出JSON，不要别的内容
                                """;

        String promptContent = systemPrompt + "\n【招聘原文】：\n" + rawText;
        Prompt prompt = new Prompt(new UserMessage(promptContent));
        ChatResponse resp = openAiChatModel.call(prompt);
        String aiText = resp.getResult().getOutput().getText().trim();
        // 清洗：去掉大模型偶尔输出的 ```json ``` 代码块标记
        aiText = aiText.replaceAll("^```json", "").replaceAll("```$", "").trim();
        try {
            return objectMapper.readValue(aiText, IntialDescriptionVo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("AI返回JSON解析失败:" + aiText, e);
        }
    }
}