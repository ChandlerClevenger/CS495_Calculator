package methods;

public class Main {
    static Function function = new Function();

    public static void main(String[] args) {
        System.out.println(function.decimalToQuaternary(100));
        System.out.println(function.decimalToQuaternary(8));
        System.out.println(function.quaternaryToDecimal(20));
        System.out.println(function.quaternaryToDecimal(1210));
        //recursive call
        //See if it's the same number
        System.out.println(function.quaternaryToDecimal(function.decimalToQuaternary(100)));
    }
}
