package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajeDePokemon extends Personaje {
	
	

	public void despuesDeAtacar(){
		magia+=10;
	}

	@Override
	public abstract void subirStats(int nivel);
}