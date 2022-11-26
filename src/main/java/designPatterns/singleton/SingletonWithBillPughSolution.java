package designPatterns.singleton;


public class SingletonWithBillPughSolution {

    private SingletonWithBillPughSolution() {
    }

    /*
      The LazyHolder class will not be initialized until required and you can still use
      other Static members of BillPughSingleton class
    */
    private static class LazyHolder {
        private static final SingletonWithBillPughSolution INSTANCE = new SingletonWithBillPughSolution();
    }

    public static SingletonWithBillPughSolution getInstance() {
        return LazyHolder.INSTANCE;
    }
}
