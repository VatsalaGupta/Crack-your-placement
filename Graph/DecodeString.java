import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decoder = new DecodeString();
        String result = decoder.decodeString(s);
        System.out.println("Decoded string: " + result);
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number for repetition
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto their respective stacks
                numStack.push(currentNum);
                strStack.push(currentString);
                currentString = new StringBuilder(); // Reset currentString for new segment
                currentNum = 0; // Reset currentNum
            } else if (c == ']') {
                // Complete the current segment
                StringBuilder tempString = currentString;
                currentString = strStack.pop(); // Get the last string from the stack
                int repeatCount = numStack.pop(); // Get the repeat count from the stack
                while (repeatCount-- > 0) {
                    currentString.append(tempString); // Append the segment repeatCount times
                }
            } else {
                // Append regular characters to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
