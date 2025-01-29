package dataFiles;

import utilityFiles.Xls_Reader;

public class DataFile {

	Xls_Reader readData = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	
	public String NoEmail = readData.getCellData("Data3", "NoEmail", 2);
	public String IncorrectEmail = readData.getCellData("Data3", "IncorrectEmail", 2);
	public String IncorrectPassword = readData.getCellData("Data3", "IncorrectPassword", 2); 
	public String GlobalexpectedError = readData.getCellData("Data3", "GlobalexpectedError", 2);
	public String MissingexpectedError = readData.getCellData("Data3", "MissingexpectedError", 2);
	
}