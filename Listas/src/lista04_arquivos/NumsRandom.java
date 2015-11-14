package lista04_arquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NumsRandom {
	
	public NumsRandom() {
		
	}
	
	public void geraNums() throws IOException {

		File file = new File("saida_q1.dat");
		FileOutputStream fileStream = new FileOutputStream(file);
		BufferedOutputStream outStream = new BufferedOutputStream(fileStream);
		DataOutputStream dataStream;
		dataStream = new DataOutputStream(outStream);
	
		for (int i = 0; i < 100; i++) {
			int num = (int) (1 + (Math.random() * 100 ));
			dataStream.writeInt(num);	
		}
		
		dataStream.close();
	}
		
}	
			
