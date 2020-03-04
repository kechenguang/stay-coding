package effectiveJava.beans;

public class Data implements Cloneable, Comparable<Data> {

    public int x;
    public int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showData() {

        System.out.println(String.format("x is %s y is %s", x, y));
    }

    @Override
    public Data clone() {

        Data data = null;
        try {
            data = (Data) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public int compareTo(Data o) {
        return 0;
    }
}
