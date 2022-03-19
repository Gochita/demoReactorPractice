package Creacion;

import io.reactivex.Observable;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void justFrom() {
        //Mono es un elemento
        //Flux es una coleccion
        Mono.just(new Persona(1, "gochi", 20));
        //Flux.fromIterable(coleccion);
        //Observable.just(item);
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    //range no incluye el ultimo numero
    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    //Hace que se repitan los objetos de una coleccion una cantidad de veces
    public void repeat() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 33));
        personas.add(new Persona(3, "eleonora", 70));

        //para flux
        /*
        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
        */

        //Para mono

        Mono.just(new Persona (4,"lucia",7))
                .repeat(4)
                .subscribe(p -> log.info(p.toString()));
    }

}
