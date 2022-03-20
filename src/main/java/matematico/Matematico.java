package matematico;

import Creacion.Creacion;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);
//trae el promedio de un atributo
    public void average() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(p -> log.info(p.toString()));



    }

//cuenta la cantidad de objetos
    public void count(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .count()
                .subscribe(x -> log.info("Cantidad :"+ x));
    }
//Trae el minimo de una variable en particular
    public void min(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(p -> log.info(p.get().toString()));

    }

    //Hace la suma de un atributo en particular
    public void sum(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(x -> log.info("Suma: "+ x));

    }

    //Trae la cantidad de elementos, la suma de uno de uno de sus atributos, el minimo de este,
    //El promedio y el maximo
    public void summarizing(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe(x -> log.info("Resumen: "+ x));

    }


}
