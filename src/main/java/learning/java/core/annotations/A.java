package learning.java.core.annotations;

public class A {
    @PublicFinal
    private String a;

    @Implement
    public String toString() {
        return super.toString();
    }
}
