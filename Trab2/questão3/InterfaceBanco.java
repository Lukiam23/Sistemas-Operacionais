import models.ContaBancaria;

class Depositar implements Runnable{
	ContaBancaria conta;
	double valor;
	public Depositar(ContaBancaria conta,double valor){
		this.conta = conta;
		this.valor = valor;
	}

	@Override
	public void run(){
		this.conta.depositar(conta,valor);
	}
}

class Transferir implements Runnable{
	ContaBancaria conta;
	ContaBancaria origem;
	double valor;

	public Transferir(ContaBancaria origem,ContaBancaria conta,double valor){
		this.conta = conta;
		this.valor = valor;
		this.origem = origem;
	}

	@Override
	public void run(){
		this.origem.transferir(conta,valor);
	}
}

class Sacar implements Runnable{
	ContaBancaria conta;
	double valor;
	
	public Sacar(ContaBancaria conta,double valor){
		this.conta = conta;
		this.valor = valor;
	}

	@Override
	public void run(){
		this.conta.sacar(valor);
	}
}

public class InterfaceBanco{
	String nome;
	double saldo;
	ContaBancaria conta;

	public InterfaceBanco(String nome,double saldo){
		this.nome = nome;
		this.saldo = saldo;
		conta = new ContaBancaria(nome,saldo);
	}

	public void depositar(ContaBancaria conta,double valor){
		Thread depositar = new Thread(new Depositar(conta,valor));
		depositar.start();
	}

	public void transferir(ContaBancaria destino, double valor){
		Thread transferir = new Thread(new Transferir(this.conta,destino,valor));
		transferir.start();
	}

	public void saque(double valor){
		Thread sacar = new Thread(new Sacar(conta,valor));
		sacar.start();
	}

	public String toString(){
		return this.conta.toString();
	}

	public static void main(String[] args) {
		InterfaceBanco interface1 = new InterfaceBanco("Conta1",1000.00);
		InterfaceBanco interface2 = new InterfaceBanco("Conta2",100.00);
		System.out.println(interface1);
		System.out.println(interface2);

		interface1.transferir(interface2.conta,100.00);
		interface2.saque(200.00);
		interface2.depositar(interface2.conta,10.00);
		interface1.saque(10.00);
	}

}