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
     * The Pi is a ratio and is obtained from a circle.
     * If the diameter and the circumference of any given circle are known, the value of Pi will be as π = Circumference/ Diameter.
     */
    public static double getPiValue() {

        /**
         * Considering Circumference and Diameter of a known circle C.
         */
        double circumference = 314.15926536;
        double diameter = 100;
        return circumference / diameter;
    }


    /**
     * This method is to used calculate the Power.
     *
     * @param base This variable accepts values of double data type.
     * @param exp  This variable accepts values of integer data type.
     * @return This method calculates and returns the power with the given base and exponent (exp) values
     */
    public static double calculatePower(double base , int exp) {
        double power = 1;
        if (exp != 0) {
            int absExponent = exp > 0 ? exp : (-1) * exp;
            for (int i = 1; i <= absExponent; i++) {
                power *= base;
            }
            if (exp < 0) {
                power = 1.0 / power;
            }
        } else {
            power = 1;
        }
        return power;
    }
}
