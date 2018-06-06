
public class BST<T> {
	  /*Binary Search Tree data type to store index of coupons */
	 int index;
    protected class Node
    {
       Node left;
       Node right;
       T info;
       int start;
       int end;
       
       public Node(T t) 
       {
    	 left=null;
    	 right=null;
    	 info=t;
       }
       protected void setleft(Node node) 
       {
    	   this.left=node;
       }
       protected void setright(Node node) 
       {
    	   this.right=node;   
       }
       protected T getleft() 
       {
    	   return this.left.info;
       }
       protected T getright() 
       {
    	   return this.right.info;
       }
       protected void setinfo(T t) 
       {
    	   this.info=t;
       }
    }
    public BST() 
    {
    	 index=-1;
    }
  
   
}
