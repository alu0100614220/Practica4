import java.util.ArrayList;

public class VorazDecreciente {
	Grafo grafo;
	Conjunto conjunto;
	Solucion solucion;
	ArrayList<Conjunto> mejoresConjuntos = new ArrayList<Conjunto>();
	int mejoresConjuntosSize = 5;
	boolean improves = false;

	public VorazDecreciente(Grafo grafo) {
		this.grafo = grafo;
		conjunto = new Conjunto(grafo);
		solucion = new Solucion(grafo);
		for (int i = 0; i < this.grafo.SIZE; i++) {
			this.conjunto.conjunto.add(i);
		}

		solucion.vacio = false;
		conjunto.setMedia();
		solucion.mejorConjunto = conjunto.clone();


	}

	public Conjunto solve() {
		
		for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
			Conjunto nuevaSolucion = this.conjunto.clone();
			nuevaSolucion.conjunto.remove(i);
			if (solucion.improves(nuevaSolucion)) {
				improves = true;
			}
			if (i == this.conjunto.conjunto.size() - 1 && improves) {
				improves = false;
				conjunto = solucion.mejorConjunto.clone();
				i = -1;
			}
		}
		return conjunto;
	}

	public ArrayList<Conjunto> solve5() {
		while (mejoresConjuntos.size() < mejoresConjuntosSize) {
			this.conjunto.conjunto.clear();
			for (int i = 0; i < this.grafo.SIZE; i++) {
				this.conjunto.conjunto.add(i);
			}

			boolean improves = false;
			solucion.vacio = false;
			solucion.mejorConjunto = conjunto.clone();

			for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
				Conjunto nuevaSolucion = this.conjunto.clone();
				nuevaSolucion.conjunto.remove(i);
				 
				if (this.contiene(nuevaSolucion) == false) {
					mejoresConjuntos(nuevaSolucion);

					if (solucion.improves(nuevaSolucion)) {
						improves = true;

					}
					if (i == this.conjunto.conjunto.size() - 1 && improves) {
						improves = false;
						conjunto = solucion.mejorConjunto.clone();
						i =  -1;
					}
				}

			}

		}

		return mejoresConjuntos;
	}

	public void mejoresConjuntos(Conjunto conjunto){
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
