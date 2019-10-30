package qt2;
public class Corredor extends Thread{
	String nome;
	int percurso;
	int descanso;

	public Corredor(String nome,int percurso,int descanso){
		this.nome = nome;
		this.percurso = percurso;
		this.descanso = descanso;
	}

	public void run(){
		while(this.percurso>0){
			try{
				System.out.println("Faltam "+this.percurso+" metros para o corredor "+this.nome);
				this.percurso--;
				Thread.sleep(this.descanso*1000);
			} catch (InterruptedException ex) { 
				System.out.println(ex); 
			} 
			
		}
		System.out.println("Corredor "+this.nome+" chegou."); 

		
	}

}