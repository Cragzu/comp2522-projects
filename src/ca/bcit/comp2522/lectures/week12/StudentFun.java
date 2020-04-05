package ca.bcit.comp2522.lectures.week12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StudentFun {

    public static void printStudentNames(Collection<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public static void printStreamStudentNames(Collection<Student> students) {
        students.stream().forEach(e -> System.out.println(e.getName()));
    }

    public static void printStreamGraduates(Collection<Student> students) {
        students
                .stream()
                .filter(e -> e.getStanding() == Student.Standing.GRADUATE)
                .forEach(e -> System.out.println(e.getName()));
    }

    public static double getAverageGraduateAge(Collection<Student> students) {
        return students
                .stream()
                .filter(e -> e.getStanding() == Student.Standing.GRADUATE)
                .mapToInt(Student::getAgeInYears)
                .average()
                .getAsDouble();
    }

    public static void main(String[] args) {

        ArrayList<Student> studentsArrayList = new ArrayList<>();

        final int sampleSize = 10;
        for (int i = 0; i < sampleSize; ++i) {

            final int nameLength = 8;
            char[] name = new char[nameLength];
            for (int j = 0; j < nameLength; ++j) {
                name[j] = (char) (65 + new Random().nextInt(26));
            }
            String generatedName = new String(name);

            long minDay = LocalDate.of(1960, 1, 1).toEpochDay();
            long maxDay = LocalDate.of(2004, 1, 1).toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate birthday = LocalDate.ofEpochDay(randomDay);

            Student student = new Student(generatedName, birthday, null);
            if (new Random().nextBoolean()) {
                student.setStanding(Student.Standing.GRADUATE);
            } else {
                student.setStanding(Student.Standing.SATISFACTORY);
            }
            studentsArrayList.add(student);

        }
        printStudentNames(studentsArrayList);
        printStreamStudentNames(studentsArrayList);
        printStreamGraduates(studentsArrayList);
        System.out.println(getAverageGraduateAge(studentsArrayList));
    }
}
