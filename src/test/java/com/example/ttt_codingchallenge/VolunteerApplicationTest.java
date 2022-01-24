package com.example.ttt_codingchallenge;

import com.example.ttt_codingchallenge.DAO.JobApplicantsDAO;
import com.example.ttt_codingchallenge.DAO.JobApplicationsDAO;
import com.example.ttt_codingchallenge.model.jpa.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith( SpringJUnit4ClassRunner.class )
@Repository
public class VolunteerApplicationTest {

    @Autowired
    private ProdHibernateUtil dbConnection;

    @Before
    public void before() {
        dbConnection.getSessionFactory().openSession();
    }

    /**
     * Test with a Person with a new job ID and check for new row added
     */
    @Test
    public void validNewJobScenario() {
        dbConnection.getSessionFactory().openSession();
        Jobs jobs = new Jobs();
        Volunteers volunteers = new Volunteers();
        Applications applications = new Applications();

        volunteers.setVolunteerId(100);
        volunteers.setApplicantFirstName("Gowtham");
        volunteers.setApplicantLastName("Mohan");

        jobs.setJobId(200);
        jobs.setJobTitle("Test Job");
        jobs.setJobDesc("This is a test job");

        applications.setId(300);
        applications.setJobId(200);
        applications.setVolunteerId(100);

        JobApplicantsDAO jobApplicantsDAO = new JobApplicantsDAO();
        JobApplicationsDAO jobApplicationsDAO = new JobApplicationsDAO();
        List<ApplicantInfo> jobApplicant = jobApplicantsDAO.getJobApplicant();
        List<JobApplications> jobApplications = jobApplicationsDAO.getJobApplications();

        // Check whether the application was added in
        Assertions.assertEquals(jobApplications.size(), 65);
        Assertions.assertTrue(jobApplications.contains("Gowtham"));
        Assertions.assertTrue(jobApplications.contains("Mohan"));
        // Job ID 200
        Assertions.assertTrue(jobApplications.contains(200));
        // Job title is Test Job
        Assertions.assertTrue(jobApplications.contains("Test Job"));
        // Job desc is This is a test job
        Assertions.assertTrue(jobApplications.contains("This is a test job"));

        // Check whether the applicant was added in
        Assertions.assertEquals(jobApplicant.size(), 8);
        Assertions.assertTrue(jobApplicant.get(7).volunteer_info.contains("Gowtham Mohan"));
    }

    /**
     * Test with a Person with a existing job ID and check is the person was added to the list of volunteers
     */
    @Test
    public void validExistingJobScenario() {
        dbConnection.getSessionFactory().openSession();
        Volunteers volunteers = new Volunteers();
        Applications applications = new Applications();

        volunteers.setVolunteerId(100);
        volunteers.setApplicantFirstName("Gowtham");
        volunteers.setApplicantLastName("Mohan");

        // Set Job ID 1 to Gowtham
        applications.setId(1);
        applications.setVolunteerId(100);

        JobApplicantsDAO jobApplicantsDAO = new JobApplicantsDAO();
        JobApplicationsDAO jobApplicationsDAO = new JobApplicationsDAO();
        List<ApplicantInfo> jobApplicant = jobApplicantsDAO.getJobApplicant();
        List<JobApplications> jobApplications = jobApplicationsDAO.getJobApplications();

        // Check whether the application was added in
        Assertions.assertEquals(jobApplications.size(), 65);
        Assertions.assertTrue(jobApplications.contains("Gowtham"));
        Assertions.assertTrue(jobApplications.contains("Mohan"));
        // Job ID 1
        Assertions.assertTrue(jobApplications.contains(1));

        // Check whether the applicant was added in
        Assertions.assertEquals(jobApplicant.size(), 7);
        Assertions.assertTrue(jobApplicant.get(0).volunteer_info.contains("Gowtham Mohan"));
    }
}
