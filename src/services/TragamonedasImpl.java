package services;

import model.Box;

import java.util.List;

public final class TragamonedasImpl implements Tragamonedas {
    private final Box box = new Box();
    private int saldo;

    public TragamonedasImpl(final int saldo){
        if(saldo <= 0){
            throw new IllegalArgumentException("No se puede tener saldo inicial cero o negativo");
        }
        this.saldo = saldo;
    }

    public int realizarApuesta(final int apuesta){
        // protection
        if (apuesta <= 0) {
            throw new IllegalArgumentException("El valor de la apuesta no puede ser cero o negativo");
        }

        // tengo saldo
        if (apuesta > this.saldo) {
            throw new IllegalArgumentException("No se puede apostar mas del saldo disponible");
        }

        // descuento la apuesta
        this.saldo -= apuesta;

        box.girarRuedas();

        // realizo la apuesta
        int premio = getPremio(apuesta);

        // sumo el saldo
        this.saldo += premio;

        // retorno el premio
        return premio;
    }

    public List<Character> getRuedasValues(){
        return box.getRuedasValues();
    }

    public int getSaldo(){
        return this.saldo;
    }

    private int getPremio(int apuesta){
        if (this.isValorRuedasIgualesDistintoDeCero()) {
            return apuesta * box.getRuedas().get(0).getValor();
        }

        // rule 2: count the ceros
        int zeros = Math.toIntExact(box.getRuedas().stream()
                .filter(rueda -> rueda.getValor() == 0)
                .count());

        return switch (zeros) {
            // '*'
            case 1 -> 50;
            // '**'
            case 2 -> 300;
            // '***'
            case 3 -> 500;
            // nothing
            default -> 0;
        };
    }

    private boolean isValorRuedasIgualesDistintoDeCero() {
        return box.getRuedas()
                .stream()
                .allMatch(rueda -> rueda.getValor() == box.getRuedas().get(0).getValor() && rueda.getValor() != 0);
    }
}
