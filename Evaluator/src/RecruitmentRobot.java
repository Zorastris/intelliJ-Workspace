import javax.swing.*;
import java.io.*;

public class RecruitmentRobot {
    //Current candidate is the candidate at the given line while new candidate is the one we entered
    private Candidate currentCandidate, newCandidate;


    //Creating a candidate array to hold previous candidates
    private Candidate[] c;
    private String[] line = new String[5];
    private double[] distances;
    private int[] y;
    private int dataCount;
    private BufferedReader bufferedReader;


    public RecruitmentRobot(File file, Candidate newCandidate) {
        this.newCandidate = newCandidate;
        //Read the file and assign it to a buffered reader
        bufferedReader = fileReader(file);
        //Count the data
        dataCount = lineCounter(bufferedReader) - 1;
        bufferedReader = fileReader(file);
        lineReader();
        //Uses a modified quick sort algorithm
        Quick2D.QuickSort(distances, y);

        //These printers can be used for testing purposes
        arrayPrint(distances);
        arrayPrint(y);

        finalEval();
        System.out.println(dataCount);
    }

    //Read the file and store it in a buffered reader
    public BufferedReader fileReader(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return br;
    }

    //Line counter is only necessary when the data size is not pre determined
    public int lineCounter(BufferedReader br) {
        int count = 0;
        try {
            while (br.readLine() != null) {
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }

    //This method reads each line from the buffer and assigns them to their designated places
    private void lineReader() {
        //This is the string variable that we use to store the line
        String st;
        //Counter
        int j = 0;
        //Candidate array
        c = new Candidate[dataCount];
        //Hired info array
        y = new int[dataCount];
        //Distances array
        distances = new double[dataCount];
        try {
            bufferedReader.readLine();
            //Loops until the next line is empty
            while ((st = bufferedReader.readLine()) != null) {
                //Splits each line between "," and assigns them into a string array
                line = st.split(",");
                //Creates a new candidate from that line array
                currentCandidate = new Candidate(stringToDouble(line));
                //Assigns the values
                c[j] = currentCandidate;
                y[j] = (int) c[j].getY();
                distances[j] = currentCandidate.distanceTo(newCandidate);
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Converts a string array to a double array
    private double[] stringToDouble(String[] line) {
        double[] parsedLine = new double[5];
        for (int i = 0; i < 5; i++) {
            parsedLine[i] = Double.parseDouble(line[i]);
        }
        return parsedLine;
    }

    //Printer methods for testing purposes
    public void arrayPrint(double[] x) {
        System.out.println("***********Start of array***********");
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);
        System.out.println("***********End of array***********");
    }

    public void arrayPrint(int[] x) {
        System.out.println("***********Start of array***********");
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);
        System.out.println("***********End of array***********");
    }

    //Final evaluator method to set the y value of the new candidate
    public void finalEval() {
        int count = 0;
        for (int i = 0; i < 5; i++)
            if (y[i] == 1)
                count++;
        if (count > 2)
            newCandidate.setY(1);
    }

    //Main method throws exceptions because the ui manager requires them
    public static void main(String[] args) throws ClassNotFoundException,
            UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        new Window();
    }

}