package trains;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * getPrice con age < 18
 * getPrice con age >= 65
 * getPrice con age >=18 e < 65
 * costruttore con km non validi
 * costruttore con age non valida
 * */
class TicketTest {

  @Test
  @DisplayName("get price for under age")
  void getPriceUnderAge() {
    Ticket ticket = new Ticket(100, 15);
    // mi aspetto che il presso sia 16.80
    assertEquals(new BigDecimal("16.80"), ticket.getPrice());
  }

  @Test
  @DisplayName("get price for under age with decimal value")
  void getPriceUnderAgeDecimal() {
    Ticket ticket = new Ticket(33, 15);
    // mi aspetto che il presso sia 5.54
    assertEquals(new BigDecimal("5.54"), ticket.getPrice());
  }

  @Test
  @DisplayName("get price for over 65")
  void getPriceOver65() {
    Ticket ticket = new Ticket(100, 75);
    // mi aspetto che il presso sia 12,60
    assertEquals(new BigDecimal("12.60"), ticket.getPrice());
  }

  @Test
  @DisplayName("get price for over 65")
  void getPriceOver65Decimal() {
    Ticket ticket = new Ticket(33, 75);
    // mi aspetto che il presso sia 4.16
    assertEquals(new BigDecimal("4.16"), ticket.getPrice());
  }

  @Test
  @DisplayName("get price not discounted")
  void getPrice() {
    Ticket ticket = new Ticket(100, 50);
    // mi aspetto che il presso sia 21.00
    assertEquals(new BigDecimal("21.00"), ticket.getPrice());
  }

  @Test
  @DisplayName("get price not discounted with decimal value")
  void getPriceDecimal() {
    Ticket ticket = new Ticket(33, 50);
    // mi aspetto che il presso sia 6.93
    assertEquals(new BigDecimal("6.93"), ticket.getPrice());
  }

  @Test
  @DisplayName("avoid creating a Ticket with km <= 0")
  void invalidKm() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Ticket(0, 10);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Ticket(-5, 10);
    });
  }

  @Test
  @DisplayName("avoid creating a Ticket with passenger age < 0")
  void invalidPassengerAge() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Ticket(100, -10);
    });

  }
}