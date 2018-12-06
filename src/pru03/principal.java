package pru03;

public class principal {
	public static void main (String args[]) {
		int aux;
		A oa = new A();
		A ob = new B();
		C oc = new C();
		oc.visibilitat(); // (1)
		System.out.println("Crides al mètode xxx() existent a les tres classes:");
		oa.xxx(); // (2)
		ob.xxx(); // (3)
		oc.xxx(); // (4)
		System.out.println("Crides al mètode xxx(int x) existent a les tres classes:");
		oa.xxx(0); // (5)
		ob.xxx(0); // (6)
		oc.xxx(0); // (7)
	}

}
