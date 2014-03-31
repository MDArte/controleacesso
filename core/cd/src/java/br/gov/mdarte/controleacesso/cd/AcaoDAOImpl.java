
// license-header java merge-point
/**
 * Attention: Generated source! Do not modify by hand!
 */
package br.gov.mdarte.controleacesso.cd;



/**
 * <p>
 * Factory class.
 * Is able to find and create objects of type Acao.
 * The Hibernate <em>subclass</em> inheritance
 * strategy is followed.
 * Those can be described as follows:
 * </p>
 * @see br.gov.mdarte.controleacesso.cd.Acao
 */
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.gov.mdarte.controleacesso.cd.DAOException;
import br.ufrj.coppetec.DataObject; 
 
public class AcaoDAOImpl extends AcaoDAO {


    protected Object handleFilter(DataObject vo) throws br.gov.mdarte.controleacesso.cd.DAOException {		
       return null;
    }
    
    protected org.hibernate.Criteria handleXmlExport(br.ufrj.coppetec.ValueObject vo, org.hibernate.Session session) throws br.gov.mdarte.controleacesso.cd.DAOException {
	return null;
    }
    
    protected Object handleSomething(DataObject vo) throws br.gov.mdarte.controleacesso.cd.DAOException {		
        return null;
    }
    
    @Override
    protected Object handleRecuperarAcoes(Session session, String sistema) throws DAOException {
		Criteria criterios = session.createCriteria(AcaoImpl.class);
		criterios.createAlias("sistema", "sistema");
		
		if(sistema != null)
			criterios.add(Restrictions.eq("sistema.nome", sistema));
		
		return criterios;
	}

}
