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


public interface ITransaction {
	
	public ITransactionCoordination getCoordinator();
	public void begin()  throws TransactionException;
	public void commit() throws TransactionException;
	public void rollback() throws TransactionException;
}
