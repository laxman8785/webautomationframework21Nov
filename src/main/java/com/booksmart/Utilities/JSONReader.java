package com.booksmart.Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
	
	JSONObject testData;
	String datafile;

	public JSONReader(String datafile) throws Exception {
		try {
			String fileExtension = null;			
			fileExtension = System.getProperty("user.dir")+"\\src\\main\\resources\\data\\" + datafile;
			System.out.println(fileExtension);
			this.datafile=fileExtension;
			File file = new File(this.datafile);
			testData = (JSONObject) ((JSONObject) (new JSONParser()).parse(new InputStreamReader(new FileInputStream(file),"UTF-8"))).get("TestData");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	
	public LinkedHashMap<String, String> getKeys(String dataset){
		JSONObject objDataSet=getDataSet(dataset);
		return getKeys(objDataSet);
	}

	public LinkedHashMap<String, String> getKeys(JSONObject objDataSet) {
		if (objDataSet == null)
			return null;
		Object objAdds = null;
		org.json.simple.JSONArray addsArray = null;
		LinkedHashMap<String,String> list=new LinkedHashMap<String,String>();
		if (objDataSet instanceof JSONObject) {
			objAdds = ((JSONObject) objDataSet).get("Add");
			if (objAdds instanceof org.json.simple.JSONArray) {
				addsArray = (org.json.simple.JSONArray) objAdds;
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> iterator = addsArray.iterator();
				while (iterator.hasNext()) {
					JSONObject add = (JSONObject) iterator.next();
					if (add.containsKey("key"))
						list.put(add.get("key").toString(),add.get("value").toString());
				}
			}else if (objAdds instanceof JSONObject) {
				JSONObject addObj = (JSONObject) objAdds;
				if (addObj.containsKey("key"))
					list.put(addObj.get("key").toString(),addObj.get("value").toString());
			}
		}
		return list;
	}
	
	public JSONObject getDataSet(String name) {
		Object objDataSets = testData.get("DataSet");
		if (objDataSets instanceof org.json.simple.JSONArray) {
			org.json.simple.JSONArray dataSets = (org.json.simple.JSONArray) objDataSets;
			for (int i = 0; i < dataSets.size(); i++) {
				JSONObject dataSet = (JSONObject) dataSets.get(i);
				if (dataSet.get("name").equals(name))
					return dataSet;
			}
		} else if (objDataSets instanceof JSONObject)
			return (JSONObject) objDataSets;
		return null;
	}
	
	public static void main(String args[]) throws Exception {
		JSONReader marsh = new JSONReader("testdata.json");
		
		LinkedHashMap<String, String> keys=marsh.getKeys(marsh.getDataSet("AddBook"));
		System.out.println(keys.get("textboxBook_Name"));
	}

	
}
