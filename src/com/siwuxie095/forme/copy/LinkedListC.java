package com.siwuxie095.forme.copy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author Jiajing Li
 * @date 2019-04-24 17:46:13
 */
public class LinkedListC<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedListC() {}

    public LinkedListC(Collection<? extends E> coll) {
        this();
        addAll(coll);
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        return addAll(size, coll);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        checkPositionIndex(index);

        Object[] arr = coll.toArray();
        int numNew = arr.length;
        if (numNew == 0) {
            return false;
        }

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object obj : arr) {
            E element = (E) obj;
            Node<E> newNode = new Node<>(pred, element, null);
            if (null == pred) {
                first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }

        if (null == succ) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (null == f) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        modCount++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (null == l) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (null == pred) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
        modCount++;
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (null == next) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (null == prev) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (null == prev) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (null == next) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (null == f) {
            throw new NoSuchElementException();
        }
        return f.item;
    }


    @Override
    public E getLast() {
        final Node<E> l = last;
        if (null == l) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (null == f) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (null == l) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        if (null == obj) {
            for (Node<E> x = first; null != x; x = x.next) {
                if (null == x.item) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; null != x; x = x.next) {
                if (obj.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = size;
        if (null == obj) {
            for (Node<E> x = last; null != x; x = x.prev) {
                index--;
                if (null == x.item) {
                    return index;
                }
            }
        } else {
            for (Node<E> x = last; null != x; x = x.prev) {
                index--;
                if (obj.equals(x.item)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (null == obj) {
            for (Node<E> x = first; null != x; x = x.next) {
                if (null == x.item) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; null != x; x = x.next) {
                if (obj.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; null != x; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }

        first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public E peek() {
        final Node<E> f = first;
        return null == f ? null : f.item;
    }

    @Override
    public E poll() {
        final Node<E> f = first;
        return null == f ? null : unlinkFirst(f);
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E peekFirst() {
        final Node<E> f = first;
        return null == f ? null : f.item;
    }

    @Override
    public E peekLast() {
        final Node<E> l = last;
        return null == l ? null : l.item;
    }

    @Override
    public E pollFirst() {
        final Node<E> f = first;
        return null == f ? null : unlinkFirst(f);
    }

    @Override
    public E pollLast() {
        final Node<E> l = last;
        return null == l ? null : unlinkLast(l);
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }


    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override
    public boolean removeLastOccurrence(Object obj) {
        if (null == obj) {
            for (Node<E> x = last; null != x; x = x.prev) {
                if (null == x.item) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; null != x; x = x.prev) {
                if (obj.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private LinkedListC<E> superClone() {
        try {
            return (LinkedListC<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public Object clone() {
        LinkedListC<E> clone = superClone();

        clone.first = clone.last = null;
        clone.size = 0;
        clone.modCount = 0;

        for (Node<E> x = first; null != x; x = x.next) {
            clone.add(x.item);
        }

        return clone;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; null != x; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] arr) {
        if (arr.length < size) {
            arr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = arr;
        for (Node<E> x = first; null != x; x = x.next) {
            result[i++] = x.item;
        }

        if (arr.length > size) {
            arr[size] = null;
        }

        return arr;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

        stream.writeInt(size);

        for (Node<E> x = first; null != x; x = x.next) {
            stream.writeObject(x.item);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();

        int size = stream.readInt();

        for (int i = 0; i < size; i++) {
            linkLast((E) stream.readObject());
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return new LLSpliterator<>(this, -1, 0);
    }

    /**
     * 第一个内部类 Node
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 第二个内部类 ListItr
     */
    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            checkForComodificaiton();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            checkForComodificaiton();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            lastReturned = next = (null == next) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForComodificaiton();
            if (null == lastReturned) {
                throw new IllegalStateException();
            }

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(E e) {
            if (null == lastReturned) {
                throw new IllegalStateException();
            }
            checkForComodificaiton();
            lastReturned.item = e;
        }

        @Override
        public void add(E e) {
            checkForComodificaiton();
            lastReturned = null;
            if (null == next) {
                linkLast(e);
            } else {
                linkBefore(e, next);
            }
            nextIndex++;
            expectedModCount++;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodificaiton();
        }

        final void checkForComodificaiton() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

    /**
     * 第三个内部类 DescendingIterator
     */
    private class DescendingIterator implements Iterator<E> {
        private final ListItr itr = new ListItr(size());

        @Override
        public boolean hasNext() {
            return itr.hasNext();
        }

        @Override
        public E next() {
            return itr.previous();
        }

        @Override
        public void remove() {
            itr.remove();
        }
    }

    static final class LLSpliterator<E> implements Spliterator<E> {
        static final int BATCH_UNIT = 1 << 10;
        static final int MAX_BATCH = 1 << 25;
        final LinkedListC<E> list;
        Node<E> current;
        int est;
        int expectedModCount;
        int batch;

        LLSpliterator(LinkedListC<E> list, int est, int expectedModCount) {
            this.list = list;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getEst() {
            int s;
            final LinkedListC<E> lst;
            if ((s = est) < 0) {
                if ((lst = list) == null) {
                    s = est = 0;
                } else {
                    expectedModCount = lst.modCount;
                    current = lst.first;
                    s = est = lst.size;
                }
            }
            return s;
        }

        @Override
        public long estimateSize() {
            return (long) getEst();
        }

        @Override
        public Spliterator<E> trySplit() {
            Node<E> p;
            int s = getEst();
            if (s > 1 && (p = current) != null) {
                int n = batch + BATCH_UNIT;
                if (n > s) {
                 n = s;
                }
                if (n > MAX_BATCH) {
                    n = MAX_BATCH;
                }
                Object[] arr = new Object[n];
                int j = 0;
                do {
                    arr[j++] = p.item;
                } while ((p = p.next) != null && j < n);

                current = p;
                batch = j;
                est = s - j;
                return Spliterators.spliterator(arr, 0, j, Spliterator.ORDERED);
            }
            return null;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Node<E> p;
            int n;
            if (null == action) {
                throw new NullPointerException();
            }
            if ((n = getEst()) > 0 && (p = current) != null) {
                current = null;
                est = 0;

                do {
                    E e = p.item;
                    p = p.next;
                    action.accept(e);
                } while (p != null && --n > 0);
            }

            if (list.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean tryAdvance(Consumer<? super E> action) {
            Node<E> p;
            if (null == action) {
                throw new NullPointerException();
            }
            if (getEst() > 0 && (p = current) != null) {
                --est;
                E e = p.item;
                current = p.next;
                action.accept(e);
                if (list.modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
            return false;
        }

        @Override
        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }

    }



}
