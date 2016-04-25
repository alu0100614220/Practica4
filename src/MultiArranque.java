
public class MultiArranque {
	Grafo grafo;
	Conjunto conjunto;
	Solucion solucion;
	VorazCreciente voraz;
	final int PRUEBAS = 500;
	public MultiArranque(Grafo grafo) {
		this.grafo = grafo;
		this.conjunto = new Conjunto(grafo);
		this.solucion = new Solucion(grafo);
		this.voraz = new VorazCreciente(this.grafo);
	}

	public Conjunto solve() {
		int i = 0;
		this.conjunto = this.conjunto.generaRandom().clone();
		this.conjunto.setMedia();
		this.solucion.mejorConjunto = conjunto.clone();
		while (i < PRUEBAS) {

			this.voraz.conjunto = this.conjunto.clone();
			// System.out.println(conjunto + " " + conjunto.getMedia());
			this.conjunto = this.voraz.solve();
			// System.out.println(conjunto + " " + conjunto.getMedia());
			this.solucion.improves(conjunto);
			this.conjunto = this.conjunto.generaRandom().clone();
			i++;
		}
		return this.solucion.mejorConjunto;

	}

}
