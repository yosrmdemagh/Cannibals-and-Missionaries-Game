/*package proj;
public class Main {

	public static void main(String[] args) {
		//recherche par largeur car j'ai utilisé une file dans ouvert
		//aller avec l'etat 3,3,false est impossible car on ne peutt trouver aucune operation à effectuer
	Etat_CM etatInitial=new Etat_CM(3,3,true);
	Iferme ferme=new Iferme();
	Iouvert ouvert=new Iouvert();
	Operation [] operations = {new Depart_C_M(),new Depart_C(),new Depart_Deux_Can(),new Depart_M_M(),new Depart_M(),new Retour_C_C(),new Retour_C_M(),new Retour_C(),new Retour_M_M(),new Retour_M()};

	AGR agr=new AGR(etatInitial,ferme,ouvert,operations);
	Etat_CM etf=(Etat_CM)agr.explorer();
	 System.out.println("solution");
	
	System.out.println(etf);
	 System.out.println(agr.chemin(etf));
	}

}*/
package proj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JComboBox<String> etatsComboBox;
    private JButton chercherButton;
    private JTextArea solutionTextField;

    public Main() {
        frame = new JFrame("Missionaries and Cannibals Game ");
        frame.setSize(600, 500); // Adjusted size to fit all components comfortably
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        String[] etats = {"(3,3,true)", "(3,2,true)", "(3,1,true)", "(3,0,true)", "(2,2,true)", "(2,1,true)", "(2,0,true)", "(1,1,true)"};
        etatsComboBox = new JComboBox<>(etats);

        chercherButton = new JButton("search a solution");

        chercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEtat = (String) etatsComboBox.getSelectedItem();
                Etat_CM etatInitial = convertirEtat(selectedEtat);
                System.out.println(etatInitial);
                Iferme ferme = new Iferme();
                Iouvert ouvert = new Iouvert();
                Operation[] operations = {new Depart_C_M(), new Depart_C(), new Depart_Deux_Can(), new Depart_M_M(), new Depart_M(), new Retour_C_C(), new Retour_C_M(), new Retour_C(), new Retour_M_M(), new Retour_M()};

                AGR agr = new AGR(etatInitial, ferme, ouvert, operations);
                Etat_CM etf = (Etat_CM) agr.explorer();
                String solution = agr.chemin(etf);
                String formattedSolution = solution.replace("/", "\n");
                solutionTextField.setText(formattedSolution);
            }
        });


        ImageIcon originalIcon = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\ProjetFondamentAI\\src\\proj\\imageCanMISS.png"); // Replace with the path to your image
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(600, 200, Image.SCALE_SMOOTH); // Change width and height as needed
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);

        // Create a panel for the combobox and button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout());
        controlsPanel.add(new JLabel("Choose an initial state :"));
        controlsPanel.add(etatsComboBox);
        controlsPanel.add(chercherButton);

        topPanel.add(imageLabel, BorderLayout.NORTH);
        topPanel.add(controlsPanel, BorderLayout.CENTER);

        // Create a panel for the solution text area
        JPanel solutionPanel = new JPanel();
        solutionPanel.setLayout(new BorderLayout());
        solutionPanel.add(new JLabel("Solution Found :"), BorderLayout.NORTH);

        solutionTextField = new JTextArea(15, 30);
        solutionTextField.setLineWrap(true);
        solutionTextField.setWrapStyleWord(true);
        solutionTextField.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(solutionTextField);
        solutionPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(solutionPanel, BorderLayout.CENTER);

        frame.setVisible(true);
      }

    private Etat_CM convertirEtat(String etatString) {
        String[] elements = etatString.replaceAll("[()]", "").split(",");
        if (elements.length != 3) {
            throw new IllegalArgumentException("Format d'état incorrect : " + etatString);
        }

        try {
            int x = Integer.parseInt(elements[0].trim());
            int y = Integer.parseInt(elements[1].trim());
            boolean etat = Boolean.parseBoolean(elements[2].trim());
            return new Etat_CM(x, y, etat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valeurs d'état incorrectes : " + etatString);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
