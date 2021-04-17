package congnghetuts.com.quarkus.service;


import congnghetuts.com.quarkus.http.HTTPResponse;
import congnghetuts.com.quarkus.model.Person;
import congnghetuts.com.quarkus.model.PersonVO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Transactional
    public Response create(PersonVO personVO) {
        Person personDB = Person.findByEmail(personVO.getEmail());
        if (personDB != null) {
            return HTTPResponse.badRequest("The email has been existed.", personVO);
        } else {
            try {
                Person person = new Person();
                person.setName(personVO.getName());
                person.setEmail(personVO.getEmail());
                person.persist();
                return HTTPResponse.success("The person has been created successfully.", personVO);
            } catch (Exception exception) {
                return HTTPResponse.serverError("Fail to create person", personVO);
            }
        }
    }

    @Transactional
    public Response update(PersonVO personVO, Integer id) {
        Person personDB = Person.findById(id);
        if (personDB == null) {
            return HTTPResponse.badRequest("The person does not exist", personVO);
        } else {
            Person otherPerson = Person.findByEmail(personVO.getEmail());
            if (otherPerson != null && !otherPerson.getEmail().equals(personDB.getEmail()))
            {
                return HTTPResponse.badRequest("The email has been existed.", personVO);
            } else {
                try {
                    personDB.setEmail(personVO.getEmail());
                    personDB.setName(personVO.getName());
                    personDB.persist();
                    return HTTPResponse.success("The person has been updated successfully.", personVO);
                } catch (Exception exception) {
                    return HTTPResponse.serverError("Fail to update person", personVO);
                }

            }
        }
    }

    public List<Person> findAll() {
        return Person.listAll();

    }

    @Transactional
    public Response delete(Integer id) {
        Person personDB = Person.findById(id);
        if (personDB == null) {
            return HTTPResponse.badRequest("The id does not exist", id);
        }
        try {
            Person.deleteById(id);
            return HTTPResponse.success("Delete successfully", id);
        } catch (Exception ex) {
            return HTTPResponse.serverError("Fail to delete", id);
        }
    }

    public List<Person> findNameIn(List<String> names) {
        PanacheQuery<Person> personPanacheQuery = Person.find("name in :name", Parameters.with("name", names));
        return personPanacheQuery.list();
    }

    public Person findByNameAndEmail(String name, String email) {
        PanacheQuery<Person> personPanacheQuery = Person.find("name = :name and email = :email",
                Parameters.with("name", name).and("email", email)
                );
        return personPanacheQuery.firstResult();
    }
}
