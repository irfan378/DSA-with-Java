import java.util.Arrays;
import java.util.List;

//  Here T should either be number or its subclasses.
public class WildcardExample<T extends Number> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildcardExample() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void getList(List<? extends Number> list) {
        // do something
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove() {
        T removed = (T) (data[--size]);
        return removed;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList{" + "data=" + Arrays.toString(data) + ",size=" + size + '}';
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list2 = new ArrayList<>();
        CustomGenericArraylist<Integer> list = new CustomGenericArraylist<>();

        list.add(2);
        list.add(34);
        System.out.println(list);
    }

}
