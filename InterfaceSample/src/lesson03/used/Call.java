package lesson03.used;

public class Call {
    public static void main(String[] args) {
        Calculator calculator1 = new AddCalc();
        Calculator calculator2 = new SubCalc();
        Integer result1 = calculator1.calc(10,5);
        Integer result2 = calculator2.calc(10,5);
        System.out.println("AddCalc 계산 결과는 ("+ result1 +") 입니다.");
        System.out.println("SubCalc 계산 결과는 ("+ result2 +") 입니다.");
    }
}
