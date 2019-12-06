//Imports for the GUI and file reader

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Window extends JFrame implements ActionListener, MouseListener {
    //Creating the GUI elements
    private JFrame f;
    private JTextField socTxt, algTxt, gpaTxt, ageTxt;
    private JLabel socL, algL, gpaL, ageL, resL;
    private JButton eval, imp;
    private JFileChooser target;
    private JTextArea results;
    //Creating the selected file and the new candidate object
    private File selFile;
    private Candidate newCandidate;

    public Window() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //UI manager to make to GUI look better
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //Creating the frame
        f = new JFrame("Evaluator");
        //Running the init method to initialize GUI elements
        init();
        f.setResizable(false);
        f.setVisible(true);
    }

    public void init() {

        int sizeX = 100;
        int sizeY = 25;
        int dist = 20;
        //Setting up the frame
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(f,
                "Welcome to the recruitment robot! To begin, import your file and enter the scores for the newest candidate.",
                "Recruitment Robot", JOptionPane.INFORMATION_MESSAGE);

        //File chooser for the import button
        target = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        target.setAcceptAllFileFilterUsed(false);
        //Restrict the selection to any csv file
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
        target.addChoosableFileFilter(filter);

        socL = new JLabel("Social score", SwingConstants.CENTER);
        socL.setSize(100, 50);
        socL.setLocation(dist, 25);
        f.add(socL);

        socTxt = new JTextField();
        socTxt.setSize(sizeX, sizeY);
        socTxt.setLocation(dist, 75);
        socTxt.addActionListener(this);
        f.add(socTxt);

        algL = new JLabel("Algorithm score", SwingConstants.CENTER);
        algL.setSize(100, 50);
        algL.setLocation(sizeX + 2 * dist, 25);
        f.add(algL);

        algTxt = new JTextField();
        algTxt.setSize(sizeX, sizeY);
        algTxt.setLocation(sizeX + 2 * dist, 75);
        algTxt.addActionListener(this);
        f.add(algTxt);

        gpaL = new JLabel("GPA", SwingConstants.CENTER);
        gpaL.setSize(100, 50);
        gpaL.setLocation(3 * dist + 2 * sizeX, 25);
        f.add(gpaL);

        gpaTxt = new JTextField();
        gpaTxt.setSize(sizeX, sizeY);
        gpaTxt.setLocation(3 * dist + 2 * sizeX, 75);
        gpaTxt.addActionListener(this);
        f.add(gpaTxt);

        ageL = new JLabel("Age", SwingConstants.CENTER);
        ageL.setSize(100, 50);
        ageL.setLocation(4 * dist + 3 * sizeX, 25);
        f.add(ageL);

        ageTxt = new JTextField();
        ageTxt.setSize(sizeX, sizeY);
        ageTxt.setLocation(4 * dist + 3 * sizeX, 75);
        ageTxt.addActionListener(this);
        f.add(ageTxt);

        imp = new JButton("Import Data");
        imp.setSize(sizeX, 50);
        imp.setLocation(sizeX + 2 * dist, 75 + sizeY + dist);
        imp.addMouseListener(this);
        f.add(imp);

        eval = new JButton("Evaluate");
        eval.setSize(100, 50);
        eval.setLocation(3 * dist + 2 * sizeX, 75 + sizeY + dist);
        eval.addMouseListener(this);
        f.add(eval);

        ageL = new JLabel("Age", SwingConstants.CENTER);
        ageL.setSize(100, 50);
        ageL.setLocation(750 + dist, 100);
        f.add(ageL);

        results = new JTextArea("Results");
        results.setSize(400, 200);
        results.setLocation(50, 150 + sizeY + 2 * dist);
        results.setEditable(false);
        f.add(results);

    }

    public void actionPerformed(ActionEvent e) {

    }


    public void mouseClicked(MouseEvent e) {
        //Mouse events for buttons
        if (e.getSource().equals(eval)) {
            //Evaluate button functions

            if (socTxt.getText().isEmpty() || algTxt.getText().isEmpty() ||
                    gpaTxt.getText().isEmpty() || ageTxt.getText().isEmpty()) {
                //Checks if new candidate info is empty or not
                JOptionPane.showMessageDialog(f, "Please enter the data for the new candidate!", "Missing info", JOptionPane.ERROR_MESSAGE);
            } else if (selFile == null) {
                //Checks if a file is selected or not
                JOptionPane.showMessageDialog(f, "Please import previous candidate dataset", "Missing data", JOptionPane.ERROR_MESSAGE);
            } else {
                //If not, use the new entries to create a new candidate
                //Parse the entries into double values to create the new candidate
                double data[] = {Double.parseDouble(
                        socTxt.getText().trim()), Double.parseDouble(algTxt.getText().trim()),
                        Double.parseDouble(gpaTxt.getText().trim()), Double.parseDouble(ageTxt.getText().trim()), 0};
                newCandidate = new Candidate(data);

                //Send the selected file and the new candidate to a new recruitment robot
                RecruitmentRobot robot = new RecruitmentRobot(selFile, newCandidate);
                results.setText("Candidate evaluated!" + "\n" + "His scores are: " + "\n" + "Social: " +
                        newCandidate.getSocial() + " Algorithmic Skill: " + newCandidate.getAlgorithm() + "\n" +
                        " GPA: " + newCandidate.getGpa() + " Age: " + newCandidate.getAge());
                if (newCandidate.checkHired())
                    results.append("\n" + "He is hired!");
                else if (!newCandidate.checkHired())
                    results.append("\n" + "He is not hired!");
            }
        } else if (e.getSource().equals(imp)) {
            //Import button functions
            int returnValue = target.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                //Assigning the imported file
                selFile = target.getSelectedFile();
            }
            results.append("\n" + "Imported file: " + selFile.getName());

        }

    }

    public void mouseEntered(MouseEvent arg0) {

    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mousePressed(MouseEvent arg0) {

    }

    public void mouseReleased(MouseEvent arg0) {

    }

}
