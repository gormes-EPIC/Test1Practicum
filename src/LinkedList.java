import java.util.*;

public class LinkedList<E>  {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    public void add(E value){
        if(size == 0){
            head = tail = new Node<E>(value, null);
        }else{
            tail.setNext(new Node<E>(value, null));
            tail = tail.getNext();
        }

        size++;
    }

    public void add(E value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }else if (size == 0) {
            head = tail = new Node<E>(value, null);
        }else if (index == size){
            tail.setNext(new Node<E>(value, null));
            tail = tail.getNext();
        }else if (index == 0){
            Node<E> next = head;
            head = new Node<E>(value, next);
        }else{
            Node<E> prev = head;

            for(int i = 0; i < index - 1; i++){
                prev = prev.getNext();
            }

            Node<E> next = prev.getNext();
            prev.setNext(new Node<E>(value, next));
        }

        size++;
    }

    public E get(int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }

        return temp.getValue();
    }

    public E remove(){
        Node<E> temp = head;
        size--;

        for(int i = 0; i < size - 2; i++){
            temp = temp.getNext();
        }

        Node<E> removedNode = temp.getNext();
        temp.setNext(removedNode.getNext());
        tail = temp;

        return removedNode.getValue();
    }

    public E remove(int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> temp = head;
        size--;

        if(index == 0){
            head = head.getNext();
            return temp.getValue();
        }

        for(int i = 0; i < index - 1; i++){
            temp = temp.getNext();
        }
        Node<E> removedNode = temp.getNext();
        temp.setNext(removedNode.getNext());

        if(index == size - 1)
            tail = temp;

        return removedNode.getValue();
    }

    public E set(E element, int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }

        E replaced = temp.getValue();
        temp.setValue(element);

        return replaced;
    }

    public int size(){
        return size;
    }


    public String toString(){
        String result = "[";
        Node<E> temp = head;
        while(temp != null){
            result += "" + temp.getValue();
            temp = temp.getNext();
            if(temp != null)
                result += ", ";
        }
        return result + "]";
    }



}
