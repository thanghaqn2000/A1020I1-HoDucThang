package stack_queue.demegring;

import java.util.Comparator;

public class Human implements Comparable<Human> {
    String gender;
    String fullName;
    String dateOfBirth;

    public Human() {
    }

    public Human(String fullName, String gender, String dateOfBirth) {
        this.gender = gender;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHeader() {
        return "FullName,Gender,Birthday";
    }

    public String writeToCSV() {
        return fullName +
                "," + gender +
                "," + dateOfBirth ;
    }

    @Override
    public String toString() {
        return "Human{" +
                "gender='" + gender + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human human) {
        if (this.getGender() == human.getGender()) {
            return this.getDateOfBirth().compareTo(human.getDateOfBirth());
        } else return this.getGender().compareTo(human.getGender());
    }
}
