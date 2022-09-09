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
        if(decimal == 0){
            return 0;
        }
        StringBuilder result = new StringBuilder();
        while(decimal > 0) {
            result.append(decimal % 4);
            decimal /= 4;
        }
        result.reverse();
        return Integer.parseInt(result.toString());
    }

    public int add(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) + quaternaryToDecimal(right));
    }

    public int subtract(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) - quaternaryToDecimal(right));
    }

    public int multiply(int left, int right){
        return decimalToQuaternary((quaternaryToDecimal(left) * quaternaryToDecimal(right)));
    }

    public int divide(int left, int right){
        return decimalToQuaternary(quaternaryToDecimal(left) / quaternaryToDecimal(right));
    }

    public int squareRoot(int number){
        return decimalToQuaternary((int) Math.sqrt(quaternaryToDecimal(number)));
    }

    public int square(int number){
        return decimalToQuaternary(quaternaryToDecimal((int) Math.pow(number, 2)));
    }
}
