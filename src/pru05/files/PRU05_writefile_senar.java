/**
 * 
 */
package pru05.files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Xavier
 *
 */
public class PRU05_writefile_senar {

	/**
	 * @param args
	 */
	public static final String NOM_FITXER="c:\\tmp\\senars.dat";
	public static void main(String[] args) {
	
		String nl = System.getProperty("line.separator");
		String linia;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(NOM_FITXER));

			for (int i=1;i<500;i=i+2) {
				linia=i+nl;
				System.out.print(linia);
				bw.write(linia);
			}
			bw.close();

			System.out.println("Archivo "+NOM_FITXER+" creat correctament.");

		} catch (IOException ioe) {
			System.out.println("S'ha produit un error de lectura/escriptura");
			System.err.println(ioe.getMessage());
		}
	}
}