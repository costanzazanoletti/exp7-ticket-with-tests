package trains;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket {

  private final static BigDecimal PRICE_PER_KM = new BigDecimal("0.21");
  private final static BigDecimal DISCOUNT_OVER_65 = new BigDecimal("0.40");
  private final static BigDecimal DISCOUNT_UNDER_AGE = new BigDecimal("0.20");
  private final int km;
  private final int passengerAge;

  public Ticket(int km, int passengerAge) throws IllegalArgumentException {
    if (km <= 0) {
      throw new IllegalArgumentException("km must be > 0");
    }
    if (passengerAge < 0) {
      throw new IllegalArgumentException("passenger age must be > 0");
    }
    this.km = km;
    this.passengerAge = passengerAge;
  }

  public BigDecimal getPrice() {
    BigDecimal kmBD = new BigDecimal(km);
    BigDecimal basePrice = kmBD.multiply(PRICE_PER_KM);
    if (passengerAge < 18) {
      return scaleAndRound(basePrice.subtract(basePrice.multiply(DISCOUNT_UNDER_AGE)));
    } else if (passengerAge >= 65) {
      return scaleAndRound(basePrice.subtract(basePrice.multiply(DISCOUNT_OVER_65)));
    } else {
      return scaleAndRound(basePrice);
    }
  }

  private BigDecimal scaleAndRound(BigDecimal value) {
    return value.setScale(2, RoundingMode.HALF_EVEN);
  }
}
