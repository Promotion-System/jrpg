package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class IraWookeana extends Hechizo{

	@Override
	public void afectar(Personaje personaje, int efecto) {
		
		int aumento= efecto/3;
		
		personaje.serAumentadoLaFuerza(aumento);
		
	}

}
