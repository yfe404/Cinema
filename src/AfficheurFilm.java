import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AfficheurFilm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JButton bFermer = null;
	
	protected AfficheurFilm(Window owner, Film f){
		super(owner, "Film", Dialog.ModalityType.APPLICATION_MODAL);
		this.setSize(600,300);
		JTextArea texte = new JTextArea(f.toString());

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(texte);

		bFermer = new JButton("Fermer");
		pane.add(bFermer);
		bFermer.addActionListener(this);

		JScrollPane scrollBar = new JScrollPane(texte, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollBar, BorderLayout.CENTER);
		this.getContentPane().add(bFermer, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == bFermer){
			setVisible(false);
		}	
	}
}
