package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */




public class UpgradeInvalidoException extends Exception {

	public UpgradeInvalidoException(String tipo) {
		super("Upgrade invalido: "+ tipo +" ja eh do tipo Veterano!");
	}
	
	public UpgradeInvalidoException() {
		super("Upgrade invalido: usuario nao possue x2p minimo de 1000.");
	}
	
	
}