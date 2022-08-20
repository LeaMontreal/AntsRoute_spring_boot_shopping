package ca.lijun.ecommerce.dao;

import ca.lijun.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
  Address findByStreetAndCityAndStateAndCountryAndZipCode(String street, String city, String state, String country, String zipCode);
}
