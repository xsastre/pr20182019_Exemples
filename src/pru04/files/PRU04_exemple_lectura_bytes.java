package pru04.files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
/**
 * @author Xavier
 *
 */
public class PRU04_exemple_lectura_bytes {

	/**
	 * @param args
	 */
	public static final String NOM_FITXER="c:\\tmp\\parells.dat";
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputstream = new FileInputStream(NOM_FITXER);

		int data;
		try {
			data = inputstream.read();
			while(data != -1) {
				//do something with data...
				System.out.println("Raw data:"+data);
				System.out.println("Interpreted data:"+Character.toString ((char) data));

				data = inputstream.read();
			}
			inputstream.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
