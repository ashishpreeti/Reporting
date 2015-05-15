package com.myreports;

import com.myreports.utils.FileUtils;

public class ReportClient {
	
	public static void main(String[] args) {
		ReportGenerator report = new ReportGenerator();
		String fileName = report.createPDFReport();
		FileUtils.openFile(fileName);
	}

}
