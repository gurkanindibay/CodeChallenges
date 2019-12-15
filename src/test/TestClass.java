package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class TestClass {
    public static void main(String[] args) throws ParseException {
        //roundWithBigDecimal();
        double value = Math.pow(126.0,1.0/3.0);
        DecimalFormat df=new DecimalFormat("0.000");
        String formate = df.format(value);
        double finalValue = df.parse(formate).doubleValue() ;
        long lFinalValue = Math.round(finalValue*1000);
        System.out.println(lFinalValue);
    }

    private static void roundWithBigDecimal() {
        BigDecimal a = new BigDecimal(Math.pow(125.0,1.0/3.0));
        BigDecimal roundOff = a.setScale(3, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(roundOff);
    }
}
