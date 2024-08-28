package cc.happybday.fanfare.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorResponseCode {

    // 공통
    INVALID_INPUT_VALUE("F01", "유효하지 않은 값을 입력하였습니다.",HttpStatus.BAD_REQUEST.value()),
    ENTITY_NOT_FOUND("F02", "리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND.value()),
    INTERNAL_SERVER_ERROR("F03", "예기치 못한 서버 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR.value()),

    // Member
    DUPLICATE_MEMBER_ID("F04", "이미 존재하는 아이디입니다.", HttpStatus.BAD_REQUEST.value());


    private final String code;
    private final String message;
    private final int status;

    ErrorResponseCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
