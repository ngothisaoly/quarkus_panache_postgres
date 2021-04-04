package congnghetuts.com.quarkus.service;

import congnghetuts.com.quarkus.model.TestCreateUpdateAnnotation;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class TestCreateUpdateAnnotationService {

    @Transactional
    public void create(String description) {
        TestCreateUpdateAnnotation testCreateUpdateAnnotation = new TestCreateUpdateAnnotation();
        testCreateUpdateAnnotation.setDescription(description);
        testCreateUpdateAnnotation.persist();
    }


    @Transactional
    public void update(Integer id, String description) {
        TestCreateUpdateAnnotation testCreateUpdateAnnotationDB = TestCreateUpdateAnnotation.findById(id);
        if (testCreateUpdateAnnotationDB != null) {
            testCreateUpdateAnnotationDB.setDescription(description);
            testCreateUpdateAnnotationDB.persist();
        }
    }
}
