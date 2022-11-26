package designPatterns.singleton.singletonAndSerialization;

public class DemoSingletonWithReadResolve {

    private volatile static DemoSingletonWithReadResolve instance = null;

    public static DemoSingletonWithReadResolve getInstance() {
        if (instance == null) {
            instance = new DemoSingletonWithReadResolve();
        }
        return instance;
    }

    /*
      To solve serialization issue, we need to include a readResolve() method in our DemoSingleton class.
      This method will be invoked when you will de-serialize the object.
      Inside of this method, you must return the existing instance to ensure a single instance application wide.
    */
    protected Object readResolve() {
        return instance;
    }

    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}
