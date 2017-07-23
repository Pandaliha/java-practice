

/**
 * @author Scharab Hessan
 */
public class GenericListElement<E> {
    private E value;
    private GenericListElement<E> next;
    private GenericListElement<E> prev;

    public GenericListElement(E value) {
        this.value = value;
    }


    public void setNext(GenericListElement<E> el) {
        this.next = el;
    }
    public void setPrev(GenericListElement<E> el) {
        this.prev = el;
    }

    public GenericListElement<E> getPrev() {
        return prev;
    }
    public GenericListElement<E> getNext() {
        return next;
    }
    public E getValue() {
        return value;
    }
}
