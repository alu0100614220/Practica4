import java.util.ArrayList;

public class Practica4 {
	static int N = 0;
	static int ID = 1;
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			N += 5;
			for (int j = 0; j < 5; j++) {
				Grafo grafo = new Grafo(N);
				// Grafo grafoPrueba = new Grafo("File.txt");
				// System.out.println(grafo);
				System.out.println("-----------------------------");
				System.out.println("N:\t\t\t" + N);
				System.out.println("-----------------------------");
				System.out.println("ID:\t\t\t" + ID);
				ID++;
				VorazCreciente vorazCreciente = new VorazCreciente(grafo);
				Conjunto vorazC = vorazCreciente.solve();
				System.out.println("Creciente \t\t" + vorazC.getMedia());

				VorazDecreciente vorazDecreciente = new VorazDecreciente(grafo);
				Conjunto vorazD = vorazDecreciente.solve();
				System.out.println("Decreciente \t\t" + vorazD.getMedia());

				GRASP grasp = new GRASP(grafo);
				Conjunto graspC = grasp.solve();
				System.out.println("GRASP \t\t\t" + graspC.getMedia());

				VNS vns = new VNS(grafo);
				Conjunto vnsC = vns.solve();
				System.out.println("VNS \t\t\t" + vnsC.getMedia());
				
				MultiArranque multi = new MultiArranque(grafo);
				Conjunto multiC = multi.solve();
				System.out.println("MultiArranque \t\t" + multiC.getMedia());

			}

		}
	}
}
