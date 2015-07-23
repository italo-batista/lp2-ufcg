import java.io.ObjectInputStream.GetField;


public class User {

	double dinheiro;
	Jogo gamer;
	
	
	public User() {
		dinheiro = 100;
		gamer = new RPG("Nada");
	}
	
	public void jogar(){
		this.dinheiro = gamer.jogar(this.dinheiro);
	}
	
	public double getDinheiro(){
		return this.dinheiro;
	}

	public static void main(String[] args) {
		
		User user = new User();
		user.jogar();
		
		System.out.println(user.getDinheiro());		
	}
	
}
