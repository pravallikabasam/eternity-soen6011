package SOEN6011.Java;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static SOEN6011.Java.Utility.*;

/**
 * This class is for computing the inverse cosine a.k.a arccos(x) function .
 *
 * @author Pravallika Basam
 * @version 1.0
 * @since 12-Jul-2022
 */
public class ArcCos {

    private static final Logger LOG = Logger.getLogger(ArcCos.class.getName());
    static Scanner sc = new Scanner(System.in);
    static double pi = getPiValue();

    /**
     * This main method is to run the Function calculateArcCos.
     *
     * @throws Exception when the input number is not between [-1,1].
     */
    public static void main(String[] args) {
        do {
            System.out.println("Enter the number to calculate the Inverse of Cosine: ");
            String input = sc.next();
            double num = 0.0;
            try {
                num = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                LOG.log(Level.SEVERE , "Invalid input, please enter a number between [-1,1]");
            }
            try {
                double arccos = calculateArcCos(num);
                System.out.println("arccos(" + num + ")" + " = " + arccos + " deg");
            } catch (Exception e) {
                LOG.log(Level.INFO , "Invalid input, please enter a number between [-1,1]");
            }
        } while (true);
    }

    /**
     * @param num This variable accepts a number of double data type.
     *            Constraints   ---   -1 <= num <= 1. Throws Exception if the constraints are not satisified.
     * @return Returns the Inverse Cosine value of a given number
     * @throws Exception Throws Exception if the input number is not between [-1,1]
     */
    public static double calculateArcCos(double num) throws Exception {
        double sum = num;
        double arcCos;
        if (num > 1 || num < -1) {
            throw new Exception("Input Values should be between -1 and 1");
        }
        if (num == 1.0) {
            arcCos = 0;
        } else if (num == -1.0) {
            arcCos = pi;
        } else if (num == 0.0) {
            arcCos = (pi) / 2;
        } else {
            for (int i = 1 ; i < 100 ; i++) {
                int j = i;
                double temp = 1.0;
                int n = 1;
                while (j >= 1) {
                    double s = ((double) n) / (n + 1);
                    temp = temp * s;
                    j--;
                    n += 2;
                }
                double power = calculatePower(num , n);
                double a = temp * power;
                double b = a / n;
                sum = sum + b;
            }
            double rad = (pi / 2) - sum;
            double deg = rad * 180 / pi;
            DecimalFormat df = new DecimalFormat("0.000000");
            String formatted = df.format(deg);
            arcCos = Double.parseDouble(formatted);
        }
        return arcCos;
    }
}
