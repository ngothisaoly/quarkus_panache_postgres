package congnghetuts.com.quarkus.http;

import javax.ws.rs.core.Response;

public class HTTPResponse {
    public static Response success(String message, Object data) {
        return Response.ok(createContentResponse(200, message, data)).build();
    }

    public static Response badRequest(String message, Object data) {
        return Response.status(Response.Status.BAD_REQUEST).entity(createContentResponse(400, message, data)).build();
    }

    public static Response serverError(String message, Object data) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(createContentResponse(500, message, data)).build();
    }

    private static HTTPContentRespone createContentResponse(Integer code, String message, Object data) {
        HTTPContentRespone httpContentRespone = new HTTPContentRespone();
        httpContentRespone.code = code;
        httpContentRespone.message = message;
        httpContentRespone.data = data;
        return httpContentRespone;
    }
}
