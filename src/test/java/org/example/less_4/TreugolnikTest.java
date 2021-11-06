package org.example.less_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.less_4.Treugolnik.calculateTriangleSquare;

public class TreugolnikTest {
    @Test
     void positiveSquareCalkTest() throws Exception {
        double result = calculateTriangleSquare ( 10, 10, 10 );
        Assertions.assertEquals ( 167.70509831248424, result );
    }
        @Test
     void negativeTriangleTest() {
         Assertions.assertThrows(Exception.class, () -> calculateTriangleSquare ( -10,10,10));
}
}
