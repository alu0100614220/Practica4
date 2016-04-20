import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Grafo {
	public double[][] matriz;
	public int SIZE;
	Grafo(int n){
		this.SIZE = n;
		matriz = new double[this.SIZE][this.SIZE];
		double valor;
		for (int i = 0; i < this.SIZE; i++) {
			for (int j = i; j < this.SIZE; j++) {
				if(i == j){
					matriz[i][j] = Double.NaN;
				}else{
					valor = (Math.random()*100) - 50;
					valor = Math.round(valor*10.0)/10.0;
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
			while (reader.ready()) {
				linea = reader.readLine();
				System.out.println(linea);
				String[] fila = linea.split(" ");
				double[] filaInt = new double[fila.length];
				for (int i = 0; i < this.SIZE; i++) {
					matriz[i][i] = Double.NaN;
				}
				for (int i = 0; i < fila.length; i++) {
					fila[i] = fila[i].replace(',', '.');
					filaInt[i] = Double.parseDouble(fila[i]);
				}
				matriz[(int)filaInt[0]][(int)filaInt[1]] = filaInt[2];
				matriz[(int)filaInt[1]][(int)filaInt[0]] = filaInt[2];

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
