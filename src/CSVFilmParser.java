/* Parser de fichier CSV 
 * Lit les lignes d'un fichier CSV contenant des Films.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFilmParser {
	
	private String source;
	private BufferedReader entree;
	private boolean EOF = false;
	
	public CSVFilmParser(String _source){
		source = _source;
		
		try{
			entree = new BufferedReader
					(new FileReader(source));
		}catch(Exception e){
			System.out.println(e);
		}
	}

	protected String getSource() {
		return source;
	}
	
	protected void setSource(String source) {
		this.source = source;
	}
	
	private Film parseLine(){
		
		String ligne;
		
		try{
			ligne=entree.readLine();
			if(ligne == null){
				EOF = true;
				return null;
			}
			
			String[] elements = new String[9];
			elements = ligne.split(";", 9);
			
			if(9 == elements.length){
				
				ArrayList<String> acteurs = new ArrayList<String>();
				ArrayList<String> horaires = new ArrayList<String>();
				
				for(String acteur : elements[7].split(",")){
					acteurs.add(acteur);
				}
				
				for(String heure : elements[8].split(",")){
					horaires.add(heure);
				}
				
				Double n1, n2;
				try{
					n1 = Double.parseDouble(elements[5]);
				}catch(Exception e){
					n1 = 0.;
				}
				try{
					n2 = Double.parseDouble(elements[6]);
				}catch(Exception e){
					n2 = 0.;
				}

				
				Film f = new Film(	
						elements[0],							// Titre
						elements[1],							// Date
						Integer.parseInt(elements[2]),			// Duree
						elements[3],							// Url Affiche
						elements[4],							// Catégorie(s)
						n1,										// Note Critiques
						n2,										// Note Spectateurs
						acteurs,								// Acteurs
						horaires);								// Horaires
				
				return f;										
			}
			
			return null;
			
			
		}catch(IOException e){
			System.out.println(e);
			return null;				// Retourne NULL en cas d'erreur 
											
			}
	}
	
	public ArrayList<Film> parseFile(){
		
		ArrayList<Film> films = new ArrayList<Film>();
		Film f;
		
		while(!EOF){
			f = parseLine();
			if(f!=null){
				films.add(f);
			}
		}
		
		return films;
	}
	
}
	
