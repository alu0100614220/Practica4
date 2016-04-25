
public class VNS {
	Grafo grafo;
	Conjunto conjunto;
	Solucion solucion;
	boolean mejora = true;

	public VNS(Grafo grafo) {
		this.grafo = grafo;
		conjunto = new Conjunto(grafo);
		solucion = new Solucion(grafo);
		this.conjunto = this.conjunto.generaRandom();
		this.solucion.mejorConjunto = this.conjunto.clone();

	}

	public Conjunto solve() {
		VorazDecreciente vorazD = new VorazDecreciente(this.grafo);
		VorazCreciente vorazC = new VorazCreciente(this.grafo);
		while (mejora) {
			System.out.println("INTENTANDO MEJORAR");
			mejora = false;
			vorazC.solucion = this.solucion;
			vorazC.conjunto = this.conjunto.clone();
			Conjunto aux;

			aux = this.changeMediana().clone();
			if (!aux.equal(this.conjunto)) {
				System.out.println("He mejorado 3");
				this.conjunto = aux.clone();
				mejora = true;

			}

			aux = vorazC.solve().clone();
			if (!aux.equal(this.conjunto)) {
				System.out.println("He mejorado 1");
				this.conjunto = aux.clone();
				this.solucion = vorazD.solucion;
				mejora = true;
			}

			vorazD.solucion = this.solucion;
			vorazD.conjunto = this.conjunto.clone();
			aux = vorazD.solve().clone();

			if (!aux.equal(this.conjunto)) {
				System.out.println("He mejorado 2");
				this.conjunto = aux.clone();
				this.solucion = vorazD.solucion;
				mejora = true;

			}

		}
		return this.conjunto;
	}

	public Conjunto changeMediana() {

		int mediana = this.conjunto.conjunto.size() / 2;
		for (int i = 0; i < this.conjunto.conjunto.size(); i++) {
			if (i != mediana) {
				Conjunto aux = this.conjunto.clone();
				aux = aux.swap(mediana, i);
				if (this.solucion.improves(aux)) {
					return this.solucion.mejorConjunto;
				}

			}
		}

		return this.conjunto;
	}

}
