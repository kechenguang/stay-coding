package reviewWork;

public class SortK {

    public int findKthNumber(int n, int k) {

        int prefix = 1;
        int count = 1;
        while (count < k) {
            int c = prefixCount(prefix, n);
            if (count + c < k) {
                prefix = prefix + 1;
                count += c;
            } else {
                prefix = prefix * 10;
                count++;
            }
        }
        return prefix;
    }

    public int prefixCount(int perfix, int n) {

        System.out.println("perfix is " + perfix);
        int a = perfix;
        int b = perfix + 1;
        int count = 0;
        while (a < n) {
            count += Math.min(n + 1, b) - a;
            a = a * 10;
            b = b * 10;
        }
        System.out.println("count is " + count);
        return count;
    }

    public static void main(String args[]) {

        SortK k = new SortK();
        k.findKthNumber(30, 20);
        //System.out.println(k.prefixCount(1, 13));
    }
}
