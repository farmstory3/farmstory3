package dto.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDtoImpl implements ResponseDto{
	private String code;
	private String message;
	private String status;
}
