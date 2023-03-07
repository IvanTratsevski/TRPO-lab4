import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;


class MyFirstJUnitJupiterTests {

    @Test
    void minTest() {
        double l, r, eps;
        double expected = 2.5;
        l = -5;
        r = 5;
        eps = 0.0001;
        double ans = TernarySearch.Search(l, r, eps);
        assertEquals(true, expected-ans<=eps );
    }


}