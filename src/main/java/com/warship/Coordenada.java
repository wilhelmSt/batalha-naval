package com.warship;
import java.util.Objects;

public class Coordenada {
    private int x;
    private int y;
    private boolean foiAtacada;

    public Coordenada(int x, int y) {
        this.x= x;
        this.y= y;
        this.foiAtacada = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordenada other = (Coordenada) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean foiAtacada() {
        return foiAtacada;
    }

    public void atacar() {
        foiAtacada = true;
    }
}
