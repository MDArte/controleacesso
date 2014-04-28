
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario;
import java.util.Collection;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.gov.mdarte.controleacesso.ServiceLocator;
import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.util.Util;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.MantemUsuarioControle
 */
public class MantemUsuarioControleImpl extends MantemUsuarioControle
{
    /**
     * @see br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.MantemUsuarioControle#carregaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.CarregaUsuarioForm)
     */
    public final void carregaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.CarregaUsuarioForm form, ViewContainer container) throws Exception
    {
    	if(form.getIdUsuario() == null)
    		return;
    	
    	Collection usuarios = ServiceLocator.instance().getAdministracaoHandlerBI().recuperarUsuario(form.getIdUsuario());
    	
    	if (usuarios != null && !usuarios.isEmpty()){
    		
    		Usuario usuario = (Usuario) usuarios.iterator().next();
	    	form.setIdUsuario(usuario.getId());
    		form.setLogin(usuario.getLogin());
	    	form.setEmail(usuario.getEmail());
	    	if (usuario.getDataValidadeSenha() != null)
	    		form.setDataValidadeSenha(Util.formatDate(usuario.getDataValidadeSenha()));
	    	form.setDataValidadeSenhaAsDate(usuario.getDataValidadeSenha());
    	}
    }

    /**
     * @see br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.MantemUsuarioControle#salvaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.SalvaUsuarioForm)
     */
    public final void salvaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.SalvaUsuarioForm form, ViewContainer container) throws Exception
    {
    	Collection usuarios = ServiceLocator.instance().getAdministracaoHandlerBI().manterUsuario(form.getLogin(), form.getSenha(), form.getEmail(), form.getDataValidadeSenhaAsDate(),form.getIdUsuario());
    	
    	if (Util.checkEmpty(usuarios)) 
    		return;
    	
		Usuario usuario = (Usuario) usuarios.iterator().next();
		
		form.setIdUsuario(usuario.getId());
		
		saveSuccessMessage("mantem.usuario.salvar.sucesso", container);
    }
}
