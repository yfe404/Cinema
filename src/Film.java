import java.util.ArrayList;

public class Film {

	private String titre;
	private String date;
	private int temps;
	private String afficheDuFilm;
	private String categorie;
	private double noteCritique;
	private double noteSpectateurs;
	private ArrayList<String> acteurs = new ArrayList<String>();
	private ArrayList<String> horaires = new ArrayList<String>();


	public Film(String titre, String date, int temps, String afficheDuFilm, String categorie, double noteCritique, double noteSpectateurs, ArrayList<String> acteurs, ArrayList<String> horaires) {
		this.setTitre(titre);
		this.setDate(date);
		this.setTemps(temps);
		this.setAfficheDuFilm(afficheDuFilm);
		this.setCategorie(categorie);
		this.setNoteCritique(noteCritique);
		this.setNoteSpectateurs(noteSpectateurs);
		this.setActeurs(acteurs);
		this.setHoraires(horaires);
	}


	protected String getTitre(){
		return titre;
	}

	/**
	 * @return the date
	 */
	protected String getDate() {
		return date;
	}


	/**
	 * @return the categories
	 */
	protected String getCategorie() {
		return categorie;
	}

	/**
	 * @return the horaires
	 */
	protected ArrayList<String> getHoraires() {
		return horaires;
	}


	/**
	 * @return the noteSpectateurs
	 */
	public double getNoteSpectateurs() {
		return noteSpectateurs;
	}






	/**
	 * @param titre the titre to set
	 */
	protected void setTitre(String titre) {
		this.titre = titre;
	}


	/**
	 * @param date the date to set
	 */
	protected void setDate(String date) {
		this.date = date;
	}


	/**
	 * @param categorie the categories to set
	 */
	protected void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	/**
	 * @param horaires the horaires to set
	 */
	protected void setHoraires(ArrayList<String> horaires) {
		this.horaires = horaires;
	}

	/**
	 * @param noteSpectateurs the noteSpectateurs to set
	 */
	public void setNoteSpectateurs(double noteSpectateurs) {
		this.noteSpectateurs = noteSpectateurs;
	}


	public int getTemps() {
		return temps;
	}


	public void setTemps(int champsC) {
		this.temps = champsC;
	}


	public String getAfficheDuFilm() {
		return afficheDuFilm;
	}


	public void setAfficheDuFilm(String afficheDuFilm) {
		this.afficheDuFilm = afficheDuFilm;
	}


	public double getNoteCritique() {
		return noteCritique;
	}


	public void setNoteCritique(double noteCritique) {
		this.noteCritique = noteCritique;
	}


	public ArrayList<String> getActeurs() {
		return acteurs;
	}


	public void setActeurs(ArrayList<String> acteurs) {
		this.acteurs = acteurs;
	}
	
	public String acteurToString(){
		String acteur = "";
		for(String s : acteurs){
			acteur += s;
			acteur += "; ";
		}
		return acteur;
	}
	

	public String toString(){
		String texte = "";

		
		texte += "Titre : " + titre + "\n";
		texte += "Date : " + date + "\n";
		texte += "Duree : " + Integer.toString(temps) + "\n";
		texte += "Affiche du film : " + afficheDuFilm + "\n";
		texte += "Categorie : " + categorie + "\n";
		texte += "Note des critiques : " + Double.toString(noteCritique) + " / 5\n";
		texte += "Note des Spectateurs : " + Double.toString(noteSpectateurs) + " / 5\n";
		texte += "Acteurs : " + "\n\t";
		for(String s : acteurs){
			texte += s;
			texte += "\n\t";
		}
		texte += "\nHoraires : " + "\n\t";
		for(String s : horaires){
			texte += s;
			texte += "h\n\t";
		}
		
		return texte;
	}
}
