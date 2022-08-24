package ca.lijun.ecommerce.service;

import ca.lijun.ecommerce.dto.PaymentInfo;
import ca.lijun.ecommerce.dto.Purchase;
import ca.lijun.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
  PurchaseResponse placeOrder(Purchase purchase);
  PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
