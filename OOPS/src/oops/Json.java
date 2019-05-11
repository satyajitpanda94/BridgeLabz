package oops;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.ObjectMapper;

public class Json {
	public static void main(String[] args) {

		Inventory inv1 = JsonUnit.jsonToJava(new File("/home/admin1/Documents/JsonTextDoc.json"), Inventory.class);
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
			e.printStackTrace();
		}
		return s;
	}

	public static <T> T jsonToJava(File file, Class<T> class1) {
		T result = null;
		try {
			result = mapr.readValue(file, class1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

@JsonPropertyOrder(value = { "rice", "pulses", "wheats" })
class Inventory {
	InventoryName Rice[];
	InventoryName Pulses[];
	InventoryName wheats[];

	public InventoryName[] getPulses() {
		return Pulses;
	}

	public void setPulses(InventoryName[] pulses) {
		Pulses = pulses;
	}

	public InventoryName[] getWheats() {
		return wheats;
	}

	public void setWheats(InventoryName[] wheats) {
		this.wheats = wheats;
	}

	public InventoryName[] getRice() {
		return Rice;
	}

	public void setRice(InventoryName[] rice) {
		Rice = rice;
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
