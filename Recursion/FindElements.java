import java.util.ArrayList;

public class FindElements {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 5, 4, 5 };
        System.out.println(findIndex(arr, 5, 0));
        System.out.println(find(arr, 5, 0));
        System.out.println(findAllIndex(arr, 5, 0, new ArrayList<>()));
    }

    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || find(arr, target, index + 1);
    }

    static int findIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, target, index + 1);
        }
    }

    static ArrayList findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }
}
