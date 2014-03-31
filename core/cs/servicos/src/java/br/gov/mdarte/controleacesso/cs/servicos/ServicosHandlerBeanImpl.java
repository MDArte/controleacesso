// license-header java merge-point
package br.gov.mdarte.controleacesso.cs.servicos;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.action.InsertAction;
import br.gov.mdarte.controleacesso.cd.DAOException;
import br.gov.mdarte.controleacesso.cd.Perfil;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioDAO;
import br.gov.mdarte.controleacesso.cd.UsuarioDAOImpl;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.util.Util;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.cs.servicos.ServicosHandler
 */
public class ServicosHandlerBeanImpl extends ServicosHandlerBean implements ServicosHandler, ServicosHandlerLocal {

	public void handleIncluirUsuario(java.lang.String login, java.lang.String senha, java.lang.String email) throws ServicosHandlerException {
		
		if (verificarLogin(login)) {
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.login.vazio");
		}
		
		if(Util.checkEmpty(login))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.login.vazio");
		if(Util.checkEmpty(senha))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.senha.vazio");
		if(Util.checkEmpty(email))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.email.vazia");
		
		UsuarioImpl usuario;
		
		try {
			usuario = new UsuarioImpl(login, senha, email);
		} catch (NoSuchAlgorithmException exception) {
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.algoritmo.senha.nao.encontrado", exception);
		}

		manipulaUsuario(usuario, new InsertAction());
	}

	public java.lang.Boolean handleVerificarLogin(java.lang.String login) throws ServicosHandlerException {
		
		if(Util.checkEmpty(login))
			throw new ServicosHandlerException("erro.servicos.handler.verifica.login.login.vazio");
		
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setLoginExato(login);
		
		Collection usuarios = manipulaUsuario(new UsuarioImpl(), new FilterAction(usuarioVO, null));
		
		if(Util.checkEmpty(usuarios)) {
			return false;
		}
		
		return true;
	}

	@Override
	public void handleAdicionarPerfil(Usuario usuario, Perfil perfil) throws ServicosHandlerException {
		UsuarioDAO usrDAO = new UsuarioDAOImpl();
		UsuarioImpl usr = (UsuarioImpl) usuario;
		Collection perfils = usr.getPerfils();
		perfils.add(perfil);
		usr.setPerfils(perfils);

		try {
			usrDAO.update(usr);
			System.out.println("Perfil adicionado");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
