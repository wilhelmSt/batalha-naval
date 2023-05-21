package com.warship;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BatalhaNavalTest {
  @Test
  public void shouldCreateBatalhaNaval() {
    BatalhaNaval batalhaNaval = new BatalhaNaval();
    assertNotNull(batalhaNaval);
  }

  @Test
  public void iniciarBatalhaNaval() {
    BatalhaNaval batalhaNaval = new BatalhaNaval();
    batalhaNaval.iniciar();
    assertNotNull(batalhaNaval);
  }
}
