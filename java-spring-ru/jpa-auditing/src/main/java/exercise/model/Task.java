package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// BEGIN
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "description"})
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String description;

    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt;
}
// END
