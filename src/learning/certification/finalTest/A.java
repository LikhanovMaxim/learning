package learning.certification.finalTest;

public interface A {

	int groupID =  10;
	default boolean f(Object o){
		return this.groupID == ((A)o).groupID;
	}
	static void print(){
		System.out.println("Firest");
	}
}
