package pl.coderslab.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main03 {
    public static void main(String[] args) {
        String reg="^[_a-zA-Z-]+[_a-zA-Z0-9-]{4,}$";
        Pattern check = Pattern.compile(reg);
        Matcher checkMacher = check.matcher("test01234_-@");
        System.out.println(checkMacher.matches());
    }
}
