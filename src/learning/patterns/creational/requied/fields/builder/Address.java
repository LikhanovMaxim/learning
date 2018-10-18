package learning.patterns.creational.requied.fields.builder;

/**
 * @author Maksim_Likhanov
 */
public class Address {
	private String protocol;
	private String url;
	private int port;
	private String path;
	private String description;

	// only builder should be able to create an instance
	private Address(Builder builder) {
		this.protocol = builder.protocol;
		this.url = builder.url;
		this.port = builder.port;
		this.path = builder.path;
		this.description = builder.description;
	}

	public static Url builder() {
		return new Builder();
	}

	public static class Builder implements Url, Port, Build{
		private String protocol;
		private String url;
		private int port;
		private String path;
		private String description;

		/** Mandatory, must be followed by {@link Port#port(int)}  */
		public Port url(String url) {
			this.url = url;
			return this;
		}

		/** Mandatory, must be followed by methods in {@link Build}  */
		public Build port(int port) {
			this.port = port;
			return this;
		}

		/** Non-mandatory, must be followed by methods in {@link Build}  */
		public Build protocol(String protocol) {
			this.protocol = protocol;
			return this;
		}

		/** Non-mandatory, must be followed by methods in {@link Build}  */
		public Build path(String path) {
			this.path = path;
			return this;
		}

		/** Non-mandatory, must be followed by methods in {@link Build}  */
		public Build description(String description) {
			this.description = description;
			return this;
		}

		/** Creates an instance of {@link Address} */
		public Address build() {
			return new Address(this);
		}
	}

	interface Url {
		public Port url(String url);
	}

	interface Port {
		public Build port(int port);
	}

	interface Build {
		public Build protocol(String protocol);
		public Build path(String path);
		public Build description(String description);
		public Address build();
	}

	// TODO: add some get methods here...
}