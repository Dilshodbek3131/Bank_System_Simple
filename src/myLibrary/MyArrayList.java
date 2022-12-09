package myLibrary;

public class MyArrayList {

    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element) {
        if (size >= elements.length) {
            Object[] temp = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[size++] = element;
    }

    public boolean add(int index, Object value) {
        if (index < 0 || index > size) {
            System.out.println("Error: Index Out Of Bound");
            return false;
        }
        if (size >= elements.length) {
            size++;
            Object[] temp = new Object[elements.length * 2];
            for (int i = 0, j = 0; i < size; i++) {
                if (i == index) temp[index] = value;
                else temp[i] = elements[j++];
            }
            elements = temp;
        } else {
            for (int i = size; i > index ; i--) {
                elements[i] = elements[i-1];
            }
            elements[index] = value;
            size++;
        }
        return true;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bound!");
            return null;
        }
        return elements[index];
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i].toString());
            sb.append(", ");
        }

        sb.append(elements[size-1].toString());
        sb.append(']');

        return sb.toString();
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return true;
        }
        return false;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
        }
        return -1;
    }

    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j+1];
                }
                size--;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Error: Index out of bound!");
            return false;
        }
        for (int j = index; j < size - 1; j++) {
            elements[j] = elements[j+1];
        }
        size--;
        return true;
    }
}
