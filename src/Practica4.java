
public class Practica4 {
	public static void main(String[] args) {
		Grafo grafo = new Grafo(6);
		//Grafo grafoPrueba = new Grafo("File.txt");
		System.out.println(grafo);
		System.out.println("Creciente");
		VorazCreciente vorazCreciente = new VorazCreciente(grafo);
		vorazCreciente.solve();
		System.out.println();
		System.out.println("Decreciente");
		VorazDecreciente vorazDecreciente = new VorazDecreciente(grafo);
		vorazDecreciente.solve();
	}
}
