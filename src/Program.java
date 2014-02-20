public class Program {
	Cinema cinema = null;
	AfficheurGui afficheur = null;
	
	protected Program(Cinema c, AfficheurGui a) {
		this.cinema = c;
		this.afficheur = a;
	}
	
	protected void run(){
		afficheur.setVisible(true);
	}
		/*int choix = afficheur.afficherMenu();
		
		switch(choix) {
			case 1 :
				cinema.add(afficheur.ajouter());
				break;
			case 2 : 
				afficheur.afficher(cinema.getListe());
				break;
			case 3 : 
				afficheur.afficher(cinema.random());
				break;
			case 4 :
				// pour le moment le fichier est chargé via le constructeur 
				// de la classe CSVFilmParser.
				System.out.println("Cette option n'est pas encore disponible.");
				break;
			case 5:
				int choixTrier = afficheur.trier();
				if(choixTrier == 1) {
					cinema.trierAlphab();
				}
				if(choixTrier == 2) {
					cinema.trierNotes();
				}
				break;
			case 6 :
				System.exit(0);
		}		
	}	*/
}