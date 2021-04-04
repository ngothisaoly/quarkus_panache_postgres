package congnghetuts.com.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
public class TestCreateUpdateAnnotation extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false)
    private Timestamp createdTime = Timestamp.from(Instant.now());

    @UpdateTimestamp
    @Column(name = "modified_time", nullable = false)
    private Timestamp modifiedTime = Timestamp.from(Instant.now());
}
