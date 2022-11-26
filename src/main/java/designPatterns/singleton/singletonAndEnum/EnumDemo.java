package designPatterns.singleton.singletonAndEnum;

public class EnumDemo {

    public static void main(String[] args) {
        SingletonWithEnum singleton = SingletonWithEnum.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}