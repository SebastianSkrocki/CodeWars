//https://www.codewars.com/kata/541c8630095125aba6000c00/java

public class SumOfDigits {

    public static void main (String[] args) {
        System.out.println(digital_root(745409));
    }
    public static int digital_root(int n) {
        int sum_of_digits = 0;
        do{
            sum_of_digits += n % 10;
            n = n / 10;
        }while (n % 10 != 0 || n > 10);
        n = sum_of_digits;
        if(n < 10){
            return n;
        }else {
            return digital_root(n);
        }
    }
}
