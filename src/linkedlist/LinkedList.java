package linkedlist;

import List.List;
import List.ListNode;

public class LinkedList<T> implements List<T>
{
    ListNode<T> head = null;
    ListNode<T> tail = null;

    /* (non-Javadoc)
     * @see linkedlist.List#size()
     */
    @Override
    public int size() {
        ListNode<T> curr = head;
        int counter = 0;
        while (curr != null) {
            counter += 1;
            curr = curr.getNext();
        }
        return counter;
    }

    /* (non-Javadoc)
     * @see linkedlist.List#get(int)
     */
    @Override
    public T get(int index) {
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }

    /* (non-Javadoc)
     * @see linkedlist.List#set(int, java.lang.Object)
     */
    @Override
    public void set(int index, T item) {
        if (index > size() || index < 0) {
            return;
        }
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        curr.setData(item);
    }
    /* (non-Javadoc)
     * @see linkedlist.List#add(java.lang.Object)
     */
    @Override
    public void add(T item) {

        if (head == null) {
            ListNode<T> myListNode = new ListNode<T>(item);
            head = myListNode;
            tail = head;
        }
        else {
            ListNode<T> myListNode = new ListNode<T>(item, tail, null);
            tail.setNext(myListNode);
            tail = myListNode;

        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     * Return a String representation of the list that consists of each element
     * of the list inside square brackets, separated by spaces.
     * For example: [ 1 2 3 ]
     *
     */
    @Override
    public String toString() {
        String s = "";
        ListNode<T> curr = head;
        int iter = 0;
        while (curr != null) {
            s += curr.getData().toString() + " ";

            curr = curr.getNext();
            iter += 1;
        }
        String f = "[ " + s + "]";
        return f;
    }

    /* (non-Javadoc)
     * @see linkedlist.List#insert(int, java.lang.Object)
     */
    @Override
    public void insert(int index, T item) {
        ListNode<T> curr = head;
        ListNode<T> temp = null;
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size()) {
            curr = tail;
            ListNode<T> ListNode = new ListNode<T> (item, tail, null);
            tail.setNext(ListNode);
            tail = ListNode;
            return;
        }
        else {
            int iter = 0;
            while (iter < index-1) {
                curr = curr.getNext();
                iter++;
            }
            ListNode<T> ListNode = new ListNode<T>(item, curr, curr.getNext());
            curr.getNext().setPrev(ListNode);
            curr.setNext(ListNode);
        }


    }

    /* (non-Javadoc)
     * @see linkedlist.List#insertFirst(java.lang.Object)
     */
    @Override
    public void insertFirst(T item) {
        ListNode<T> ListNode = new ListNode<T>(item);
        if (size()>0) {
            ListNode.setNext(head);
            ListNode.setPrev(null);
            ListNode.getNext().setPrev(ListNode);
        }
        if (size() == 0) {
            tail = ListNode;
        }
        head = ListNode;


    }

    /* (non-Javadoc)
     * @see linkedlist.List#remove(int)
     */
    @Override
    public T remove(int index) {
        ListNode<T> curr = head;
        ListNode<T> temp = null;
        if (index > size()-1) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size()-1) {
            curr = tail;
            curr.getPrev().setNext(null);
            tail = curr.getPrev();
            return curr.getData();
        }

        int iter = 0;
        while (iter < index-1) {
            curr = curr.getNext();
            iter++;
        }

        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());
        return curr.getData();
    }

    /* (non-Javadoc)
     * @see linkedlist.List#removeFirst()
     */
    @Override
    public T removeFirst() {
        ListNode<T> curr = head;

        curr.getNext().setPrev(null);
        head = curr.getNext();
        return curr.getData();
    }

    /* (non-Javadoc)
     * @see linkedlist.List#subList(int, int)
     */
    @Override
    public List<T> subList(int start, int end) {
        LinkedList<T> list = new LinkedList<T>();
        if (start == end || start > size() || end > size()) {
            return list;
        }

        ListNode<T> curr = head;

        int iter = 0;
        while (iter < start) {
            curr = curr.getNext();
            iter++;
        }
        for( int i = 0; i < end-start; i++) {
            //    	   System.out.println(i);
            //    	   System.out.println(list.toString());
            list.insert(i, curr.getData());
            curr = curr.getNext();
        }
        return list;


    }

    /* (non-Javadoc)
     * @see linkedlist.List#subList(int)
     */
    @Override
    public List<T> subList(int index) {
        List<T> list = new LinkedList<T>();

        if (index >= size()) {
            return list;
        }
        int end = size();
        list = subList(index,end);
        return list;
    }

    /* (non-Javadoc)
     * @see linkedlist.List#add(linkedlist.List)
     */
    @Override
    public void add(List<T> other) {


        for (int i = 0; i < other.size(); i++) {
            insert(size(), other.get(i));

        }
    }

    /* (non-Javadoc)
     * @see linkedlist.List#contains(java.lang.Object)
     */
    @Override
    public boolean contains(T item) {
        ListNode<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(item)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

}
