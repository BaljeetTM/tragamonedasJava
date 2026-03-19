package services;

import java.util.List;

public interface Tragamonedas {
    public int realizarApuesta(int apuesta);

    public List<Character> getRuedasValues();

    public int getSaldo();
}
