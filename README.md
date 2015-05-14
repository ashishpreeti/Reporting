# Reporting
Working PDF reports on standalone Java 8 program

Pulls data (model) from the mysql database. Uses xml files created and designed in iReports. Users Jasper to render 
the xml with the model and create pdf. 

Used Java File IO to create a unique file everytime the program is run.

-- Next steps are to refactor the code. 

-- Convert this into a web application. Use java servlet and render the pdf in browser instead of creating a pdf file. 
--If the browser doesn't support pdf format then the file will get download but, it won't get created on the server side.

-- Make the pdf secure with username and password

-- Create excel and word

-- make the report dynamic by injecting the sql

-- make the report columns dynamic by creating the report.xml on the fly



