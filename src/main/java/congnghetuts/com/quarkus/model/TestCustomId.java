package congnghetuts.com.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@ApplicationScoped
@Data
public class TestCustomId extends PanacheEntityBase {
    @EmbeddedId
    private CustomId id;

    private String description;
}
