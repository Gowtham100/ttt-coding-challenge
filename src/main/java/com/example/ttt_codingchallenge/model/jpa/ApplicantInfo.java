package com.example.ttt_codingchallenge.model.jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicantinfo", schema="public")
public class ApplicantInfo {

  @Id
  public long job_id;

  @Column(name="job_title")
  public String job_title;

  @Column(name="volunteer_info")
  public String volunteer_info;


  public long getJobId() {
    return job_id;
  }

  public void setJobId(long jobId) {
    this.job_id = jobId;
  }


  public String getJobTitle() {
    return job_title;
  }

  public void setJobTitle(String jobTitle) {
    this.job_title = jobTitle;
  }


  public String getVolunteerInfo() {
    return volunteer_info;
  }

  public void setVolunteerInfo(String volunteerInfo) {
    this.volunteer_info = volunteerInfo;
  }

}
