package congnghetuts.com.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Category extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Post> posts;
}
