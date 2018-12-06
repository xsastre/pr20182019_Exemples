package pru03;


public class AlumneReal extends Alumne implements InteficiaAlumne {
	
	/* Aquí volem posar una matriu per controlar els moduls als quals
	 * se pot matricular un alumne. Com que Java no permet crear arrays
	 * multidimensionals haurem de crear una classe modul_matricula amb dos
	 * atributs nom_modul i matriculat, i després fer un array d'objectes
	 * modul_matricula
	 * 
	 */
	public class Modul_Matricula {
		String nom_modul;
		boolean matriculat;
		public Modul_Matricula(String nou_nom_modul,boolean nou_matriculat) {
			this.nom_modul=nou_nom_modul;
			this.matriculat=nou_matriculat;
		}
	}
	
	Modul_Matricula[] moduls;
	
	public void inicialitzar_Modul_Matricula(int num_moduls, String[] nom_moduls) {
		moduls=new Modul_Matricula[num_moduls];
		for (int i=0;i<num_moduls;i++) {
			this.moduls[i]=new Modul_Matricula(nom_moduls[i],false);
		}	
	}

	/*  
	 * Implementació del constructor
	 */
	
	public AlumneReal(String nom) {
		this.nom=nom; //this.nom és l'atribut nom heretat de la classe Alumne
		
		/* 
		 * Aquí indicarem que no està matriculat encara de cap mòdul.
		 * Només ho farem per dos mòduls. Feu-ho per la resta de mòduls de 
		 * 1er DAM.
		 */
		
		/*
		 * Ho podriem fer així com segueix, però no vols sembla mes elegant
		 * i optim fer-ho d'una altra manera?
		 *
		this.moduls=new Modul_Matricula[2];
		this.moduls[0] = new Modul_Matricula("Programació",false);
		this.moduls[1] = new Modul_Matricula("Llenguatge de marques",false);
		*/

		
		
		String[] nom_moduls= {"Programació",
				"Llenguatge de marques",
				"FOL",
				"Entorns de desenvolupament",
				"Base de dades",
				"Sistemes Informàtics"};
		
		this.inicialitzar_Modul_Matricula(2, nom_moduls);
		
	}

	/*  
	 * Implementem el mètode de l'interface
	 */

	@Override
	public void matricularModul(String nom_modul) throws Exception {
		
		/* 
		 * Comprovarem que el nom del modul és "matriculable" si no ho
		 * és llançarem una excepció
		 */

		int nom_modul_trobat=trobarNomModul(nom_modul);
		
		if (nom_modul_trobat==-1) 
			throw new Exception ("Missatge d'excepció control·lada ==> Nom de mòdul erroni");
		else if (moduls[nom_modul_trobat].matriculat==true)
				throw new Exception ("Missatge d'excepció control·lada ==> Mòdul ja matriculat");
		else 
			moduls[nom_modul_trobat].matriculat=true;
	}

	/*  
	 * Implementem nous mètode propi de la subclasse
	 */

	public int trobarNomModul(String nom_modul) { // retorna -1 si el nom no existeix o la posicio si existeix
		int i=0;
		boolean nom_modul_trobat=false;
		do {
			if (nom_modul.equals(moduls[i].nom_modul))
				nom_modul_trobat=true;
			else
				i++;
		} while ((i<moduls.length) && (!nom_modul_trobat));
		if (!nom_modul_trobat)
			return -1;
		else
			return i;
	}
	
	public boolean comprovarMatriculat(String nom_modul) { // implementació d'un get per matriculat_curs
		int nom_modul_trobat=trobarNomModul(nom_modul);
		if (nom_modul_trobat==-1) 
			return false;
		else
			return moduls[nom_modul_trobat].matriculat;
	}
	
	/*  
	 * Implementem el mètode de l'interface
	 */
	
	
	@Override
	public int ferExamen(String nom_modul) throws Exception {
		if (this.comprovarMatriculat(nom_modul)) { //comprova si està matriculat
			return (int)(Math.random()*10);
		}
		else
			throw new Exception ("Missatge d'excepció control·lada ==> L'alumne "+this.nom+
					" no està matriculat i no pot fer l'examen");
	}
}
