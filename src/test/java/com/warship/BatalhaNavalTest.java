package com.warship;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BatalhaNavalTest {
  @Test
  public void shouldCreateBatalhaNaval() {
    BatalhaNaval batalhaNaval = new BatalhaNaval();
    assertNotNull(batalhaNaval);
  }
}
