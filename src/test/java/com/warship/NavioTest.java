package com.warship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    assertEquals("If is equals", 4, navio.getTamanho());
  }

  @Test
  public void getCoordenadasNavio() {
    Navio navio = new Navio(1);
    List<Coordenada> test = navio.getCoordenadas();
    List<Coordenada> coordenadas = new ArrayList<>();

    assertEquals("Get coordenadas", coordenadas, test);
  }
}
