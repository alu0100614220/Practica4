import java.util.ArrayList;

public class VorazDecreciente {
	Grafo grafo;
	Conjunto conjunto;
	Solution solucion;
	ArrayList<Conjunto> mejoresConjuntos = new ArrayList<Conjunto>();
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
	
	public void solve5(){
		while(mejoresConjuntos.size() < 5){
			
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
				if (mejoresConjuntos.contains(nuevaSolucion) == false) {
					if (solucion.improves(nuevaSolucion, conjunto)) {
						improves = true;
					}
					if (i == this.conjunto.conjunto.size() - 1 && improves) {
						improves = false;
						conjunto = solucion.mejorConjunto.clone();
						this.conjunto.setMedia();
						mejoresConjuntos.add(this.conjunto);
						i = -1;
					}	
				}
				
			}
			
		}
		for (int i = 0; i < mejoresConjuntos.size(); i++) {
			System.out.println(mejoresConjuntos.get(i));
		}
	}
}
