package bridgeLabzDatastructure;

public class AnagramQueue {
public static void main(String[] args) {
	PrimeNumbersAnagram.findAnagram();
	Queue<Integer> q=new Queue<>();
	for(int i:PrimeNumbersAnagram.primeAnagram1D)
	{
		if(i!=0)
		{
			q.enqueue(i);
		}
		
	}
	System.out.println("Anagram prime no in between 0 to 1000 in reverse order are :");
	int l=q.size;
	for(int k=0;k<l;k++)
		System.out.print(q.dequeue()+" ");
}
}
class Queue<T>
{
	Node<T> head;
	int size;
	public void enqueue(T data)
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
	public T dequeue()
	{
		Node<T> n=head;
		head=head.next;
		T temp=n.data;
		n=null;
		size--;
		return temp;
	}
}
