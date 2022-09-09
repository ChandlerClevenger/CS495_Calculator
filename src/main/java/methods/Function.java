package methods;

import java.util.Scanner;

public class Function {

    public static int quaternaryToDecimal(int qua){
        int sum = 0;
        StringBuilder result = new StringBuilder();
        result.append(qua);
        result.reverse();
        for(int i = 0; i < result.length(); i++){
            int currentNumber = Integer.parseInt(String.valueOf(result.charAt(i)));
            sum += currentNumber * Math.pow(4,i);
        }
        return sum;
    }

    public static int decimalToQuaternary(int decimal){
        StringBuilder result = new StringBuilder();
        while(decimal > 0) {
            result.append(decimal % 4);
            decimal /= 4;
        }
        result.reverse();
        return Integer.parseInt(result.toString());
    }

    public static int add(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) + quaternaryToDecimal(right));
    }

    public static int subtract(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) - quaternaryToDecimal(right));
    }

    public static int multiply(int left, int right){
        return decimalToQuaternary((quaternaryToDecimal(left) * quaternaryToDecimal(right)));
    }

    public static int divide(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) / quaternaryToDecimal(right));
    }

    public static int squareRoot(int number){
        return decimalToQuaternary((int) Math.sqrt(quaternaryToDecimal(number)));
    }

    public static int square(int number){
        return decimalToQuaternary(quaternaryToDecimal((int) Math.pow(number, 2)));
    }
    //had a psvm instance for testing and calling, removed for commit due to lack of necessity
}
