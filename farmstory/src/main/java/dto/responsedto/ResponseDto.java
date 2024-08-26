package dto.responsedto;

public interface ResponseDto {
	String getStatus();
    void setStatus(String status);

    String getCode();
    void setCode(String code);

    String getMessage();
    void setMessage(String message);
}
