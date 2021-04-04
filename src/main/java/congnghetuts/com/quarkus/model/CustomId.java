package congnghetuts.com.quarkus.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
public class CustomId implements Serializable {
    private String name1;
    private String name2;
}
