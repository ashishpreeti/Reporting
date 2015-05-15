package com.myreports;

import net.sf.jasperreports.engine.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ReportGenerator {

	public String createPDFReport() {
        Connection conn = null;
		String pdfDestination = "";
		String fileName = "school";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/college", "ash", "password");

			HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
			JasperReport jasperReport;
			JasperPrint jasperPrint;

			String content = new String(Files.readAllBytes(Paths.get("out/production/Reporting/school1.xml")));

			String workingdirectory = System.getProperty("user.dir");


			jasperReport = JasperCompileManager.compileReport("out/production/Reporting/school1.xml");
			// jasperReØport = compileTemplate(template, context);

			jasperPrint = JasperFillManager.fillReport(jasperReport,null, conn);

			long currentTime = System.currentTimeMillis();

			String filePath = "school";
			String fileExtension = ".pdf";
			pdfDestination = filePath + currentTime + fileExtension;
			fileName = fileName + currentTime + fileExtension;
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					pdfDestination);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}


}
