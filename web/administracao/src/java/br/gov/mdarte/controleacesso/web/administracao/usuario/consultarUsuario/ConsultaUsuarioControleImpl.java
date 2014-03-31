
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.consultarUsuario;
import br.gov.mdarte.controleacesso.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;

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
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
