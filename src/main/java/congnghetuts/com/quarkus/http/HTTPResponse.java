package congnghetuts.com.quarkus.http;

import javax.ws.rs.core.Response;

public class HTTPResponse {
    public static Response success(String message, Object data) {
        HTTPContentRespone httpContentRespone = new HTTPContentRespone();
        httpContentRespone.code = 200;
        httpContentRespone.message = message;
        httpContentRespone.data = data;
        return Response.ok(httpContentRespone).build();
    }

    public static Response badRequest(String message, Object data) {
        HTTPContentRespone httpContentRespone = new HTTPContentRespone();
        httpContentRespone.code = 400;
        httpContentRespone.message = message;
        httpContentRespone.data = data;
        return Response.status(Response.Status.BAD_REQUEST).entity(httpContentRespone).build();
    }

    public static Response serverError(String message, Object data) {
        HTTPContentRespone httpContentRespone = new HTTPContentRespone();
        httpContentRespone.code = 500;
        httpContentRespone.message = message;
        httpContentRespone.data = data;
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(httpContentRespone).build();
    }
}
