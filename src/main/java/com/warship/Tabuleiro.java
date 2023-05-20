package com.warship;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Tabuleiro {
    private static final int TAMANHO = 10;
    private static final String[] LETRAS_COLUNAS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    private Scanner scanner;
    private static final char VAZIO = '-';
     static final char NAVIO = 'N';
    private static final char TIRO_AGUA = 'A';
    private static final char TIRO_ACERTO = 'X';

    private static final int TAMANHO_TABULEIRO = 10;
     static final int[] TAMANHOS_NAVIOS = {1, 2, 2, 3, 3, 4};



    private char[][] tabuleiro;
    private List<Navio> navios = new ArrayList<>();

    private Set<Coordenada> coordenadasAtacadas;


    public Tabuleiro() {
        this.coordenadasAtacadas = new HashSet<>();
        this.tabuleiro = new char[TAMANHO][TAMANHO];
        for (char[] linha : this.tabuleiro) {
            Arrays.fill(linha, VAZIO);
        }
    }

    public void exibir() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void exibirTabuleiroOculto() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO; j++) {
                if (tabuleiro[i][j] == NAVIO) {
                    System.out.print(VAZIO + " ");
                } else {
                    System.out.print(tabuleiro[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public boolean atacar() {
        Coordenada coordenada = lerCoordenada();


        int x = coordenada.getX();
        int y = coordenada.getY();
        switch (tabuleiro[x][y]) {
            case VAZIO:
                tabuleiro[x][y] = TIRO_AGUA;
                System.out.println("Tiro na água!");
                return false;
            case NAVIO:
                boolean parteAtingida = false;
                Navio navioAtingido = null;
                for (Navio navio : navios) {
                    if (navio.getCoordenadas().contains(coordenada)) {
                        navio.getCoordenadas().remove(coordenada);
                        parteAtingida = true;
                        if (navioAtingido == null || navioAtingido.getTamanho() < navio.getTamanho()) {
                            navioAtingido = navio;
                        }
                    }
                }
                tabuleiro[x][y] = TIRO_ACERTO;
                if (parteAtingida) {
                    System.out.println("Você acertou uma parte do navio!");
                    if (navioAtingido != null && navioAtingido.getCoordenadas().isEmpty()) {
                        System.out.println("Você afundou um navio de tamanho " + navioAtingido.getTamanho() + "!");
                    }
                }
                return true;
            default:
                System.out.println("Coordenada inválida!");
                return false;
        }
    }


    public boolean todosNaviosAfundados() {
        for (char[] linha : tabuleiro) {
            for (char celula : linha) {
                if (celula == NAVIO) {
                    return false;
                }
            }
        }
        System.out.println("Você afundou todos os navios");
        return true;
    }

    public void posicionarNavios() {
        for (int tamanho : TAMANHOS_NAVIOS) {
            Navio navio = new Navio(tamanho);
            boolean navioPosicionado = false;

            while (!navioPosicionado) {
                System.out.print("Informe a coordenada inicial do navio de tamanho " + tamanho + ": ");
                Coordenada coordenadaInicial = lerCoordenada();

                System.out.print("Informe a direção do navio (H para horizontal, V para vertical): ");
                String direcaoStr = lerString().toUpperCase();

                boolean horizontal = direcaoStr.equals("H");

                List<Coordenada> coordenadas = new ArrayList<>();
                boolean coordenadasValidas = true;

                // Gera as coordenadas do navio com base na coordenada inicial e na direção
                for (int i = 0; i < tamanho; i++) {
                    int xAtual = horizontal ? coordenadaInicial.getX() : coordenadaInicial.getX() + i;
                    int yAtual = horizontal ? coordenadaInicial.getY() + i : coordenadaInicial.getY();

                    // Verifica se as coordenadas estão dentro do tabuleiro e se estão vazias
                    if (xAtual >= 0 && xAtual < 10 && yAtual >= 0 && yAtual < 10 && tabuleiro[xAtual][yAtual] == VAZIO) {
                        // Verifica se há pelo menos uma coordenada de distância dos navios existentes
                        boolean distanciaValida = true;
                        for (Navio navioExistente : navios) {
                            for (Coordenada coordenadaExistente : navioExistente.getCoordenadas()) {
                                int distanciaX = Math.abs(xAtual - coordenadaExistente.getX());
                                int distanciaY = Math.abs(yAtual - coordenadaExistente.getY());
                                if (distanciaX <= 1 && distanciaY <= 1) {
                                    distanciaValida = false;
                                    break;
                                }
                            }
                            if (!distanciaValida) {
                                break;
                            }
                        }
                        if (distanciaValida) {
                            coordenadas.add(new Coordenada(xAtual, yAtual));
                        } else {
                            coordenadasValidas = false;
                            break;
                        }
                    } else {
                        coordenadasValidas = false;
                        break;
                    }
                }

                if (coordenadasValidas && coordenadas.size() == tamanho) {
                    // Posiciona o navio no tabuleiro e adiciona ao conjunto de navios
                    navio.getCoordenadas().addAll(coordenadas);
                    coordenadas.forEach(coordenada -> tabuleiro[coordenada.getX()][coordenada.getY()] = NAVIO);
                    navios.add(navio);
                    navioPosicionado = true;
                    exibir();
                } else {
                    System.out.println("Posição inválida para o navio. Tente novamente.");
                }
            }
        }
    }


    private Coordenada lerCoordenada() {
        while (true) {
            System.out.print("Informe uma coordenada: ");
            String coordenadaStr = lerString().toUpperCase();

            // Verifica se a coordenada tem o formato correto
            if (coordenadaStr.matches("[A-J]([1-9]|10)")) {
                int coluna = coordenadaStr.charAt(0) - 'A';
                int linha = Integer.parseInt(coordenadaStr.substring(1)) - 1;
                return new Coordenada(linha, coluna);
            } else {
                System.out.println("Coordenada inválida. Tente novamente.");
            }
        }
    }

    private String lerString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
