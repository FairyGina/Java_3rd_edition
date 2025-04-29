// import java.util.*;

// public class MyVector implements List{
//     Object[] data = null;
//     int capacity = 0;
//     int size = 0;

//     public MyVector(int capacity) {
//         if (capacity < 0) {
//             throw new IllegalArgumentException("유효하지 않은 값입니다. :" + capacity);

//         }
//         this.capacity = capacity;
//         data = new Object[capacity];
//     }

//     public MyVector() {
//         this(10);
//     }

//     public void ensureCapacity(int minCapacity) {
//         if(minCapacity - data.length > 0) {
//             setCapacity(minCapacity);
//         }
//     }

//     @Override
//     public boolean add(Object obj) {
//         ensureCapacity(size + 1);
//         data[size++] = obj;
//         return true;
//     }

//     @Override
//     public Object get(int index) {
//         if(index < 0 || index >= size) {
//             throw new ArrayIndexOutOfBoundsException("범위를 벗어났습니다.");
//         }
//         return data[index];
//     }  

//     @Override
//     public Object remove(int index) {
//         Object oldObj = null;

//         if(index < 0 || index >= size) {
//             throw new ArrayIndexOutOfBoundsException("범위를 벗어났습니다.");
//         }
        
//         oldObj = data[index];

//         if(index < size - 1) {
//             System.arraycopy(data, index + 1, data, index, size - index - 1);
//         }
//         data[size - 1] = null;
//         size--;
//         return oldObj;
//     }

//     @Override
//     public boolean remove(Object obj) {
//         for(int i = 0; i < size; i++) {
//             if(data[i].equals(obj)) {
//                 remove(i);
//                 return true;
//             }
//         }
//         return false;
//     }

//     public void trimToSize() {
//         setCapacity(size);
//     }

//     private void setCapacity(int capacity) {
//         if(this.capacity == capacity) {
//             return;
//         }

//         Object[] tmp = new Object[capacity];
//         System.arraycopy(data,0,tmp,0, size);
//         data = tmp;
//         this.capacity = capacity;
//     }

//     @Override
//     public void clear() {
//         for(int i = 0; i < size; i++) {
//             data[i] = null;
//         }
//         size = 0;
//     }

//     @Override
//     public Object[] toArray() {
//         Object[] result = new Object[size];
//         System.arraycopy(data, 0, result, 0, size);

//         return result;
//     }

//     @Override
//     public boolean isEmpty() {
//         return size == 0;
//     }

//     public int capacity() {
//         return capacity;
//     }

    
//     @Override
//     public int size() {
//         return size;
//     }

//     /*********************************************************************/
//     /*            List인터페이스로부터 상속받은 메서드들                   */
//     /*********************************************************************/
//     //public int size();
//     //public boolean isEmpty();
//     @Override
//     public boolean contains(Object o){return false;}
//     @Override
//     public Iterator iterator(){return null;}

//     //public Object[] toArray();
//     @Override
//     public Object[] toArray(Object a[]){return null;}
//     //public boolean add(Object o);
//     //public boolean remove(Object o);
//     @Override
//     public boolean containsAll(Collection c){return false;}
//     @Override
//     public boolean addAll(Collection c){return false;}
//     @Override
//     public boolean addAll(int index, Collection c){return false;}
//     @Override
//     public boolean removeAll(Collection c){return false;}
//     @Override
//     public boolean retainAll(Collection c){return false;}
//     //public void clear();
//     @Override
//     public boolean equals(Object o){return false;}
//     //public int hashCode();
//     //public Object get(int index);
//     @Override
//     public Object set(int index, Object element){return null;}
//     @Override
//     public void add(int index, Object element){}
//     //public Object remove(int index);
//     @Override
//     public int indexOf(Object o){return -1;}
//     @Override
//     public int lastIndexOf(Object o){return -1;}
//     @Override
//     public ListIterator listIterator(){return null;}
//     @Override
//     public ListIterator listIterator(int index){return null;}
//     @Override
//     public List subList(int fromIndex, int toIndex){return null;}

//     // default void sort(Comparator c){/* */}
//     // default Spliterator spliterator(){/* */}
//     // default void replaceAll(UnaryOperator operator){/* */}
    
// }


