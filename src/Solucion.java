
public class Solucion {
	Grafo grafo;
	double media = 0;
	boolean vacio = true;
	Conjunto mejorConjunto;

	public Solucion(Grafo grafo) {
		this.grafo = grafo;
		mejorConjunto = new Conjunto(grafo);

	}

	boolean improves(int i, int j) {
		if (vacio) {
			if (this.grafo.matriz[i][j] >= this.media) {

				this.media = this.grafo.matriz[i][j];
				return true;
			}
		}
		return false;
	}

	boolean improves(Conjunto nuevaSolucion) {
//		System.out.println(this.mejorConjunto + " " + this.mejorConjunto.getMedia());
//		System.out.println(nuevaSolucion.conjunto + " " + nuevaSolucion.getMedia());
		if (nuevaSolucion.getMedia() > mejorConjunto.getMedia()) {
			mejorConjunto = nuevaSolucion;

			return true;
		} else {
			return false;
		}
	}
}
