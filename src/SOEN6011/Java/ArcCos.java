package SOEN6011.Java;

import java.text.DecimalFormat;
import java.util.Scanner;

import static SOEN6011.Java.Utility.*;

/**
 * This class is for computing the inverse cosine a.k.a arccos(x) function .
 *
 * @author Pravallika Basam
 * @version 1.0
 * @since 12-Jul-2022
 */
public class ArcCos {

    static Scanner sc = new Scanner(System.in);
    static double pi = getPiValue();

    /**
     * Main method to run the Function.
     *
     * @throws Exception when the input number is not between [1,-1].
     */
    public static void main(String[] args) {
        do {
            System.out.println("Enter the number to calculate the Inverse of Cosine: ");
            double num = sc.nextDouble();
            try {
                double arccos = calculateArcos(num);
                System.out.println("arccos("+num+")"+" = "+arccos+" deg");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static double calculateArcos(double num) throws Exception {

        double sum = num;

        double arccos = 0.0;

        if (num > 1 || num < -1) {
            throw new Exception("Input Values should be between -1 and 1");
        }

        if (num == 1.0) {
            arccos = 0;
        } else if (num == -1.0) {
            arccos = pi;
        } else if (num == 0.0) {
            arccos = (pi) / 2;
        } else {
            for (int i = 1; i < 100; i++) {

                int j = i;

                double temp = 1.0;

                int n = 1;

                while (j >= 1) {

                    double s = ((double) n) / (n + 1);

                    temp = temp * s;

                    j--;

                    n += 2;

                }
                double power = calculatePower(num, n);
                double a = temp * power;

                double b = a / n;

                sum = sum + b;

            }

            double rad = (pi / 2) - sum;

            double deg = rad * 180 / pi;

            DecimalFormat df = new DecimalFormat("0.000000");

            String formatted = df.format(deg);

            arccos = Double.parseDouble(formatted);

        }
        return arccos;
    }

}
