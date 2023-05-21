package com.warship;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NavioTest {
  
  @Test
  public void shouldCreateNavioTam1() {
    Navio navio = new Navio(1);
    assertNotNull(navio);
  }

  @Test
  public void shouldCreateNavioTam2() {
    Navio navio = new Navio(2);
    assertNotNull(navio);
  }

  @Test
  public void shouldCreateNavioTam3() {
    Navio navio = new Navio(3);
    assertNotNull(navio);
  }

  @Test
  public void shouldCreateNavioTam4() {
    Navio navio = new Navio(4);
    assertNotNull(navio);
  }

  @Test
  public void getTamanhoNavio() {
    Navio navio = new Navio(4);
    assertNotNull(navio.getTamanho());
  }

  @Test
  public void getCoordenadasNavio() {
    Navio navio = new Navio(4);
    assertNotNull(navio.getCoordenadas());
  }
}
