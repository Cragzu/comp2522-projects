package ca.bcit.comp2522.lectures.week12;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    public enum Standing {
        HONOURS, SATISFACTORY, ON_PROBATION, GRADUATE
    }

    private final String name;
    private final LocalDate birthday;
    private Standing standing;
    private String emailAddress;

    public Student() {
        name = null;
        birthday = null;
        standing = null;
        emailAddress = null;
    }

    public Student(final String name, final LocalDate birthday, final String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.standing = Standing.SATISFACTORY;
        this.emailAddress = emailAddress;
    }

    public int getAgeInYears() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public Standing getStanding() {
        return standing;
    }

    public void setStanding(final Standing standing) {
        this.standing = standing;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }
}