package qt1;
public class Crescente implements Runnable{
	String nome;
	int contador = 0;

	public Crescente(String nome){
		this.nome = nome;
	}

	public void run(){
		while(contador<=100){
			System.out.println(this.nome+": "+this.contador);
			this.contador++;
		}

	}
}