import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Grafo {
	public int[][] matriz;

	Grafo(String nombre) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombre));
			String linea = reader.readLine();
			int size = Integer.parseInt(linea);
			matriz = new int[size][size];
			while (reader.ready()) {
				linea = reader.readLine();
				System.out.println(linea);
				String[] fila = linea.split(" ");
				int[] filaInt = new int[fila.length];
				for (int i = 0; i < size; i++) {
					matriz[i][i] = 0;
				}
				for (int i = 0; i < fila.length; i++) {
					filaInt[i] = Integer.parseInt(fila[i]);
				}
				matriz[filaInt[0]][filaInt[1]] = filaInt[2];
				matriz[filaInt[1]][filaInt[0]] = filaInt[2];

			}
			//this.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		System.out.println("Grafo");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+ "\t");
			}
			System.out.println();
		}
		return "";
	}

}
