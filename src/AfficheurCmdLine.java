import java.util.ArrayList;
import java.util.Scanner;

public class AfficheurCmdLine {

	protected int trier() {
		System.out.println("Trier par : ");
		System.out.println("1. Nom");
		System.out.println("2. Note");

		Scanner sc = new Scanner(System.in);

		int choix = sc.nextInt();

		return choix;
	}

/*	protected String getChemin() {
		System.out.println("Veuillez rentrer un chemin de fichier à lire : ");

		Scanner sc = new Scanner(System.in);

		String path = sc.nextLine();

		return path;
	}*/

	protected int afficherMenu() {

		boolean etat = false;
		int choix = 0;
		Scanner sc = new Scanner(System.in);

		while (etat == false) {

			System.out.println("Différentes options : ");
			System.out.println("1. Ajouter");
			System.out.println("2. Afficher");
			System.out.println("3. Random");
			System.out.println("4. Lire un fichier CSV");
			System.out.println("5. Trier");
			System.out.println("6. Quitter");

			choix = sc.nextInt();

			if (choix < 1 || choix > 6) {
				System.out.println("Veuillez saisir un entier entre 1 et 6");
			} else {
				etat = true;
			}

		}
		
		return choix;
	}

	public void afficher(Film f) {
		System.out.println("Titre du film : " + f.getTitre());
		System.out.println("Date du film : " + f.getDate());
		System.out.println("Durée du film : " + f.getTemps());
		System.out.println("Affiche du Film : " + f.getAfficheDuFilm());
		System.out.println("Catégorie du film : " + f.getCategorie());
		System.out.println("Note des critiques : " + f.getNoteCritique());
		System.out.println("Note des spectateurs : " + f.getNoteSpectateurs());

		System.out.println("Acteurs pour ce film : ");
		ArrayList<String> acteurs = f.getActeurs();
		for (int i = 0; i < acteurs.size(); i++) {
			System.out.println("   " + acteurs.get(i));
		}

		System.out.println("Horaires pour ce film : ");
		ArrayList<String> horaires = f.getHoraires();
		for (int i = 0; i < horaires.size(); i++) {
			System.out.println("   " + horaires.get(i) + "h");
		}
	}

	public void afficher(ArrayList<Film> liste) {

		System.out.println("-----------------------------");

		for (Film f : liste) {
			afficher(f);
			System.out.println("-----------------------------");
		}
	}

	public Film ajouter() {

		// vrai alors l'état est bon, faux l'état à mal était saisie,
		String titre;
		String date;
		int temps = 0;
		String afficheDuFilm;
		String categorie;
		double noteCritique = 0;
		double noteSpectateurs = 0;
		ArrayList<String> acteurs = new ArrayList<String>();
		ArrayList<String> horaires = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Titre du film : ");
		titre = sc.nextLine();

		System.out.println("Date du film : ");
		date = sc.nextLine();

		try {
			System.out.println("Durée du film : ");
			temps = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Ce n'est pas une durée");
			temps = 0;
		}
		sc.nextLine();

		System.out.println("L'affiche du film : ");
		afficheDuFilm = sc.nextLine();

		System.out.println("Catégorie du film : ");
		categorie = sc.nextLine();

		try {
			System.out.println("Note des critiques pour ce film : ");
			noteCritique = sc.nextDouble();
		} catch (Exception e) {
			System.out.println("Ce n'est pas une note");
			noteCritique = 0;
		}
		sc.nextLine();
		

		try {
			System.out.println("Note des Spectateurs pour ce film : ");
			noteSpectateurs = sc.nextDouble();
		} catch (Exception e) {
			System.out.println("Ce n'est pas une note");
			noteSpectateurs = 0;
		}
		sc.nextLine();


		int nbActeurs = 0;
		try {
			System.out.println("Combien d'acteurs voulez-vous ajouter ?");
			nbActeurs = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Ce n'est pas un nombre");
			nbActeurs = 0;
		}
		sc.nextLine();
		for(int i = 0 ; i < nbActeurs ; i++) {
			acteurs.add(sc.nextLine());
		}


		int nbHoraires = 0;
		
		try {
			System.out.println("Combien d'horaires voulez-vous ajouter ?");
			nbHoraires = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Ce n'est pas un nombre");
			nbHoraires = 0;
		}
		sc.nextLine();

		for(int i = 0 ; i < nbHoraires ; i++) {
			System.out.println("Horaire n° " + i+1);
				horaires.add(sc.nextLine());
		}

		return new Film(titre, date, temps, afficheDuFilm, categorie, noteCritique, noteSpectateurs, acteurs, horaires);
	}
}
