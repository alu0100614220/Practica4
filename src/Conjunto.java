import java.util.ArrayList;
import java.util.Collections;

public class Conjunto implements Cloneable {
	ArrayList<Integer> conjunto = new ArrayList<Integer>();
	private double media = 0;
	Grafo grafo;

	public Conjunto(Grafo grafo) {
		this.grafo = grafo;
	}

	public void setMedia() {
		int cantidadAristas = conjunto.size() * (conjunto.size() - 1) / 2;
		boolean[][] visitadas = new boolean[this.grafo.matriz.length][this.grafo.matriz.length];
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
		Collections.sort(this.conjunto);
		return media;
	}

	public Conjunto clone() {
		Conjunto copia = new Conjunto(this.grafo);
		for (int i = 0; i < conjunto.size(); i++) {
			copia.conjunto.add(conjunto.get(i));
		}

		return copia;
	}
	
}
