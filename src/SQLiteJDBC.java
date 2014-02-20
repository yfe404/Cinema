
import java.sql.*;
import java.util.ArrayList;

public class SQLiteJDBC
{

	private Connection _connection = null;

	public SQLiteJDBC()
	{

		try {
			Class.forName("org.sqlite.JDBC");
			this.setConnection(DriverManager.getConnection("jdbc:sqlite:test.db"));
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}


	/**
	 * Crée une table Film.
	 * @return 
	 * @throws SQLException 
	 */
	public void createFilmTable() throws SQLException
	{
		Statement stmt = null;

		try{
			stmt = getConnection().createStatement();
			String sql = "CREATE TABLE TFILMS " +
					"(TITRE VARCHAR PRIMARY KEY     NOT NULL," +
					" DATE           VARCHAR    , " + 
					" DUREE          INT    , " + 
					" URLAFFICHE     VARCHAR	, " + 
					" CATEGORIE     VARCHAR	NOT NULL, " + 
					" NOTECRITIQUES   DOUBLE	, " + 
					" NOTESPECTATEURS     DOUBLE,	 " + 
					" ACTEURS     VARCHAR,	 " + 
					" HORAIRES     VARCHAR)"; 
			stmt.executeUpdate(sql);
			stmt.close();
			getConnection().close();
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		System.out.println("Table created successfully");
	}

	public void insertFilms(ArrayList<Film> list) throws SQLException
	{
		Statement stmt = null;
		String query = null;

		try{
			stmt = getConnection().createStatement();


			for(Film f : list){
				try{
				query = "INSERT INTO TFILMS VALUES(" + 
						"'" + f.getTitre().replace('\'', ' ') + "', " +
						"'" + f.getDate() + "', " +
						"'" + f.getTemps() + "', " +
						"'" + f.getAfficheDuFilm() + "', " +
						"'" + f.getCategorie().replace('\'', ' ') + "', " +
						"'" + f.getNoteCritique() + "', " +
						"'" + f.getNoteSpectateurs() + "', ";

				query += "'";
				for(String a : f.getActeurs()){
					query += a + ", ";
				}
				query += "', ";

				query += "'";
				for(String h : f.getHoraires()){
					query += h + ", ";
				}
				query += "')";

				stmt.executeUpdate(query);
				}catch(Exception e){
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
					System.err.println("Request: " + query + " has failed !");
				}
			}

			stmt.close();
			this.getConnection().close();
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.err.println("Last request: " + query);
		}

		System.out.println("All the films have been added successfully");

	}


	/**
	 * @return the connection
	 */
	protected Connection getConnection() {
		return _connection;
	}


	/**
	 * @param connection the connection to set
	 */
	protected void setConnection(Connection connection) {
		this._connection = connection;
	}

}
