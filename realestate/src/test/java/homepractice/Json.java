package homepractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Json {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser p=new JSONParser();
		Object obj = p.parse(new FileReader("./data/readdata.json"));
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("username"));
		

	}

}
