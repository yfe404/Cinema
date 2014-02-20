

public class Main {

	public static void main(String[] args) {
		
		/* BEGIN TEST DATABASE */
		SQLiteJDBC database = new SQLiteJDBC();
		/* END TEST DATABASE */
		
		CSVFilmParser parser = new CSVFilmParser("cinedome_20140128.csv");
		Cinema c = new Cinema(parser.parseFile());
		AfficheurGui a = new AfficheurGui("Cinedome", c);
		
		Program prog = new Program(c, a);
		prog.run();
		
	}
		
}