package entity;

public class Client {

	private String token;
	private String key;
	private String name;

	public Client() {

	}

	public Client(String token, String key, String name) {
		this.token = token;
		this.key = key;
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
