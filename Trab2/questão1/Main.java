import qt1.Decrescente;
import qt1.Crescente;
public class Main{
	public static void main(String args[]){
		Decrescente t1 = new Decrescente("T1");
		Decrescente t2 = new Decrescente("T2");
		Thread t3 = new Thread(new Crescente("T3"));
		Thread t4 = new Thread(new Crescente("T4"));


		t1.start();
		t3.start();
		t2.start();
		t4.start();

	}
}