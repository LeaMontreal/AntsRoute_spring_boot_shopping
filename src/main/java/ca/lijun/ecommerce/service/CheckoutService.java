package ca.lijun.ecommerce.service;

import ca.lijun.ecommerce.dto.Purchase;
import ca.lijun.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
  PurchaseResponse placeOrder(Purchase purchase);
}
