package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.razas.Humano;
import promotionSystem.razas.PokemonTipoFuego;
import promotionSystem.Personaje;

import java.util.ArrayList;
import java.util.List;

public class AlianzaBuilder {

    public static Alianza crearAlianza(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new PokemonTipoFuego());
        }
        return new Alianza(personajes);
    }

    public static AlianzaDeHumanos crearAlianzaDeHumanos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new PokemonTipoFuego());
        }
        return new AlianzaDeHumanos(personajes);
    }
}
