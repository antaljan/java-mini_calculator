package de.aj.taschenrechner_V4;
/* Es ist ein mini Taschenrechner mit Grundfunktionen
 * es wird über JFrame visualisiert
 * die Zahlen über JLabel dargestellt
 * das Nummertastature mit Schaltflächen über ein JPanel festgelegt
 * ein innere Listener steuert die Funktionen und
 * die Methode Berechnung macht das Kalkulation.
 *  Funktion:
 *  Zahl 1 widr bis auf eine Operaton aufgenomen dann in Variable ersteZahl gespeichrt
 *  das operaror wird in berechnungErste gespeichert, dann
 *  komt den zweite Zahl analog zum erste, dass ändert sich mit dem zweite Operator,
 *  welche in berechnungZweite Variable gespeichert.
 *  Dann wird den erte operetion mit dem zwei Zahlen durchführen.
 * Für die Aufbau von Tastaturen Panel habe Ich ein separate Methode gabaut. 
 */

// Imports
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

// Klasse für die grafische Oberfläche auf JFrame Basis
public class Taschenrechner_V4_GUI extends JFrame{
	//automatisch über Eclipse eingefügt
	private static final long serialVersionUID = 1961969115423238973L;
	//die Variablen für die Berechnung
	private double ersteZahl=0;
	private double zweiteZahl=0;
	private String berechnungErste="+";
	private String berechnungZweite="";
	private boolean loeschen=false;
	//ein Label für die aktuelle Ausgabe
	private JLabel ausgabe;
	//die Tastaturen
	private JButton schaltflaeche_0;
	private JButton schaltflaeche_1;
	private JButton schaltflaeche_2;
	private JButton schaltflaeche_3;
	private JButton schaltflaeche_4;
	private JButton schaltflaeche_5;
	private JButton schaltflaeche_6;
	private JButton schaltflaeche_7;
	private JButton schaltflaeche_8;
	private JButton schaltflaeche_9;
	private JButton schaltflaeche_PlusMinus;
	private JButton schaltflaeche_Koma;
	private JButton schaltflaeche_Plus;
	private JButton schaltflaeche_Minus;
	private JButton schaltflaeche_Multipl;
	private JButton schaltflaeche_Teilen;
	private JButton schaltflaeche_Wurzel;
	private JButton schaltflaeche_Prozent;
	private JButton schaltflaeche_Ce;
	private JButton schaltflaeche_Berechnen;

