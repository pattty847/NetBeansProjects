/**
 * The NeuralNetwork involved in this project will take two inputs and produce a result based on training data.
 * When the network is fed a number of elements in an array and the sorting method it will return a guess on how long
 * this sorting algorithm will take to execute based on previous data.
 */
package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pat
 */
public class NeuralNetwork {

    // result - time it took to execute sort
    private static float[][] input;
    private static float weight[], bias[];

    private static Random r;

    private static String file = "results.txt";

    private static int type;

    public NeuralNetwork() {
        input = new float[2][countLines()];
        readInData();
        train();
    }

    private static void train() {
        Neuron n1 = new Neuron(input);
        Neuron n2 = new Neuron(input);
        Neuron n3 = new Neuron(input);
    }

    private static void readInData() {
        try {
            Scanner scan = new Scanner(new File(file));
            scan.useDelimiter(":");

            for (int i = 0; i < input[0].length; i++) {
                input[0][i] = Integer.parseInt(scan.next());
                input[1][i] = Integer.parseInt(scan.next());
                scan.nextLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NeuralNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int countLines() {
        int lines = 0;
        try {
            Scanner scan = new Scanner(new File(file));

            while (scan.hasNextLine()) {
                lines = lines + 1;
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lines;
    }
}
