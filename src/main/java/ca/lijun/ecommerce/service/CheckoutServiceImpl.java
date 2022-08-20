package ca.lijun.ecommerce.service;

import ca.lijun.ecommerce.dao.AddressRepository;
import ca.lijun.ecommerce.dao.CustomerRepository;
import ca.lijun.ecommerce.dto.Purchase;
import ca.lijun.ecommerce.dto.PurchaseResponse;
import ca.lijun.ecommerce.entity.Address;
import ca.lijun.ecommerce.entity.Customer;
import ca.lijun.ecommerce.entity.Order;
import ca.lijun.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private AddressRepository addressRepository;

//  private CustomerRepository customerRepository;
//
//  public CheckoutServiceImpl(CustomerRepository customerRepository) {
//    this.customerRepository = customerRepository;
//  }

  @Override
  @Transactional
  public PurchaseResponse placeOrder(Purchase purchase) {
    // retrieve the order info from dto
    Order order = purchase.getOrder();

    // generate tracking number
    String orderTrackingNumber = generateOrderTrackingNumber();
    order.setOrderTrackingNumber(orderTrackingNumber);

    // populate order with orderItems
    Set<OrderItem> orderItems = purchase.getOrderItems();
//    orderItems.forEach(item -> order.add(item));
    orderItems.forEach(order::add);

//    Address billingAddress = purchase.getBillingAddress();
//    Address billingAddressFromDB = addressRepository.findByStreetAndCityAndStateAndCountryAndZipCode(billingAddress.getStreet(), billingAddress.getCity(), billingAddress.getState(), billingAddress.getCountry(), billingAddress.getZipCode());
//    if (billingAddressFromDB != null){
//      billingAddress = billingAddressFromDB;
//    }
//    order.setBillingAddress(billingAddress);
//
//    Address shippingAddress = purchase.getShippingAddress();
////    Address shippingAddressFromDB = addressRepository.findByStreetAndCityAndStateAndCountryAndZipCode(shippingAddress.getStreet(), shippingAddress.getCity(), shippingAddress.getState(), shippingAddress.getCountry(), shippingAddress.getZipCode());
////    if (shippingAddressFromDB != null){
////      shippingAddress = shippingAddressFromDB;
////    }
//    order.setShippingAddress(shippingAddress);

    // populate order with billingAddress and shippingAddress
    order.setBillingAddress(purchase.getBillingAddress());
    order.setShippingAddress(purchase.getShippingAddress());

    // populate customer with order
    Customer customer = purchase.getCustomer();
    // check if this is an existing customer
    String theEmail = customer.getEmail();

    Customer customerFromDB = customerRepository.findByEmail(theEmail);

    if (customerFromDB != null) {
      // we found them ... let's assign them accordingly
      customer = customerFromDB;
    }
    customer.add(order);

    // save to the database
    customerRepository.save(customer);

    // return a response
    return new PurchaseResponse(orderTrackingNumber);
  }

  private String generateOrderTrackingNumber(){
    // generate a random UUID number (UUID version-4)
    // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
    //
    return UUID.randomUUID().toString();
  }
}