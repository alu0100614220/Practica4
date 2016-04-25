
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
			mejora = false;
			vorazC.solucion = this.solucion;
			vorazC.conjunto = this.conjunto.clone();
			Conjunto aux;

			aux = this.changeMediana().clone();
			if (!aux.equal(this.conjunto)) {
				this.conjunto = aux.clone();
				mejora = true;
				continue;

			}
			aux = this.changeRandom().clone();
			if (!aux.equal(this.conjunto)) {
				this.conjunto = aux.clone();
				mejora = true;
				continue;

			}

			aux = vorazC.solve().clone();
			if (!aux.equal(this.conjunto)) {
				this.conjunto = aux.clone();
				this.solucion = vorazD.solucion;
				mejora = true;
				continue;
			}

			vorazD.solucion = this.solucion;
			vorazD.conjunto = this.conjunto.clone();
			aux = vorazD.solve().clone();

			if (!aux.equal(this.conjunto)) {
				this.conjunto = aux.clone();
				this.solucion = vorazD.solucion;
				mejora = true;
				continue;

			}

		}
		return this.conjunto;
	}

	public Conjunto changeMediana() {
		int mediana = this.conjunto.conjunto.size() / 2;
		int a;
		for (int i = 0; i < 100; i++) {
			a = (int) Math.random() * this.grafo.SIZE;
			if (a != mediana && this.conjunto.conjunto.contains(a) == false) {
				Conjunto aux = this.conjunto.clone();
				aux = aux.swap(mediana, a);
				if (this.solucion.improves(aux)) {
					return this.solucion.mejorConjunto;
				}
			}
		}

		return this.conjunto;
	}

	public Conjunto changeRandom() {
		int a, b;

		for (int i = 0; i < 100; i++) {
			a = (int) Math.random() * this.conjunto.conjunto.size();
			b = (int) Math.random() * this.grafo.SIZE;
			if (a != b && this.conjunto.conjunto.contains(b) == false) {
				Conjunto aux = this.conjunto.clone();
				aux = aux.swap(a, b);
				if (this.solucion.improves(aux)) {
					return this.solucion.mejorConjunto;
				}
			}
		}
		return this.conjunto;
	}

}
