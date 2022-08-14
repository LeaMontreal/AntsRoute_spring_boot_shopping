package ca.lijun.ecommerce.controller;

import ca.lijun.ecommerce.dto.Purchase;
import ca.lijun.ecommerce.dto.PurchaseResponse;
import ca.lijun.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
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
}
