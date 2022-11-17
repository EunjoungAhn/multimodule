package dev.be.moduleapi.exceptionhandler;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    //CustomException으로 에러를 직접 메세지와 함께 관리하자
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e){
      return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    //꼼곰하게 exception 처리를 하여도 발생하는 모든 애로 처리를 해주는 exception을 꼭 생성하자
    @ExceptionHandler(Exception.class)
    public CommonResponse handlerCustomException(Exception e){
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
