package ca.sheridancollege.database;

import ca.sheridancollege.beans.School;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * A simple class marked up as a repository to simulate
 * database access.
 * We are also asking lombok to create the getters/setters for us
 * we'll use injection in our controller class to access it
 */
@Repository
@Data
public class DatabaseAccess {

    // used to simulate a table
    // in this list, we are storing list of student details.
    private ArrayList<School> schoolList = new ArrayList<>();

}
