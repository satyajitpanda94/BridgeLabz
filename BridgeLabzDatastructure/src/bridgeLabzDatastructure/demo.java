package bridgeLabzDatastructure;
/**
 * 
 * @author admin1
 *
 */
public class demo {
public static void main(String[] args) {
	int a[]= {24,45,7,36,41,95,420,751};
	int max1=a[0],max2=a[1];
	if(a[0]<a[1])
	{
		max1=a[1];
		max2=a[0];
	}
	for(int i=2;i<a.length;i++)
	{
		if(a[i]>max1)
		{
			int temp=max1;
			max1=a[i];
			max2=temp;
		}
		else if(a[i]>max2)
		{
			max2=a[i];
		}
		else
			continue;
	}
	System.out.println(max1);
	System.out.println(max2);
}
}