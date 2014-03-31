
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario;
import br.gov.mdarte.controleacesso.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;

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
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

    /**
     * @see br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.MantemUsuarioControle#salvaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.SalvaUsuarioForm)
     */
    public final void salvaUsuario(br.gov.mdarte.controleacesso.web.administracao.usuario.manterUsuario.SalvaUsuarioForm form, ViewContainer container) throws Exception
    {
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
