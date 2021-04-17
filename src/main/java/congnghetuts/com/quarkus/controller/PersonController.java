package congnghetuts.com.quarkus.controller;


import congnghetuts.com.quarkus.model.Person;
import congnghetuts.com.quarkus.model.PersonVO;
import congnghetuts.com.quarkus.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    public List<Person> getAll() {
        return personService.findAll();
    }

    @POST
    @Path("/name-in")
    public List<Person> getByNameIn(List<String> names) {
        return personService.findNameIn(names);
    }

    @POST
    public Response create(PersonVO person) {
        return personService.create(person);
    }

    @PUT

    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, PersonVO personVO) {
        return personService.update(personVO, id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        return personService.delete(id);
    }
}
