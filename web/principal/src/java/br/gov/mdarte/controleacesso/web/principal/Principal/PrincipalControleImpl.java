
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.principal.Principal;
import br.gov.mdarte.controleacesso.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;

/**
 * @see br.gov.mdarte.controleacesso.web.principal.Principal.PrincipalControle
 */
public class PrincipalControleImpl extends PrincipalControle
{
    /**
     * @see br.gov.mdarte.controleacesso.web.principal.Principal.PrincipalControle#insereTraceCA(br.gov.mdarte.controleacesso.web.principal.Principal.InsereTraceCAForm)
     */
    public final void insereTraceCA(br.gov.mdarte.controleacesso.web.principal.Principal.InsereTraceCAForm form, ViewContainer container) throws Exception
    {
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
