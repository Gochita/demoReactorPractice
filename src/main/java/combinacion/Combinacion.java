package combinacion;

import Creacion.Creacion;
import model.Persona;
import model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);



    //Une diferentes flujos
    public void merge(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "mariotso", 40));
        personas2.add(new Persona(5, "wisin", 20));
        personas2.add(new Persona(6, "yandel", 70));


        List<Venta> ventas= new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux <Persona> fx1 = Flux.fromIterable(personas);
        Flux <Persona> fx2 = Flux.fromIterable(personas2);
        Flux <Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1,fx2,fx3)
                .subscribe(p -> log.info(p.toString()));
    }

    public void zip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "mariotso", 40));
        personas2.add(new Persona(5, "wisin", 20));
        personas2.add(new Persona(6, "yandel", 70));


        List<Venta> ventas= new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux <Persona> fx1 = Flux.fromIterable(personas);
        Flux <Persona> fx2 = Flux.fromIterable(personas2);
        Flux <Venta> fx3 = Flux.fromIterable(ventas);

//Imprime uno de cada uno

      /*
        Flux.zip(fx1,fx2,(p1,p2)-> String.format("Flux1 : %s, Flux2 : %s",p1,p2))
                .subscribe(p -> log.info(p));

       */

        //Imprime to do en una sola linea, de varios flujos
        Flux.zip(fx1,fx2,fx3)
                .subscribe(p -> log.info(p.toString()));


    }

    public void zipWith(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 20));
        personas.add(new Persona(3, "eleonora", 70));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "mariotso", 40));
        personas2.add(new Persona(5, "wisin", 20));
        personas2.add(new Persona(6, "yandel", 70));


        List<Venta> ventas= new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux <Persona> fx1 = Flux.fromIterable(personas);
        Flux <Persona> fx2 = Flux.fromIterable(personas2);
        Flux <Venta> fx3 = Flux.fromIterable(ventas);


        //Junta los datos del flujo dos con los del flujo uno y les da un formato


        /*
        fx1.zipWith(fx2,(p1,p2)-> String.format("Flux1: %s, Flux2: %s",p1,p2))
        .subscribe(p -> log.info(p.toString()));
         */



        //Junta los datos de un usuario con los de una venta
        fx1.zipWith(fx3,(p1,v1)-> String.format("Flux1: %s, Flux2: %s",p1,v1))
                .subscribe(p -> log.info(p.toString()));

    }

}
