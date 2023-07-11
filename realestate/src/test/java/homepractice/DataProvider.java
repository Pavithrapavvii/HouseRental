package homepractice;

import org.testng.annotations.Test;

public class DataProvider {
	
	
	
	@Test(dataProvider = "bookTicket")
	public void getBookDetails(String src, String dest,String price) 
{
	System.out.println(src+" "+dest+" "+price);
}
	
	@org.testng.annotations.DataProvider
	public Object[][] bookTicket()
	{
	
	 Object[][] obj =new Object[3][3];
	obj[0][0]="bglr";
	obj[0][1]="delhi";
	obj[0][2]="2000";
	
	obj[1][0]="delhi";
	obj[1][1]="kerala";
	obj[1][2]="4000";
	
	obj[2][0]="chennai";
	obj[2][1]="bglr";
	obj[2][2]="3000";
	return obj;
	
	}

}
