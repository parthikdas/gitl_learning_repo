package DataStructures;


public class MyLinkedList<E> {
	
	/* Here are the details of functions which is available in MyLinkedList class
	 * 1.add(data)  - Adding a new data at defined position.
	 * 2.update(data,position)  -  If you want to add in between the list.
	 * 3.get(position)  -  get the value which is at that index.
	 * 4.set(data,position)  -  for updating the data in list in specified position.
	 * 5.remove(position)  -  for updating the data in list in specified position.
	 * 6.print()  -  Printing the list.
	 * 7.isEmpty()  -  checking for empty list.
	 * 8.size()  -  for getting the size of the list.
	 * 9.clear()  -  clears the whole list
	 * 10.contains(data)  -  checks whether that data is present in the list or not.
	 * 11.reverse()  -  reverses the list.
	 * 12.indexOf(data)  -  returns the index of the element in the list.
	 */
	
		
	Node<E> head;
	void add(E data)  //Adding a new data at defined position//
	{
		Node<E> toAdd =new Node<E>(data);
		if(isEmpty())  //checking if it is empty//
		{
			head=toAdd;
			return;
		}
		Node<E> temp=head;  //traversing in the list//
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=toAdd;
	}
	
	void add(E data,int position)  //if you want to add in between the list//
	{
		Node<E> toAdd =new Node<E>(data);
		
		if(isEmpty())
		{
			head=toAdd;
			return;
		}
		
		if(position==0)  //if it is to be inserted at first//
		{
			toAdd.next=head;
			head=toAdd;
			return;
		}
		
		
		Node<E> temp=head;  //if it is to be inserted anywhere middle //
		int c=0;
		while(temp!=null) {if(c+1==position) {break;}temp=temp.next;c++;}
		Node<E> temp1=temp.next;
		temp.next=toAdd;
		toAdd.next=temp1;
		
		
	}
	
	int indexOf(E data)  //returns the index of the element in the list//
	{
		if(isEmpty())
		{
			return -1;
		}
		Node<E> temp = head;int c=0;
		while(temp!=null)
		{
			if(temp.data==data) {return c;} c++; temp=temp.next;
		}
		return -1;
	}
	
	
	E get(int position)  //get the value which is at that index//
	{
		if(isEmpty()||position < 0)
		{
			return null;
		}
		
		Node<E> temp=head;int c=0;
		while(temp!=null) {if(c==position) {break;}temp=temp.next;c++;}
		
		return temp.data;
	}
	
	void set(E data,int position)  //for updating the data in list in specified position//
	{
		if(isEmpty()||position < 0)
		{
			return;
		}
		
		Node<E> temp=head;int c=0;
		while(temp!=null) {if(c==position) {break;}temp=temp.next;c++;}
		temp.data=data;
	}
	
	void remove(int position)  //removed the value in specified position//
	{
		if(isEmpty()||position < 0)
		{
			return;
		}
		
		Node<E> temp=head;
		if(position == 0)  //this is a edge case as here the head is to be changed//
			{
			head=temp.next;
			return;
			}
		int c=0;	
		while(temp!=null) {if(c+1==position) {break;}temp=temp.next;c++;}
		Node<E> temp1=temp.next.next;
		temp.next=temp1;
		
	}
	
	void print() {  //Printing the list//
		if(isEmpty())
		{
			return;
		}
		
		Node<E> temp=head;
		while(temp!=null) {System.out.println(temp.data+" ");
		temp = temp.next;
		}
	}
	boolean isEmpty()  //checking for empty list//
	{
		return head==null;
	}
	
	int size()  //for getting the size of the list//
	{
		if(isEmpty())
		{
			return -1;
		}
		int c=0;Node<E> temp=head;
		while(temp!=null) {temp=temp.next;c++;}
		return c;
	}
	
	void clear()  //clears the whole list//
	{
		 head=null;
	}
	
	boolean contains(E data)  //checks whether that data is present in the list or not//
	{
		if(isEmpty())
		{
			return false;
		}
		Node<E> temp=head;
		while(temp!=null) {if(temp.data==data) {return true;} temp=temp.next;}
		return false;
	}

	void reverse()   //reverses the list//
	{
		Node<E> prev = null; 
        Node<E> current = head; 
        Node<E> next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
	}
	
	
	static class Node<E>
	{
		E data;
		Node<E> next;
		public Node(E data)
		{
			this.data=data;
			next=null;
		}
	}
}

