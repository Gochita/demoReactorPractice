package transformacion;

import model.Persona;
import operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);


    //retorna el objeto
    public void map() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 40));
        personas.add(new Persona(2, "evelyn", 33));
        personas.add(new Persona(3, "eleonora", 70));


        /*
        Flux.fromIterable(personas)
                .map(p ->{
                    p.setEdad(p.getEdad()+10); //Hace un mapeo en la lista de personas y modifica su edad
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));


         */

        Flux<Integer> fx = Flux.range(0, 10);
        //Para ver los datos de fx transformados, necesitamos otro flux donde guardar ese mapeo donde
        //se modifican los del primer flujo
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("x: " + x));

    }

//Retorna un flujo de objetos
     public void flatMap(){
         List<Persona> personas = new ArrayList<>();
         personas.add(new Persona(1, "vicci", 40));
         personas.add(new Persona(2, "evelyn", 33));
         personas.add(new Persona(3, "eleonora", 70));
         Flux.fromIterable(personas)
                 .flatMap(p -> {
                     p.setEdad(p.getEdad() +10 );
                     return Mono.just(p);
                 })
                 .subscribe(p -> log.info(p.toString()));

     }
//agrupa por la variable en comun que tengan los objetos
     public void groupBy(){
         List<Persona> personas = new ArrayList<>();
         personas.add(new Persona(1, "vicci", 40));
         personas.add(new Persona(1, "evelyn", 33));
         personas.add(new Persona(3, "eleonora", 70));
         Flux.fromIterable(personas)
                 .groupBy(Persona::getIdPersona)
                 .flatMap(idFlux -> idFlux.collectList())
                 .subscribe(x -> log.info(x.toString()));
     }
}
