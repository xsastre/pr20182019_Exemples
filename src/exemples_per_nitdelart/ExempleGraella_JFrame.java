package exemples_per_nitdelart;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
class MargesiCaselles {
	int marge;
	int mida;
}
public class ExempleGraella_JFrame {
	
	private static MargesiCaselles optimitza(int midaMaxima, int nombreDesitjat) {
		MargesiCaselles margesicaselles=new MargesiCaselles();
		if ((midaMaxima%nombreDesitjat)==0) {
			margesicaselles.marge=0;
			margesicaselles.mida=midaMaxima/nombreDesitjat;
			return margesicaselles;
		}
		else {
			margesicaselles.mida=midaMaxima/nombreDesitjat-1;
			margesicaselles.marge=(midaMaxima-(margesicaselles.mida*nombreDesitjat)+midaMaxima%nombreDesitjat)/2;
			return margesicaselles;
		}
	}
	public static ImageIcon obtenirImatgeIcona(JLabel label) {
		URL url_imatge = ExempleGraella_JFrame.class.getResource("baixa.png"); 
		BufferedImage img = null;
		try {
		    img = ImageIO.read(url_imatge);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
		        Image.SCALE_SMOOTH);
		return new ImageIcon(dimg);
	}
	
	public static void dibuixaCaselles(int numFiles,int numColumnes,int midaFiles,int midaColumnes,int margeSup,
			int margeEsq,JFrame frame){
		JLabel[] casella = new JLabel[numFiles*numColumnes];
		int comptador=0;
		frame.getContentPane().removeAll();
		for (int y=0;y<nombreFilesDesitjades;y++) {
			for (int x=0;x<nombreColumnesDesitjades;x++){
				casella[x]=new JLabel(String.valueOf(comptador++));
				casella[x].setBounds(margeEsq+x*midaColumnes,margeSup+y*midaFiles, midaColumnes,midaFiles);
				casella[x].setOpaque(true);
				Border borde=BorderFactory.createLineBorder(Color.BLUE, 1);
				casella[x].setBorder(borde);
				casella[x].setBackground(Color.black);
				casella[x].setForeground(Color.red);		
				casella[x].setIcon(obtenirImatgeIcona(casella[x]));
				frame.add(casella[x]);
				frame.repaint();
			}
		}
	}
	public static final int midaX=800;
	public static final int midaY=800;
	public static final int nombreColumnesDesitjades=6;
	public static final int nombreFilesDesitjades=6;

	public static void main(String[] args){
		// Inicialitzo el frame
		JFrame frame= new JFrame();	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(midaX, midaY);
		frame.setLocation(100,100);
		frame.setLayout(null);
		/*
		 * Les linies que venen a continuacio me permeten dimensionar les mides del frame
		 * a les mides que realment vull. I.e. eliminant la barra del titol de la finestra.
		 */
		Dimension Dim = new Dimension(midaX, midaY);
	    frame.setPreferredSize(Dim);
	    frame.pack();
	    Dim.width  = midaX  + (frame.getWidth()  - frame.getContentPane().getWidth()); 
	    Dim.height = midaY + (frame.getHeight() - frame.getContentPane().getHeight());
	    frame.setPreferredSize(Dim);
	    frame.pack();
        frame.setVisible(true);

        // Calculo les dimensions en funcio de l'espai disponible i a les preferencies
		MargesiCaselles horitzontal, vertical;
		horitzontal=optimitza(frame.getContentPane().getWidth(),nombreColumnesDesitjades);
    	vertical=optimitza(frame.getContentPane().getHeight(),nombreFilesDesitjades);
    	
    	// Pinta les caselles
		dibuixaCaselles(nombreFilesDesitjades, nombreColumnesDesitjades, vertical.mida,horitzontal.mida,
				vertical.marge,horitzontal.marge,frame);

		
		// Afegeixo un esdeveniment per poder redimensionar la pantalla
		frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
            	MargesiCaselles horitzontal, vertical;
            	horitzontal=optimitza(frame.getContentPane().getWidth(),nombreColumnesDesitjades);
            	vertical=optimitza(frame.getContentPane().getHeight(),nombreFilesDesitjades);
        		dibuixaCaselles(nombreFilesDesitjades, nombreColumnesDesitjades, vertical.mida,horitzontal.mida,
        				vertical.marge,horitzontal.marge,frame);
            	frame.repaint();
            }
        });
		while(true) {
			
		}
	}
}
