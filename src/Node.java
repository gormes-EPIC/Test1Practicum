
public class Node<E> {

    private Node<E> next;
    private E value;

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

    public E getValue(){
        return value;
    }

    public void setValue(E value){
        this.value = value;
    }

    public String toString(){
        return "" + value;
    }
}
