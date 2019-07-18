package learning.java.core.collections;
//TODO add lombok
public class PersonSort {
    private String name;
    private int age;

    public PersonSort(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonSort{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
