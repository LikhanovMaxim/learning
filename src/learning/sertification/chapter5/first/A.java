package learning.sertification.chapter5.first;

public class A {
	//TODO it is not allowed to have only one private constructor if you have child class
	//	private A(){
	//
	//	}

	public A(int a) {

	}

	protected A(String a, String b) {
	}

	//
	public A(int a, String b) {
	}
}

class B extends A {

	public B(int a) {
		super(a);
	}

	//TODO case 1
	//	private B() {
	//		super();
	//	}
}
