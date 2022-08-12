package ca.lijun.ecommerce.config;

import ca.lijun.ecommerce.entity.Product;
import ca.lijun.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

    // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
    config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
    config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

  }
}
