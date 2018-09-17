package solutions;

public class LinkedList {
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int val)
		{
			data=val;
			next = null;
		}
	}
	
	public void add_node(int val)
	{
		Node newnode = new Node(val);
		
		if(head==null)
			head = newnode;
		else
		{
			Node first = head;
			while(first.next!=null)
				first=first.next;
			first.next=newnode;
		}
		
	}
	
	public void remove_nth_node_from_end(int n)
	{
		Node first=head, second=head;
		for(int i=0; i<=n; i++)
		{
			first = first.next;
		}
		while(first!=null)
		{
			second=second.next;
			first=first.next;
		}
		second.next=second.next.next;
	}
	
	public void print_linkedlist()
	{
		if(head==null)
			System.out.println("Linked List is empty");
		else
		{
			
			Node curr = head;
			while(curr!=null)
			{
				System.out.print(curr.data+"->");
				curr=curr.next;
			}
			
			
		}
	}
	
	public void reverse_list()
	{
		Node dummy = null;
		Node temp = null;
		Node curr = head;
		while(curr.next!=null)
		{
			temp = curr.next;
			curr.next=dummy;
			dummy=curr;
			curr=temp;
		}
		curr.next=dummy;
		head=curr;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add_node(1);
		list.add_node(2);
		list.add_node(3);
		list.add_node(4);
		list.add_node(5);
		System.out.print("Input Linked List is: ");
		list.print_linkedlist();
//		list.remove_nth_node_from_end(3);
//		System.out.print("\nOutput Linked List is: ");
//		list.print_linkedlist(list.head);
		System.out.print("\nReversed Linked List is: ");
		list.print_linkedlist();

	}

}
