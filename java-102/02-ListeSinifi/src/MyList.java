import java.util.Arrays;

public class MyList <T>{
    private T[] arr;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    MyList() {
        this.arr = (T[]) new Object[10];
    }

    MyList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arr = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.arr = (T[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public int size(){
        int count = 0;
        for (T element: this.arr) {
            if (element==null) break;
            else count++;
        }
        return count;
    }

    public int getCapacity(){
        return this.arr.length;
    }

    public void add(T data){
        for (int i=0; i<this.arr.length; i++){
            if(this.arr[i]==null){
                this.arr[i] = data;
                break;
            }
            if((this.arr[i] != null) && (i==this.arr.length-1)){
                this.arr = Arrays.copyOf(this.arr, arr.length * 2);
                this.arr[this.arr.length / 2] = data;
                break;
            }
        }
    }

    public T get(int index){
        if (index>this.arr.length-1 || index<0) return null;
        else if (this.arr[index]!=null) return this.arr[index];
        else return null;
    }

    public void remove(int index){
        if (index<this.arr.length && index>-1) {
            if (this.arr[index]!=null){
                for (int i=index; i<this.arr.length;i++){
                    if (this.arr[i+1]==null){
                        this.arr[i] = null;
                        break;
                    }
                    else{
                        this.arr[i] = this.arr[i+1];
                    }
                }
            }
        }
    }

    public void set(int index, T data){
        if (index<this.arr.length && index>-1) {
            if (this.arr[index]!=null) this.arr[index]=data;
            else{
                for (int i=index; i>=0; i--){
                    if (this.arr[index]!=null){
                        this.arr[index]=data;
                        break;
                    }
                }
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<this.arr.length;i++){
            if (this.arr[i]==null) break;
            else if (i+1==this.arr.length){
                sb.append(this.arr[i]);
                break;
            }
            else if (this.arr[i+1]==null){
                sb.append(this.arr[i]);
                break;
            }
            else{
                sb.append(this.arr[i]).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data){
        for (int i=0; i<this.arr.length;i++){
            if (data.equals(this.arr[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i=this.arr.length-1; i>-1;i--){
            if (data.equals(this.arr[i])) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return this.arr[0] == null;
    }

    public T[] toArray() {
        return Arrays.copyOfRange(this.arr, 0, size());
    }

    public void clear() {
        this.arr = (T[]) new Object[10];
    }

    public MyList<T> subList(int start,int finish){
        if(start<finish){
            MyList<T> newArr = new MyList<>((finish - start + 1));
            for (int i=start;i<=finish;i++){
                newArr.add(this.arr[i]);
            }
            return newArr;
        }
        else return null;
    }

    public boolean contains(T data){
        for (T t : this.arr) {
            if (data.equals(t)) return true;
        }
        return false;
    }

}