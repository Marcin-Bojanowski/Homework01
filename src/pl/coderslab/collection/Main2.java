package pl.coderslab.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {


        String reg1 = "^[-+]?\\d*\\.?\\d*$";
        String reg2 = "[+-]?\\d(\\.\\d+)?[Ee][+-]?\\d+";
        String reg3 = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        String reg4 = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

        Pattern floatingPointNumbers = Pattern.compile(reg1);
        Matcher floatingPointNumbersMacher = floatingPointNumbers.matcher("4234.5464");
        System.out.println(floatingPointNumbersMacher.matches());

        Pattern scienceNumber = Pattern.compile(reg2);
        Matcher scienceNumberMacher = scienceNumber.matcher("5.4325e+04");
        System.out.println(scienceNumberMacher.matches());

        Pattern dateOne = Pattern.compile(reg3);
        Matcher dateOneMacher = dateOne.matcher("01/01/2500");
        System.out.println(dateOneMacher.matches());

        Pattern dateTwo = Pattern.compile(reg4);
        Matcher dateTwoMacher = dateTwo.matcher("2500-01-25");
        System.out.println(dateTwoMacher.matches());
    }
}
