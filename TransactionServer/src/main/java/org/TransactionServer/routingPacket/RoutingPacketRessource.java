package org.TransactionServer.routingPacket;

import java.util.HashMap;

import org.TRansactionCommon.Paquet;
import org.TransactionServerCommon.IRoutingPacketRessource;

public class RoutingPacketRessource implements IRoutingPacketRessource {
	
	public HashMap<String, String> maMapMaskNetwork = new HashMap<String, String>();
	public HashMa<String, String> maMapNetwork = new HashMap<String, String>();
	public static String INVOKERROR = "unsuccessfully invoked";
	
	
	public RoutingPacketRessource() {
		
	}

	public Paquet setTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() - 1);
		return pqt;
	}

	public Paquet unSetTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() + 1);
		return pqt;
	}
	
	public Paquet routingPacket(Paquet paquet) {
		
		if (paquet.getTtl() == 0) {
			paquet.setBourrage(INVOKERROR);
			paquet=this.unSetTTL(paquet);
			return paquet;
		}
		else if(paquet.getBourrage().equals("reseux1")){
			paquet.setBourrage("Paquet recus pas la machine" + paquet.getIpDestination() +"du reseux 1");
			paquet=this.setTTL(paquet);
			return paquet;	
		}
		else{
			paquet.setBourrage("Paquet router vers la machine" + paquet.getIpDestination() +"du reseux 2");
			paquet=this.setTTL(paquet);
			return paquet;	
		}

	}

}
