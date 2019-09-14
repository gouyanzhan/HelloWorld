package com.siwuxie095.forme.copy;


import java.util.*;

/**
 * @author Jiajing Li
 * @date 2019-04-24 14:22:52
 */
public abstract class MyAbstractList<E> extends AbstractCollection<E> implements List<E> {

    protected transient int modCount = 0;

    protected MyAbstractList() {}

    @Override
    public abstract int size();

    @Override
    public boolean add(E element) {
        add(size(), element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract E get(int index);

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object obj) {
        ListIterator<E> it = listIterator();
        if (null == obj) {
            while (it.hasNext()) {
                if (null == it.next()) {
                    return it.previousIndex();
                }
            }
        } else {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    return it.previousIndex();
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        ListIterator<E> it = listIterator(size());
        if (null == obj) {
            while (it.hasPrevious()) {
                if (null == it.previous()) {
                    return it.nextIndex();
                }
            }
        } else {
            while (it.hasPrevious()) {
                if (obj.equals(it.previous())) {
                    return it.nextIndex();
                }
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        removeRange(0, size());
    }

    protected void removeRange(int fromIndex, int toIndex) {
        ListIterator<E> it = listIterator(fromIndex);
        for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
            it.next();
            it.remove();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        rangeCheckForAdd(index);
        boolean modified = false;
        for (E element : coll) {
            add(index++, element);
            modified = true;
        }
        return modified;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }


    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(final int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this instanceof RandomAccess ? new RandomAccessSubList<>(this, fromIndex, toIndex) : new SubList<>(this, fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        ListIterator<E> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(null == o1 ? null == o2 : o1.equals(o2))) {
                return false;
            }
        }
        return !(e1.hasNext() || e2.hasNext());
     }

     @Override
     public int hashCode() {
        int hashCode = 1;
        for (E element : this) {
            hashCode = 31 * hashCode  + (null == element ? 0 : element.hashCode());
        }
        return hashCode;
     }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }


    /**
     * 第一个内部类
     */
    private class Itr implements Iterator<E> {

        int cursor = 0;

        int lastRet = -1;

        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();

            try {
                MyAbstractList.this.remove(lastRet);
                if (lastRet < cursor) {
                    cursor--;
                }
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * 第二个内部类 ListItr
     */
    private class ListItr extends Itr implements ListIterator<E> {

        ListItr(int index) {
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            checkForComodification();
            try {
                int i = cursor - 1;
                E previous = get(i);
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void set(E element) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();

            try {
                MyAbstractList.this.set(lastRet, element);
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(E element) {
            checkForComodification();

            try {
                int i  = cursor;
                MyAbstractList.this.add(i, element);
                lastRet = -1;
                cursor = i + 1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

}

/**
 * 同级类 SubList
 */
class SubList<E> extends MyAbstractList<E> {

    private final MyAbstractList<E> list;
    private final int offset;
    private int size;

    SubList(MyAbstractList<E> list, int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex > list.size()) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        this.list = list;
        this.offset = fromIndex;
        this.size = toIndex - fromIndex;
        this.modCount = this.list.modCount;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        checkForComodification();
        return this.list.set(index + offset, element);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        checkForComodification();
        return this.list.get(index + offset);
    }

    @Override
    public int size() {
        checkForComodification();
        return size;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        checkForComodification();
        this.list.add(index + offset, element);
        this.modCount = this.list.modCount;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        checkForComodification();
        E result = this.list.remove(index + offset);
        this.modCount = this.list.modCount;
        size--;
        return result;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        checkForComodification();
        this.list.removeRange(fromIndex, toIndex);
        this.modCount = this.list.modCount;
        size -= (toIndex - fromIndex);
    }

    @Override
    public boolean addAll(Collection<? extends  E> coll) {
        return addAll(size, coll);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        rangeCheckForAdd(index);
        int cSize = coll.size();
        if (cSize == 0) {
            return false;
        }
        checkForComodification();
        this.list.addAll(index + offset, coll);
        this.modCount = this.list.modCount;
        size += cSize;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public ListIterator<E> listIterator(final int index) {
        checkForComodification();
        rangeCheckForAdd(index);

        return new ListIterator<E>() {
            private final ListIterator<E> i = list.listIterator(index + offset);

            @Override
            public boolean hasNext() {
                return nextIndex() < size;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return i.next();
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasPrevious() {
                return previousIndex() >= 0;
            }

            @Override
            public E previous() {
                if (hasPrevious()) {
                    return i.previous();
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {
                return i.nextIndex() - offset;
            }

            @Override
            public int previousIndex() {
                return i.previousIndex() - offset;
            }

            @Override
            public void remove() {
                i.remove();
                SubList.this.modCount = list.modCount;
                size--;
            }

            @Override
            public void set(E e) {
                i.set(e);
            }

            @Override
            public void add(E e) {
                i.add(e);
                SubList.this.modCount = list.modCount;
                size++;
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new SubList<>(this, fromIndex, toIndex);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkForComodification() {
        if (this.modCount != this.list.modCount) {
            throw new ConcurrentModificationException();
        }
    }
}

/**
 * 同级类 RandomAccessSubList
 */
class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
    RandomAccessSubList(MyAbstractList<E> list, int fromIndex, int toIndex) {
        super(list, fromIndex, toIndex);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new RandomAccessSubList<>(this, fromIndex, toIndex);
    }
}
