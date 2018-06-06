

public class DataCollection<T> 
     /*Collection data type to store Coupons */
    {
	    Node currNode; int index=-1;int MAX=100;
	protected void add(T t) 
	{    
		Node newnode=new Node(t);   
	  if(is_full()) 
	  {
		  System.out.println("your list is full!");
	  }
		if(currNode == null) {
			currNode = newnode;
			index++;
		}else {
	     newnode.Setlink(currNode);
	     currNode =newnode;
	     index++;}
		
	    
	}
	protected void remove(int n) 
	{   
		Node temp=currNode; int indexx=index;
		if(n==index) 
		{
			currNode=currNode.Getlink();
			index--;
		}
		else {
			while(indexx-1!=n) {
			temp=temp.Getlink();
			indexx--;
			}
			if(indexx-1==n) 
			{
				temp.Setlink(temp.Getlink().Getlink());
				index--;
			}
		}
	    
	}
	public DataCollection() 
	{
		currNode=null;
		index=-1;
		
	}
	protected Node get(int i) 
	{  
		Node temp=currNode;
		int indexx=index;
		while(temp.Getlink()!=null) 
	  {    
		if(indexx==i) 
		{
			return temp;
		}
		else 
		{   
			temp=temp.Getlink();
			indexx--;
		}
	   }
		
	  return temp;
		
		
	
		
	}
    protected class Node 
    {
    	T info;
    	Node link; 	
    	public Node(T t)
    	{
    		info=t;
    		link=null;
    	}
    	void Setinfo(T t)
    	{
    	  this.info=t;
    	}
    	void Setlink(Node p) 
    	{
    	  if(p!=null) {
    	  this.link=p;}
    	  else 
    	  {
    	   this.link=null;
    	  }
    	}
    	Node Getlink() 
    	{   
			return this.link;
    	}
    	T Getinfo() 
    	{   
    		return this.info;
    	}
    	
    	 
    }
    protected boolean is_full()
    {
    	if(index==MAX) 
    	{
    		return true;
    	}
    	return false;
    }
  
   
}