package com.myreports;

public class ReportClient {
	
	public static void main(String[] args) {
		MyReports report = new MyReports();
		String fileName = report.createPDFReport();
		report.openPdfReport(fileName);
	}

}
