// license-header java merge-point
package br.gov.mdarte.controleacesso.cs.servicos;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.action.InsertAction;
import br.gov.mdarte.controleacesso.action.UpdateAction;
import br.gov.mdarte.controleacesso.cd.Perfil;
import br.gov.mdarte.controleacesso.cd.PerfilImpl;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.eo.Situacao;
import br.gov.mdarte.controleacesso.util.Util;
import br.gov.mdarte.controleacesso.vo.PerfilVO;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.cs.servicos.ServicosHandler
 */
public class ServicosHandlerBeanImpl extends ServicosHandlerBean implements ServicosHandler, ServicosHandlerLocal {
	
	private Usuario recuperaUsuario(String login) {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setLoginExato(login);
		
		Collection usuarios = manipulaUsuario(new UsuarioImpl(), new FilterAction(usuarioVO, null));
		
		if(Util.checkEmpty(usuarios)) {
			return null;
		}
		
		return (Usuario) usuarios.iterator().next();
	}
	
	private Perfil recuperaPerfil(String perfil, String sistema) {
		PerfilVO perfilVO = new PerfilVO();
		perfilVO.setNome(perfil);
		perfilVO.setSistema(sistema);
		
		Collection perfils = manipulaPerfil(new PerfilImpl(), new FilterAction(perfilVO, null));
		
		if(Util.checkEmpty(perfils)) {
			return null;
		}
		
		return (Perfil) perfils.iterator().next();
	}
	
	public void handleIncluirUsuario(java.lang.String login, java.lang.String senha, java.lang.String email) throws ServicosHandlerException {
		
		if(Util.checkEmpty(login))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.login.vazio");
		if(Util.checkEmpty(senha))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.senha.vazio");
		if(Util.checkEmpty(email))
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.email.vazia");
		
		if (verificarLogin(login)) {
			throw new ServicosHandlerException("erro.servicos.handler.criar.usuario.login.vazio");
		}
		
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
		
		Usuario usuario = recuperaUsuario(login);
		
		if(usuario == null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void handleAdicionarPerfil(String login, String nomePerfil, String sistema) throws ServicosHandlerException {
		
		if(Util.checkEmpty(login))
			throw new ServicosHandlerException("erro.servicos.handler.adiciona.perfil.login.vazio");
		
		if(Util.checkEmpty(nomePerfil))
			throw new ServicosHandlerException("erro.servicos.handler.adiciona.perfil.perfil.vazio");
		
		if(Util.checkEmpty(sistema))
			throw new ServicosHandlerException("erro.servicos.handler.adiciona.perfil.sistema.vazio");
		
		Usuario usuario = recuperaUsuario(login);
		
		if(usuario == null) {
			throw new ServicosHandlerException("erro.servicos.handler.adiciona.perfil.usuario.nao.encontrado");
		}
		
		Perfil perfil = recuperaPerfil(nomePerfil, sistema);
		
		if(perfil == null) {
			throw new ServicosHandlerException("erro.servicos.handler.adiciona.perfil.perfil.nao.encontrado");
		}
		
		if(usuario.getPerfils() == null)
			usuario.setPerfils(new ArrayList());
		
		usuario.getPerfils().add(perfil);
		
		manipulaUsuario(usuario, new UpdateAction());
	}

	@Override
	public void handleAtivarUsuario(String login) {
		
		Usuario usuario = recuperaUsuario(login);
		
		usuario.setSituacao(Situacao.ATIVO);
		
		manipulaUsuario(usuario, new UpdateAction());
		
	}

	@Override
	public void handleBloquearUsuario(String login) {
		
		Usuario usuario = recuperaUsuario(login);
		
		usuario.setSituacao(Situacao.BLOQUEADO);
		
		manipulaUsuario(usuario, new UpdateAction());
		
	}
}
