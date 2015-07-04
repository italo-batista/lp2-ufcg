package prova02;

import java.util.HashSet;

public class Aluno implements Comparable<Aluno>{

	private String nome;
	private double mensalidade;
	private double escuta;
	private double fala;
	private double leitura;
	private double escrita;
	private Curso cursoMatriculado;
	private double pontuacao;
	
	public Aluno(
		String nome,
		double mensalidade,
		double escrita,
		double escuta,
		double fala,
		double leitura ) throws EntradaInvalidaException {
		
		this.nome = nome;
		this.mensalidade = mensalidade;
		
		if (escuta < 0 || escuta > 10 ||
			escrita < 0 || escrita > 10 ||
			fala < 0 || fala > 10 ||
			leitura < 0 || leitura > 10) {
			//throw new Exception("Nivel de proficiencia invalido. Deve ser entre 0 e 10.");
			throw new ProficienciaInvalidaException();
		} else {
			this.escuta = escuta;
			this.escrita = escrita;
			this.fala = fala;
			this.leitura = leitura;
		}
	}

	public void matricula(String curso) throws EntradaInvalidaException{
		CursoFactory seMatricula = new CursoFactory();
		this.cursoMatriculado = seMatricula.emTurma(curso);
	}
	
	public double calculaFacilidadeMedia() throws LogicaException {
		if (this.cursoMatriculado == null) {
			//throw new Exception(this.nome +" ainda nao esta matriculado em nenhum curso.");
			throw new NaoMatriculadoException(this.nome);
		} else { 
			double facilidadeGenerica = (this.escuta + this.leitura + this.escrita + this.fala) / 4;
			return facilidadeGenerica;
		}			
	}
	
	public double calculaFacilidade() throws LogicaException{
		if (this.cursoMatriculado == null) {
			//throw new Exception(this.nome +" ainda nao esta matriculado em nenhum curso.");
			throw new NaoMatriculadoException(this.nome);
		} else { 
			double facilidade = this.cursoMatriculado.calculaFacilidade(this.escuta, this.fala, this.leitura, this.escrita);
			return facilidade;
		}
	}
	
	public String cumprimenta(){
		String msg = this.cursoMatriculado.cumprimenta(this.nome);
		return msg;
	}
	
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public double getEscuta() {
		return escuta;
	}

	public void setEscuta(double escuta) {
		this.escuta = escuta;
	}

	public double getFala() {
		return fala;
	}

	public void setFala(double fala) {
		this.fala = fala;
	}

	public double getLeitura() {
		return leitura;
	}

	public void setLeitura(double leitura) {
		this.leitura = leitura;
	}

	public double getEscrita() {
		return escrita;
	}

	public void setEscrita(double escrita) {
		this.escrita = escrita;
	}

	
	public Curso getCursoMatriculado() {
		return cursoMatriculado;
	}

	
	public void setCursoMatriculado(Curso cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
	}

	
	public double getPontuacao() {
		return pontuacao;
	}

	
	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	@Override
	public int compareTo(Aluno outroAluno) {
		return this.nome.compareTo(outroAluno.getNome());
	}
			
}
