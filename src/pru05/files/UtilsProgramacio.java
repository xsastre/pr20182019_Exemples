package pru05.files;


class UtilsProgramacio {
	public static String MostraBinari(int valor, int longitud) {
		String num_binari="";
		int[] matriu_num_binari;
		int modul=0;
		int quocient=0;
		int potencia=0;
		int num_digits=0;
		int limit_superior;
		// Calcula num digits
		while (potencia<=valor) {
			num_digits++;
			potencia=(int)Math.pow(2, num_digits);
		}
		matriu_num_binari=new int[num_digits];
		//System.out.println("Num digits: "+num_digits);
		quocient=valor;
		do {
			modul=quocient%2;
			quocient=quocient/2;
			matriu_num_binari[num_digits-1]=modul;
			//System.out.println(quocient+"--"+modul);
			num_digits--;
		} while (quocient>=2);
		matriu_num_binari[0]=quocient;

		//Converteix array a string
		if (matriu_num_binari.length<longitud) {
			limit_superior=longitud;
		} else {
			limit_superior=matriu_num_binari.length;
		}
		
		for (int i=0;i<limit_superior;i++) {
			if (i<matriu_num_binari.length) {
				num_binari=num_binari+matriu_num_binari[i];
			} else {
				num_binari="0"+num_binari;
			}
		}
		//System.out.println(num_binari);
		return num_binari;
	}
}
