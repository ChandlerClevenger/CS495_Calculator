package methods;

public class Main {
    static Function calculations = new Function();

    public static void main(String[] args) {
        System.out.println(calculations.decimalToQuaternary(100));
        System.out.println(calculations.decimalToQuaternary(8));
        System.out.println(calculations.quaternaryToDecimal(20));
        System.out.println(calculations.quaternaryToDecimal(1210));
        //recursive call
        //See if it's the same number
        System.out.println(calculations.quaternaryToDecimal(calculations.decimalToQuaternary(100)));
    }
}
