// license-header java merge-point
package br.gov.mdarte.controleacesso.cs.administracao;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;

import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.action.InsertAction;
import br.gov.mdarte.controleacesso.action.InsertOrUpdateAction;
import br.gov.mdarte.controleacesso.action.SelectAction;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.util.Util;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.cs.administracao.AdministracaoHandler
 */
public class AdministracaoHandlerBeanImpl
    extends AdministracaoHandlerBean
    implements AdministracaoHandler, AdministracaoHandlerLocal
{

	private Usuario recuperaUsuario(String login) {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setLogin(login);
		
		Collection usuarios = manipulaUsuario(new UsuarioImpl(), new FilterAction(usuarioVO, null));
		
		if(Util.checkEmpty(usuarios)) {
			return null;
		}
		
		return (Usuario) usuarios.iterator().next();
	}
	
	public  java.util.Collection handleIncluirUsuario (java.lang.String login, java.lang.String senha, java.lang.String email, java.lang.Integer paginacao) throws br.gov.mdarte.controleacesso.cs.administracao.AdministracaoHandlerException {
		
		if(Util.checkEmpty(senha))
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.senha.vazio");
		if(Util.checkEmpty(email))
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.email.vazia");
		if (verificarLogin(login)) {
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.login.vazio");
		}
		
		UsuarioImpl usuario;
		
		try {
			usuario = new UsuarioImpl(login, senha, email);
		} catch (NoSuchAlgorithmException exception) {
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.algoritmo.senha.nao.encontrado", exception);
		}

		manipulaUsuario(usuario, new InsertAction());
		
		return null;
	}
	
	public java.lang.Boolean handleVerificarLogin(java.lang.String login) throws AdministracaoHandlerException {
		
		if(Util.checkEmpty(login))
			throw new AdministracaoHandlerException("erro.administracao.handler.verifica.login.login.vazio");
		
		Usuario usuario = recuperaUsuario(login);
		
		if(usuario == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public Collection handleManterUsuario(String login, String senha,
			String email, Date dataValidadeSenha, Long idUsuario,
			Integer paginacao) {
		
		if(verificarLogin(login) && idUsuario == null)
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.login.vazio");
		if(Util.checkEmpty(senha) && idUsuario == null)
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.senha.vazio");
		if(Util.checkEmpty(email))
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.email.vazia");
		
		UsuarioImpl usuario;
		
		try {
			if (idUsuario == null){
				usuario = new UsuarioImpl(login, senha, email);
			}
			else{
				Collection usuarios = handleRecuperarUsuario(idUsuario, null);
				usuario = (UsuarioImpl) usuarios.iterator().next();
				
				if (recuperaUsuario(login) != null && (recuperaUsuario(login).getId() != usuario.getId()))
					throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.usuario.ja.utilizado");
				
				usuario.setLogin(login);
				usuario.setEmail(email);
				if(!Util.checkEmpty(senha))
					usuario.setSenha(senha);
			}
			usuario.setDataValidadeSenha(dataValidadeSenha);
		} catch (NoSuchAlgorithmException exception) {
			throw new AdministracaoHandlerException("erro.administracao.handler.criar.usuario.algoritmo.senha.nao.encontrado", exception);
		}
		
		return manipulaUsuario(usuario, new InsertOrUpdateAction());
	}

	@Override
	public Collection handleRecuperarUsuarios(String login, String email,
			Integer paginacao) {
		
		UsuarioVO usuario = new UsuarioVO();
		usuario.setLogin(login);
		usuario.setEmail(email);
		return manipulaUsuario(new UsuarioImpl(), new FilterAction(usuario, paginacao));
	}

	@Override
	public Collection handleRecuperarUsuario(Long idUsuario, Integer paginacao) {

		UsuarioImpl usuario = new UsuarioImpl();
		usuario.setId(idUsuario);
		return manipulaUsuario(usuario, new SelectAction());
	}
}
