public class LLStack<E> {
    private Node<E> Top;

/*    public LLStack() {
        this.Top = null;
    }*/

    // check if stack isEmpty
    public boolean isEmpty(){
        return Top == null;
    }

    // push an item into stack
    public void push(E data) {
        if(isEmpty()){
            Top = new Node<>(data);
        }
        else{
            Node<E> temp = new Node<>(data);
            temp.next = Top;
            Top = temp;
        }
    }

    // method to pop item from stack
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        E data = Top.data;
        Top = Top.next;
        return data;
    }

    // method to peek at current data (TOP) in stack
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return Top.data;
    }

}
