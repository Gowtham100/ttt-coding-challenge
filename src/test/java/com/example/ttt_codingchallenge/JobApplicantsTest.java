package com.example.ttt_codingchallenge;

import com.example.ttt_codingchallenge.DAO.JobApplicantsDAO;
import com.example.ttt_codingchallenge.model.jpa.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith( SpringJUnit4ClassRunner.class )
@Repository
public class JobApplicantsTest {

    @Autowired
    private ProdHibernateUtil dbConnection;

    @Before
    public void before() {
        dbConnection.getSessionFactory().openSession();
    }

    @Test
    public void validPathScenario() {
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
        List<JobApplications> jobApplications = jobApplicantsDAO.getJobApplicant();
        System.out.println(jobApplications);

        // with a new Job added, there will be 8 jobs in total. Hence 8 rows.
        Assertions.assertEquals(jobApplications.size(), 8);

    }
}
