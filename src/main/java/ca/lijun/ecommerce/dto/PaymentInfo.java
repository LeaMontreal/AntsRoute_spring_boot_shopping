package ca.lijun.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentInfo {
  // why int? positive integer representing how much to charge in the smallest denomination of a currency
  // e.g. for USD, one cent (0.01 dollars) is the smallest denomination, so for USD 12.54, amount = 12.54 * 100 = 1254,
  private int amount;
  private String currency;
}
