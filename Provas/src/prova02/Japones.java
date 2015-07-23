package prova02;

public class Japones implements Curso {

	public Japones() {
		super();
	}
	
	public double calculaFacilidade(double escuta, double fala, double leitura, double escrita){
		double facilidade = (0.4 * leitura) + (0.6 * escrita);
		return facilidade;
	}
	
	public String cumprimenta(String nomeAluno){
		String msg = ("Hajimemashite. Watashi ha "+ nomeAluno +" desu.");
		return msg;
	}
}
