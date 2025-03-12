package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b {
    public Day3b() throws FileNotFoundException {
    }

    private long result = 0;
    BufferedReader br = new BufferedReader(new FileReader("inputDay3.txt"));

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

    public int mul(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public String doAndDont() {
        String text;
        boolean isActive = true;
        try {
            while ((text = br.readLine()) != null){
                String[] line = text.split("");
                String lineInString = "";
                for (String s : line) {
                    lineInString +=s;
                }
                Pattern patternTask2 = Pattern.compile("(don't[(][)])|(do[(][)])|(\\bmul[(][0-9]{1,3},[0-9]{1,3}[)]\\b|mul[(][0-9]{1,3},[0-9]{1,3}[)])");
                Matcher matcherTask2 = patternTask2.matcher(Objects.requireNonNull(lineInString));
                while (matcherTask2.find()) {
                    //don't()
                    if (matcherTask2.group(1) != null) {
                        isActive = false;
                    }
                    //do()
                    if (matcherTask2.group(2) != null) {
                        isActive = true;
                    }
                    //mul(X,Y)
                    if (matcherTask2.group(3) != null && isActive) {
                        regexAndResult(String.valueOf(matcherTask2.group(3)));
                    }
                }
            }
            br.close();
            return "This is your result of second task in day 3: " + result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
