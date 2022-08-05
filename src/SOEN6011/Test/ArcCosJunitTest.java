package SOEN6011.Test;


import SOEN6011.Java.ArcCos;
import SOEN6011.Java.Utility;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArcCosJunitTest {

  /**
   * Method to test getPiValue function.
   */
  @Test
  public void piValueTest() {
    double value = Utility.getPiValue();
    assertEquals(3.1415926536, value, 0);
  }

  /**
   * Method to test the actual arccos values of x.
   */
  @Test
  public void arccosTest() throws Exception {
    double x = ArcCos.calculateArcCos(-0.987);
    double y = ArcCos.calculateArcCos(0.5);
    assertEquals(170.720521, x, 0);
    assertEquals(60.0, y, 0);

  }

  @Test
  public void calculatePowerTest() {
    double base = 5.0;
    int exp  = 2;
    double powerValue = Utility.calculatePower(base, exp);
    assertEquals(25,powerValue,0);
  }

  /**
   * Method to test the invalid value of x.
   */
  @Test
  public void arccosInvalidTest() throws Exception {

    Exception thrown = assertThrows(Exception.class, () -> {
      double x = ArcCos.calculateArcCos(100);
    });
    assertEquals("Input Values should be between -1 and 1", thrown.getMessage());
  }

}
