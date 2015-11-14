package lista04_arquivos;

import java.io.IOException;

public class Main {

	
	public void qstUmDois() throws IOException{
		NumsRandom nums = new NumsRandom();
		nums.geraNums();
		ReadInt reader = new ReadInt();
		reader.leDados();
	}
	
	public void qstQuatroCinco() throws IOException {
		ReadCSV reader = new ReadCSV();
		reader.leCidadoes();
		reader.listaCidadoes();
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		
		main.qstUmDois();
		
		main.qstQuatroCinco();
	}
	
}
