import java.util.Scanner;

public class Practica4 {
	static int N = 0;
	static int ID = 1;

	public void opciones(Grafo grafo) {
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

	public static void main(String[] args) {
		System.out.println("1. Para generar grafos.");
		System.out.println("2. Para probar con uno de entrada.");
		Scanner keyboard = new Scanner(System.in);
		Practica4 prct4 = new Practica4();

		int opc = keyboard.nextInt();
		switch (opc) {
		case 1:
			for (int i = 0; i < 10; i++) {
				N += 5;
				for (int j = 0; j < 5; j++) {
					Grafo grafo = new Grafo(N);
					prct4.opciones(grafo);
				}
			}
			break;
		case 2:
			Grafo grafo = new Grafo("File.txt");
			N = grafo.SIZE;
			System.out.println(grafo);
			prct4.opciones(grafo);
			break;
		default:
			System.out.println("Opción incorrecta");
			break;
		}

	}
}
