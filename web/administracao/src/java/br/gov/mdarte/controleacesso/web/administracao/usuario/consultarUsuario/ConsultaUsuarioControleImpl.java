
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.gov.mdarte.controleacesso.ServiceLocator;
import br.gov.mdarte.controleacesso.action.FilterAction;
import br.gov.mdarte.controleacesso.action.SelectAction;
import br.gov.mdarte.controleacesso.cd.Usuario;
import br.gov.mdarte.controleacesso.cd.UsuarioImpl;
import br.gov.mdarte.controleacesso.util.Constantes;
import br.gov.mdarte.controleacesso.vo.UsuarioVO;
import br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario.ConsultaUsuarioControle;

/**
 * @see br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario.ConsultaUsuarioControle
 */
public class ConsultaUsuarioControleImpl extends ConsultaUsuarioControle
{
    /**
     * @see br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario.ConsultaUsuarioControle#consultaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario.ConsultaUsuarioForm)
     */
    public final void consultaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario.ConsultaUsuarioForm form, ViewContainer container) throws Exception
    {
    	Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	
    	Collection usuarios = ServiceLocator.instance().getAdministracaoHandlerBI().recuperarUsuarios(form.getLogin(),form.getEmail(),paginacao);
    
    	ArrayList<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();
    	
    	if(usuarios != null && !usuarios.isEmpty()){
	    	for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
	    		
	    		Usuario user = (Usuario) iterator.next();
	    		
	    		UsuarioVO usuarioVO = new UsuarioVO();
	    		usuarioVO.setLogin(user.getLogin());
	        	usuarioVO.setEmail(user.getEmail());
	        	usuarioVO.setIdUsuario(user.getId());
	        	usuarioVO.setSituacao(user.getSituacao());
	    		
	    		usuariosVO.add(usuarioVO);
	    	}
    	}
    	form.setUsuarios(usuariosVO);
    }
}
