package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day2a {

    public Day2a() {
    }

    public int isRising(int firstNum, int secondNum) {
        int isRising;
        if (firstNum < secondNum) {
            isRising = 1;
        } else if (firstNum > secondNum) {
            isRising = 0;
        } else {
            isRising = 3;
        }
        return isRising;
    }

    public String findingResult() {
        int result = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputDay2.txt"));
            String text;
            int difference;
            boolean isBad;
            while ((text = br.readLine()) != null) {
                isBad = false;
                String[] lineNum = text.split(" ");
                if (lineNum.length < 2) {
                    continue;
                }
                int firstInt = Integer.parseInt(lineNum[0]);
                int secondInt = Integer.parseInt(lineNum[1]);
                int isRising = isRising(firstInt, secondInt);
                int maxDifference = 3;
                switch (isRising) {
                    case 1 -> {
                        for (int i = 0; i < lineNum.length - 1; i++) {
                            if (Integer.parseInt(lineNum[i]) < Integer.parseInt(lineNum[i + 1])) {
                                difference = Integer.parseInt(lineNum[i + 1]) - Integer.parseInt(lineNum[i]);
                                if (difference > maxDifference || difference <= 0) {
                                    isBad = true;
                                    break;
                                }
                            } else {
                                isBad = true;
                                break;
                            }
                        }
                    }
                    case 0 -> {
                        for (int i = 0; i < lineNum.length - 1; i++) {
                            if (Integer.parseInt(lineNum[i]) > Integer.parseInt(lineNum[i + 1])) {
                                difference = Integer.parseInt(lineNum[i]) - Integer.parseInt(lineNum[i + 1]);
                                if (difference > maxDifference || difference <= 0) {
                                    isBad = true;
                                    break;
                                }
                            } else {
                                isBad = true;
                                break;
                            }
                        }
                    }
                    case 3 -> isBad = true;
                }
                if (!isBad) result++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException n) {
            System.err.println("Number format error");
        } catch (Exception e) {
            System.err.println("Something is wrong.");
        }
        return "This is your result of first task in day 2: " + result;
    }

}