import java.util.ArrayList;

public class Solution {
	Grafo grafo;
	double media = 0;
	boolean vacio = true;
	Conjunto mejorConjunto;

	public Solution(Grafo grafo) {
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

	boolean improves(Conjunto nuevaSolucion, Conjunto conjunto) {


		nuevaSolucion.setMedia();
//
//		System.out.println("Conjunto inicial: " + mejorConjunto.conjunto + " Media inicial " + mejorConjunto.getMedia());
//		System.out.println("Conjunto nuevo: " + nuevaSolucion.conjunto + " Nueva media " + nuevaSolucion.getMedia());

		if (nuevaSolucion.getMedia() >= mejorConjunto.getMedia()) {
			mejorConjunto = nuevaSolucion;

			return true;
		} else {
			return false;
		}
	}
}
