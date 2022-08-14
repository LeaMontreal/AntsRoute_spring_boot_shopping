package ca.lijun.ecommerce.dto;

import ca.lijun.ecommerce.entity.Address;
import ca.lijun.ecommerce.entity.Customer;
import ca.lijun.ecommerce.entity.Order;
import ca.lijun.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

  private Customer customer;
  private Address shippingAddress;
  private Address billingAddress;
  private Order order;
  private Set<OrderItem> orderItems;
}
