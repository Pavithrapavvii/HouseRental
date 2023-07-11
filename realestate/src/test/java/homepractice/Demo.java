package homepractice;

import java.io.IOException;

import com.realestate.generic.ExcelUtlity;

public class Demo {
	public static void main(String[] args) throws IOException, Throwable {
		ExcelUtlity e =new ExcelUtlity();
		String password = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 4);
	//	String conpassword = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 5);
		String data = e.getDataFromExcel("./testdata/homeCredentatial.xlsx", "homeregister", 1, 5);
		System.out.println(data);
		
	}

}
