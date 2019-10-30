package qt1;
public class Decrescente extends Thread{
	String nome;
	int contador = 100;

	public Decrescente(String nome){
		this.nome = nome;
	}

	public void run(){
		while(contador>=0){
			System.out.println(this.nome+": "+this.contador);
			this.contador--;
		}

	}
}