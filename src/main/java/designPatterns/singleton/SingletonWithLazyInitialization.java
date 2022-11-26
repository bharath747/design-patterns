package designPatterns.singleton;

public class SingletonWithLazyInitialization {

    private static volatile SingletonWithLazyInitialization instance = null;


    private SingletonWithLazyInitialization() {

    }

    public static SingletonWithLazyInitialization getInstance() {
        if (instance == null) {
            synchronized (SingletonWithLazyInitialization.class) {
                /*
                   double checking if instance is null to handle
                   two threads looking for instance at same time

                   Note : Please be sure to use “volatile” keyword with instance variable otherwise you can run into an out of order write error scenario,
                          where reference of an instance is returned before actually the object is constructed i.e. JVM has only allocated the memory
                          and constructor code is still not executed.
                   */
                if (instance == null) {
                    instance = new SingletonWithLazyInitialization();
                }
            }
        }
        return instance;
    }
}
