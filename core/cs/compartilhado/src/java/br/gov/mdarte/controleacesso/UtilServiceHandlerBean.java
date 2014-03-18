package br.gov.mdarte.controleacesso;

import javax.ejb.EJBException;
import javax.naming.NamingException;


public abstract class UtilServiceHandlerBean implements javax.ejb.SessionBean, UtilServiceHandlerBI{
    
	    
	public abstract void clearSecondCache();

	public abstract void reloadAccessControl();
   
    protected javax.ejb.SessionContext ctx = null;

    public void setSessionContext( javax.ejb.SessionContext ctx )
    {
        this.ctx = ctx;
    } 
    
   // ---------------- create methods -------------------------

    public void ejbCreate ()
           throws javax.ejb.CreateException
    {
    }

    public void ejbPostCreate ()
           throws javax.ejb.CreateException
    {
    }

    public void ejbRemove()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbActivate()
    {
    }
}