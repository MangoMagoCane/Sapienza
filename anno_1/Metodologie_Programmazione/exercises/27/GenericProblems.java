import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class GenericProblems {
    @SuppressWarnings("unchecked")
    static <T extends Comparable> T max(List<T> list) {
        T largest = list.get(0);
        int len = list.size();
        for (int i = 1; i < len; i++) {
            T elem = list.get(i);
            if (elem != null && largest.compareTo(elem) < 0) {
                largest = elem;
            }
        }
        return largest;
    }

    

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        System.out.println(max(list));

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("b");
        System.out.println(list2);
        System.out.println(max(list2));
    }
}
