package com.warship;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CoordenadaTest {
  @Test
  public void shouldCreateCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertNotNull(coordenada);
  }

  @Test
  public void atackedCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.atacar();
    assertNotNull(coordenada);
  }

  @Test
  public void equalsCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    Coordenada coordenada2 = new Coordenada(1, 1);
    assertNotNull(coordenada.equals(coordenada2));
  }

  @Test
  public void hashCodeCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertNotNull(coordenada.hashCode());
  }

  @Test
  public void wasAtackedCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.atacar();
    assertNotNull(coordenada.foiAtacada());
  }
}
