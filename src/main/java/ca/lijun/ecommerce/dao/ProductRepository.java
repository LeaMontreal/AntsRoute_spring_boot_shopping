package ca.lijun.ecommerce.dao;

import ca.lijun.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
//@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
  // http://localhost:8080/api/products/search/findByCategoryId?id=2
  // query method, Spring will execute a sql query
  Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

  Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
