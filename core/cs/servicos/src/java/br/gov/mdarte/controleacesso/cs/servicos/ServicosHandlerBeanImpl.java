// license-header java merge-point
package br.gov.mdarte.controleacesso.cs.servicos;

import java.util.Collection;
import java.util.List;

import br.gov.mdarte.controleacesso.cd.DAOException;
import br.gov.mdarte.controleacesso.cd.Perfil;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioDAO;
import br.gov.mdarte.controleacesso.cd.UsuarioDAOImpl;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.cs.servicos.ServicosHandler
 */
public class ServicosHandlerBeanImpl
    extends ServicosHandlerBean
    implements ServicosHandler, ServicosHandlerLocal
{

	public  void handleIncluirUsuario (java.lang.String login, java.lang.String senha) throws br.gov.mdarte.controleacesso.cs.servicos.ServicosException {
		
		if (!verificarLogin(login)) {
			
			UsuarioDAO usrDAO = new UsuarioDAOImpl();
			UsuarioImpl usr = new UsuarioImpl(login);
			
			usr.setLogin(login);
			//usr.setSenha(senha);
			
			try
			{
				usrDAO.insert(usr);
			}
			catch (DAOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Login já existe!");
		}
		
	}

	public  java.lang.Boolean handleVerificarLogin (java.lang.String login) throws br.gov.mdarte.controleacesso.cs.servicos.ServicosException {
		
		UsuarioDAO usrDAO = new UsuarioDAOImpl();
		UsuarioVO usrVO = new UsuarioVO();
		
		usrVO.setLogin(login);
		
		try
		{
			List list = usrDAO.filter(usrVO, null);
			
			if (list != null && list.isEmpty()) {
				return Boolean.FALSE;
			} else {
				return Boolean.TRUE;
			}
		}
		catch (DAOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Boolean.FALSE;
	}

	@Override
	public void handleAdicionarPerfil(Usuario usuario, Perfil perfil) throws ServicosException
	{
		// TODO Auto-generated method stub
		UsuarioDAO usrDAO = new UsuarioDAOImpl();
		UsuarioImpl usr = (UsuarioImpl) usuario;
		Collection perfils = usr.getPerfils();
		perfils.add(perfil);
		usr.setPerfils(perfils);
		
		
		try
		{
			usrDAO.update(usr);
			System.out.println("Perfil adicionado");
		}
		catch (DAOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
