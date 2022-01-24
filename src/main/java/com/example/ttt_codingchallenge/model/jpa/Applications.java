package com.example.ttt_codingchallenge.model.jpa;


public class Applications {

  private long id;
  private long jobId;
  private long volunteerId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public long getVolunteerId() {
    return volunteerId;
  }

  public void setVolunteerId(long volunteerId) {
    this.volunteerId = volunteerId;
  }

}
