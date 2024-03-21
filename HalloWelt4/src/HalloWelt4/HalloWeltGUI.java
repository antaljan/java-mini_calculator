package HalloWelt4;
/*Klasse HelloWeltGUI ist die grafische OberflächeDiese 
 * dies Version mit Innere und kompakt Listener
*/

//Imports
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

// die Klasse HelloWeltGUI auf Basis JFrame Fenster
public class HalloWeltGUI extends JFrame{
	//automatisch von Eclips hingefügt
	private static final long serialVersionUID = 635029908949600524L;
	// Die beide Labels
	private JLabel ausgabe, ausgabe2;
	// die beide Schaltflächen
	private JButton schaltflaeche1, schaltflaeche2;
	// das ist die kompakte und innere Listener
	class MeinKompakterListener extends WindowAdapter implements ActionListener{
		//  Windowslistener welche beim öffnen der Fenster fragt nach eine Nahme
		@Override
		public void windowOpened(WindowEvent e) {
			String eingabe;
			eingabe = JOptionPane.showInputDialog("Wer will die Welt grüßen?");
			setAusgabe2Text(eingabe);
		}
		// Actionlistener welche beide Schaltflächen handelt
		@Override
		public void actionPerformed(ActionEvent e) {
			// Aufgaben für die Schaltfläche Beenden
			if (e.getActionCommand().equals("exit"))
				System.exit(0);
			// Aufgaben für die Schaltfläche neue Nahme
			if (e.getActionCommand().equals("change")) {
				String eingabe;
				eingabe = JOptionPane.showInputDialog("Wer will die Welt grüßen?");
				setAusgabe2Text(eingabe);		}
		}
	}
	// Konstructor für de Instanz
	public HalloWeltGUI(String fenstertitel) {
		super(fenstertitel);
		// Variablen
		ausgabe = new JLabel("Hallo Welt, ");
		ausgabe2 = new JLabel();
		// Schaltflächen
		schaltflaeche1 = new JButton("Beenden");
		schaltflaeche1.setActionCommand("exit");
		schaltflaeche1.setToolTipText("Program beenden.");
		schaltflaeche2 = new JButton("Ändern");
		schaltflaeche2.setActionCommand("change");
		schaltflaeche2.setToolTipText("Nahme ändern.");
		// Fenster bauen
		setLayout(new FlowLayout());
		add(ausgabe);
		ausgabe.setFont(new Font("Arial", Font.BOLD, 14));
		add(ausgabe2);
		add(schaltflaeche1);
		add(schaltflaeche2);
		// Listener hinfügen
		MeinKompakterListener listener = new MeinKompakterListener();
		addWindowListener(listener);
		schaltflaeche1.addActionListener(listener);
		schaltflaeche2.addActionListener(listener);
		// finale Fenstereinstellungen
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
        setLocationRelativeTo(null);
		setVisible(true);
	}
	// die Methode erzeugt den Text mit der Nahme
	public void setAusgabe2Text(String text) {
		ausgabe2.setText("es grüßt Dich " + text+"!");
		ausgabe2.setFont(new Font("Arial", Font.PLAIN, 14));
		pack();
	}
 }
