package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Parser {

	public void read() throws IOException, ParseException, JSONException {
	try{
		System.out.println("entering parse mode");
		JSONParser parser= new JSONParser();
		
//		Object obj=parser.parse(new FileReader("E:\\Ashna\\jar_files\\example_2.json"));
		//JSONObject jsonObject=(JSONObject) obj;
		//
		
//		Object p=parser.parse(obj.toString());
		String URL="E:\\Ashna\\jar_files\\example_2.json";
		List<String>headerNames=checkForJSON(parser.parse(new FileReader(URL)).toString());
		write(headerNames);
		
		
		//
		////String pa=jsonObject.values().toString();
		
		//String pa1=pa.substring(pa.indexOf("sport")); // --. change to defineDataContentSpec
		//pa1=pa1.substring(pa1.indexOf("{")+1);
		//String[] pa2=pa1.split(":");
		//
		
		
		//System.out.println(jsonObject.values());
		//Iterator it1=jsonObject.values().iterator();
		//Collection value=jsonObject.values();
		//System.out.println("Size:"+value.size());
		
		/*Iterator itr=value.iterator();
		while(itr.hasNext()){
			Map.Entry map=(Map.Entry)itr.next();
			if(map.getKey().equals("options")){
		System.out.println("Value:" +itr.next());
		}*/
		
	/*	while(it1.hasNext()){
			
			Map.Entry me=(Map.Entry)it1.next();
			System.out.println(me.getValue());
		}
		*/
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
		
	}

	public void write(List<String> headerNames) throws IOException{
		File file=new File("E:\\Ashna\\Ash.csv");
		FileWriter fileWriter=new FileWriter(file, true);
		
		PrintWriter writer=new PrintWriter(fileWriter);
		for(String s: headerNames){
		writer.print(s+",");
		}
		int i=12;
		writer.println();
		for(String s: headerNames){
			writer.print("val"+i+++",");
		}
		writer.close();
	

}
public List checkForJSON(String parser) throws JSONException{

	String cutOff="parameters";

	String s1=parser;
	s1=s1.substring(s1.indexOf(cutOff)+cutOff.length()+3);
	s1=s1.replace("{}[]", "");
	s1=s1.replace("}", "");
	s1=s1.replace("[", "");
	s1=s1.replace("]", "");
	String cutOff2="messageFormatVersion";
	s1=s1.substring(0, s1.indexOf(cutOff2));
	String[] splitByComma=s1.split(",");
	List<String> returnHeaders=new ArrayList<>();
	for(String s:splitByComma)
	{
		if(s.length()>1)
		{
			s=s.substring(1, s.length()-1);
			returnHeaders.add(s);
		}
		
	}
	System.out.println("Done Parameters naming");
	return returnHeaders;
	
}
}
