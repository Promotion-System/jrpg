package promotionSystem.razas.castas.pokemon;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDePokemon;

import static promotionSystem.Constantes.INICIO_MAPA;

public class PokemonTipoAguaTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDePokemon personaje=new PokemonTipoAgua();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_AGUA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_POKEMON_DE_AGUA +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_POKEMON_DE_AGUA +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_POKEMON_DE_AGUA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_AGUA +2*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE, personaje.obtenerPuntosDeVelocidad());
	}

}
