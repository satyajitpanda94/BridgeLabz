package bridgeLabzDatastructure;

public class CalendarStack {
public static void main(String[] args) {
	int month=Integer.parseInt(args[0]);
	int year=Integer.parseInt(args[1]);
	WeekStack<Integer,Integer> s=new WeekStack<>();
	printCalendar(month,year,s);
}

private static void printCalendar(int month, int year, WeekStack<Integer, Integer> s) {
	creatCalendar(month,year,s);
	WeekStack<Integer, Integer> s1=new WeekStack<>();
	for(int j=1;j<=Calendar.noOfDaysOfMonths[month-1];j++)
	{
		int date=s.pop();
		s1.push(s.day,date);
	}
	
	System.out.println(Calendar.months[month-1]+", "+year);
    System.out.println("sun\tmon\ttue\twed\tthr\tfri\tsat");
    int dayOfWeek=Calendar.findFirstDay(1,month,year);
    int i=0,k=0;
	for(int j=1;j<=Calendar.noOfDaysOfMonths[month-1]+dayOfWeek;j++)
	{
		if(i<dayOfWeek)
		{
			System.out.print(" \t");
			i++;
		}
		else
			System.out.print(s1.pop()+"\t");
		k++;
		if(k>6)
	    {
			System.out.println();
			k=0;
		}
	}
	
}

private static void creatCalendar(int month, int year, WeekStack<Integer, Integer> s) {
	if(Calendar.isLeapYear(year))
    {
    	Calendar.noOfDaysOfMonths[1]=29;
    }
    int dayOfWeek=Calendar.findFirstDay(1,month,year);
	for(int j=1;j<=Calendar.noOfDaysOfMonths[month-1];j++)
	{
		s.push(dayOfWeek,j);
		dayOfWeek++;
		if(dayOfWeek>6)
		     dayOfWeek=0;
	}
	
}
}
class WeekStack<D,DT>
{
	WeekDay<D,DT> head;
	D day;
	private int size;
	public void push(D day,DT date)
	{
		WeekDay<D,DT> n=new WeekDay<>();
		n.day=day;
		n.date=date;
		
		if(head==null)
		{
			head=n;
			size++;
		}
		else
		{
			WeekDay<D,DT> n1=head;
			while(n1.Next!=null)
			{
				n1=n1.Next;
			}
			n1.Next=n;
			size++;
		}
	}
	public DT pop()
	{
		WeekDay<D,DT> n=head;
		WeekDay<D,DT> pre=n;
		if(n.Next==null)
		{
			head=null;
			DT temp=n.date;
			day=n.day;
			n=null;
			size--;
			return temp;
		}
		else
		{
			while(n.Next!=null)
			{
				pre=n;
				n=n.Next;
			}
			pre.Next=null;
			DT temp=n.date;
			day=n.day;
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
