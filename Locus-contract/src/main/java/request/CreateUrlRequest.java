package request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateUrlRequest implements Serializable {

    private String requestId;

    private String longUrl;

    private String description;


}
