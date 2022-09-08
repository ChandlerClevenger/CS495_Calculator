package java;

public class Calculations {

    public int quaternaryToDecimal(int qua){
        return 0;
    }

    public int decimalToQuaternary(int decimal){
        String result = "";
        while(decimal > 0){
            result += decimal % 4;
            decimal /= 4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result);
        stringBuilder.reverse();
        return Integer.parseInt(stringBuilder.toString());
    }

    public int add(int left, int right){
        return left + right;
    }

    public int subtract(int left, int right){
        return left - right;
    }

    public int multiply(int left, int right){
        return left * right;
    }

    public int divide(int left, int right){
        return left / right;
    }

    public int squareRoot(int number){
        return (int) Math.sqrt(number);
    }

    public int square(int number){
        return number^2;
    }
}
