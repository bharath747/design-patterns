package designPatterns.singleton.singletonAndSerialization;

import java.io.*;

public class SerializationTest {
    private static DemoSingleton instanceOne = DemoSingleton.getInstance();

    private static DemoSingletonWithReadResolve instanceOneWithReadResolve = DemoSingletonWithReadResolve.getInstance();

    public static void main(String[] args) {
        SerializationTest serializationTest = new SerializationTest();
        serializationTest.serializationSingletonIssueTest();
    }

    private void serializationSingletonIssueTest() {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                    "filename.ser"));
            out.writeObject(instanceOne);
            out.close();

            instanceOne.setI(20);

            // DeSerialize to a file
            ObjectInput in = new ObjectInputStream(new FileInputStream(
                    "filename.ser"));
            DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
            in.close();

            System.out.println(instanceOne.getI()); //20
            System.out.println(instanceTwo.getI()); //10

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void serializationSingletonWithReadResolve() {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                    "filename.ser"));
            out.writeObject(instanceOneWithReadResolve);
            out.close();

            instanceOneWithReadResolve.setI(20);

            // DeSerialize to a file
            ObjectInput in = new ObjectInputStream(new FileInputStream(
                    "filename.ser"));
            DemoSingleton instanceTwoWithReadResolve = (DemoSingleton) in.readObject();
            in.close();

            System.out.println(instanceOne.getI()); //20
            System.out.println(instanceTwoWithReadResolve.getI()); //10

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}