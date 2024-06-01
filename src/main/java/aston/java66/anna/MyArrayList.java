package aston.java66.anna;


import java.util.*;

/**
 * Implementation of a dynamic array that expands as elements are added to it.
 * This implementation supports all basic operations on lists, such as adding, deleting,
 * getting elements by index and others.
 * This class is not thread safe.
 * The implementation uses an array as internal element storage. Upon reaching
 * maximum array size, it automatically grows to accommodate new elements.
 *
 * @param <N> type of elements stored in the list
 * @author Anna Astaptsova
 * @version 1.0
 */

public class MyArrayList<N> implements List<N> {

    /**
     * Default initial capacity.
     */
    private static final int INITIAL_CAPACITY = 20;

    /**
     * Empty array instance used for default sized empty instances.
     */
    private static final Object[] EMPTY_ARRAY = {};

    /**
     * An array that stores the elements of the ArrayList. The capacity of an ArrayList is the length of that array.
     */
    private transient Object[] internalArray;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with an initial capacity of twenty.
     */
    public MyArrayList() {
        this.internalArray = EMPTY_ARRAY;
    }

    /**
     * This method is responsible for increasing the size of the internalArray, which is used to store
     * the elements in MyArrayList.
     * Ensures that the internal array's size is dynamically increased so that it can accommodate more elements
     * when needed.
     * @param minCapacity the desired minimum capacity
     */
    private Object[] grow(int minCapacity) {
        if (internalArray == EMPTY_ARRAY) {
            if (minCapacity > INITIAL_CAPACITY) {
                internalArray = new Object[minCapacity + 10];
            } else internalArray = new Object[INITIAL_CAPACITY];
        } else {
            int newCapacity = minCapacity + 10;
            Object[] newArray = new Object[newCapacity];
            for (int i=0; i<size-1; i++){
                newArray[i]=internalArray[i];
            }
            internalArray = newArray;
        }
        return internalArray;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * This method inserts an element at the specified position in the ArrayList, shifting all subsequent elements to the right.
     * First it checks whether the index is within the valid range.
     * If the ArrayList's current capacity is equal to its size, it calls the rowCapacity() function
     * to increase the capacity.
     * It then shifts all elements starting at index one position to the right and assigns an index
     * to the new element and increases its size by 1.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, N element) {
        if (index > size) throw new IndexOutOfBoundsException("Index should be =<" + size);
        final int l = size;
        Object[] internalArray = this.internalArray;
        if (l == internalArray.length)
            internalArray = grow(size + 1);
        for (int i = l + 1; i >= index; i--) {
            internalArray[i + 1] = internalArray[i];
        }
        internalArray[index] = element;
        size = l + 1;
    }

    /**
     * This method is called when an element needs to be added without specifying an index.
     * @param n element to be appended to this list
     */
    public boolean add(N n) {
        if (size == internalArray.length)
            internalArray = grow(size + 1);
        internalArray[size] = n;
        size++;
        return true;
    }

    /**
     * This method adds all elements from the passed array c to the end of the MyArrayList.
     * It checks if there is enough space in the internalArray array to add all the new elements.
     * If not, it calls grow to increase the capacity.
     * After that, it copies the elements from array arrayToAdd to array internalArray and updates the size of MyArrayList.
     */
     public boolean addArray(N[] arrayToAdd) {
        int sizeOfArray = arrayToAdd.length;
        if (sizeOfArray == 0)
            return false;
        Object[] internalArray;
        final int s = size;
        internalArray = grow(s + sizeOfArray);
        for (int i = 0; i < sizeOfArray; i++) {
            internalArray[i + size] = arrayToAdd[i];
        }
        size = s + sizeOfArray;
        return true;
    }

    /**
     * This method checks if the list is empty. If so, it throws an IndexOutOfBoundsException.
     * If the index is in the valid range, then the method returns the element from the internalArray at that index.
     * @param index   index of the element to replace
     */
    public N get(int index) {
        if (size == 0)
            throw new IndexOutOfBoundsException("List is empty");
        if ((index < 0) | (index > size - 1))
            throw new IndexOutOfBoundsException("Index should be >0 and <" + (size - 1));
        return (N) internalArray[index];
    }

    /**
     * This method allows you to change the value of an element in an ArrayList at a specified index.
     * Checks if the list is empty.
     * Checks whether the specified index is within a valid range.
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public N set(int index, N element) {
        if (size == 0)
            throw new IndexOutOfBoundsException("List is empty");
        if ((index < 0) | (index > size - 1))
            throw new IndexOutOfBoundsException("Index should be >0 and <" + (size - 1));
        N oldValue = (N) internalArray[index];
        internalArray[index] = element;
        return oldValue;
    }

    /**
     * The method implements removing an element from the MyArrayList at the specified index, shifting all subsequent
     * elements to the left and reducing the size of the list.
     * The last element in the array is reset to free memory.
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public N remove(int index) {
        if (index > size - 1) throw new IndexOutOfBoundsException("Index should be <" + size);
        N removedValue = (N) internalArray[index];
        for (int i = index; i < size; i++) {
            internalArray[i] = internalArray[i + 1];
        }
        internalArray[size - 1] = null;
        size--;
        return removedValue;
    }

    /**
     * This method clears the entire MyArrayList, removing all of its elements.
     * Sets all elements of the cleanedArray, starting with the last one, to null.
     * Sets size to 0.
     */
    public void clear() {
        for (int i = size - 1; i > 0; i--)
            internalArray[i] = null;
        size = 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection<? extends N> c) {
        return false;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean addAll(int index, Collection c) {  //&&&&&
        return false;
    }

}
