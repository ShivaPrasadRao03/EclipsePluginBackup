package com.lti.model;

public class  Defect {
	

	private float similarity;
	private String status;
	private String Severity;
	private String Summary;
	private String DefectID;
	private String TestCaseID;
	private String Detectedby;
	@Override
	public String toString() {
		return "Defect [similarity=" + similarity + ", status=" + status + ", Severity=" + Severity + ", Summary="
				+ Summary + ", DefectID=" + DefectID + ", TestCaseID=" + TestCaseID + ", Detectedby=" + Detectedby
				+ "]";
	}
	
}
