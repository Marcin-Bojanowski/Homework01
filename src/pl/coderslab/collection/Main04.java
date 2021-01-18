package pl.coderslab.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main04 {
    public static final String EMAIL_REGEX = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
    public static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    public static final String SURNAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    public static final String AGE_REGEX = "\\d{1,3}";
    public static final String CITY_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";


    public static void main(String[] args) {
        Path path = Paths.get("people.csv");
        List<Person> persons = new ArrayList<>();
        try {
            List<String> list = new ArrayList<>(Files.readAllLines(path));
            for (String line : list) {
                String[] splittedList = line.split(",");
                if (check(splittedList)) {
                    persons.add(new Person(splittedList[1], splittedList[2], Integer.parseInt(splittedList[3]), splittedList[4]));
                }
                // System.out.println(check(splittedList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(persons.toString());
        System.out.println(peopleByAge(persons).toString());
    }

    public static boolean check(String[] array) {
        boolean status = true;
        if (array.length != 5) {
            System.out.println("Za mało danych");
            return false;
        }

        Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
        Matcher matcherEmail = patternEmail.matcher(array[0]);
        if (!matcherEmail.matches()) {
            System.out.println("Niepoprawny email");
            status = false;
        }

        Pattern patternName = Pattern.compile(NAME_REGEX);
        Matcher matcherName = patternName.matcher(array[1]);
        if (!matcherName.matches()) {
            System.out.println("Niepoprawne imię");
            status = false;
        }

        Pattern patternSurname = Pattern.compile(SURNAME_REGEX);
        Matcher matcherSurname = patternSurname.matcher(array[2]);
        if (!matcherSurname.matches()) {
            System.out.println("Niepoprawne nazwisko");
            status = false;
        }

        Pattern patternAge = Pattern.compile(AGE_REGEX);
        Matcher matcherAge = patternAge.matcher(array[3]);
        if (!matcherAge.matches()) {
            System.out.println("Niepoprawny wiek");
            status = false;
        }
        Pattern patternCity = Pattern.compile(CITY_REGEX);
        Matcher matcherCity = patternCity.matcher(array[4]);
        if (!matcherCity.matches()) {
            System.out.println("Niepoprawne miasto");
            status = false;
        }
        return status;
    }

    public static Map<Integer, Integer> peopleByAge(List<Person> list) {
        Map<Integer, Integer> peopleByAge = new HashMap<>();
        for (Person pr : list) {
            peopleByAge.put(pr.getAge(), 0);
        }
        for (Integer key : peopleByAge.keySet()) {
            for (Person pr : list) {
                if (pr.getAge().equals(key)) {
                    peopleByAge.put(key, peopleByAge.get(key) + 1);
                }
            }
        }
        return peopleByAge;
    }
}
