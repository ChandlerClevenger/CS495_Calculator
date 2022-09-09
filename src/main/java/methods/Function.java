package methods;

public class Function {

    public int quaternaryToDecimal(int qua){
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

    public int decimalToQuaternary(int decimal){
        StringBuilder result = new StringBuilder();
        while(decimal > 0) {
            result.append(decimal % 4);
            decimal /= 4;
        }
        result.reverse();
        return Integer.parseInt(result.toString());
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
