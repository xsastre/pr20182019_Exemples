package pru03;

public class C extends B
{
	protected int d = 30;

	public void xxx() {
		System.out.println ("d en C = " + d);
		super.xxx();
	}

	public void visibilitat () {
		System.out.println ("Des del mètode \"visibilitat\" en C:");
		System.out.println ("d en C = " + d);
		System.out.println ("d en B = " + super.d);
	}
}
