package lista04_arquivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

public class ReadCSV {
	
	private List<Cidadao> cidadoes;

	public ReadCSV() {
		cidadoes = new ArrayList<Cidadao>();
	}
	
	public void leCidadoes() throws IOException {	
		
		BufferedReader stream = new BufferedReader( new FileReader("cidadoes.csv") );
		String infos = "";
		
		while ( (infos = stream.readLine()) != null) {
			List<String> listaInfos = popularizaLista((String)infos);
			Cidadao cidadao = criaCidadao(listaInfos);
			this.cidadoes.add(cidadao);
		}
		
		stream.close();
	}	
	
	public List<String> popularizaLista(String string) {
		List<String> lista = new ArrayList<>();
		
		int ultComma = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.substring(i, i+1).equals(",")){
				lista.add( string.substring(ultComma, i));
				ultComma = i+1;
			}
		}
		lista.add( string.substring(ultComma, string.length()-1));
		return lista;
		
		
	}
	
	public Cidadao criaCidadao(List<String> infos) {

		String nome = infos.get(0);
		String idade = infos.get(1);
		List<String> atividades = new ArrayList<String>();

		for (int i = 2; i < infos.size(); i++) {
			atividades.add( infos.get(i) );
		}
		
		Cidadao cidadao = new Cidadao(nome, idade, atividades);
		return cidadao;
	}

	public void listaCidadoes() {
		for (Cidadao cidadao : cidadoes) {
			System.out.println(cidadao);
		}
	}
	
	
}
