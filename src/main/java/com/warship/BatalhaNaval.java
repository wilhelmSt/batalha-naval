package com.warship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BatalhaNaval {
    private static final String[] LETRAS_COLUNAS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    private Tabuleiro tabuleiroJogador1;
    private Tabuleiro tabuleiroJogador2;
    private Scanner scanner;

    public BatalhaNaval() {
        tabuleiroJogador1 = new Tabuleiro();
        tabuleiroJogador2 = new Tabuleiro();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Jogador 1, posicione seus navios:");
        tabuleiroJogador1.posicionarNavios();
        System.out.println("Jogador 2, posicione seus navios:");
        tabuleiroJogador2.posicionarNavios();

        while (true) {
            System.out.println("Jogador 1:");
            System.out.println("Jogador 1 sua vez de atacar;");
            if (tabuleiroJogador1.todosNaviosAfundados()) {
                System.out.println("Parabéns, Jogador 2! Você ganhou!");
                break;
            }
            tabuleiroJogador2.atacar();
            tabuleiroJogador2.exibirTabuleiroOculto();

            System.out.println("Jogador 2:");
            System.out.println("Jogador 2 sua vez de atacar;");

            if (tabuleiroJogador2.todosNaviosAfundados()) {
                System.out.println("Parabéns, Jogador 1! Você ganhou!");
                break;
            }

            tabuleiroJogador1.atacar();
            tabuleiroJogador1.exibirTabuleiroOculto();


        }

        System.out.println("Tabuleiro do Jogador 1:");
        tabuleiroJogador1.exibir();
        System.out.println("Tabuleiro do Jogador 2:");
        tabuleiroJogador2.exibir();
    }

}
