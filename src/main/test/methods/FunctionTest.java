package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {
    Function function = new Function();

    @Test
    void quaternaryToDecimal100() {
        assertEquals(function.quaternaryToDecimal(1210), 100);
    }
    @Test
    void quaternaryToDecimal8() {
        assertEquals(function.quaternaryToDecimal(20), 8);
    }

    @Test
    void decimalToQuaternary100() {
        assertEquals(function.decimalToQuaternary(100), 1210);
    }

    @Test
    void decimalToQuaternary8() {
        assertEquals(function.decimalToQuaternary(8), 20);
    }

    @Test
    void recursiveDecimal() {
        assertEquals(function.quaternaryToDecimal(function.decimalToQuaternary(100)), 100);
    }

    @Test
    void recursiveQuaternary(){
        assertEquals(function.decimalToQuaternary(function.quaternaryToDecimal(1210)), 1210);
    }

}