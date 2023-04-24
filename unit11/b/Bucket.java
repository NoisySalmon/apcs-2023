package unit11.b;

// https://www.youtube.com/watch?v=xVAvMIhvqfk
public class Bucket {
    private int value;

    public Bucket(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // to explore...

    static void updateValue(Bucket b) {
        b.setValue(5);
        System.out.println("inst method:" + b.getValue());

    }

    void updateValue() {
        setValue(5);
    }

    static void updateValueDirect(Bucket b) {
        b.value = 5;
    }

    // what does static mean?
    // what is by value vs. by reference?

    static void updateValue(int val) {
        val = 5;
        System.out.println("method:" + val);
    }

    public static void main(String[] args) {
        // explore: predict before uncommenting
        int value = 3;
        //value = 5;
        // System.out.println(value);

        // System.out.println("Within method:");
        // updateValue(value);
        // System.out.println(value);

        System.out.println("Within bucket:");
        Bucket b = new Bucket(value);
        System.out.println(b.getValue());
                //b.value = 5;
        updateValue(b);
        //updateValueDirect(b);
        System.out.println(b.getValue());
    }
}
