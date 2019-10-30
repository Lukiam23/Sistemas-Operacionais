package models;
public class ContaBancaria{
	String nome;
	double saldo;

	public ContaBancaria(String nome, double saldo){
		this.nome = nome;
		this.saldo = saldo;
	}

	public synchronized void depositar(ContaBancaria conta,double valor){
		conta.saldo += valor;
		System.out.println(conta.nome+" depositou "+valor+" na conta bancária "+conta.nome);
	}

	public synchronized  void transferir(ContaBancaria destino, double valor){
		this.saldo -= valor;
		destino.saldo += valor;
		System.out.println(this.nome+" transferiu "+valor+" para a conta bancária "+destino.nome);
	}

	public synchronized double sacar(double valor){
		this.saldo -= valor;
		System.out.println(this.nome+" sacou "+valor);
		return valor;
	}

	public String toString(){
		return "Saldo da conta "+this.nome+": "+this.saldo;
	}
}