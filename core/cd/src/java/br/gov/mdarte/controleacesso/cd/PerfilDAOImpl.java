
// license-header java merge-point
/**
 * Attention: Generated source! Do not modify by hand!
 */
package br.gov.mdarte.controleacesso.cd;



/**
 * <p>
 * Factory class.
 * Is able to find and create objects of type Perfil.
 * The Hibernate <em>union-subclass</em> inheritance
 * strategy is followed.
 * Those can be described as follows:
 * </p>
 * @see br.gov.mdarte.controleacesso.cd.Perfil
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

import br.ufrj.coppetec.DataObject;
 
public class PerfilDAOImpl extends PerfilDAO {


    protected Object handleFilter(DataObject vo) throws br.gov.mdarte.controleacesso.cd.DAOException {		
       return null;
    }
    
    protected org.hibernate.Criteria handleXmlExport(br.ufrj.coppetec.ValueObject vo, org.hibernate.Session session) throws br.gov.mdarte.controleacesso.cd.DAOException {
	return null;
    }
    
    @Override
    protected Object handleRecuperarSuperPerfil(Session session, String sistema) throws DAOException {
    	ProjectionList projectionList = Projections.projectionList();
		
		projectionList.add(Projections.property("id"));		
		
		
    	
		Criteria criterios = session.createCriteria(PerfilImpl.class);
		criterios.createAlias("sistema", "sistema");
		
		criterios.add(Restrictions.eq("superUsuario",  Boolean.TRUE));
		
		criterios.setProjection(projectionList);
		
		if(sistema != null)
			criterios.add(Restrictions.eq("sistema.nome", sistema));
		
		ResultTransformer resultTransformer = new ResultTransformer()
		{
			
			public Object transformTuple(Object[] result, String[] arg1)
			{
				return result;
			}

		
			public List transformList(List resultado)
			{
				List idPerfis = new ArrayList<Long>();
				
				for(Object[] result:(List<Object[]>) resultado)
				{
					Collection rows = Arrays.asList(result);						
					Iterator iteratorRow = rows.iterator();
					
					idPerfis.add((Long) iteratorRow.next());	
				}
				
				return idPerfis;
			}
		};
		
		criterios.setResultTransformer(resultTransformer);
		
		return criterios;
	}

}
