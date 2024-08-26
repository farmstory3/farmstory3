package common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
	SUCCESS("200 (OK)", "SU", "Success."),
    
    // VF: Validation Failed
    VALIDATION_FAILED("400 (Bad Request)", "VF", "Validation failed."),
    
    AUTHORIZATION_FAILED("401 (Unauthorized)", "SF", "Login information mismatch."),
    
    DATABASE_ERROR("500 (Internal Server Error)", "DBE", "Database error."),
    
    DUPLICATE_EMAIL("400 (Bad Request)", "DE", "Duplicate email."),
    
    DUPLICATE_NICKNAME("400 (Bad Request)", "DN", "Duplicate nickname."),
    
    DUPLICATE_PHONE("400 (Bad Request)", "DT", "Duplicate telephone number."),

	NICKNAME_NOT_FOUND("404 (Not Found)", "NNF", "Nickname not found."),
	
	EMAIL_SEND_FAILED("404 (Not Found)","ESF","Email can't send"),
	
	TOKEN_NOT_FOUND("404 (Not Found)", "TNF", "Available token is null"),
	
	NO_MATCHING_SEARCH("404 (Not Found)", "NMS", "There are no matching search terms."),
	
	COMMENT_NOT_FOUND("404 (Not Found)", "CNF", "Comment is null"),
	
	WRITE_COMMENT_ERROR("404 (Not Found)", "WCE", "Comment is null"),
	
	BOARD_NOT_FOUND("404 (Not Found)", "BNF", "Board is null");
	
	private final String status;
    private final String code;
    private final String message;
}
