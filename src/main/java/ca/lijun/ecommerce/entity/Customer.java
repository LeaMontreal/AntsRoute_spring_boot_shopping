package ca.lijun.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @Column(name="email")
  private String email;

  // with cascade = CascadeType.ALL, when customer record is created, orders record will be created
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//  @OneToMany(mappedBy = "customer")
  private Set<Order> orders = new HashSet<>();

  public void add(Order order) {

    if (order != null) {

      if (orders == null) {
        orders = new HashSet<>();
      }

      orders.add(order);
      order.setCustomer(this);
    }
  }

}