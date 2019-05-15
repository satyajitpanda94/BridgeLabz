package oop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import org.codehaus.jackson.map.ObjectMapper;

public class JsonInventory {
public static void main(String[] args) {
	InventoryDataMangament invenObj = JsonUtil.jsonToJava(new File("/home/admin1/eclipse-workspace/BridgeLabz/src/oop/JsonFile.json"), InventoryDataMangament.class);
	System.out.println(JsonUtil.javaToJson(invenObj));
//	try {
//		FileWriter fw=new FileWriter(new File("/home/admin1/eclipse-workspace/BridgeLabz/src/oop/JsonFileOutput.json"));
//		fw.write(JsonUtil.javaToJson(invenObj));
//		fw.flush();
//		fw.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
}
}

class JsonUtil {
	private static ObjectMapper mapr = new ObjectMapper();

	public static String javaToJson(Object obj) {
		String s = "";
		try {
			s = mapr.writeValueAsString(obj);
		} catch (IOException e) {
			System.out.println("Exception during Java to Json.");
			e.printStackTrace();
		}
		return s;
	}

	public static <T> T jsonToJava(File file, Class<T> class1) {
		T result = null;
		try {
			result = mapr.readValue(file, class1);
		} catch (IOException e) {
			System.out.println("Exception during Json to Java.");
			e.printStackTrace();
		}
		return result;
	}
}

class InventoryDataMangament {
	Inventory inventory[];

	public Inventory[] getInventory() {
		return inventory;
	}

	public void setInventory(Inventory[] inventory) {
		this.inventory = inventory;
	}
	
}

class Inventory {
	private String name;
	private double weight;
	private double pricePerKg;

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public double getTotalPrice() {
		return this.pricePerKg * this.weight;
	}
}
