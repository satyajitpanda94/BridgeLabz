package bridgeLabzDatastructure;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

public class Json {
public static void main(String[] args) {
	Employ em=new Employ();
	em.setName("Umesh");
	em.setId(456);
	em.setPhNum(898459645);
//	Employ em1=new Employ();
//	em1.setName("karthik");
//	em1.setId(458);
//	em1.setPhNum(898459945);
//	Employ em=new Employ();
	String s=JsonClass.convertJavatoJson(em);
	System.out.println(s);
	Employ emp=JsonClass.jsonToJava(s, Employ.class);
	System.out.println(emp.getName()+" "+emp.getId()+" "+emp.getPhNum());
}
}
class Employ implements Serializable
{
	public String name;
	public int id;
	public long phNum;
//	public Employ(String name, int id, long phNum) {
//		super();
//		this.name = name;
//		this.id = id;
//		this.phNum = phNum;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhNum() {
		return phNum;
	}
	public void setPhNum(long phNum) {
		this.phNum = phNum;
	}

	
}
class JsonClass
{
	private static ObjectMapper mapr=new ObjectMapper();
	public static String convertJavatoJson(Object obj)
	{
		String s = null;
		try {
			s = mapr.writeValueAsString(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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