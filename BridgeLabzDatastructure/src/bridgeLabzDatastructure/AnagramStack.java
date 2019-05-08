package bridgeLabzDatastructure;

public class AnagramStack {
public static void main(String[] args) {
	PrimeNumbersAnagram.findAnagram();
	StackAnagramPrime<Integer> st=new StackAnagramPrime<>();
	for(int i:PrimeNumbersAnagram.primeAnagram1D)
	{
		if(i!=0)
		{
			st.push(i);
		}
		
	}
	
	System.out.println("Anagram prime no in between 0 to 1000 in reverse order are :");
	int l=st.size;
	for(int k=0;k<l;k++)
		System.out.print(st.pop()+" ");
}
}

class Node<T>
{
	T data;
	Node<T> next;
}
class StackAnagramPrime<T>
{
	Node<T> head;
	int size;
	public void push(T data)
	{
		Node<T> n=new Node<>();
		n.data=data;
		
		if(head==null)
		{
			head=n;
			size++;
		}
		else
		{
			Node<T> n1=head;
			while(n1.next!=null)
			{
				n1=n1.next;
			}
			n1.next=n;
			size++;
		}
	}
	public T pop()
	{
		Node<T> n=head;
		Node<T> pre=n;
		if(n.next==null)
		{
			head=null;
			T temp=n.data;
			n=null;
			size--;
			return temp;
		}
		else
		{
			while(n.next!=null)
			{
				pre=n;
				n=n.next;
			}
			pre.next=null;
			T temp=n.data;
			n=null;
			size--;
			return temp;
		}
		
	}
	public boolean isEmpty()
	{
		return size==0;
	}
}

