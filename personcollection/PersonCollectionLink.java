package personcollection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonCollectionLink implements PersonCollectionI{
    // start is a refrerence to a sentinel in the linked list of persons
    private Node start;
    // number of entries in the list;
    private int size;
    private int modification;

    /**
     * Creates an Collection with capacity 16.
     */
    public PersonCollectionLink() {
        start = new Node();
        size = 0;
        modification = 0;
    }



    /**
     * Adds the entry at the end of this list.
     */
    public void add(Person person) {
       Node temp = this.start;
       while (temp.next != null){
           temp = temp.next;
       }
       Node newNode = new Node();
       newNode.person = person;
       temp.next = newNode;
       this.size++;
       modification++;
    }

    /**
     * Adds the person at the index. Throws IndexOutOfBoundsException if index is
     * not in [0, size()].
     */
    public void add(int index, Person person) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node();
        newNode.person = person;
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
        modification++;
    }

    /**
     * Removes and returns the person at the index. Throws IndexOutOfBoundsException
     * if this list is empty or index is not in [0, size()-1].
     */
    public Person remove(int index) {
        if (index < 0 || index > this.size - 1 /* || size == 0 */) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = start;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Person person = temp.next.person;
        temp.next = temp.next.next;
        this.size--;
        modification++;
        return person;
    }

    /**
     * Returns the person at the index. Throws IndexOutOfBoundsException if this
     * list is empty or index is not in [0, size()-1].
     */
    public Person get(int index) {
        if (index < 0 || index > this.size - 1 /* || this.size == 0 */) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = start.next;
        for (int i =0; i < index; i++){
            temp = temp.next;
        }

        return temp.person;
    }

    /**
     * Return true if the entry is in this list.
     */
    public boolean contains(Person person) {
        boolean found = false;
        Node temp = start.next;
        while (!found && temp !=null) {
            if (temp.person.equals(person)) {
                found = true;
            }
            else{
                temp = temp.next;
            }
        }
        return found;
    }

    /**
     * Returns the number of entries in this list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this list is empty.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Removes all entries from this list.
     */
    public void clear() {
        start = new Node();
        this.size = 0;
        modification++;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return ("[]");
        }

        StringBuilder sb = new StringBuilder("[");
        Node temp = start.next;
        while (temp != null) {
            sb.append(", " + temp.person);
            temp = temp.next;
        }
        sb.append("]");
        sb.delete(1, 3);
        return sb.toString();
    }

    private class Node{
        Node next;
        Person person;
    }

    private class PersonLinkIterator implements Iterator<Person> {
        private Node current = start.next;
        private Node previous = null;
        private final int modificationMax = modification;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Person next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(modificationMax != modification)
            {
                throw new ConcurrentModificationException();
            }
            Person person = current.person;
            previous = current;
            current = current.next;
            return person;
        }

        @Override
        public void remove() {

            if(modificationMax != modification)
            {
                throw new ConcurrentModificationException();
            }

            Node temp = start;
            while (temp.next != previous) {
                temp = temp.next;
            }
            temp.next = previous.next;
            previous = null;
            size--;
        }
    }

    public Iterator<Person> iterator() {
        return new PersonLinkIterator();
    }
}


