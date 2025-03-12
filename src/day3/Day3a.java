package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    private long result = 0;

    public Day3a() throws FileNotFoundException {
    }
    BufferedReader br = new BufferedReader(new FileReader("inputDay3.txt"));
    public String getMulFromLine() {
        try {
            String text;
            while ((text = br.readLine()) != null) {
                String[] line = text.split("");
                StringBuilder lineInString = null;
                for (String s : line) {
                    lineInString = (lineInString == null ? new StringBuilder("null") : lineInString).append(s);
                }
                Pattern patternIsMul = Pattern.compile("\\bmul[(][0-9]{1,3},[0-9]{1,3}[)]\\b|mul[(][0-9]{1,3},[0-9]{1,3}[)]");
                Matcher matcherIsMul = patternIsMul.matcher(Objects.requireNonNull(lineInString == null ? null : lineInString.toString()));
                while (matcherIsMul.find()) {
                    regexAndResult(String.valueOf(matcherIsMul.group()));
                }
            }
            return "This is your result of first task in day 3: " + result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int mul(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public void regexAndResult(String sequence) {
        ArrayList<Integer> twoNumbers = new ArrayList<>();
        Pattern patternIsNum = Pattern.compile("\\d+");
        Matcher matcherIsNum = patternIsNum.matcher(sequence);
        while (matcherIsNum.find()) {
            twoNumbers.add(Integer.parseInt(matcherIsNum.group()));
        }
        int firstNumber = twoNumbers.get(0);
        int secondNumber = twoNumbers.get(1);
        int multiResult = mul(firstNumber, secondNumber);
        result += multiResult;
    }
}
