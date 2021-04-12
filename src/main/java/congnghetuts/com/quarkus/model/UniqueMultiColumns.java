package congnghetuts.com.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(
        name="unique_multi_columns",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"name1", "name2"})
)
public class UniqueMultiColumns extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name1;
    private String name2;
}
