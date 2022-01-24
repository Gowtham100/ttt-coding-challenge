package com.example.ttt_codingchallenge.model.jpa;


public class Jobs {

  private long jobId;
  private String jobTitle;
  private String jobDesc;


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }


  public String getJobDesc() {
    return jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

}
