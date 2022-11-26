package designPatterns.singleton;

public class SingletonWithEagerInitialization {
    private static volatile SingletonWithEagerInitialization instance = new SingletonWithEagerInitialization();

    // private constructor
    private SingletonWithEagerInitialization() {
    }

    public static SingletonWithEagerInitialization getInstance() {
        return instance;
    }
}
