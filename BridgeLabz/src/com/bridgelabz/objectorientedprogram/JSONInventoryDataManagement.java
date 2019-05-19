package com.bridgelabz.objectorientedprogram;


import java.io.File;

public class JSONInventoryDataManagement {
public static void main(String[] args) {
	InventoryArray invenObj = JsonConversion.jsonToJava(new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/JsonFile.json"), InventoryArray.class);
	System.out.println(JsonConversion.javaToJson(invenObj));
}
}
class InventoryArray {
	Inventory inventory[];

	public Inventory[] getInventory() {
		return inventory;
	}

	public void setInventory(Inventory[] inventory) {
		this.inventory = inventory;
	}
	public void change()
	{
		for(Inventory i:inventory)
		{
			System.out.println(i.getName());
			if(i.getName().equals("Rice"))
			{
				i.setName("xyz");
				break;
			}
		}
	}
	
}
