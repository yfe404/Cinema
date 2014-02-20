import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Cinema {
	ArrayList<Film> liste = new ArrayList<Film>();


	protected Cinema(ArrayList<Film> liste) {
		this.liste = liste;
	}

	
	protected ArrayList<Film> getListe() {
		return liste;
	}

	protected void trierAlphab(){
		Collections.sort(liste, new Comparator<Film>() {
			@Override
			public int compare(Film a, Film b){
				int value = 0;
				String titre = a.getTitre();
				value = titre.compareTo(b.getTitre());
				return value;
			}
		});

	}

	protected void trierNotes(){
		Collections.sort(liste, new Comparator<Film>() {
			@Override
			public int compare(Film a, Film b){
				int value = 0;
				Double note = a.getNoteSpectateurs();
				return note.compareTo(b.getNoteSpectateurs());
			}
		});
	}

	protected void add(String titre, String date, int temps, String afficheDuFilm, String categorie, double noteCritique, double noteSpectateurs, ArrayList<String> acteurs, ArrayList<String> horaires) {
		Film f = new Film(titre, date, temps, afficheDuFilm, categorie, noteCritique, noteSpectateurs, acteurs, horaires);
		liste.add(f);
	}
	
	protected void add(Film f){
		liste.add(f);
	}
	
	
	protected Film atPosition(int i) {
		return liste.get(i);
	}
	
	
	protected Film random() {
		return atPosition((int)(Math.random() * (liste.size())));
	}
}
