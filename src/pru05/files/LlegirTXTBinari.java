package pru05.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import proves.UtilsProgramacio;

public class LlegirTXTBinari {
	public static final String NOM_FITXER="c:\\tmp\\parells.dat";

	public static void main(String[] args) {
		
		int dadallegida;
		UtilsProgramacio utils=new UtilsProgramacio();
		try {
			InputStream inputstream = new FileInputStream(NOM_FITXER);
			dadallegida=inputstream.read();
			while (dadallegida!=-1) {
				System.out.println(utils.MostraBinari(dadallegida,8)+" - "+dadallegida+" - "+ (char)dadallegida);
				dadallegida=inputstream.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No s'ha trobat l'arxiu");
		} catch (IOException e) {
			System.out.println("S'ha produit un error llegint el fitxer");
		}
	}

}
