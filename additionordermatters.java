import java.math.BigDecimal;
import java.math.*;

public class additionordermatters {
    public static void main(String[] args) {
        double num1 = 2.6 + 3.9 + 1.3;
        System.out.println(num1);
        
        double num2 = 2.6 + (3.9 + 1.3);
        System.out.println(num2);
        
        System.out.println("Using BigDecimal");
        int scale = 32;
        BigDecimal one = new BigDecimal("2.6");
        BigDecimal bdone = one.setScale(scale, RoundingMode.FLOOR);
        BigDecimal two = new BigDecimal("3.9");
        BigDecimal three   = new BigDecimal("1.3");
        BigDecimal bdtwo = two.setScale(scale, RoundingMode.FLOOR);
        BigDecimal bdthree = three.setScale(scale, RoundingMode.FLOOR);
        BigDecimal sum1 = bdone.add(bdtwo.add(bdthree));
        System.out.println(sum1);
        BigDecimal sum2 = (bdone.add(bdtwo)).add(bdthree);
        System.out.println(sum2);

    }
}
