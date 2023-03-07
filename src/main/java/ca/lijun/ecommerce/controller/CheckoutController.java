package ca.lijun.ecommerce.controller;

import ca.lijun.ecommerce.dto.PaymentInfo;
import ca.lijun.ecommerce.dto.Purchase;
import ca.lijun.ecommerce.dto.PurchaseResponse;
import ca.lijun.ecommerce.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {
  private Logger logger = Logger.getLogger(getClass().getName());

  @Autowired
  private CheckoutService checkoutService;

//  private CheckoutService checkoutService;
//
//  public CheckoutController(CheckoutService checkoutService) {
//    this.checkoutService = checkoutService;
//  }

  @PostMapping("/purchase")
  public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
    PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
    return purchaseResponse;
  }

  @PostMapping("/payment-intent")
  public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException{
    logger.info("paymentInfo.amount: " + paymentInfo.getAmount());

    PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);

    String paymentStr = paymentIntent.toJson();

    // send PaymentIntent to front-end (includes client_secret)
    return new ResponseEntity<>(paymentStr, HttpStatus.OK);
  }
}
