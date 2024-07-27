import java.util.HashMap;
import java.util.HashSet;


public class solvingpuzzle {
    private static HashMap<Character, Integer> letterToDigit = new HashMap<>();
    private static HashSet<Integer> usedDigits = new HashSet<>();

    public static void main(String[] args) {
        String[] puzzleStrings = { "SEND", "MORE", "MONEY" };
        Puzzle puzzle = new Puzzle(puzzleStrings[0], puzzleStrings[1], puzzleStrings[2]);
        String lettersToAssign = "SENDMORY";
        boolean solved = exhaustiveSolve(puzzle, lettersToAssign);
        if (solved) {
            System.out.println("Puzzle Solved!");
            System.out.println(letterToDigit);
        } else {
            System.out.println("No solution found.");
        }
    }

    static boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
        if (lettersToAssign.isEmpty()) { // no more choices to make
            return puzzleSolved(puzzle); // checks arithmetic to see if works
        }
        for (int digit = 0; digit <= 9; digit++) { // try all digits
            if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
                if (exhaustiveSolve(puzzle, lettersToAssign.substring(1)))
                    return true;
                unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
            }
        }
        return false; // nothing worked, need to backtrack
    }

    static boolean assignLetterToDigit(char letter, int digit) {
        if (letterToDigit.containsKey(letter) || usedDigits.contains(digit))
            return false;
        letterToDigit.put(letter, digit);
        usedDigits.add(digit);
        return true;
    }

    static void unassignLetterFromDigit(char letter, int digit) {
        letterToDigit.remove(letter);
        usedDigits.remove(digit);
    }

    static boolean puzzleSolved(Puzzle puzzle) {
        String addend1 = puzzle.addend1;
        String addend2 = puzzle.addend2;
        String sum = puzzle.sum;

        int num1 = convertToNumber(addend1);
        int num2 = convertToNumber(addend2);
        int result = convertToNumber(sum);

        return num1 + num2 == result;
    }

    static int convertToNumber(String word) {
        int number = 0;
        for (char letter : word.toCharArray()) {
            number = number * 10 + letterToDigit.get(letter);
        }
        return number;
    }

    static class Puzzle {
        String addend1;
        String addend2;
        String sum;

        Puzzle(String addend1, String addend2, String sum) {
            this.addend1 = addend1;
            this.addend2 = addend2;
            this.sum = sum;
        }
    }
}
