package org.TransactionServer.iptables;

import java.util.Vector;

import org.TRansactionCommon.Paquet;
import org.TransactionServerCommon.IIPTablesResource;
import javax.jws.WebService;

@WebService(endpointInterface = "org.TransactionServerCommon.IIPTablesResource")
public class IPTablesResource implements IIPTablesResource {

	Vector<String> networkRules = new Vector<String>();
	public static String INVOKERROR = "unsuccessfully invoked";
	public static String INVOKSUCCESS = "successfully invoked";

	public IPTablesResource() {
		networkRules.add("192.168.48.20");
		networkRules.add("192.168.48.21");
		networkRules.add("192.168.48.22");
		networkRules.add("192.168.48.23");
		networkRules.add("192.168.48.24");
		networkRules.add("192.168.48.25");
	}

	public boolean verifyRules(String addresSource) {
		for (String address : networkRules) {
			if (address.equals(addresSource)) {
				return true;
			}
		}
		return false;
	}

	public Paquet setTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() - 1);
		return pqt;
	}

	public Paquet unSetTTL(Paquet pqt) {
		pqt.setTtl(pqt.getTtl() + 1);
		return pqt;
	}

	public Paquet getIpTables(Paquet paquet) {
		boolean isPaquetExsits = verifyRules(paquet.getIpSource());
		if (!isPaquetExsits || paquet.getTtl() == 0) {
			paquet.setBourrage(INVOKERROR);
			String ipDestination = paquet.getIpSource();
			String ipSource = paquet.getIpDestination();
			paquet.setIpSource(ipDestination);
			paquet.setIpDestination(ipSource);
			paquet = this.unSetTTL(paquet);
			
			return paquet;
		}
		else{
			paquet.setBourrage(INVOKSUCCESS);
			paquet=this.setTTL(paquet);
			return paquet;
		}
	}

}
