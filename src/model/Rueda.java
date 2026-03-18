package model;

import java.util.Random;

public class Rueda {
    private static final Random RANDOM = new Random();

    private static final int MAX_VALUE = 10;

    private int valor = 0;

    public Rueda(){
        this.girarAlAzar();
    }

    public void girarAlAzar(){
        this.valor = RANDOM.nextInt(MAX_VALUE);
    }

    public int getValor(){
        return this.valor;
    }

    public char getChar(){
        return this.valor == 0 ? '*' : Character.forDigit(this.valor, 10);
    }
}
