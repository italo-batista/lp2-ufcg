package prova02;

public class Ingles implements Curso {

	public Ingles() {
		super();
	}
	
	public double calculaFacilidade(double escuta, double fala, double leitura, double escrita){
		double facilidade = (0.1 * leitura) + (0.5 * escrita) + (0.4 * fala);
		return facilidade;
	}
	
	public String cumprimenta(String nomeAluno){
		String msg = ("Hello! I am "+ nomeAluno +". Nice to meet you.");
		return msg;
	}
}
