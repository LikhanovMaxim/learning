package learning.patterns.creational.requied.fields.builder;

/**
 * @author Maksim_Likhanov
 */
public class Address {
	private String name;
	private String protocol;
	private String url;
	private int port;
	private String path;
	private String description;

	// only builder should be able to create an instance
	private Address(Builder builder) {
		this.name = builder.name;
		this.protocol = builder.protocol;
		this.url = builder.url;
		this.port = builder.port;
		this.path = builder.path;
		this.description = builder.description;
	}

	public static Url builder() {
		return new Builder();
	}

	public static class Builder implements Url, Port, Name, Build{
		private String name;
		private String protocol;
		private String url;
		private int port;
		private String path;
		private String description;

		/** for deprecate this: Address address2 = new Address.Builder().build(); */
		private Builder(){}

		/** Mandatory, must be followed by {@link Port#port(int)}  */
		public Name url(String url) {
			this.url = url;
			return this;
		}

		public Port name(String name) {
			this.name = name;
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
		public Name url(String url);
	}

	interface Name{
		public Port name(String name);
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

	public String getProtocol() {
		return protocol;
	}

	public String getUrl() {
		return url;
	}

	public int getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}
}