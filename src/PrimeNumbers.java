//https://www.codewars.com/kata/5262119038c0985a5b00029f/java

public class PrimeNumbers {
    public static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 ==0)return false;
        for(int i = 3; i<= Math.sqrt(num); i+= 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
