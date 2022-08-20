package ca.lijun.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="address")
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="street")
  private String street;

  @Column(name="city")
  private String city;

  @Column(name="state")
  private String state;

  @Column(name="country")
  private String country;

  @Column(name="zip_code")
  private String zipCode;

//  @OneToMany(mappedBy = "billingAddress")
////  @JsonIgnore
//  private Set<Order> ordersByBillingAddress = new HashSet<>();

  @OneToOne
  @PrimaryKeyJoinColumn
  private Order order;
}