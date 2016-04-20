import java.util.ArrayList;
import java.util.Collections;

public class VorazCreciente {
	Grafo grafo;
	Conjunto conjunto;
	Solution solucion;

	public VorazCreciente(Grafo grafo) {
		this.grafo = grafo;
		conjunto = new Conjunto(grafo);
		solucion = new Solution(grafo);
	}

	public void solve() {
		for (int i = 0; i < this.grafo.SIZE; i++) {
			for (int j = 0; j < this.grafo.SIZE; j++) {
				if (i != j) {
					if (solucion.improves(i, j)) {
						conjunto.conjunto.clear();
						conjunto.conjunto.add(i);
						conjunto.conjunto.add(j);
					}
				}

			}
		}
		solucion.vacio = false;
		conjunto.setMedia();
		solucion.mejorConjunto = conjunto.clone();
		
		boolean improves = false;

		for (int i = 0; i < this.grafo.SIZE; i++) {
			if (!conjunto.conjunto.contains(i)) {
				Conjunto nuevoConjunto = conjunto.clone();
				nuevoConjunto.conjunto.add(i);

				if (solucion.improves(nuevoConjunto, conjunto)) {
					improves = true;
				}
			}
			if (i == this.grafo.SIZE - 1) {
				if (improves) {
					i = 0;
					improves = false;
					this.conjunto = solucion.mejorConjunto.clone();
					this.conjunto.setMedia();
				}

			}
		}
		System.out.println(conjunto.conjunto + " Media: " + conjunto.getMedia());

		
	}
}
