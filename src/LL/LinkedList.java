package LL;


import  java.util.Scanner;

public class LinkedList 
{

	Scanner user_input = new Scanner(System.in);
	private ListElement myElement = new ListElement();
	private ListElement head;
	private ListElement tail;
	private ListElement current;
	private int n;
	
	/**
	 * constructor
	 * initializes head and tail to null because no elements added yet
	 * length is also zero
	 */
	public LinkedList ()
	{
		head = null;
		tail = head;
		n = 0;
	}
	/**
	 * Adds an element to the end of the linked list
	 * @param le 
	 * The element to add
	 */
	public void addElement (ListElement le)
	{
		ListElement x;
		if (tail == null)
		{
			x = new ListElement();
			x.data = le.data;
		    x.next = null;
		    x.previous = null;
		    head = x;
		    tail = head;
		    
		}
		else
		{
			x = new ListElement();
			x.data = le.data;
		    x.next = null;
		    x.previous = tail;
		    tail.next = x;
		    tail = x;
		}
	    
	     n++;
	}
	
	/**
	 *  Deletes an element specified by its index in the list
	 * @param index
	 * The integer value of the index to delete
	 * @return
	 * returns the element that was deleted
	 */
	public ListElement deleteElement (int index)
	{
		current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		// Delete current
		if (current == head && current == tail)
		{
			current = null;
			head = null;
			tail = head;
			n--;
			return current;
		}
		else if (current == head)
		{
			ListElement next_temp = current.next;
			next_temp.previous = null;
			head.next = null;
			head = next_temp;
			n--;
			return head;
		}
		
		else if (current == tail)
		{
			ListElement prev_temp = tail.previous;
			prev_temp.next = null;
			tail.previous = null;
			tail = prev_temp;
			n--;
			return tail;
		}
		else
		{
			ListElement prev_temp = current.previous;
			ListElement next_temp = current.next;
			prev_temp.next = next_temp;
			current.previous = null;
			current.next = null;
			next_temp.previous = prev_temp;
			n--;
			return current;
		}
		
	}
	/**
	 * Retrieves an element from a specified index in the list
	 * @param index which is an integer value of the index to get
	 * @return returns the list element at the index
	 */
	public ListElement getElement (int index)
	{
		current = head;
		for (int i= 0; i < index; i++)
		{		
			current = current.next;
		}
		
		return current;
	}
	/**
	 * Prints the list starting at the head (index 0) to tail (index n)
	 */
	public void printLinkedListHead ()
	{
		current = head;
		if (n <= 0)
			System.out.println("EMPTY LIST!!");
		for (int i=0; i < n; i++)
		{
			System.out.println("Item #" + i + ": " + (current.data));
			current = current.next;
		}
	}
	/**
	 * 
	 * Prints the list from the tail (index n) to head (index 0)
	 */
	public void printLinkedListTail ()
	{
		current = tail;
		for (int i = (n - 1); i >= 0; i--)
		{
			System.out.println("Item #" + i + ": " + current.data);
			current = current.previous;
		}
	}
	/**
	 * checks to see if the index entered by the user is valid for 
	 * the number of elements currently in the list
	 * @param index
	 * @return true or false
	 */
	public boolean validIndex (int index)
	{
		if (index < 0 || index > n)
			return false;
		else
			return true;
	}
	
	
	public static void main (java.lang.String[] args)
	{
		LinkedList myList = new LinkedList();
		ListElement myElement = new ListElement();

		Scanner user_input = new Scanner(System.in);
		int whatToInsert, indexToGet;
		String input = "a";
		
		while (input != "q")
		{
			System.out.println("Chose what you would like to do: \nAdd a Node (a) "
				+ "\nRetrieve a node (r) "
				+ "\nDelete a Node (d)"
				+ "\n"
				+ "Print list from the Tail (t)"
				+ "\nPrint List from the Head (h)"
				+ "\nQuit program (q)");
			input = user_input.nextLine();
		
			switch (input)
			{
			case "a": {System.out.println("enter a number to insert: ");
				whatToInsert = user_input.nextInt();
			
				myElement.data = whatToInsert;
				myList.addElement (myElement);
				break;}
		
			case "r": {System.out.println("enter an index to retreive the data from: ");
				indexToGet = user_input.nextInt();
				while (!(myList.validIndex(indexToGet)))
				{
					System.out.println("Not a valid index, please enter another: ");
					indexToGet = user_input.nextInt();
				}
				System.out.println("content at that index is: " + (myList.getElement (indexToGet)).data);
				break;}
			
			case "d": {System.out.println("enter an index to delete: ");
				indexToGet = user_input.nextInt();
				while (!(myList.validIndex(indexToGet)))
				{
					System.out.println("Not a valid index, please enter another: ");
					indexToGet = user_input.nextInt();
				}
				myList.deleteElement (indexToGet);
				break;}
				
			case "t": {myList.printLinkedListTail();
				break;}
			
			case "h": {myList.printLinkedListHead();
				break;}
			
			case "q": {input = "q";}
			
			}
		} // end of while
		
		
	} // end of main

}