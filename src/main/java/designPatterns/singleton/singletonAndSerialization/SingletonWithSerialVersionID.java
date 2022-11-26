package designPatterns.singleton.singletonAndSerialization;

/*

  Serial version ID is required in cases where your class structure changes between serialization and deserialization.
  A changed class structure will cause the JVM to give an exception in the de-serializing process.

  Exception :

    java.io.InvalidClassException: singleton.DemoSingleton; local class incompatible: stream classdesc serialVersionUID = 5026910492258526905,
    local class serialVersionUID = 3597984220566440782
    at java.io.ObjectStreamClass.initNonProxy(Unknown Source)
    at java.io.ObjectInputStream.readNonProxyDesc(Unknown Source)
    at java.io.ObjectInputStream.readClassDesc(Unknown Source)
    at java.io.ObjectInputStream.readOrdinaryObject(Unknown Source)
    at java.io.ObjectInputStream.readObject0(Unknown Source)
    at java.io.ObjectInputStream.readObject(Unknown Source)
    at singleton.SerializationTest.main(SerializationTest.java:24)

 This problem can be solved only by adding a unique serial version id to the class. It will prevent the compiler from throwing
 the exception by telling it that both classes are same, and will load the available instance variables only.

 Singleton code template below shall ensure only one instance of a class in the whole application in all above discussed scenarios.

*/
public class SingletonWithSerialVersionID {

    private static final long serialVersionUID = 1L;

    private SingletonWithSerialVersionID() {
        // private constructor
    }

    private static class DemoSingletonHolder {
        private static final DemoSingleton INSTANCE = new DemoSingleton();
    }

    private static DemoSingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
