package learning;

/* Java program to check if linked list is palindrome */

class LinkedList 
{
    Node head;  // head of list
    
 
    /* Linked list Node*/
    class Node 
    {
        char data;
        Node next;
 
        Node(char d) 
        {
            data = d;
            next = null;
        }
    }
 
   public void reverse_linkedlist()
   {
	   Node prev = null;
	   Node next = null;
	   Node curr = head;
	   
	   while(curr!=null)
	   {
		   next = curr.next;
		   curr.next = prev;
		   prev = curr;
		   curr = next;
	   }
	   head = prev;
   }
   
   public void add_element(char c)
   {
	   Node newnode = new Node(c);
	   Node curr = head;
	   if(head!=null)
	   {
		  while(curr.next!=null)
		  {
			  curr=curr.next;
		  }
		  curr.next=newnode;
	   }
	   else
		   head = newnode;
   }
   
   
   public void remove_node(char c)
   {
	   Node curr = head;
	   Node next = head;
	   if(head.data == c)
		   head = head.next;
	   else
	   {
		   while(curr.data!=c)
		   {
			   next = curr;
			   curr = curr.next;
		   }
		   next.next = curr.next;
	   }
	   
   }
   public void print_linkedlist()
   {
	   Node curr = head;
	   while(curr!=null)
	   {
		   System.out.print("->"+curr.data);
		   curr = curr.next;
	   }
		   
	   
   }
   
   public static void main(String[] args)
   {
	   LinkedList ll = new LinkedList();
	   ll.add_element('s');
	   ll.add_element('a');
	   ll.add_element('c');
	   ll.add_element('h');
	   ll.add_element('i');
	   ll.add_element('n');
	   ll.print_linkedlist();
	   ll.reverse_linkedlist();
	   System.out.println("\nReversed LinkedList: ");
	   ll.print_linkedlist();
	   ll.remove_node('h');
	   System.out.println("\nLinkedList after removing h: ");
	   ll.print_linkedlist();
	   ll.remove_node('s');
	   System.out.println("\nLinkedList after removing s: ");
	   ll.print_linkedlist();
	   ll.remove_node('n');
	   System.out.println("\nLinkedList after removing n: ");
	   ll.print_linkedlist();
   }
}


