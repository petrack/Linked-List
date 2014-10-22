package LL;

public class ListElement 
{
	protected ListElement next;
	protected ListElement previous;

	protected int data;

	public ListElement()
	{
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	public ListElement getNext ()
	{
		return next;
	}
	
	public ListElement getPrevious ()
	{
		return previous;
	}
	
	public int getData ()
	{
		return data;
	}
	

}