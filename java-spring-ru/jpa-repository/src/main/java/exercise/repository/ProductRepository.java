package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findAllByPriceBetweenOrderByPriceAsc(Integer min, Integer max);
    List<Product> findAllByPriceGreaterThanOrderByPriceAsc(Integer min);
    List<Product> findAllByPriceLessThanOrderByPriceAsc(Integer max);
    // END
}
