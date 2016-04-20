import java.util.ArrayList;

public class Practica4 {
	public static void main(String[] args) {
		Grafo grafo = new Grafo(20);
		//Grafo grafoPrueba = new Grafo("File.txt");
		System.out.println(grafo);
		System.out.println("Creciente");
		VorazCreciente vorazCreciente = new VorazCreciente(grafo);
		vorazCreciente.solve();
		System.out.println();
		System.out.println("Decreciente");
		VorazDecreciente vorazDecreciente = new VorazDecreciente(grafo);
		vorazDecreciente.solve();
		System.out.println("GRASP");
		GRASP grasp = new GRASP(grafo);
		grasp.solve();
//		ArrayList<Conjunto> prueba = new ArrayList<Conjunto>();
//		Conjunto c1 = new Conjunto(grafo);
//		c1.conjunto.add(1);
//		c1.conjunto.add(2);
//		
//		Conjunto c2 = new Conjunto(grafo);
//		c2.conjunto.add(1);
//		c2.conjunto.add(2);
//		prueba.add(c1);
//		if(prueba.contains(c2)){
//			System.out.println("lotienexd");
//		}
//		if (prueba.get(0).equals(c2)) {
//			System.out.println("xd");
//		}
//		
	}
}
