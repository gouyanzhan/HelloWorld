package com.siwuxie095.forme.copy;

import sun.misc.SharedSecrets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Jiajing Li
 * @date 2019-04-18 14:47:38
 */
public class ArrayListC<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    /**
     * 默认容量（初始容量）
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空对象数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 默认容量的空对象数组
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_EMPTY_ELEMENT_DATA = {};

    /**
     * 缓冲数组
     */
    transient Object[] elementData;

    /**
     * List 的大小
     */
    private int size;

    /**
     * List 的结构被修改的次数 modified count
     */
    protected transient int modCount;

    /**
     * 数组可供分配的最大容量
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 有参构造器，参数是 List 的容量
     */
    public ArrayListC(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 无参构造器
     */
    public ArrayListC() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_EMPTY_ELEMENT_DATA;
    }

    /**
     * 有参构造器，参数是一个集合
     */
    public ArrayListC(Collection<? extends E> coll) {
        elementData = coll.toArray();
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            this.elementData = EMPTY_ELEMENT_DATA;
        }
    }

    /**
     * 将 List 动态增长的多余容量去除，只留下实际容量的大小
     */
    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = (size == 0) ? EMPTY_ELEMENT_DATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * List 扩容（如果所需容量很大，且有预计，那么一次性扩容效率更高）
     */
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULT_CAPACITY_EMPTY_EMPTY_ELEMENT_DATA) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    /**
     * List 扩容（同时计算 List 被修改次数）
     */
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 计算容量
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_CAPACITY_EMPTY_EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 扩容的核心操作
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // newCapacity 小于 minCapacity，则取 minCapacity
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        // newCapacity 大于 MAX_ARRAY_SIZE
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 最大化容量
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public int indexOf(Object obj) {
        if (null == obj) {
            for (int i = 0; i < size; ++i) {
                if (null == elementData[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; ++i) {
                if (obj.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        if (null == obj) {
            for (int i = size - 1; i >= 0; --i) {
                if (null == elementData[i]) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; --i) {
                if (obj.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object clone() {
        try {
            ArrayListC<?> list = (ArrayListC<?>) super.clone();
            list.elementData = Arrays.copyOf(elementData, size);
            list.modCount = 0;
            return list;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] arr) {
        if (arr.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, arr.getClass());
        }
        System.arraycopy(elementData, 0, arr, 0, size);
        if (arr.length > size) {
            arr[size] = null;
        }
        return arr;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public boolean add(E element) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;

        return oldValue;
    }

    @Override
    public boolean remove(Object obj) {
        if (null == obj) {
            for (int index = 0; index < size; ++index) {
                if (null == elementData[index]) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; ++index) {
                if (obj.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 快速移除（不校验边界条件，也不返回移除的那个值）
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public void clear() {
        modCount++;

        for (int i = 0; i < size; ++i) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        Object[] arr = coll.toArray();
        int numNew = arr.length;
        ensureCapacityInternal(size + numNew);
        System.arraycopy(arr, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        rangeCheckForAdd(index);

        Object[] arr = coll.toArray();
        int numNew = arr.length;

        ensureCapacityInternal(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        }

        System.arraycopy(arr, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = size - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex, numMoved);

        int newSize = size - (toIndex - fromIndex);
        for (int i = newSize; i < size; ++i) {
            elementData[i] = null;
        }
        size = newSize;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        Objects.requireNonNull(coll);
        return batchRemove(coll, false);
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        Objects.requireNonNull(coll);
        return batchRemove(coll, true);
    }

    /**
     * complement 是否补充 也可理解为补集的概念
     */
    private boolean batchRemove(Collection<?> coll, boolean complement) {
        final Object[] elementData = this.elementData;
        int r = 0;
        int w = 0;
        boolean modified = false;
        try {
            for (; r < size; ++r) {
                if (coll.contains(elementData[r]) == complement) {
                    elementData[w++] = elementData[r];
                }
            }
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; ++i) {
                    elementData[i] = null;
                }
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        int expectedModCount  = modCount;
        stream.defaultWriteObject();

        stream.writeInt(size);

        for (int i = 0; i < size; ++i) {
            stream.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENT_DATA;

        stream.defaultReadObject();

        stream.readInt();

        if (size > 0) {
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(stream, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] arr = elementData;
            for (int i = 0; i < size; ++i) {
                arr[i] = stream.readObject();
            }
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return new ListItr(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new SubList(this, 0, fromIndex, toIndex);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        final E[] elementData = (E[]) this.elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; ++i) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return new ArrayListSpliterator<>(this, 0, -1, 0);
    }


    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        int removeCount = 0;
        final BitSet removeSet = new BitSet(size);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; ++i) {
            final E element = (E) elementData[i];
            if (filter.test(element)) {
                removeSet.set(i);
                removeCount++;
            }
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        final boolean anyToRemove = removeCount > 0;
        if (anyToRemove) {
            final int newSize = size - removeCount;
            for (int i = 0, j = 0; i < size && j < newSize; ++i, ++j) {
                i = removeSet.nextClearBit(i);
                elementData[j] = elementData[i];
            }
            for (int k = newSize; k < size; ++k) {
                elementData[k] = null;
            }
            this.size = newSize;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            modCount++;
        }
        return anyToRemove;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; ++i) {
            elementData[i] = operator.apply((E) elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elementData, 0, size, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    /**
     * 第一个内部类 Itr
     */
    private class Itr implements Iterator<E> {

        int cursor = 0;
        int lastRet = -1;
        int expectedModCount = modCount;

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayListC.this.elementData;
            if (i > elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ArrayListC.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayListC.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayListC.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }

            cursor = i;
            lastRet = i - 1;
            checkForComodification();
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
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
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
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayListC.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void set(E element) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ArrayListC.this.set(lastRet, element);
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(E element) {
            checkForComodification();

            try {
                int i = cursor;
                ArrayListC.this.add(i, element);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * 第三个内部类 SubList
     */
    private class SubList extends AbstractList<E> implements RandomAccess {

        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;

        SubList(AbstractList<E> parent, int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = ArrayListC.this.modCount;
        }

        @Override
        public E set(int index, E element) {
            rangeCheck(index);
            checkForComodification();
            E oldValue = ArrayListC.this.elementData(offset + index);
            ArrayListC.this.elementData[offset + index] = element;
            return oldValue;
        }

        @Override
        public E get(int index) {
            rangeCheck(index);
            checkForComodification();
            return ArrayListC.this.elementData(offset + index);
        }

        @Override
        public int size() {
            checkForComodification();
            return this.size;
        }

        //@Override
        //public void add(int index, E element) {
        //    rangeCheckForAdd(index);
        //    checkForComodification();
        //    parent.add(parentOffset + index, element);
        //    this.modCount = parent.modCount;
        //    this.size++;
        //}

        //@Override
        //public E remove(int index) {
        //    rangeCheck(index);
        //    checkForComodification();
        //    E result = parent.remove(parentOffset + index);
        //    this.modCount = parent.modCount;
        //    this.size--;
        //    return result;
        //}

        //@Override
        //protected void removeRange(int fromIndex, int toIndex) {
        //    checkForComodification();
        //    parent.removeRange(parentOffset + fromIndex, parentOffset + toIndex);
        //    this.modCount = parent.modCount;
        //    this.size = toIndex - fromIndex;
        //}

        @Override
        public boolean addAll(Collection<? extends E> coll) {
            return addAll(this.size, coll);
        }

        //@Override
        //public boolean addAll(int index, Collection<? extends E> coll) {
        //    rangeCheckForAdd(index);
        //    int cSize = coll.size();
        //    if (cSize == 0) {
        //        return false;
        //    }
        //    checkForComodification();
        //    parent.addAll(parentOffset + index, coll);
        //    this.modCount = parent.modCount;
        //    this.size += cSize;
        //    return true;
        //}

        @Override
        public Iterator<E> iterator() {
            return listIterator();
        }

        @Override
        public ListIterator<E> listIterator(final int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            final int offset = this.offset;

            return new ListIterator<E>() {
                int cursor = index;
                int lastRet = -1;
                int expectedModCount = ArrayListC.this.modCount;

                @Override
                public boolean hasNext() {
                    return cursor != SubList.this.size;
                }

                @Override
                public E next() {
                    checkForComodification();
                    int i = cursor;
                    if (i >= SubList.this.size) {
                        throw new NoSuchElementException();
                    }
                    Object[] elementData = ArrayListC.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    cursor = i + 1;
                    return (E) elementData[offset + (lastRet = i)];
                }

                @Override
                public boolean hasPrevious() {
                    return cursor != 0;
                }

                @Override
                public E previous() {
                    checkForComodification();
                    int i = cursor - 1;
                    if (i < 0) {
                        throw new NoSuchElementException();
                    }
                    Object[] elementData = ArrayListC.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    cursor = i;
                    return (E) elementData[offset + (lastRet = i)];
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
                public void remove() {
                    if (lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    checkForComodification();

                    try {
                        SubList.this.remove(lastRet);
                        cursor = lastRet;
                        lastRet = -1;
                        expectedModCount = ArrayListC.this.modCount;
                    } catch (IndexOutOfBoundsException e) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override
                public void set(E element) {
                    if (lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    checkForComodification();

                    try {
                        ArrayListC.this.set(offset + lastRet, element);
                    } catch (IndexOutOfBoundsException e) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override
                public void add(E element) {
                    checkForComodification();

                    try {
                        int i = cursor;
                        SubList.this.add(i, element);
                        cursor = i + 1;
                        lastRet = -1;
                        expectedModCount = ArrayListC.this.modCount;
                    } catch (IndexOutOfBoundsException e) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override
                public void forEachRemaining(Consumer<? super E> consumer) {
                    Objects.requireNonNull(consumer);
                    final int size = SubList.this.size;
                    int i = cursor;
                    if (i >= size) {
                        return;
                    }
                    final Object[] elementData = ArrayListC.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    while (i != size && modCount == expectedModCount) {
                        consumer.accept((E) elementData[offset + (i++)]);
                    }

                    lastRet = cursor = i;
                    checkForComodification();
                }

                final void checkForComodification() {
                    if (expectedModCount != ArrayListC.this.modCount) {
                        throw new ConcurrentModificationException();
                    }
                }

            };
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubList(this, offset, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
        }

        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + size;
        }

        private void checkForComodification() {
            if (ArrayListC.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public Spliterator<E> spliterator() {
            checkForComodification();
            return new ArrayListSpliterator<E>(ArrayListC.this, offset, offset + this.size, this.modCount);
        }

    }

    /**
     * 第四个内部类 ArrayListSpliterator
     */
    static final class ArrayListSpliterator<E> implements Spliterator<E> {

        private final ArrayListC<E> list;
        private int index;
        private int fence;
        private int expectedModCount;

        ArrayListSpliterator(ArrayListC<E> list, int origin, int fence, int expectedModCount) {
            this.list = list;
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() {
            int hi;
            ArrayListC<E> lst;
            if ((hi = fence) < 0) {
                if ((lst = list) == null) {
                    hi = fence = 0;
                } else {
                    expectedModCount = lst.modCount;
                    hi = fence = lst.size;
                }
            }
            return hi;
        }

        @Override
        public Spliterator<E> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid) ? null : new ArrayListSpliterator<E>(list, lo, index = mid, expectedModCount);
        }

        @Override
        public boolean tryAdvance(Consumer<? super E> action) {
            if (null == action) {
                throw new NullPointerException();
            }
            int hi = getFence();
            int i = index;
            if (i < hi) {
                index = i + 1;
                E element = (E) list.elementData[i];
                action.accept(element);
                if (list.modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            int i;
            int hi;
            int mc;
            ArrayListC<E> lst;
            Object[] arr;
            if (null == action) {
                throw new NullPointerException();
            }
            if ((lst = list) != null && (arr = lst.elementData) != null) {
                if ((hi = fence) < 0) {
                    mc = lst.modCount;
                    hi = lst.size;
                } else {
                    mc = expectedModCount;
                }
                if ((i = index) >= 0 && (index = hi) <= arr.length) {
                    for (; i < hi; ++i) {
                        E element = (E) arr[i];
                        action.accept(element);
                    }
                    if (lst.modCount == mc) {
                        return;
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override
        public long estimateSize() {
            return (long) (getFence() - index);
        }

        @Override
        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }

    }

}
