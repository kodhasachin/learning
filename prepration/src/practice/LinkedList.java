package practice;



class node{
	int val;
	node next;
	public node(int val)
	{
		this.val=val;
		next=null;
	}
}

public class LinkedList {
	
    node head;
   
    public void print_LinkedList()
    {
    	System.out.print("\nLinkedlist is: ");
    	node curr=head;
    	while(curr!=null)
    	{
    		System.out.print(curr.val+" ");
    		curr=curr.next;
    	}
    }
    
    public void add_node(int val)
    {
    	if(head==null)
    	{
    		head=new node(val);
    		head.next=null;
    	}
    	else
    	{
    		node curr = head;
    		while(curr.next!=null)
    			curr=curr.next;
    		node new_node = new node(val);
    		curr.next=new_node;
    	}
    }
    
    public void delete_node(int val)
    {
    	node curr = head;
    	while(curr.next.val!=val)
    		curr=curr.next;
    	node temp = curr.next;
    	curr.next=temp.next;
    }
    
    public void get_kth_node_from_end(int k)
    {
    	int count = 1;
    	node first = head;
    	node second = head;
    	
    	while(count!=k)
    	{
    		first=first.next;
    		count++;
    	}
    	while(first.next!=null)
    	{
    		first=first.next;
    		second = second.next;
    	}
    	
    	System.out.println("kth node from end is: "+second.val);	
    }
    public void reverse_list()
	{
		node dummy = null;
		node temp = null;
		node curr = head;
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
		LinkedList ll = new LinkedList();
		
		ll.add_node(1);
		ll.add_node(2);
		ll.add_node(3);
		ll.add_node(4);
		ll.add_node(5);
		ll.print_LinkedList();
		ll.reverse_list();
		ll.print_LinkedList();
		
		ll.get_kth_node_from_end(2);
		ll.print_LinkedList();
		
		

	}

}
