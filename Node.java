public class Node<E> {
    public E data;  // Stores the data in obj
    public Node<E> next;  // pointer to next obj

     Node(E data) {
        this.data = data;
        this.next = null;
    }
}
