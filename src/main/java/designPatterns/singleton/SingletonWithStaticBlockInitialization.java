package designPatterns.singleton;

public class SingletonWithStaticBlockInitialization {

    private static final SingletonWithStaticBlockInitialization instance;

    /*
      If you have an idea of the class loading sequence, you can use the fact that static blocks are executed
      during the loading of a class, even before the constructor is called. We can use this feature in our
      singleton pattern like this

      If we use this static initialization, we will have one instance created though it is required or not.
    */
    static {
        try {
            instance = new SingletonWithStaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Uffff, i was not expecting this!", e);
        }
    }

    public static SingletonWithStaticBlockInitialization getInstance() {
        return instance;
    }

    private SingletonWithStaticBlockInitialization() {

    }
}
