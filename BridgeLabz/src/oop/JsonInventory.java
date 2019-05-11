package oop;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonInventory {
public static void main(String[] args) {
	Inventory inv1 = JsonUnit.jsonToJava(new File("/home/admin1/eclipse-workspace/BridgeLabz/src/oop/JsonFile.json"), Inventory.class);
	System.out.println(JsonUnit.javaToJson(inv1));
}
}

class JsonUnit {
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

@JsonPropertyOrder(value = { "rice", "pulses", "wheats" })
class Inventory {
	InventoryName rice[];
	InventoryName pulses[];
	InventoryName wheats[];

	public InventoryName[] getPulses() {
		return pulses;
	}

	public void setPulses(InventoryName[] pulses) {
		this.pulses = pulses;
	}

	public InventoryName[] getWheats() {
		return wheats;
	}

	public void setWheats(InventoryName[] wheats) {
		this.wheats = wheats;
	}

	public InventoryName[] getRice() {
		return rice;
	}

	public void setRice(InventoryName[] rice) {
		this.rice = rice;
	}

}

class InventoryName {
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
