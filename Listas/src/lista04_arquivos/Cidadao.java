package lista04_arquivos;

import java.util.ArrayList;
import java.util.List;

public class Cidadao {

	private String nome;
	private String idade;
	private List<String> atividades;
	private StringBuffer strBuffer;
	
	public Cidadao(String nome, String idade, List<String> atividades ) {
		this.nome = nome;
		this.idade = idade;
		this.atividades = atividades;
	}
	
	public String toString(){
		this.strBuffer = new StringBuffer();
		strBuffer.append(this.nome +", "+ this.idade +" anos. Atividade(s): ");
		
		for (String atividade : atividades) {
			strBuffer.append(atividade +", ");
		}
		
		return strBuffer.substring(0, strBuffer.length()-2);
	}
	
}
