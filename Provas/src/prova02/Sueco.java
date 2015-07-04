package prova02;

public class Sueco implements Curso {

	public Sueco() {
		super();
	}
	
	public double calculaFacilidade(double escuta, double fala, double leitura, double escrita){
		double facilidade = (0.1 * leitura) + (0.1 * escrita) + (0.3 * fala) + (0.5 * escuta);
		return facilidade;
	}
	
	public String cumprimenta(String nomeAluno){
		String msg = ("Hej hej! Jag heter "+ nomeAluno +". Trevligt att träffas.");
		return msg;
	}
	
}
