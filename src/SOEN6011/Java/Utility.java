package SOEN6011.Java;

/**
 * This class is for computing the Archimedes of Syracuse's Pi value .
 *
 * @author Pravallika Basam
 * @version 1.0
 * @since 12-Jul-2022
 */

public class Utility {

    /**
     * The SOEN6011.Java.Pi is a ratio and is obtained from a circle.
     * If the diameter and the circumference of any given circle are known, the value of Pi will be as π = Circumference/ Diameter.
     */
    public static double getPiValue() {

        /**
         * Considering Circumference and Diameter of a known circle C.
         */
        double circumference = 314.5926536;
        double diameter = 100;
        return circumference/diameter;
    }

    /**
     * This method is to calculate the Power.
     */
    public static double calculatePower(double base, int exp) {
        double pow = 1;
        if (exp != 0) {
            int absExponent = exp > 0 ? exp : (-1) * exp;
            for (int i = 1; i <= absExponent; i++) {
                pow *= base;
            }

            if (exp < 0) {

                pow = 1.0 / pow;
            }
        } else {

            pow = 1;
        }

        return pow;
    }

}
