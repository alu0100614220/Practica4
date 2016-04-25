import java.util.ArrayList;

public class GRASP {
	Grafo grafo;
	Conjunto conjunto;
	Solucion solucion;

	public GRASP(Grafo grafo){
		this.grafo = grafo;
		this.conjunto = new Conjunto(grafo);
		this.solucion = new Solucion(grafo);
	}
	public Conjunto solve(){
		VorazDecreciente vorazGrasp = new VorazDecreciente(this.grafo);
		ArrayList<Conjunto> mejores = vorazGrasp.solve5();
		int i = (int) (Math.random()*mejores.size());
		Conjunto mejor = mejores.get(i);
		while(mejor.conjunto.size() == this.grafo.SIZE){
			i = (int) (Math.random()*mejores.size());
			mejor = mejores.get(i);	
		}
		
		mejor.setMedia();
		solucion.mejorConjunto = mejor.clone();
		for (int j = 0; j < grafo.SIZE; j++) {
			Conjunto prueba = mejor.clone();
			if (prueba.conjunto.contains(j) == false) {
				prueba.conjunto.add(j);
				if(solucion.improves(prueba)){
					mejor = prueba.clone();
					j = -1;
				};
			}
		}
		
		return mejor;
	}
}
