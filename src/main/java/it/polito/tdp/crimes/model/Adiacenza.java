package it.polito.tdp.crimes.model;

public class Adiacenza {

	private String a;
	private String b;
	private int peso;
	
	public Adiacenza(String a, String b, int peso) {
		
		this.a = a;
		this.b = b;
		this.peso = peso;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return  a +" -- " + b +" -- " + peso ;
	}
	
	
	
}
