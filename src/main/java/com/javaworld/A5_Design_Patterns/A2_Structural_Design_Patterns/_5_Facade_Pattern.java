package com.javaworld.A5_Design_Patterns.A2_Structural_Design_Patterns;
/**
 * 
 */

import java.sql.Connection;

/**
 * @author Shaik Khader
 
 According to GoF, Facade design pattern is:

    "Provide a unified interface to a set of interfaces in a subsystem. Facade Pattern defines a
	higher-level interface that makes the subsystem easier to use".
 
 Facade Pattern is used to help client applications to easily interact with the system. Suppose we have an application with set of 
 interfaces to use MySql/Oracle database and to generate different types of reports, such as HTML report, PDF report etc. So we will
 have different set of interfaces to work with different types of database. Now a client application can use these interfaces to get
 the required database connection and generate reports. But when the complexity increases or the interface behavior names are 
 confusing, client application will find it difficult to manage it. So we can apply Facade pattern here and provide a wrapper 
 interface on top of the existing interface to help client application.
 
 As you can see below that using Facade pattern interface is a lot easier and cleaner way to avoid having a lot of logic at client 
 side. JDBC Driver Manager class to get the database connection is a wonderful example of facade design pattern.
 
 Facade Design Pattern Important Points:

    .Facade design pattern is more like a helper for client applications, it doesn`t hide subsystem interfaces from the client.
     Whether to use Facade or not is completely dependent on client code.
    .Facade design pattern can be applied at any point of development, usually when the number of interfaces grow and system gets 
     complex.
    .Subsystem interfaces are not aware of Facade and they shouldn`t have any reference of the Facade interface.
    .Facade design pattern should be applied for similar kind of interfaces, its purpose is to provide a single interface rather 
     than multiple interfaces that does the similar kind of jobs.
    .We can use Factory pattern with Facade to provide better interface to client systems.
    
 
 */


class MySqlDBHelper {
	
	public static Connection getMySqlDBConnection(){
		//get MySql DB connection using connection parameters
		return null;
	}
	
	public void generateMySqlPDFReport(String tableName, Connection con){
		//get data from table and generate pdf report
	}
	
	public void generateMySqlHTMLReport(String tableName, Connection con){
		//get data from table and generate pdf report
	}
}

class OracleDBHelper {

	public static Connection getOracleDBConnection(){
		//get Oracle DB connection using connection parameters
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, Connection con){
		//get data from table and generate pdf report
	}
	
	public void generateOracleHTMLReport(String tableName, Connection con){
		//get data from table and generate pdf report
	}
	
}

class DBHelperFacade {

	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
		Connection con = null;
		switch (dbType){
		case MYSQL: 
			con = MySqlDBHelper.getMySqlDBConnection();
			MySqlDBHelper mySqlHelper = new MySqlDBHelper();
			switch(reportType){
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, con);
				break;
			}
			break;
		case ORACLE: 
			con = OracleDBHelper.getOracleDBConnection();
			OracleDBHelper oracleHelper = new OracleDBHelper();
			switch(reportType){
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		}
		
	}
	
	public static enum DBTypes{
		MYSQL,ORACLE;
	}
	
	public static enum ReportTypes{
		HTML,PDF;
	}
}

public class _5_Facade_Pattern {
	public static void main(String... args) {
String tableName="Employee";
		
		//generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = MySqlDBHelper.getMySqlDBConnection();
		MySqlDBHelper mySqlHelper = new MySqlDBHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		
		Connection con1 = OracleDBHelper.getOracleDBConnection();
		OracleDBHelper oracleHelper = new OracleDBHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		
		//generating MySql HTML report and Oracle PDF report using Facade
		DBHelperFacade.generateReport(DBHelperFacade.DBTypes.MYSQL, DBHelperFacade.ReportTypes.HTML, tableName);
		DBHelperFacade.generateReport(DBHelperFacade.DBTypes.ORACLE, DBHelperFacade.ReportTypes.PDF, tableName);
	}

}
