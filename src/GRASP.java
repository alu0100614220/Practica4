
public class GRASP {
	Grafo grafo;
	Conjunto conjunto;
	Solution solucion;

	public GRASP(Grafo grafo){
		this.grafo = grafo;
		this.conjunto = new Conjunto(grafo);
		this.solucion = new Solution(grafo);
	}
	public void solve(){
		VorazDecreciente vorazGrasp = new VorazDecreciente(this.grafo);
		vorazGrasp.solve5();
	}
}
