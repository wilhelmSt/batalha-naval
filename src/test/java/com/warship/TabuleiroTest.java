package com.warship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TabuleiroTest {
  @Test
  public void shouldCreateTabuleiro() {
    Tabuleiro tabuleiro = new Tabuleiro();
    assertNotNull(tabuleiro);
  }

  @Test
  public void todosNaviosAfundados() {
    Tabuleiro tabuleiro = new Tabuleiro();
    boolean test = tabuleiro.todosNaviosAfundados();
    assertEquals("If is true", true, test);
  }

}
