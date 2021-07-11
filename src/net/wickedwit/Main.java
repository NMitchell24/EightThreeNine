package net.wickedwit;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String args[]) {
        Instant start = Instant.now();
        //   EIGHT
        // + THREE
        // +  NINE
        // ========
        //  TWENTY

        int eight = 10000;
        int three = 10000;
        int nine = 1000;
        int twenty = 0;

        boolean solved = false;

        while(eight < 100000) {
            three = 10000;
            boolean threeSolution = false;
            boolean nineSolution = false;
            boolean eightTest = testEight(eight);

            if(eightTest) {
                while (three < 100000) {
                    threeSolution = testThree(eight, three);
                    if (threeSolution) {
                        nine = 1000;
                        while (nine < 10000) {
                            nineSolution = testNine(eight, three, nine);
                            if (nineSolution) {
                                twenty = solveForTwenty(eight, three, nine);
                                if(twenty > 0) {
                                    solved = true;
                                }
                            }
                            nine++;
                        }
                    }
                    three++;
                }
            }
            eight++;
        }


        if(solved){
            //Print out solution.
            System.out.println("All solutions found");

        }else {
            //Print error message if there was a failure.
            System.out.println("unable to solve puzzle.");
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("\nIn "+duration.toMillis()+" Milliseconds");
    }

    public static boolean testEight(int eight){
        String eightStr = String.valueOf(eight);
        // If at any time we encounter 2 same
        // characters, return false
        for (int i = 0; i < eightStr.length(); i++) {
            for (int j = i + 1; j < eightStr.length(); j++) {
                if (eightStr.charAt(i) == eightStr.charAt(j)) {
                    return false;
                }
            }
        }
        // If no duplicate characters encountered,
        // return true
        return true;
    }

    public static boolean testThree(int eight, int three){
        //compare eight and three to make sure they match criteria
        String eightStr = String.valueOf(eight);
        String threeStr = String.valueOf(three);

        if(!eightStr.contains(threeStr.substring(2,3))
                && !threeStr.contains(eightStr.substring(1,2))
                && !threeStr.contains(eightStr.substring(2,3))
                && eightStr.charAt(0) == threeStr.charAt(3)
                && eightStr.charAt(0) == threeStr.charAt(4)
                && eightStr.charAt(3) == threeStr.charAt(1)
                && eightStr.charAt(4) == threeStr.charAt(0)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean testNine(int eight, int three, int nine){
        //compare eight and nine to make sure they match criteria
        String eightStr = String.valueOf(eight);
        String threeStr = String.valueOf(three);
        String nineStr = String.valueOf(nine);

        if(!eightStr.contains(nineStr.substring(0,1))
                && !threeStr.contains(nineStr.substring(0,1))
                && !nineStr.contains(threeStr.substring(2,3))
                && !nineStr.contains(eightStr.substring(2,3))
                && !nineStr.contains(eightStr.substring(3,4))
                && !nineStr.contains(eightStr.substring(4))
                && nineStr.charAt(0) == nineStr.charAt(2)
                && eightStr.charAt(0) == nineStr.charAt(3)
                && eightStr.charAt(1) == nineStr.charAt(1)){
            return true;
        } else {
            return false;
        }
    }

    public static int solveForTwenty(int eight, int three, int nine){
        int twenty = eight + three + nine;

        String eightStr = String.valueOf(eight);
        String threeStr = String.valueOf(three);
        String nineStr = String.valueOf(nine);
        String twentyStr = String.valueOf(twenty);

        if(twentyStr.length() == 6
                && !eightStr.contains(twentyStr.substring(1,2))
                && !eightStr.contains(twentyStr.substring(5))
                && !twentyStr.contains(eightStr.substring(1,2))
                && !twentyStr.contains(eightStr.substring(2,3))
                && !twentyStr.contains(eightStr.substring(3,4))
                && !twentyStr.contains(threeStr.substring(2,3))
                && twentyStr.charAt(0) == eightStr.charAt(4)
                && twentyStr.charAt(2) == eightStr.charAt(0)
                && twentyStr.charAt(3) == nineStr.charAt(0)
                && twentyStr.charAt(4) == eightStr.charAt(4)
                && twentyStr.charAt(1) != twentyStr.charAt(5)){
            //Solution found, print it
            printSolution(eight, three, nine, twenty);
        } else {
            //Set twenty to 0 if it fails
            twenty = 0;
        }
        return twenty;
    }

    public static void printSolution(int eight, int three, int nine, int twenty){
        //Print out solution.
        System.out.println("   "+eight);
        System.out.println(" + "+three);
        System.out.println(" +  "+nine);
        System.out.println(" ========");
        System.out.println("  "+twenty);
        System.out.println("");
    }
}

