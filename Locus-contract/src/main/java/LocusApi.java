import request.CreateUrlRequest;
import response.CreateUrlResponse;
import response.Response;

public interface LocusApi {

    Response<CreateUrlResponse> createUrlMap(CreateUrlRequest createUrlRequest);
}
