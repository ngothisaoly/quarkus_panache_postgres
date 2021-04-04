package congnghetuts.com.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
