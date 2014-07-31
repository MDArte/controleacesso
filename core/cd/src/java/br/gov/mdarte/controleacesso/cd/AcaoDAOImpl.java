
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
import org.hibernate.Criteria;
import org.hibernate.Session;

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
    protected Object handleRecuperarAcoes(Session session,Integer paginacao, Integer linhas, Integer paginas) throws DAOException {
		Criteria criterios = session.createCriteria(AcaoImpl.class);
	
		return criterios;
	}

}
