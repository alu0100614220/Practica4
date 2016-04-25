import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Grafo {
	public double[][] matriz;
	public int SIZE;

	Grafo(int n) {
		this.SIZE = n;
		matriz = new double[this.SIZE][this.SIZE];
		double valor;
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = i; j < this.SIZE; j++) {
				if (i == j) {
					matriz[i][j] = Double.NaN;
				} else {
					valor = (Math.random() * 100) - 50;
					valor = Math.round(valor * 10.0) / 10.0;
					matriz[i][j] = valor;
					matriz[j][i] = valor;

				}
			}
		}
	};

	Grafo(String nombre) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(nombre));
			String linea = reader.readLine();
			SIZE = Integer.parseInt(linea);
			matriz = new double[this.SIZE][this.SIZE];
			for (int i = 0; i < this.SIZE; i++) {
				for (int j = i; j < this.SIZE; j++) {
					if (i == j) {
						matriz[i][j] = Double.NaN;
					} else {
						linea = reader.readLine();
						System.out.println(linea);
						String[] fila = linea.split(" ");
						fila[0] = fila[0].replace(',', '.');
						double filaInt = Double.parseDouble(fila[0]);

						matriz[i][j] = filaInt;
						matriz[j][i] = filaInt;
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		System.out.println("Grafo");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
		return "";
	}

}
