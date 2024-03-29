package learning.java.core.clone;

/**
 * @author Maksim_Likhanov
 */
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Manager manager = new Manager();

        Bean b = new Bean();
        b.setA(2);
        //		b.setB("ads");

        manager.setBean(b);

        Bean c = new Bean();
        c.setA(4);
        c.setB("sadasdas");

        //TODO copy c to b.
        // What is the task??
//        b = (Bean) c.clone(); // не подходит

        System.out.println("Bean b:");
        System.out.println(b.getA());
        System.out.println(b.getB());

        System.out.println("Bean from manager:");
        System.out.println(manager.getBean().getA());
        System.out.println(manager.getBean().getB());

    }

}

class Manager {
    String str;
    Bean bean;

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public String getStr() {

        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class Bean implements Cloneable {
    Integer a;
    private String b;

    Bean() {
    }

    Bean(Bean copy) {
        a = copy.getA();
        b = copy.getB();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
