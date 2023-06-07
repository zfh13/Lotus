package response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    public static final long SUCCESS = 200l;

    public static final long ERROR = 500l;

    public static final long BAD_REQUEST = 400l;

    private T payLoad;

    private Long code;

    public <T> Response<T> getResponse(T payLoad) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS);
        response.setPayLoad(payLoad);
        return response;

    }



}
