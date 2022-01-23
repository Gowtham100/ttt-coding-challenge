package com.example.ttt_codingchallenge.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobapplications", schema="public")
public class JobApplications {

  @Id
  public long id;

  @Column(name="job_id")
  public long job_id;

  @Column(name="applicant_first_name")
  public String applicant_first_name;

  @Column(name="applicant_last_name")
  public String applicant_last_name;

  @Column(name="job_title")
  public String job_title;

  @Column(name="job_desc")
  public String job_desc;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getJobId() {
    return job_id;
  }

  public void setJobId(long jobId) {
    this.job_id = jobId;
  }


  public String getApplicantFirstName() {
    return applicant_first_name;
  }

  public void setApplicantFirstName(String applicantFirstName) {
    this.applicant_first_name = applicantFirstName;
  }


  public String getApplicantLastName() {
    return applicant_last_name;
  }

  public void setApplicantLastName(String applicantLastName) {
    this.applicant_last_name = applicantLastName;
  }


  public String getJobTitle() {
    return job_title;
  }

  public void setJobTitle(String jobTitle) {
    this.job_title = jobTitle;
  }


  public String getJobDesc() {
    return job_title;
  }

  public void setJobDesc(String jobDesc) {
    this.job_title = jobDesc;
  }

}
