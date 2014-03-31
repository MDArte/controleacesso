
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.detalharUsuario;
import br.gov.mdarte.controleacesso.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;

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
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
