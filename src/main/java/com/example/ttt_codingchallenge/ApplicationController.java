package com.example.ttt_codingchallenge;

import com.example.ttt_codingchallenge.DAO.JobApplicantsDAO;
import com.example.ttt_codingchallenge.DAO.JobApplicationsDAO;
import com.example.ttt_codingchallenge.model.jpa.ApplicantInfo;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Main controller class
 */
@Controller
public class ApplicationController {

    @Autowired
    private JobApplicationsDAO jobApplicationsDAO;

    @Autowired
    private JobApplicantsDAO jobApplicantsDAO;

    /**
     * This method maps the Job Applications that ware called from the DAO methods
     * @param model Used to map the string which is used to call in the front end to the DAO List
     * @return
     */
    @RequestMapping("/applications")
    public String application(Map<String, Object> model) {
        List<JobApplications> jobApplication = jobApplicationsDAO.getJobApplications();
        model.put("applications", jobApplication);

        return "applications";
    }
    @RequestMapping("/applicants")
    public String applicants(Map<String, Object> model) {
        List<ApplicantInfo> jobApplicants = jobApplicantsDAO.getJobApplicant();
        model.put("applicants", jobApplicants);

        return "applicants";
    }
}
