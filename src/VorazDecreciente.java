import java.util.ArrayList;

public class VorazDecreciente {
	Grafo grafo;
	Conjunto conjunto;
	Solution solucion;

	public VorazDecreciente(Grafo grafo) {
		this.grafo = grafo;
		conjunto = new Conjunto(grafo);
		solucion = new Solution(grafo);

	}

	public void solve() {
		
		// Rellenamos el conjunto de testeo
		for (int i = 0; i < this.grafo.matriz.length; i++) {
			this.conjunto.conjunto.add(i);
		}

		boolean improves = false;

		for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
			Conjunto nuevaSolucion = this.conjunto.clone();
			nuevaSolucion.conjunto.remove(i);
			if (solucion.improves(nuevaSolucion, conjunto)) {
				improves = true;
			}
			if (i == this.conjunto.conjunto.size() - 1 && improves) {
				improves = false;
				conjunto = solucion.mejorConjunto;
				i = -1;
			}
		}
		System.out.println(conjunto.conjunto + " Media: " + conjunto.getMedia());
	}

}
