import java.util.ArrayList;

public class VorazDecreciente {
	Grafo grafo;
	Conjunto conjunto;
	Solution solucion;
	ArrayList<Conjunto> mejoresConjuntos = new ArrayList<Conjunto>();
	int mejoresConjuntosSize = 3;

	public VorazDecreciente(Grafo grafo) {
		this.grafo = grafo;
		conjunto = new Conjunto(grafo);
		solucion = new Solution(grafo);

	}

	public void solve() {

		// Rellenamos el conjunto de testeo
		for (int i = 0; i < this.grafo.SIZE; i++) {
			this.conjunto.conjunto.add(i);
		}

		boolean improves = false;
		solucion.vacio = false;
		conjunto.setMedia();
		solucion.mejorConjunto = conjunto.clone();

		for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
			Conjunto nuevaSolucion = this.conjunto.clone();
			nuevaSolucion.conjunto.remove(i);
			if (solucion.improves(nuevaSolucion, conjunto)) {
				improves = true;
			}
			if (i == this.conjunto.conjunto.size() - 1 && improves) {
				improves = false;
				conjunto = solucion.mejorConjunto.clone();
				this.conjunto.setMedia();
				i = -1;
			}
		}
		System.out.println(conjunto.conjunto + " Media: " + conjunto.getMedia());
	}

	public void solve5() {
		while (mejoresConjuntos.size() < mejoresConjuntosSize) {
			this.conjunto.conjunto.clear();
			for (int i = 0; i < this.grafo.SIZE; i++) {
				this.conjunto.conjunto.add(i);
			}

			boolean improves = false;
			solucion.vacio = false;
			conjunto.setMedia();
			solucion.mejorConjunto = conjunto.clone();

			for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
				Conjunto nuevaSolucion = this.conjunto.clone();
				nuevaSolucion.conjunto.remove(i);
				 
				if (this.contiene(nuevaSolucion) == false) {
					mejora(nuevaSolucion);

					if (solucion.improves(nuevaSolucion, conjunto)) {
						improves = true;

					}
					if (i == this.conjunto.conjunto.size() - 1 && improves) {
						improves = false;
						conjunto = solucion.mejorConjunto.clone();
						this.conjunto.setMedia();
						i =  -1;
					}
				}

			}

		}
		for (int i = 0; i < mejoresConjuntos.size(); i++) {
			System.out.println(mejoresConjuntos.get(i).conjunto + " X: " + mejoresConjuntos.get(i).getMedia());
		}
	}

	public void mejora(Conjunto conjunto){
		for (int i = 0; i < mejoresConjuntos.size(); i++) {
		}
		if(this.mejoresConjuntos.size() < mejoresConjuntosSize){
			mejoresConjuntos.add(conjunto);	
		}
		else{
			int peor = 0;
			for (int i = 0; i < mejoresConjuntos.size(); i++) {
				if(mejoresConjuntos.get(peor).getMedia() > mejoresConjuntos.get(i).getMedia()){
					peor = i;
				}
			}
			if(conjunto.getMedia() > mejoresConjuntos.get(peor).getMedia()){
				
				mejoresConjuntos.remove(peor);
				mejoresConjuntos.add(conjunto);
				}
		}	
	}

	public boolean contiene(Conjunto conjunto) {
		

		for (int i = 0; i < mejoresConjuntos.size(); i++) {
			if (conjunto.equal(mejoresConjuntos.get(i))) {
				return true;
			}
		}
		return false;
	}
}
