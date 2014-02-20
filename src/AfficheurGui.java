import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AfficheurGui extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Cinema c = null;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table = null;
	private JButton bAfficher = null;
	private JMenuItem charger = new JMenuItem("Charger");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem random = new JMenuItem("Random");
	private JMenuItem trierNote = new JMenuItem("Par Note");
	private JMenuItem trierTitre = new JMenuItem("Par Titre");

	
	
	protected AfficheurGui(String titre, Cinema c){
		super(titre);
		this.c = c;
		this.setSize(750,500);
		menu();
		body();
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == bAfficher){
			int index;
			if(((index = table.getSelectedRow()) != -1)){
				AfficheurFilm af = new AfficheurFilm(this, c.getListe().get(index));
				af.setVisible(true);
			}
		}
		
		if(event.getSource() == quitter){
			System.exit(0);
		}
		
		/*if(event.getSource() == charger){
			System.exit(0);
		}*/
		
		if(event.getSource() == random){
			AfficheurFilm af = new AfficheurFilm(this, c.random());
			af.setVisible(true);
		}
		
		if(event.getSource() == trierNote){
			c.trierNotes();
			model.setRowCount(0); // pour supprimer la table
			body();
		}
		
		if(event.getSource() == trierTitre){
			c.trierAlphab();
			model.setRowCount(0); // pour supprimer la table
			body();
		}
	}
	
	private void menu(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fichier = new JMenu("Fichier");
		JMenu afficher = new JMenu("Afficher");
		JMenu rechercher = new JMenu("Rechercher");
		
		fichier.add(charger);
		fichier.add(new JSeparator());
		fichier.add(quitter);


		afficher.add(random);

		JMenu trier = new JMenu("Trier");
		trier.add(trierNote);
		trier.add(trierTitre);
		
		charger.addActionListener(this);
		quitter.addActionListener(this);
		random.addActionListener(this);
		trierNote.addActionListener(this);
		trierTitre.addActionListener(this);

		afficher.add(trier);


		menuBar.add(fichier);
		menuBar.add(afficher);
		menuBar.add(rechercher);

		this.setJMenuBar(menuBar);
	}

	private void body(){
		String[] columnNames = {"Titre", "Acteurs"};

		int taille = c.getListe().size();
		
		Object[][] data = new Object[taille][taille];
		for(int h = 0; h < taille; h++){
			for(int l = 0; l < columnNames.length; l++){
				if(l == 0){
					data[h][l] = c.getListe().get(h).getTitre();
				}else{
					data[h][l] = c.getListe().get(h).acteurToString();
				}
			}
		}
		model.setDataVector(data, columnNames);
		
		table = new JTable(model);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(table, BorderLayout.CENTER);
		
		bAfficher = new JButton("Afficher");
		pane.add(bAfficher);
		bAfficher.addActionListener(this);

		JScrollPane scrollBar = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollBar, BorderLayout.CENTER);
		this.getContentPane().add(bAfficher, BorderLayout.SOUTH);

	}
}

