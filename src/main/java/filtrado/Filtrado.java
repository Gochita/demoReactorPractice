package filtrado;

import model.Persona;
import Creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);


    //Filtra los elementos dada una condicion
    public void filter(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .filter(p -> p.getEdad()>28)
                .subscribe(p -> log.info(p.toString()));

    }

    //No trae elementos repetidos (en este caso por id por el metodo que esta especificado en la clase persona)
    public void distinct(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(1, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));

    }


    //Trae la cantidad de objetos especificados en sus argumentos desde el inicio hasta el final

    public void take(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(1, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .take(1)
                .subscribe(p -> log.info(p.toString()));
    }
    //Trae la cantidad de objetos especificados en sus argumentos desde el final hasta el inicio

    public void takeLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }
//Se salta al inicio la cantidad de elementos indicados en los argumentos
    public void skip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .skip(2)
                .subscribe(p -> log.info(p.toString()));

    }

    //Se salta al final la cantidad de elementos indicados en los argumentos
    public void skipLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));
        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));

    }



}
