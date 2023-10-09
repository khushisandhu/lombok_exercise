package ca.sheridancollege.beans;

import lombok.Data;

@Data
public class School {

    private String schoolName;
    private String schoolAddress;
    private int numOfStudents;

    public School(String schoolName, String schoolAddress, int numOfStudents) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.numOfStudents = numOfStudents;
    }

}
