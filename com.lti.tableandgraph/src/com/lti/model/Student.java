package com.lti.model;

public class Student {

    private String std_id;
    private String std_nm;
    private String std_gender;
    private String std_branch;

    
	public Student() {
        // TODO Auto-generated constructor stub
    }
    public Student(String sid,String snm,String sgender,String std_branch) {
        this.std_id=sid;
        this.std_nm=snm;
        this.std_gender=sgender;
        this.std_branch=std_branch;
    }

    public String getStd_id() {
        return std_id;
    }
    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }
    public String getStd_nm() {
        return std_nm;
    }
    public void setStd_nm(String std_nm) {
        this.std_nm = std_nm;
    }
    public String getStd_gender() {
        return std_gender;
    }
    public void setStd_gender(String std_gender) {
        this.std_gender = std_gender;
    }
    public String getStd_branch() {
		return std_branch;
	}
	public void setStd_branch(String std_branch) {
		this.std_branch = std_branch;
	}
}