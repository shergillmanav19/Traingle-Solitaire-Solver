// see Stack Interface for documentation
// complete the given stubs
public class StackRefBased<T extends Object> implements Stack<T> {
    private StackNode<T> top;
    private int count;
    public StackRefBased() {
        this.top = null;
        this.count = 0;
    }

    public int size() {

        
        return count;
    }


    public boolean isEmpty() {
       if(count==0)
        return true;
        else
        return false;
    }


    public void push(T data) {
        StackNode<T> n = new StackNode(data);
        if(top!=null)
        {
            n.setNext(top);
        }
        top = n;
        count++;
        
    }


    public T pop() throws StackEmptyException {
        StackNode<T> tmp = top;
        if(top==null){
            StackEmptyException e = new StackEmptyException("Error in Pop");
            throw e;
        }
        if(top!=null){
            top = top.getNext();
        }
        count--;
        return tmp.getValue();
        
    }


    public T peek() throws StackEmptyException {
        if(count==0){
            StackEmptyException e = new StackEmptyException("Error in Peek");
            throw e;
        }
        
        return top.getValue();
    }


    public void makeEmpty() {
        top=null;
        count = 0;
    }
    
    /*
     * Purpose: creates and returns a String representation of this Stack
     *  from bottom to top
     * Parameters: none
     * Returns: String - the representation
     */
    
    public String toString() {
        String result = "";
        
        StackNode<T> tmp = top;
        while(tmp != null) {
            result = tmp.getValue() + result;
            tmp = tmp.getNext();
        }
        
        return result;
    }
    /*
     * Purpose: overrides Object's equals method
     *  determines whether this StackRefBased has the same
     *  elements as other StackRefBased, in the same order
     * Parameters: Object other - the other StackRefBased
     * Precondition: assumes other is an instance of StackRefBased<T>
     * Returns: boolean - true if the are equal, false otherwise
     */
    public boolean equals(Object other) {
        // this line will cause a warning when you compile
        // you can ignore this warning
        StackRefBased<T> otherStack = (StackRefBased<T>)other;
        
        StackNode<T> thisTmp = top;
        StackNode<T> otherTmp = otherStack.top;

        while(thisTmp!=null && otherTmp!=null){
            T thisVal = thisTmp.getValue();
            T otherVal = otherTmp.getValue();
            if (!thisVal.equals(otherVal)){
                return false;
            }
            thisTmp = thisTmp.getNext();
            otherTmp = otherTmp.getNext();
        }
            
        if (thisTmp!=null || otherTmp!=null)
            return false;
        else
            return true;
    }
}
