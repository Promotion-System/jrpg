package promotionSystem.razas;

import promotionSystem.Punto;

public class Roxas extends PersonajesDeKingdomHearts {

    public Roxas() {
        energia = 1000;
        salud = 100;
        ataque = 50;
        defensa = 200;
        magia = 200;
        velocidad = 150;
        experiencia = 0;
        nivel = 0;
        posicion = new Punto(0, 0);
    }

    @Override
    public void subirStats(int nivel) {
        energia += nivel * 10;
        salud += nivel * 5;
        ataque += nivel * 5;
        defensa += nivel * 10;
        magia += nivel * 10;
        velocidad += nivel * 10;
    }

}
