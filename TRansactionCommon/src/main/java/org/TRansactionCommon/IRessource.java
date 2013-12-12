package org.TRansactionCommon;

/**
 * <p>
 * The class <code>IRessource</code> .
 * <p>
 * the class IRessource is a common between the servers and the the transaction
 * driver
 * 
 * @author Youssef El Fiad & viet dung
 * @version 1.0 / 12. 2013
 */
public interface IRessource {
	
	public boolean getIpTables(Paquet paquet);
	public Paquet getNetwork(Paquet paquet);
	public Paquet routingPacket(Paquet paquet);
	
	public Paquet unGetIpTables(Paquet paquet);
	public Paquet unGetNetwork(Paquet paquet);
	public Paquet unRoutingPacket(Paquet paquet);

}
