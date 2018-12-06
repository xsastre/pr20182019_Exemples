package pru03;

public class A {
	protected int d = 10;

	public void xxx() { System.out.println ("d en A = " + d); }

	public void xxx(int x) {
		char aux;
		if (this instanceof C) aux = 'C';
		else if (this instanceof B) aux = 'B';
		else aux = 'A';
		System.out.println ("Sóc xxx d'A aplicat sobre un objecte de la classe " + aux );
	}
}
