package com.example.demoreactor;
import io.reactivex.Observable;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication {

	private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);


	public static void reactor(){
		Mono.just(new Persona(1,"Gochi",21))
				.subscribe(p -> Log.info("[Reactor] Persona: "+ p));

	}
	public static void rxjava2(){
		Observable.just(new Persona(1,"Gochi",21))
				.subscribe(p -> Log.info("[Rxjava2] Persona: "+ p));
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
		reactor();
		rxjava2();
	}

}
