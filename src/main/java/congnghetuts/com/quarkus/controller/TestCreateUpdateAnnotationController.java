package congnghetuts.com.quarkus.controller;

import congnghetuts.com.quarkus.service.TestCreateUpdateAnnotationService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/test_create_update_annotation")
public class TestCreateUpdateAnnotationController {

    @Inject
    TestCreateUpdateAnnotationService service;

    @POST
    public void create(String description) {
        service.create(description);
    }

    @Path("/{id}")
    @PUT
    public void update(@PathParam("id") Integer id, String description) {
        service.update(id, description);
    }
}
