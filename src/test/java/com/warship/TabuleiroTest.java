package com.warship;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TabuleiroTest {
  @Test
  public void shouldCreateTabuleiro() {
    Tabuleiro tabuleiro = new Tabuleiro();
    assertNotNull(tabuleiro);
  }

  @Test
  public void shouldExibirTabuleiro() {
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.exibir();
    assertNotNull(tabuleiro);
  }

  @Test
  public void shouldExibirTabuleiroOculto() {
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.exibirTabuleiroOculto();
    assertNotNull(tabuleiro);
  }

  @Test
  public void attackTabuleiro() {
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.atacar();
    assertNotNull(tabuleiro);
  }

  @Test
  public void todosNaviosAfundados() {
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.todosNaviosAfundados();
    assertNotNull(tabuleiro);
  }

  @Test
  public void posicionarNavios() {
    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.posicionarNavios();
    assertNotNull(tabuleiro);
  }
}
