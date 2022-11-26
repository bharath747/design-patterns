package designPatterns.singleton.singletonAndEnum;

/*

 The code make a singleton without any of the problems discussed. Since enums are inherently serializable,
 we don't need to implement it with a serializable interface. The reflection problem is also not there. Therefore,
 it is 100% guaranteed that only one instance of the singleton is present within a JVM. Thus, this method is recommended
 as the best method of making singletons in Java.

 One thing to remember here is, when serializing an enum, field variables are not getting serialized. For example,
 if we serialize and deserialize the SingletonEnum class, we will lose the value of the int value field .

*/
public enum SingletonWithEnum {

    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
