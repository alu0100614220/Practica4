import java.util.ArrayList;

public class Solution {
	Grafo grafo;
	ArrayList<Integer> solucion = new ArrayList<Integer>();
	double media = 0;
	boolean vacio = true;
	Conjunto mejorConjunto;
	Conjunto conjuntoAspirante;

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

		conjunto.setMedia();
		nuevaSolucion.setMedia();

//		System.out.println("Conjunto inicial: " + conjunto.conjunto + " Media inicial " + conjunto.getMedia());
//		System.out.println("Conjunto nuevo: " + nuevaSolucion.conjunto + " Nueva media " + nuevaSolucion.getMedia());

		if (nuevaSolucion.getMedia() >= conjunto.getMedia()) {
			conjuntoAspirante = nuevaSolucion;
			if (mejorConjunto == null) {
				mejorConjunto = conjuntoAspirante;
				return true;

			} else if (conjuntoAspirante.getMedia() > mejorConjunto.getMedia()) {
				mejorConjunto = conjuntoAspirante;
				return true;

			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
