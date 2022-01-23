package com.example.ttt_codingchallenge;

import com.example.ttt_codingchallenge.DAO.JobApplicantsDAO;
import com.example.ttt_codingchallenge.DAO.JobApplicationsDAO;
import com.example.ttt_codingchallenge.model.jpa.JobApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {

    @Autowired
    private JobApplicationsDAO jobApplicationsDAO;

    @Autowired
    private JobApplicantsDAO jobApplicantsDAO;

    @RequestMapping("/applications")
    public String application(Map<String, Object> model) {
        List<JobApplications> jobApplication = jobApplicationsDAO.getJobApplications();
        model.put("applications", jobApplication);

        return "applications";
    }
    @RequestMapping("/applicants")
    public String applicants(Map<String, Object> model) {
        List<JobApplications> jobApplicants = jobApplicantsDAO.getJobApplicant();
        model.put("applicants", jobApplicants);

        return "applicants";
    }
}