	//die innere Listener für die Ereignisverarbeitung
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double ergebniss;
			if (e.getActionCommand().equals("+") || e.getActionCommand().equals("-") || e.getActionCommand().equals("*") || e.getActionCommand().equals("/") || e.getActionCommand().equals("=") || e.getActionCommand().equals("√")){
				zweiteZahl = Double.parseDouble(ausgabe.getText());
				berechnungZweite=e.getActionCommand();
				ergebniss = berechnen();
				ausgabe.setText(String.valueOf(ergebniss));
				loeschen=true;
				return;
			}
			if (e.getActionCommand().equals("%") ){
				ausgabe.setText(String.valueOf(Double.parseDouble(ausgabe.getText())/10));
				return;
			}
			if (e.getActionCommand().equals("±")) {
				ausgabe.setText(String.valueOf(Double.parseDouble(ausgabe.getText())*-1));
				return;
			}
			if (e.getActionCommand().equals("C")) {
				ausgabe.setText("");
				ersteZahl=0;
				zweiteZahl=0;
				berechnungErste="+";
				berechnungZweite="";
				loeschen=false;
				return;
			}
			if (e.getActionCommand()==".") {
				ausgabe.setText(ausgabe.getText() + e.getActionCommand() );
				return;
			}
			if (e.getActionCommand()=="0") {
				if (!loeschen)
					ausgabe.setText(ausgabe.getText() + e.getActionCommand() );
				else {
					ausgabe.setText(e.getActionCommand() );
					loeschen=false;
				}
				return;
			}
			if (Double.parseDouble(e.getActionCommand())>0) {
				if (!loeschen)
					ausgabe.setText(ausgabe.getText() + e.getActionCommand() );
				else {
					ausgabe.setText(e.getActionCommand() );
					loeschen=false;
				}
			}
		}
	}

	// Konstruktor für die Instanz
	public Taschenrechner_V4_GUI(String titel) {
		super(titel);
		//Ausgabe Label
		ausgabe = new JLabel("   ");
		ausgabe.setFont(new Font("Arial", Font.PLAIN, 20));
		ausgabe.setHorizontalAlignment(SwingConstants.RIGHT);
		//Panel aufruffen
		JPanel tastaturePanel=tastatureErzeugen();
		// Auffühlen den Layout
		setLayout(new GridLayout(0,1));
		add(ausgabe);
		add(tastaturePanel);
		//die Standardaktion setzen
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				//packen und anzeigen
        setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	// Panel für die Tastature erzeugen
	private JPanel tastatureErzeugen() {
		JPanel tempPanel = new JPanel();
		// festlegen die Schaltflächen für die Tastaturepanel
		schaltflaeche_0 = new JButton("0");
		schaltflaeche_1 = new JButton("1");
		schaltflaeche_2 = new JButton("2");
		schaltflaeche_3 = new JButton("3");
		schaltflaeche_4 = new JButton("4");
		schaltflaeche_5 = new JButton("5");
		schaltflaeche_6 = new JButton("6");
		schaltflaeche_7 = new JButton("7");
		schaltflaeche_8 = new JButton("8");
		schaltflaeche_9 = new JButton("9");
		schaltflaeche_PlusMinus = new JButton("±");
		schaltflaeche_Koma = new JButton(".");
		schaltflaeche_Plus = new JButton("+");
		schaltflaeche_Minus = new JButton("-");
		schaltflaeche_Multipl = new JButton("*");
		schaltflaeche_Teilen = new JButton("/");
		schaltflaeche_Wurzel = new JButton("√");
		schaltflaeche_Prozent = new JButton("%");
		schaltflaeche_Ce = new JButton("C");
		schaltflaeche_Berechnen=new JButton("=");
		//Schaltflächen zufügen
		tempPanel.setLayout(new GridLayout(0, 4));
		tempPanel.add(schaltflaeche_Wurzel);
		tempPanel.add(schaltflaeche_Prozent);
		tempPanel.add(schaltflaeche_PlusMinus);
		tempPanel.add(schaltflaeche_Ce);
		tempPanel.add(schaltflaeche_7);
		tempPanel.add(schaltflaeche_8);
		tempPanel.add(schaltflaeche_9);
		tempPanel.add(schaltflaeche_Teilen);
		tempPanel.add(schaltflaeche_4);
		tempPanel.add(schaltflaeche_5);
		tempPanel.add(schaltflaeche_6);
		tempPanel.add(schaltflaeche_Multipl);
		tempPanel.add(schaltflaeche_1);
		tempPanel.add(schaltflaeche_2);
		tempPanel.add(schaltflaeche_3);
		tempPanel.add(schaltflaeche_Minus);
		tempPanel.add(schaltflaeche_0);
		tempPanel.add(schaltflaeche_Koma);
		tempPanel.add(schaltflaeche_Berechnen);
		tempPanel.add(schaltflaeche_Plus);
		//die Schaltflächen mit dem Listener verbinden
		MeinListener listener = new MeinListener();
		schaltflaeche_0.addActionListener(listener);
		schaltflaeche_1.addActionListener(listener);
		schaltflaeche_2.addActionListener(listener);
		schaltflaeche_3.addActionListener(listener);
		schaltflaeche_4.addActionListener(listener);
		schaltflaeche_5.addActionListener(listener);
		schaltflaeche_6.addActionListener(listener);
		schaltflaeche_7.addActionListener(listener);
		schaltflaeche_8.addActionListener(listener);
		schaltflaeche_9.addActionListener(listener);
		schaltflaeche_PlusMinus.addActionListener(listener);
		schaltflaeche_Koma.addActionListener(listener);
		schaltflaeche_Plus.addActionListener(listener);
		schaltflaeche_Minus.addActionListener(listener);
		schaltflaeche_Multipl.addActionListener(listener);
		schaltflaeche_Wurzel.addActionListener(listener);
		schaltflaeche_Prozent.addActionListener(listener);
		schaltflaeche_Ce.addActionListener(listener);
		schaltflaeche_Berechnen.addActionListener(listener);
		schaltflaeche_Teilen.addActionListener(listener);
		return tempPanel;
	}

	// Methode für die Berechnung
	private double berechnen() {
		// temporelle Variable für die Ergebniss
		double ergebniss=0;
		// Berechnung für Addiren
		if (berechnungErste=="+")
			ergebniss=ersteZahl + zweiteZahl;
		// Berechnung für Substraktion
		if (berechnungErste=="-")
			ergebniss=ersteZahl - zweiteZahl;
		// Berechnung für Multiplizieren
		if (berechnungErste=="*")
			ergebniss=ersteZahl * zweiteZahl;
		// Berechnung für Teilen
		if (berechnungErste=="/")
			ergebniss=ersteZahl / zweiteZahl;
		// Berechnung für Quadratwurzel
		if (berechnungZweite=="√") {
			zweiteZahl=Math.abs(zweiteZahl);
			ergebniss = Math.sqrt(zweiteZahl);
			ersteZahl=0;
			berechnungZweite="=";
			}
		// wenn Gleich Tastature gedrückt erte Zahl 0 und die nächte Operetion addiren
		if (berechnungZweite=="=") {
				ersteZahl=0;
				berechnungErste="+";
			}
			// sonzt die aktuelle ergebniss wird Zahl 1 sein und aktuelle Operator Operator 1
			else {
				ersteZahl=ergebniss;
				berechnungErste=berechnungZweite;
		}
		// liefert die Ergebniss zurück
		return ergebniss;
	}
}
