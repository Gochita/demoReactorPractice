package com.example.demoreactor;

import combinacion.Combinacion;
import condicional.Condicional;
import error.ErrorOp;
import filtrado.Filtrado;
import io.reactivex.Observable;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication {

    private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);


    public static void reactor() {
        Mono.just(new Persona(1, "Gochi", 21))
                .doOnNext(p -> {
                    Log.info("[Reactor] Persona: " + p);
                })
                .subscribe(p -> Log.info("[Reactor] Persona: " + p));


    }

    public static void rxjava2() {
        Observable.just(new Persona(1, "Gochi", 21))
                .doOnNext(p -> Log.info("[Rxjava2] Persona: " + p))
                .subscribe(p -> Log.info("[Rxjava2] Persona: " + p));
    }

    public static void mono() {
        Mono.just(new Persona(2, "mito", 22))
                .subscribe(p -> Log.info(p.toString()));
    }

    public static void flux() {
        //Se suscribe a un arreglo de personas, los imprime individualmente
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 33));
        personas.add(new Persona(3, "eleonora", 70));

        Flux.fromIterable(personas)
                .subscribe(p -> Log.info(p.toString()));


    }
    public static void fluxMono(){
        //se suscribe a un arreglo de personas, los imprime en un solo bloque
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 33));
        personas.add(new Persona(3, "eleonora", 70));

        Flux <Persona> fx = Flux.fromIterable(personas);
        fx.collectList().subscribe(lista -> Log.info(lista.toString()));
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoReactorApplication.class, args);
        Condicional app = new Condicional();
        app.takeUntil();
    }

}
