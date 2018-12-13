package learning.patterns.creational.requied.fields.builder;

/**
 * @author Maksim_Likhanov
 */
public class App {

	public static void main(String[] args) {
		Address address = Address.builder().url("asd").name("asd").port(90).build();
		Address address1 = Address.builder().url("asd").name("asd").port(90).description("lol").build();
	}//
}
