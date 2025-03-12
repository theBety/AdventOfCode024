import day1.Day1a;
import day1.Day1b;
import day2.Day2a;
import day2.Day2b;
import day3.Day3a;
import day3.Day3b;
import day4.Day4a;
import day4.Day4b;

import java.io.FileNotFoundException;

public class Start {
    public static void start() throws FileNotFoundException {
        Day1a d1a = new Day1a();
        System.out.println(d1a.start());
        Day1b d1b = new Day1b();
        System.out.println(d1b.similarity());

        System.out.println(" ");

        Day2a d2a = new day2.Day2a();
        System.out.println(d2a.findingResult());
        Day2b d2b = new Day2b();
        System.out.println(d2b.mainLogic());

        System.out.println(" ");

        Day3a d3a = new Day3a();
        System.out.println(d3a.getMulFromLine());
        Day3b d3b = new Day3b();
        System.out.println(d3b.doAndDont());

        System.out.println(" ");

        Day4a d4a = new Day4a();
        System.out.println(d4a.mainLogic());
        Day4b d4b = new Day4b();
        System.out.println(d4b.mainLogic());
    }

}
