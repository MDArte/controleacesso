package br.gov.mdarte.controleacesso;

public interface UtilServiceHandler extends javax.ejb.EJBObject, UtilServiceHandlerBI{

	public void clearSecondCache() throws java.rmi.RemoteException;

	public void reloadAccessControl() throws java.rmi.RemoteException;
}
