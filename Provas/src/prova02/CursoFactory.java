package prova02;

public class CursoFactory {

	public CursoFactory() {
		
	}
	
	public Curso emTurma(String curso) throws EntradaInvalidaException {
		Curso novoCurso = null;
		
		if (curso.equals("Sueco")){
			novoCurso = new Sueco();
		} else if (curso.equals("Ingles")){
			novoCurso = new Ingles();
		} else if (curso.equals("Japones")){
			novoCurso = new Japones();
		} else {
			//throw new Exception("HelloWorld nao ensina "+ curso);
			throw new CursoInvalidoException(curso);
		}
		
		return novoCurso;
	}
	
}
