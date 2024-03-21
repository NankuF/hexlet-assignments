package exercise.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@ToString(includeFieldNames = true, onlyExplicitlyIncluded = true)
public class ProductDTO {
    @ToString.Include
    private Long id;
    private Long categoryId;
    @ToString.Include
    private String categoryName;
    @ToString.Include
    private String title;
    @ToString.Include
    private int price;
    @ToString.Include
    private double rating;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
