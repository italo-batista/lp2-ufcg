package lista04_arquivos;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadInt {

	private List<Integer> meusNums;
	
	public ReadInt() {

	}
	
	public void leDados() throws IOException{
		
		FileInputStream fileStream = new FileInputStream("saida_q1.dat");
		BufferedInputStream inputStream = new BufferedInputStream(fileStream);
		DataInputStream dataStream = new DataInputStream(inputStream);
	
		try {

			Object num;
			StringBuffer string = new StringBuffer();
			string.append("Amostra lida:");
			
			do {
				num = dataStream.readInt();
				string.append(" "+ num);
			} while (num != null);
						
		} catch (EOFException e) {
			e.getMessage();
		}
		
		dataStream.close();
		
	}
	
}
