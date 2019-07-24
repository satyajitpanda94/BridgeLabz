package exceptionhandeling;

public class Xyz {
public static void main(String[] args) throws XyzException {
	int x=5;
	
	try {
		if(x<50)
			throw new XyzException("XyzException due to less than 50.");
		System.out.println(x);
		}
	catch(XyzException e){
		e.getMessage();
	}
}
}
