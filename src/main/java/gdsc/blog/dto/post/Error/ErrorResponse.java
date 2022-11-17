package gdsc.blog.dto.post.Error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    public String code;
    public String message;

    @Builder
    public ErrorResponse(String code, String message){
        this.code = code;
        this.message = message;
    }


}
