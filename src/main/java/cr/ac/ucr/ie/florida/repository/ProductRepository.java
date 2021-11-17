package cr.ac.ucr.ie.florida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cr.ac.ucr.ie.florida.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
