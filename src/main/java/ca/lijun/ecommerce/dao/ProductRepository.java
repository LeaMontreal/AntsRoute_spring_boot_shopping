package ca.lijun.ecommerce.dao;

import ca.lijun.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
  // query method, Spring will execute a sql query
  Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
}
