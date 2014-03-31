
// license-header java merge-point
/**
 * Attention: Generated source! Do not modify by hand!
 */
package br.gov.mdarte.controleacesso.cd;



/**
 * <p>
 * Factory class.
 * Is able to find and create objects of type Usuario.
 * The Hibernate <em>subclass</em> inheritance
 * strategy is followed.
 * Those can be described as follows:
 * </p>
 * @see br.gov.mdarte.controleacesso.cd.Usuario
 */
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.gov.mdarte.controleacesso.vo.UsuarioVO;
import br.ufrj.coppetec.DataObject;
 
public class UsuarioDAOImpl extends UsuarioDAO {


    protected Object handleFilter(DataObject vo) throws br.gov.mdarte.controleacesso.cd.DAOException {
    	
    	Session session = AbstractDAO.currentSession();
    	Criteria criterios = session.createCriteria(UsuarioImpl.class);
    	if(vo instanceof UsuarioVO)
		{
			UsuarioVO usuarioVO = (UsuarioVO) vo;
			
			if(usuarioVO.getLogin() != null && !usuarioVO.getLogin().equals(""))
			{
				criterios.add(Restrictions.ilike("login", usuarioVO.getLogin(),MatchMode.ANYWHERE));
			}
			
		}

		return criterios;
    }
    
    protected org.hibernate.Criteria handleXmlExport(br.ufrj.coppetec.ValueObject vo, org.hibernate.Session session) throws br.gov.mdarte.controleacesso.cd.DAOException {
	return null;
    }

	@Override
	protected Object handleRecuperarUsuario(Session session, String login) throws DAOException {
		Criteria criterios = session.createCriteria(UsuarioImpl.class);
		criterios.add(Restrictions.eq("login", login));
		
		Collection usuarios = criterios.list();
		
		if(usuarios != null && !usuarios.isEmpty())
			return usuarios.iterator().next();
		
		return null;
	}
}
