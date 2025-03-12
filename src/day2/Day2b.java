package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day2b {
    public String mainLogic() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputDay2.txt"));
            String text;
            int result = 0;
            while ((text = br.readLine()) != null) {
                String[] lineStr = text.split(" ");
                List<String> numbersInLine = new ArrayList<>();
                //Adds every number from 'lineStr' to 'numbersInLine'
                IntStream.range(0, lineStr.length).forEach(i -> numbersInLine.add(i, lineStr[i]));
                boolean isBad = safeness(numbersInLine);
                if(isBad){
                    for (int i = 0; i < numbersInLine.size(); i++) {
                        List<String> deleteIntsLine = new ArrayList<>();
                        IntStream.range(0, lineStr.length).forEach(j -> deleteIntsLine.add(j, lineStr[j]));
                        deleteIntsLine.remove(i);
                        isBad = safeness(deleteIntsLine);
                        if(!isBad) break;
                    }
                }
                if(!isBad) result++;
            }
            return "This is your result of second task in day 2: " + result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean safeness(List<String> numbersInLine) {
        boolean isBad = false;
        try{
            int currentNum = -10;
            CasesOfSequence state = CasesOfSequence.START;

            for (String s : numbersInLine) {
                int nextNum = Integer.parseInt(s);
                if (currentNum == -10) {
                    currentNum = nextNum;
                    continue;
                }
                if (currentNum < nextNum) {
                    if (state.equals(CasesOfSequence.START)) {
                        state = CasesOfSequence.RISING;
                    } else if (state.equals(CasesOfSequence.FALLING)) {
                        isBad = true;
                        break;
                    }
                    if (Math.abs(currentNum - nextNum) > 3) {
                        isBad = true;
                        break;
                    }
                    currentNum = nextNum;
                } else if (currentNum > nextNum) {
                    if (state.equals(CasesOfSequence.START)) {
                        state = CasesOfSequence.FALLING;
                    } else if (state.equals(CasesOfSequence.RISING)) {
                        isBad = true;
                        break;
                    }
                    if (Math.abs(currentNum - nextNum) > 3) {
                        isBad = true;
                        break;
                    }
                    currentNum = nextNum;
                } else {
                    isBad = true;
                    break;
                }
            }
        }catch (NumberFormatException n){
            System.err.println("Number format error" + numbersInLine);
        }
        return isBad;
    }
}
