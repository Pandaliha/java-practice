

/**
 * @author Saliha Hessan
 */
public class LinkedList {
    private LinkedListElement first;
    private LinkedListElement last;
    private int size;

    public LinkedList() {
    }


    public void addFirst(String value) {
        LinkedListElement el = new LinkedListElement(value);
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


    public void addLast(String value) {
        LinkedListElement el = new LinkedListElement(value);
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

    public void add(int index, String value) {
        assert index >= 0 : "Index kleiner 0";
        assert index <= size : "Index zu groß";

        if (index == 0) {
            addFirst(value);
        } 
        else if (index == size) {
            addLast(value);
        } 
        else {
            LinkedListElement el = new LinkedListElement(value);
            LinkedListElement tmp = goToIndex(index);

            tmp.getPrev().setNext(el);
            el.setPrev(tmp.getPrev());
            el.setNext(tmp);
            tmp.setPrev(el);
            size++;
        }
    }


    public String get(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        LinkedListElement tmp = goToIndex(index);

        return tmp.getValue();
    }


    public String removeFirst() {
        assert size > 0 : "Liste ist schon leer!";

        String value = first.getValue();

        if (size > 1) {
            LinkedListElement tmp = first.getNext();

            first.setNext(null);
            first = tmp;
        } 
        else {
            first = null;
            last = null;
        }
        size--;
        return value;
    }


    public String removeLast() {
        assert size > 0 : "Liste ist schon leer!";
        String value = last.getValue();

        if (size > 1) {
            LinkedListElement tmp = last.getPrev();
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

    public String remove(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        if (index == 0) {
            return removeFirst();
        } 
        else if (index == size - 1) {
            return removeLast();
        } 
        else {
            LinkedListElement tmp = goToIndex(index);
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            size--;
            return tmp.getValue();
        }
    }

    public int getSize() {
        return size;
    }

    private LinkedListElement goToIndex(int index) {
        LinkedListElement tmp = first;
        for (int i = 1; i <= index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void printList() {
        assert size > 0 : "Liste ist leer!";

        LinkedListElement tmp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }
}
