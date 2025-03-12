package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Day1a {
    private final ArrayList<String> list1;
    private final ArrayList<String> list2;
    private long result;

    public Day1a() {
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
        }catch (Exception e){
            throw new RuntimeException("Something's wrong");
        }
    }

    public String getDis() {
        //Adds absolute value of list1.get(i)) - list2.get(i) to the result.
        IntStream.range(0, list1.size()).map(i ->
                        Math.abs(Integer.parseInt(list1.get(i)) - Integer.parseInt(list2.get(i))))
                .forEach(difference -> result += difference);
        return "This is your result of first task in day 1: " + result;
    }

    public String start(){
        getData();
        return getDis();
    }
}