/**
 * 
 */
package pru05.files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/**
 * @author Xavier
 *
 */
public class PRU05_read_bytes {

	/**
	 * @param args
	 */

	public static final String NOM_FITXER_LECTURA_PARELLS="c:\\tmp\\parells.dat";
	public static void main(String[] args) {
		
		try {
			
			//BufferedReader br_parells = new BufferedReader(new FileReader(NOM_FITXER_LECTURA_PARELLS));
			DataInputStream br_parells = new DataInputStream(new FileInputStream(NOM_FITXER_LECTURA_PARELLS));
			int caracter=br_parells.read();
			while (caracter!=-1) {
				System.out.print(caracter);
				caracter=br_parells.read();
			} 
			br_parells.close();

		} catch (IOException ioe) {
			System.out.println("S'ha produit un error de lectura/escriptura");
			System.err.println(ioe.getMessage());
		}
	}
}
