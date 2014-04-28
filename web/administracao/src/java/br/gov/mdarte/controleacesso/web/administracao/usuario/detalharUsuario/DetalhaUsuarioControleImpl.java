
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.gov.mdarte.controleacesso.ServiceLocator;
import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.util.Util;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;

/**
 * @see br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario.DetalhaUsuarioControle
 */
public class DetalhaUsuarioControleImpl extends DetalhaUsuarioControle
{
    /**
     * @see br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario.DetalhaUsuarioControle#carregaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario.CarregaUsuarioForm)
     */
    public final void carregaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario.CarregaUsuarioForm form, ViewContainer container) throws Exception
    {
    	if(form.getIdUsuario() == null)
    		return;
    	
    	Collection usuarios = ServiceLocator.instance().getAdministracaoHandlerBI().recuperarUsuario(form.getIdUsuario());
    	
    	if (usuarios != null && !usuarios.isEmpty()){
    		
    		Usuario usuario = (Usuario) usuarios.iterator().next();
			form.setLogin(usuario.getLogin());
			form.setEmail(usuario.getEmail());
			if (usuario.getDataValidadeSenha() != null)
				form.setDataValidadeSenha(Util.formatDate(usuario.getDataValidadeSenha()));
    		}
    	}
}
