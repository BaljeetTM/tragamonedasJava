package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Box {
    private final int numero_ruedas = 3;
    private final List<Rueda> ruedas;

    public Box() {
        this.ruedas = Stream
                .generate(Rueda::new)
                .limit(numero_ruedas)
                .collect(Collectors.toList());
    }

    public void girarRuedas(){
        ruedas.forEach(Rueda::girarAlAzar);
    }

    public List<Rueda> getRuedas(){
        return Collections.unmodifiableList(this.ruedas);
    }

    public List<Character> getRuedasValues(){
        return this.ruedas.stream()
                .map(Rueda::getChar)
                .collect(Collectors.toList());
    }
}
