package com.taoye.labor_dispatch.handle;

import com.taoye.labor_dispatch.config.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验 @Valid 异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultVo<Void> validException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldError() != null
                ? e.getBindingResult().getFieldError().getDefaultMessage()
                : "参数非法";
        return ResultVo.error(400, msg);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultVo<Void> bindException(BindException e) {
        String msg = e.getBindingResult().getFieldError() != null
                ? e.getBindingResult().getFieldError().getDefaultMessage()
                : "参数绑定失败";
        return ResultVo.error(400, msg);
    }

    /**
     * AI大模型调用异常（超时、网络、密钥错误）
     */
//    @ExceptionHandler(org.springframework.ai.openai.api.common..class)
//    @ResponseStatus(HttpStatus.OK)
//    public ResultVo<Void> aiApiException(OpenAiApi. e) {
//        log.error("DeepSeek接口调用异常", e);
//        org.springframework.ai.openai.api.
//        return ResultVo.error(5001, "AI服务调用失败，请稍后重试：" + e.getMessage());
//    }

    /**
     * JSON解析异常（AI返回格式错乱）
     */
    @ExceptionHandler(com.fasterxml.jackson.core.JsonProcessingException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultVo<Void> jsonParseException(com.fasterxml.jackson.core.JsonProcessingException e) {
        log.error("AI返回JSON解析失败", e);
        return ResultVo.error(5002, "解析招聘信息失败，大模型返回格式异常");
    }

    /**
     * 通用业务运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultVo<Void> runtimeException(RuntimeException e) {
        log.error("业务异常", e);
        return ResultVo.error(5000, e.getMessage());
    }

    /**
     * 全部兜底异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultVo<Void> allException(Exception e) {
        log.error("系统未知异常", e);
        return ResultVo.error(9999, "系统繁忙，请稍后重试");
    }
}