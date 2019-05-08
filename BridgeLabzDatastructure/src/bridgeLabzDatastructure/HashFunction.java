package bridgeLabzDatastructure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HashFunction {
public static void main(String[] args) throws IOException {
	File f=new File("/home/admin1/Documents/HashFunctionInput");
	Scanner sc=new Scanner(f);
	String s[]=sc.nextLine().split(",");
	HashMap<Integer> hm=new HashMap<>();
	for(String st:s)
	{
		hm.put(Integer.parseInt(st));
	}
	Scanner sca=new Scanner(System.in);
	System.out.println("Enter Number :");
	int num=sca.nextInt();
	if(hm.search(num))
		hm.remove(num);
	else
		hm.put(num);
	System.out.println(hm);
	FileWriter fw=new FileWriter("/home/admin1/Documents/HashFunctionOutput");
	fw.write(hm.toString());
	fw.flush();
	fw.close();
	sc.close();
	sca.close();
}
}
class NodeHashing<T>
{
	T data;
	NodeHashing<T> next;
}
class HashMap<T extends Comparable<T>>
{

	@SuppressWarnings("unchecked")
	private NodeHashing<T>[] slot=new NodeHashing[11];
	public int size;
	
	public int hashFunction(T data)
	{
		return data.hashCode()%11;
	}
	
	public void put(T data)
	{
		int index=hashFunction(data);
		NodeHashing<T> n=new NodeHashing<>();
		
		n.data=data;
		if(slot[index]==null)
		{
			slot[index]=n;
			size++;
		}
		else
		{
			NodeHashing<T> n1=slot[index];
			NodeHashing<T> pre=n1;
			while(n1!=null)
			{
				if(n1.data.compareTo(data)<0)
					break;
				pre=n1;
				n1=n1.next;
			}
			if(n1==slot[index])
			{
				slot[index]=n;
				n.next=pre;
				size++;
			}
			
			else {
				pre.next=n;
				n.next=n1;
				size++;
			}
		}
		
	}
	public boolean search(T data)
	{
		int index=hashFunction(data);
		NodeHashing<T> n=slot[index];
		if(n==null)
			return false;
		while(n!=null)
		{
			if(n.data.compareTo(data)==0)
				return true;
			n=n.next;
		}
			return false;
	}
	public void remove(T data)
	{
		int index=data.hashCode()%11;
		NodeHashing<T> n=slot[index];
		NodeHashing<T> pre=n;
		while(n!=null)
		{
			if(n.data.compareTo(data)==0)
				break;
			pre=n;
			n=n.next;
			
		}
		if(n==slot[index])
		{
			slot[index]=slot[index].next;
			n=null;
			size--;
		}
		else
		{
			pre.next=n.next;
			n=null;
			size--;
		}
	}

	public String toString()
	{
		String s="";
		for(int i=0;i<11;i++)
		{
			s=s+i+" : ";
			NodeHashing<T> n=slot[i];
			if(n==null)
			{
				s=s+"none";
			}
			while(n!=null)
			{
				s=s+n.data+" ";
				n=n.next;
			}
			s=s+"\n";
		}
		return s;
	}
}