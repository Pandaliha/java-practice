

/**
 * 
 * @author Saliha Hessan
 */
public class GenericList<E> {
    private GenericListElement<E> first;
    private GenericListElement<E> last;
    private int size;

    public void addFirst(E value) {
        GenericListElement<E> el = new GenericListElement<>(value);
        if (size == 0) {
            last = el;
        } 
        else {
            first.setPrev(el);
            el.setNext(first);
        }
        first = el;
        size++;
    }

    public void addLast(E value) {
        GenericListElement<E> el = new GenericListElement<>(value);
        if (size == 0) {
            first = el;
        } 
        else {
            last.setNext(el);
            el.setPrev(last);
        }
        last = el;
        size++;
    }
    public void add(int index, E value) {
        assert index >= 0 : "Index kleiner 0";
        assert index <= size : "Index zu groß";

        if (index == 0) {
            addFirst(value);
        } 
        else if (index == size) {
            addLast(value);
        } 
        else {
            GenericListElement<E> el = new GenericListElement<>(value);
            GenericListElement<E> tmp = goToIndex(index);

            tmp.getPrev().setNext(el);
            el.setPrev(tmp.getPrev());
            el.setNext(tmp);
            tmp.setPrev(el);
            size++;
        }
    }

    public E get(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        GenericListElement<E> tmp = goToIndex(index);

        return tmp.getValue();
    }

    public E removeFirst() {
        assert size > 0 : "Liste ist schon leer!";

        E value = first.getValue();

        if (size > 1) {
            GenericListElement<E> tmp = first.getNext();
            tmp.setPrev(null);
            first = tmp;
        } 
        else {
            first = null;
            last = null;
        }

        size--;

        return value;
    }


    public E removeLast() {
        assert size > 0 : "Liste ist schon leer!";

        E value = last.getValue();

        if (size > 1) {
            GenericListElement<E> tmp = last.getPrev();
            tmp.setNext(null);
            last = tmp;
        } 
        else {
            first = null;
            last = null;
        }
        size--;

        return value;
    }

    public E remove(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        if (index == 0) {
            return removeFirst();
        } 
        else if (index == size - 1) {
            return removeLast();
        } 
        else {
            GenericListElement<E> tmp = goToIndex(index);

            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());

            size--;

            return tmp.getValue();
        }
    }

    public int getSize() {
        return size;
    }

    private GenericListElement<E> goToIndex(int index) {
        GenericListElement<E> tmp = first;
        for (int i = 1; i <= index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void printList() {
        assert size > 0 : "Liste ist leer!";

        GenericListElement<E> tmp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }
}
