package com.myreports;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class MyReports {
	
	public String createPDFReport() {
		Connection conn = null;
		String pdfDestination = "";
		String fileName = "school";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/college", "ash", "password");

			HashMap<String, Object> jasperParameter = new HashMap<String, Object>();
			/*
			 * JasperReport is the object that holds our compiled jrxml file
			 */
			JasperReport jasperReport;

			/*
			 * JasperPrint is the object contains report after result filling
			 * process
			 */
			JasperPrint jasperPrint;

			// jrxml compiling process
			// This file is in context/reporttemplates folder
			String content = new String(Files.readAllBytes(Paths.get("out/production/Reporting/school1.xml")));
			jasperReport = JasperCompileManager.compileReport("out/production/Reporting/school1.xml");
			// jasperReport = compileTemplate(template, context);

			// filling report with data from data source
			jasperPrint = JasperFillManager.fillReport(jasperReport,null, conn);

			// below piece of code will create a unique file name
			// a unique file name is required so that the user can open multiple
			// pdfs and keep the file open in Adobe reader at the same
			long currentTime = System.currentTimeMillis();

			String filePath = "school";
			String fileExtension = ".pdf";
			pdfDestination = filePath + currentTime + fileExtension;
			fileName = fileName + currentTime + fileExtension;
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					pdfDestination);

			 openPdfReport(pdfDestination);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public void openPdfReport(String file) {
	
	try {
		 System.out.println(file);
		if ((new File(file)).exists()) {

			if(OSDetector.isWindows()) {

				//Windows
			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ file);
				p.waitFor();
			} else if (OSDetector.isLinux() || OSDetector.isMac()) {

				Process p = Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
						file});
				p.waitFor();
			}  else if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(new File(file));
			}
 
		} else {
 
			System.out.println("File does not exists");
 
		}
 
		System.out.println("Done");
 
  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
 
	}
	}
