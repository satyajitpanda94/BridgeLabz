package bridgelabz;

public class HashMap {
	public static void main(String[] args) {
		HashMaping<Integer> hm=new HashMaping<>();
		hm.put(77);
		hm.put(44);
		hm.put(25);
		hm.put(66);
		hm.put(32);
		hm.put(70);
		hm.put(6);
		hm.put(45);
		hm.put(36);
		hm.put(21);
		hm.put(88);
		hm.put(37);
		hm.put(90);
		hm.put(5);
		   
		System.out.println(hm);
		if(hm.search(66))
			hm.remove(66);
		else
			hm.put(66);
		System.out.println(hm);
	}
}

class NodeHashing<T>
{
	T data;
	NodeHashing<T> next;
}
class HashMap<T extends Comparable<T>>
{
	@SuppressWarnings({ "unchecked" })
	private NodeHashing<T>[] slot=new NodeHashing[11];
//	NodeHashing<T> head;
	public int size;
	public void put(T data)
	{
		int index=data.hashCode()%11;
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
			while(n1.next!=null)
			{
				if(n1.data.compareTo(data)<0)
					break;
				pre=n1;
				n1=n1.next;
			}
			if(pre==slot[index] && pre.next==null && n1.data.compareTo(data)<0)
			{
				NodeHashing<T> temp=slot[index];
				slot[index]=n;
				n.next=temp;
				size++;
			}
			else if(n1!=slot[index] && n1.data.compareTo(data)<0)
			{
				pre.next=n;
				n.next=n1;
				size++;
			}
			else {
				n1.next=n;
				size++;
			}
		}
		
	}
	public boolean search(T data)
	{
		int index=data.hashCode()%11;
		NodeHashing<T> n=slot[index];
		while(n.next!=null)
		{
			if(n.data.compareTo(data)==0)
				return true;
			n=n.next;
		}
		if(n.data.compareTo(data)==0)
			return true;
		else if(n.next)
		else
			return false;
	}
	public void remove(T data)
	{
		int index=data.hashCode()%11;
		NodeHashing<T> n=slot[index];
		NodeHashing<T> pre=slot[index];
		while(n.next!=null)
		{
			if(n.data.compareTo(data)==0)
				break;
			pre=n;
			n=n.next;
			
		}
		if(n==slot[index])
		{
			slot[index]=slot[index].next;
		}
		else
		{
			pre.next=n.next;
			n=null;
		}
	}

	public String print()
	{
		String s="* ";
		for(int i=0;i<11;i++)
		{
			s=s+i+" : ";
			NodeHashing<T> n=slot[i];
			while(n.next!=null)
			{
				s=s+n.data+" ";
			}
			s=s+n.data+"\n";
		}
		return s;
	}
}