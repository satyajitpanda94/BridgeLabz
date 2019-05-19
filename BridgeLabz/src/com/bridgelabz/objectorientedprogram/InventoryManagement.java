package com.bridgelabz.objectorientedprogram;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class InventoryManagement {
	Inventory invtry[];
	
public Inventory[] getInvtry() {
		return invtry;
	}

	public void setInvtry(Inventory[] invtry) {
		this.invtry = invtry;
	}

public static void main(String[] args) {
	
	File file=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/JsonFile.json");
	ObjectMapper mapr=new ObjectMapper();
	try {
		JsonNode rootNode = mapr.readTree(file);
			JsonNode inventory=rootNode.get("inventory");
			Inventory inventoryArray[]=new Inventory[inventory.size()];
			int index=0;
//			Iterator<JsonNode> iterator = marksNode.elements();
			for(JsonNode node:inventory)
			{
				Inventory invtryObj=new Inventory();
				invtryObj.setName(node.path("name").asText());
				invtryObj.setPricePerKg(node.path("pricePerKg").asDouble());
				invtryObj.setWeight(node.path("weight").asDouble());
				inventoryArray[index]=invtryObj;
				index++;
				
			}
			InventoryManagement im=new InventoryManagement();
			im.setInvtry(inventoryArray);
			System.out.println(JsonConversion.javaToJson(im));
			
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
