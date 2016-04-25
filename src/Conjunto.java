import java.util.ArrayList;
import java.util.Collections;

public class Conjunto {
	ArrayList<Integer> conjunto = new ArrayList<Integer>();
	private double media = 0;
	Grafo grafo;

	public Conjunto(Grafo grafo) {
		this.grafo = grafo;
	}

	public void setMedia() {

		int cantidadAristas = conjunto.size() * (conjunto.size() - 1) / 2;
		boolean[][] visitadas = new boolean[this.grafo.SIZE][this.grafo.SIZE];
		media = 0;
		for (int i = 0; i < conjunto.size(); i++) {
			for (int j = 0; j < conjunto.size(); j++) {
				if (conjunto.get(i) != conjunto.get(j) && visitadas[conjunto.get(i)][conjunto.get(j)] == false) {
					media += this.grafo.matriz[conjunto.get(i)][conjunto.get(j)];
					visitadas[conjunto.get(i)][conjunto.get(j)] = true;
					visitadas[conjunto.get(j)][conjunto.get(i)] = true;
				}
			}
		}

		media = media / conjunto.size();

	}

	public double getMedia() {
		this.setMedia();
		Collections.sort(this.conjunto);
		this.media = Math.round(this.media * 10.0) / 10.0;
		return media;
	}

	public Conjunto clone() {
		Conjunto copia = new Conjunto(this.grafo);
		for (int i = 0; i < conjunto.size(); i++) {
			copia.conjunto.add(conjunto.get(i));
		}
		copia.media = this.getMedia();
		return copia;
	}

	public boolean equal(Conjunto obj) {
		if (obj.conjunto.size() != this.conjunto.size()) {
			return false;
		} else {
			for (int i = 0; i < this.conjunto.size(); i++) {
				if (obj.conjunto.get(i) != this.conjunto.get(i)) {
					return false;
				}
			}

		}
		return true;
	}

	public String toString() {
		return this.conjunto.toString();
	}

	public Conjunto generaRandom() {

		Conjunto random = new Conjunto(this.grafo);
		for (int i = 0; i < this.grafo.SIZE; i++) {
			int si = (int) (Math.random() * 2);
			if (si == 1) {
				random.conjunto.add(i);
			}

		}
		return random;
	}

	public Conjunto swap(int i, int j) {
		Conjunto auxC = this.clone();
		int aux = auxC.conjunto.get(i);
		auxC.conjunto.set(i, auxC.conjunto.get(j));
		auxC.conjunto.set(j, aux);
		return auxC;
	}
}
