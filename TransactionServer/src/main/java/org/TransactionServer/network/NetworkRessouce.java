package org.TransactionServer.network;

import java.util.HashMap;

import javax.jws.WebService;
import org.TRansactionCommon.Paquet;
import org.TransactionServerCommon.INetworkRessouce;

@WebService(endpointInterface = "org.TransactionServerCommon.INetworkRessouce")
public class NetworkRessouce implements INetworkRessouce {
	
	public HashMap <String, String> maMapMaskNetwork = new HashMap<String, String>();
	public HashMap<String, String> maMapNetwork = new HashMap<String, String>();
	public static String INVOKERROR = "unsuccessfully invoked";

	
	public NetworkRessouce() {
		maMapMaskNetwork.put("255.255.255.1", "reseux1");
		maMapMaskNetwork.put("255.255.254.0", "reseux2");

		maMapNetwork.put("192.168.48.20", "255.255.255.1");
		maMapNetwork.put("192.168.48.21", "255.255.255.1");
		maMapNetwork.put("192.168.48.22", "255.255.255.1");
		maMapNetwork.put("192.168.48.23", "255.255.255.0");
		maMapNetwork.put("192.168.48.24", "255.255.255.0");
		maMapNetwork.put("192.168.48.25", "255.255.255.0");
	}
	
	public Paquet setTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() - 1);
		return pqt;
	}

	public Paquet unSetTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() + 1);
		return pqt;
	}
	
	public Paquet getNetwork(Paquet paquet) {
		if (paquet.getTtl() == 0) {
			paquet.setBourrage(INVOKERROR);
			paquet=this.unSetTTL(paquet);
			return paquet;
		}
		else{
			String mask = maMapNetwork.get(paquet.getIpDestination());
			String reseux = maMapMaskNetwork.get(mask);
			paquet.setBourrage(reseux);
			paquet=this.setTTL(paquet);
			return paquet;	
		}

	}

}
