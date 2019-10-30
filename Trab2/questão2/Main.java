import qt2.Corredor;

public class Main{
	public static void main(String args[]){
		Corredor corredor1 = new Corredor("1",1,2);
		Corredor corredor2 = new Corredor("2",5,5);
		Corredor corredor3 = new Corredor("3",10,1);
		Corredor corredor4 = new Corredor("4",7,3);
		Corredor corredor5 = new Corredor("5",10,5);

		corredor1.start();
		corredor2.start();
		corredor3.start();
		corredor4.start();
		corredor5.start();

	}
}