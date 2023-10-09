package ca.sheridancollege.controllers;

import ca.sheridancollege.beans.School;
import ca.sheridancollege.database.DatabaseAccess;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    // calling databaseAccess object
    private DatabaseAccess da;

    /**
     * One arg constructor
     *
     * @param da will be injected by spring.
     */
    public HomeController(DatabaseAccess da) {
        this.da = da;
    }

    /**
     * This method returns the form page to add a school
     * @return the page to return to the user, addSchool
     */
    @GetMapping("/addSchoolForm")
    public String addSchoolForm() {
        // returning to addSchool page
        return "addSchool";
    }

    /**
     * This method will handle the form's POST to add a school and
     * add it to our arraylist.
     * @param schoolName The name of the school
     * @param schoolAddress The address of the school
     * @param numStudents Number of students attending the school
     * @return goes back to index page
     */
    @PostMapping("/add")
    public String addSchool(@RequestParam String schoolName, @RequestParam String schoolAddress,
                            @RequestParam int numStudents) {
        School school = new School(schoolName, schoolAddress, numStudents);
        da.getSchoolList().add(school);
        // go back to index
        return "index";
    }

    /**
     * This method will clear the data from the arraylist
     * @return goes back to index page
     */
    @GetMapping("/removeAll")
    public String removeAndGoHome() {
        // clearing the data inside list
        da.getSchoolList().clear();
        return "index";
    }

    /**
     * This method will be used to view the list of school details
     * @param model this will store the list of school details
     * @return returns to the listing page
     */
    @GetMapping("/viewSchools")
    public String viewSchools(Model model) {
        ArrayList<School> schools = da.getSchoolList(); // get your list of schools
        model.addAttribute("schools", schools);
        return "listing";
    }

}
