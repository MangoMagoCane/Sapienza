import java.util.Iterator;

public class MyIterableArray implements Iterable<Integer> {
    private Integer[] myArray;

    private class MyIter implements Iterator<Integer> {
        private int pos = 0;

        public boolean hasNext() {
            return pos < myArray.length;
        }

        public Integer next() {
            Integer elem = myArray[pos];
            pos++;
            return elem;
        }
    }

    MyIterableArray(Integer[] array) {
        myArray = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIter();
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        MyIterableArray myArr = new MyIterableArray(arr);
        for (int i : myArr) {
            System.out.println(i);
        }
        for (int i : myArr) {
            System.out.println(i);
        }
    }
}
