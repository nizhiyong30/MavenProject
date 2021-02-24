package cn.serializable;

import java.io.*;

/**
 * @author nizy
 * @date 2021/1/20 11:14 上午
 */
public class User implements Externalizable {

    private transient String user;

    public String getUser() {
        return user;
    }

    public int getAge() {
        return age;
    }

    private int age;

    public User() {
        System.out.println("user constructor.");
    }

    public User(String user, int age) {
        System.out.println("user constructor two.");
        this.user = user;
        this.age = age;
    }

    @Override
    public void readObject(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("read external.");
        user = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public void writeObject(ObjectOutput out) throws IOException {
        System.out.println("write external.");
        out.writeObject(user);
        out.writeInt(age);
    }

    public static void main(String[] args) {
        writeExternalizableObject();
        readExternalizableObject();
    }

    public static void writeExternalizableObject() {
        User user = new User("huhx", 22);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/nizhiyong/Downloads/Externalizable.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Externalizable的反序列化对象
    public static void readExternalizableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/nizhiyong/Downloads/Externalizable.txt"));
            User user = (User) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("name: " + user.getUser() + ", age: " + user.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
