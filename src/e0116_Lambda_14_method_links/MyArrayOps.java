package e0116_Lambda_14_method_links;

public class MyArrayOps {
    static <N> int countMatching(N[] vals, N v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }

        return count;
    }
}
