package com.warship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CoordenadaTest {
  @Test
  public void shouldCreateCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertNotNull(coordenada);
  }

  @Test
  public void getXCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertEquals("If coord x is equals", 1, coordenada.getX());
  }

  @Test
  public void getYCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertEquals("If coord y is equals", 1, coordenada.getY());
  }

  @Test
  public void setXCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.setX(2);
    assertEquals("If coord x is equals", 2, coordenada.getX());
  }

  @Test
  public void setYCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.setY(2);
    assertEquals("If coord y is equals", 2, coordenada.getY());
  }

  @Test
  public void wasAttackedCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    assertEquals("If was attacked", false, coordenada.foiAtacada());
  }

  @Test
  public void attackCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.atacar();
    assertEquals("If was attacked", true, coordenada.foiAtacada());
  }

  @Test
  public void equalsTrueCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    Coordenada coordenada2 = new Coordenada(1, 1);
    assertEquals("If is equals", true, coordenada.equals(coordenada2));
  }

  @Test
  public void equalsFalseCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    Coordenada coordenada2 = null;
    assertEquals("If is equals", false, coordenada.equals(coordenada2));
  }

  @Test
  public void hashCodeCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    int hash = coordenada.hashCode();
    assertEquals("If is equals", true , hash == coordenada.hashCode());
  }

  @Test
  public void wasAtackedCoordenada() {
    Coordenada coordenada = new Coordenada(1, 1);
    coordenada.atacar();
    assertNotNull(coordenada.foiAtacada());
  }
}
