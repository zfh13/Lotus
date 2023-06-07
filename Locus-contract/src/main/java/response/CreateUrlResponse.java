package response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public class CreateUrlResponse implements Serializable {

    private final String requestId;

    private final String shortUrl;

}
