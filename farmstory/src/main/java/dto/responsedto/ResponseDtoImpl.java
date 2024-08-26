package dto.responsedto;

import common.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDtoImpl implements ResponseDto{
	private String code;
	private String message;
	private String status;
	
	public ResponseDtoImpl(ResponseStatus responseStatus) {
		this.code = responseStatus.getCode();
		this.message = responseStatus.getMessage();
	}
}
