package pru05.files;

public class PRU05_parametres01 {
	public static void main(String[] arg) {
		if (arg.length==0) {
			System.out.println("Falten parametres");
		}
		else {
			System.out.println("El primer parametre es: "+arg[0]);
			System.out.println("El segon parametre es: "+arg[1]);
		}
	}

}