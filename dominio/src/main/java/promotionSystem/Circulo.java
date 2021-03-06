package promotionSystem;

public class Circulo {
	private Punto centro;
	private double radio;

	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public boolean intersectaCon(Circulo circulo) {
		return this.centro.distanciaCon(circulo.centro) <=
				this.radio + circulo.radio;
	}

	public boolean incluye(Punto posicion) {
		return posicion.distanciaCon(centro)<radio;
	}

	public void setCentro(Punto posicion) {
		centro=posicion;
	}
}
