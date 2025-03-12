package day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day1b {

    private final ArrayList<String> list1;
    private final ArrayList<String> list2;

    public Day1b() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }
    public void getData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputDay1.txt"));
            String text;
            while ((text = br.readLine()) != null) {
                String[] temp = text.split(" {3}");
                list1.add(temp[0]);
                list2.add(temp[1]);
            }
            br.close();
            Collections.sort(list1);
            Collections.sort(list2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String similarity() {
        long simResult = 0;
        try {
            int count = 0;
            int indexInList1 = 0;
            int makeSim;
            int stop = 0;
            getData();
            HashMap<String, Integer> numbers = new HashMap<>();
            while (indexInList1 < list1.size()) {
                for (String s : list2) {
                    for (String j : numbers.keySet()) {
                        if (list1.get(indexInList1).equals(j)) {
                            simResult += numbers.get(j);
                            stop = 1;
                            break;
                        }
                    }
                    if (stop == 1) {
                        stop = 0;
                        indexInList1++;
                        count = 0;
                    }
                    if (list1.get(indexInList1).equals(s)) {
                        count++;
                    }
                }
                makeSim = Integer.parseInt(list1.get(indexInList1)) * count;
                numbers.put(list1.get(indexInList1), makeSim);
                simResult += makeSim;
                indexInList1++;
                count = 0;
            }
        }catch (Exception e){
            throw new RuntimeException("Something's wrong");
        }
        return "This is your result of second task in day 1: " + simResult;
    }
}
