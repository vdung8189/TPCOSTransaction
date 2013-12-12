package org.TRansactionCommon;

/**
 * <p>
 * The class <code>Paquet</code> .
 * <p>
 * the class Paquet is a common between the servers and the the transaction
 * driver
 * 
 * @author Youssef El Fiad & viet dung
 * @version 1.0 / 12. 2013
 */
public class Paquet {
	
	
	private String ipDestination;
	private int ttl;
	private String protocole;
	private String donnees;
	private String bourrage;

	public Paquet(String ipDestination, int ttl, String protocole,
			String donnees, String bourrage, String ipSource) {
		this.ipDestination = ipDestination;
		this.ttl = ttl;
		this.protocole = protocole;
		this.donnees = donnees;
		this.bourrage = bourrage;
		this.ipSource = ipSource;
	}

	private String ipSource;

	public String getIpSource() {
		return ipSource;
	}

	public void setIpSource(String ipSource) {
		this.ipSource = ipSource;
	}

	public String getIpDestination() {
		return ipDestination;
	}

	public void setIpDestination(String ipDestination) {
		this.ipDestination = ipDestination;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public String getProtocole() {
		return protocole;
	}

	public void setProtocole(String protocole) {
		this.protocole = protocole;
	}

	public String getDonnees() {
		return donnees;
	}

	public void setDonnees(String donnees) {
		this.donnees = donnees;
	}

	public String getBourrage() {
		return bourrage;
	}

	public void setBourrage(String bourrage) {
		this.bourrage = bourrage;
	}

}
