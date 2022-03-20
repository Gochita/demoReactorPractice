package condicional;

import com.example.demoreactor.DemoReactorApplication;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {
    private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void defaultIfEmpty(){
        Mono.just(new Persona(1,"mito",30))
        //Flux.empty()
        //Mono.empty()
                //Funciona igual con flux y con mono, pero cuando encuentra, el default no se utiliza
                .defaultIfEmpty(new Persona(0,"default",99))
                .subscribe(x -> Log.info(x.toString()));



    }
//Devuelve el flujo hasta que se cumpla la condicion
    public void takeUntil(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() >26)
                .subscribe(x -> Log.info(x.toString()));


    }
//Arroja un timeout despues de dos segundos
    public void timeOut() throws InterruptedException{
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "vicci", 27));
        personas.add(new Persona(2, "evelyn", 28));
        personas.add(new Persona(3, "eleonora", 29));
        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(3)) //demora 3 segundos en leer los elementos
                .timeout(Duration.ofSeconds(2))       //solo espera dos, lo que ocasiona que lance el timeout
                .subscribe(x -> Log.info(x.toString()));


        /*

            Si el delayElements durara menos de lo que dura el timeout, no habría error
            
         */


        Thread.sleep(10000);

    }


}
