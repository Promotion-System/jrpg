package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class RoxasTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Roxas personaje=new Roxas();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+10*3, personaje.getEnergia());
		Assert.assertEquals(100+5*3, personaje.getSalud());
		Assert.assertEquals(50+5*3, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(200+10*3, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(200+10*3, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(150+10*3, personaje.obtenerPuntosDeVelocidad());
	}
}
