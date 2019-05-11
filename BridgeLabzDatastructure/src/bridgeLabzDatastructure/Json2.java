package bridgeLabzDatastructure;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class Json2 {
	public static void main(String[] args) {
		InventoryName basmati=new InventoryName();
		basmati.setName("Basmati");
		basmati.setWeight(35);
		basmati.setPricePerKg(120);
		InventoryName brownRice=new InventoryName();
		brownRice.setName("Brown Rice");
		brownRice.setWeight(26);
		brownRice.setPricePerKg(210);
		InventoryName normalRice=new InventoryName();
		normalRice.setName("Normal Rice");
		normalRice.setWeight(21);
		normalRice.setPricePerKg(40);
		InventoryName rice[]= {basmati,brownRice,normalRice};
		Inventory inv=new Inventory();
		inv.setRice(rice);
		String jsonText=JsonUnit.javaToJson(inv);
		System.out.println(jsonText+"\n");
		Inventory inv1=JsonUnit.jsonToJava(jsonText, Inventory.class);
		for(InventoryName i:inv1.getRice())
		{
			System.out.println(i.getName()+" "+i.getPricePerKg()+" "+i.getWeight());
		}
		System.out.println(inv1.getRice()[0].getName()+" "+inv1.getRice()[0].getWeight()+" "+inv1.getRice()[0].getPricePerKg());
		
	}
}
	class JsonUnit
	{
		private static ObjectMapper mapr=new ObjectMapper();
		public static String javaToJson(Object obj)
		{
			String s="";
			try {
				s=mapr.writeValueAsString(obj);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}
		public static <T> T jsonToJava(String jsonText,Class<T> cls)
		{
			T result=null;
			try {
				result=mapr.readValue(jsonText, cls);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}
	class Inventory
	{
		InventoryName Rice[];

		public InventoryName[] getRice() {
			return Rice;
		}

		public void setRice(InventoryName[] rice) {
			Rice = rice;
		}
		
//		public Inventory(ArrayList<InventoryName> rice, ArrayList<InventoryName> pulses, ArrayList<InventoryName> wheats) {
//			super();
//			Rice = rice;
//			Pulses = pulses;
//			Wheats = wheats;
//		}


		
	}

	class InventoryName 
	{
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
	}	
		
