package model;

public class Korisnik {
	
	private String username;
	private String password;
	private String ime;
	private String prezime;
	private String uloga;
	private String email;
	
	
	public Korisnik(String username, String password, String ime,
			String prezime, String email, String uloga) {
		super();
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.uloga = uloga;
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getUloga() {
		return uloga;
	}


	public void setUloga(String uloga) {
		this.uloga = uloga;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
