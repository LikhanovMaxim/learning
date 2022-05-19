package learning.java.core.keywords._final;

public class Child extends First {

    Child() {
        System.out.println("Child constructor");
    }

    Child(int a) {
        super(a);
        System.out.println("Child constructor with param" + a);
    }

    @Override
    public void lol() {
        System.out.println("Child lol");
        leeeel();
//        super.leeeel(); //the same
        super.lol();
    }

    public void leeeel(int b) {

    }


}
