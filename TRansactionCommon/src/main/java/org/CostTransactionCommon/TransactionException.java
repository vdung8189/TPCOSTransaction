package org.CostTransactionCommon;

/**
 * <p>
 * The interface <code>ITransaction</code> .
 * <p>
 * the interface ITransaction is a common between the servers and the the transaction
 * driver
 * 
 * @author Youssef El Fiad & viet dung
 * @version 1.0 / 12. 2013
 */
public class TransactionException extends Exception {

	public TransactionException(String message) {
		super(message);
	}

}
