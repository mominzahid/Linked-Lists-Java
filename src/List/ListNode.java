package List;
/**
 * @author mzahid
 *
 * @param <T>
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;
    private ListNode<T> prev;

    public ListNode(T t){
        // fancy way to call a different constructor
        this(t, null, null);
    }

    public ListNode(T t, ListNode<T> prev, ListNode<T> next){
        this.data = t;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public ListNode<T> getPrev() {
        return this.prev;
    }

    public void setData(T t){
        this.data = t;
    }

    public void setNext(ListNode<T> next){
        this.next = next;
    }

    public void setPrev(ListNode<T> prev){
        this.prev = prev;
    }

    public String toString() {
        return "ListNode with data "+this.data.toString()+"";
    }
}
