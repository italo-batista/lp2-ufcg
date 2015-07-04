

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.login.LoginException;

import exceptions.*;

public class Loja {
	
	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
		totalArrecadado = 0;
		
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
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}