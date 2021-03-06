package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loja {
	
	private List<Usuario> usuarios;
	private double totalArrecadado;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
		totalArrecadado = 0;
		
	}
	
	public void ordenaUsuarios(){
		Collections.sort(this.usuarios);
	}
	
	public void armazenaUsuario(Usuario usuario) {
			usuarios.add(usuario);
	}
	
	public void removeUsuario(Usuario usuario){
		usuarios.remove(usuario);
	}
	
	public void calcTotalArrecadado(double valorVenda){
		this.totalArrecadado = this.totalArrecadado + valorVenda;
	}
		
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append("=== Central P2-CG ===");
		sb.append(endOfLine);
		sb.append(endOfLine);
		
		for (Usuario usuario : usuarios) {
			sb.append(usuario);
			sb.append(endOfLine);
			sb.append(endOfLine);
		}
		
		sb.append(endOfLine);
		sb.append("--------------------------------");
		sb.append("Total arrecadado com vendas de jogos: R$ ");
		sb.append(totalArrecadado);
		return sb.toString();
	}
	
	// getters and setters
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}