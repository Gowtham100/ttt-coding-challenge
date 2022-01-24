package com.example.ttt_codingchallenge.model.jpa;


public class Volunteers {

  private long volunteerId;
  private String applicantFirstName;
  private String applicantLastName;


  public long getVolunteerId() {
    return volunteerId;
  }

  public void setVolunteerId(long volunteerId) {
    this.volunteerId = volunteerId;
  }


  public String getApplicantFirstName() {
    return applicantFirstName;
  }

  public void setApplicantFirstName(String applicantFirstName) {
    this.applicantFirstName = applicantFirstName;
  }


  public String getApplicantLastName() {
    return applicantLastName;
  }

  public void setApplicantLastName(String applicantLastName) {
    this.applicantLastName = applicantLastName;
  }

}
