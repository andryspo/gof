package Prototype;

/**
 * Created by andry on 15/10/2016.
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human original = new Human(20, "Alex");
        Human clone = (Human)original.clone();
        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);
    }
}
class Human implements Cloneable{

    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Prototype.Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Human human = new Human(age, name);
        return human;
    }
}