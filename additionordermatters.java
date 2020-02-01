import java.math.BigDecimal;
import java.math.*;

public class additionordermatters {
    public static void main(String[] args) {
        double num1 = (2.6 + 3.9) + 1.3;
        System.out.println(num1);
        // output will be 7.8
        
        double num2 = 2.6 + (3.9 + 1.3);
        System.out.println(num2);
        // output will be 7.80000000000001 
        
        // why they are different?
        // because in the computer
        // check here https://www.mathsisfun.com/binary-decimal-hexadecimal-converter.html
        // decimal 2.6 will be in the binary format 10.100110011001100110011001100110011001100110011001100110011001
        // decimal 3.9 will be in the binary format 11.111001100110011001100110011001100110011001100110011001100110
        // decimal 7.8 will be in the binary format 111.110011001100110011001100110011001100110011001100110011001100
        
        // computer does the calculation using binary format, when double have a default precision level, it causes that
        // different order (2.6 + 3.9) + 1.3 is different from 2.6 + (3.9 + 1.3)
        
        
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
