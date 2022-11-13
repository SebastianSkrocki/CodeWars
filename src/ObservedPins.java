//https://www.codewars.com/kata/5263c6999e0f40dee200059d

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObservedPins {
    /**
     * Calculates the number of all possible combinations
     * */
    public static int poisbleCombinations(String givenPN){
        int allCombinations = 1;
        for(int i=0;i<givenPN.length();i++){
            allCombinations *= adjacentNumbers().get(givenPN.charAt(i)).length;
        }
        return allCombinations;
    }
    /**
     * HashMap with all adjacent characters for a given character
     * */
    public static HashMap<Character ,String[]> adjacentNumbers(){
        HashMap<Character ,String[]> adjacentDigit = new HashMap<>();
        adjacentDigit.put('1', new String[]{"1", "2", "4"});
        adjacentDigit.put('2', new String[]{"2", "1", "3", "5"});
        adjacentDigit.put('3', new String[]{"2", "3", "6"});
        adjacentDigit.put('4', new String[]{"4", "1", "5", "7"});
        adjacentDigit.put('5', new String[]{"5", "2", "4", "6", "8"});
        adjacentDigit.put('6', new String[]{"3", "5", "6", "9"});
        adjacentDigit.put('7', new String[]{"7", "4", "8"});
        adjacentDigit.put('8', new String[]{"8", "5", "7", "9", "0"});
        adjacentDigit.put('9', new String[]{"9", "6", "8"});
        adjacentDigit.put('0', new String[]{"0", "8"});
        return adjacentDigit;
    }
    /**
     * Returns all possible combinations of PINs
     * */
    public static List<String> getPINs(String observed){
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < observed.length(); i++) {
            int count;
            int lenghtOfTheAdjacentNumbers = adjacentNumbers().get(observed.charAt(i)).length;
            int signCount = 0;
            String[] signsToAdd = adjacentNumbers().get(observed.charAt(i));
            String singleSign;
            for (int j = 0; j < poisbleCombinations(observed); j += poisbleCombinations(observed.substring(i + 1))) {
                count = j;

                if (signCount >= lenghtOfTheAdjacentNumbers) {
                    signCount = 0;
                }
                singleSign = signsToAdd[signCount];
                signCount++;
                for (int k = 0; k < poisbleCombinations(observed.substring(i + 1)); k++) {
                    if (i == 0) {
                        results.add(singleSign);
                    } else {
                        results.set(count, results.get(count).concat(singleSign));
                    }
                    count++;

                }

            }
        }
        return results;
    }
}
