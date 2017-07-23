                                                                                                                              

/**
 *@author Scharab Hessan
 */
public class LinkedListElement {
    private String value;
    private LinkedListElement next;
    private LinkedListElement prev;

    /**
     *Übergibt ein Element mit einem Wert.
     *@param value der übergebene Wert
     */
    public LinkedListElement(String value) {
        this.value = value;
    }


    public void setNext(LinkedListElement el) {
        this.next = el;
    }
    public void setPrev(LinkedListElement el) {
        this.prev = el;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public LinkedListElement getPrev() {
        return prev;
    }
    public LinkedListElement getNext() {
        return next;
    }
    public String getValue() {
        return value;
    }
}
