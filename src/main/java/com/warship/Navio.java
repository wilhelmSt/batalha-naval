package com.warship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Navio {
    private int tamanho;
    private List<Coordenada> coordenadas;
    private List<Coordenada> coordenadasAtingidas;

    public Navio(int tamanho) {
        this.tamanho = tamanho;
        this.coordenadas = new ArrayList<>();
        this.coordenadasAtingidas = new ArrayList<>();
    }

    public int getTamanho() {
        return tamanho;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }



}
