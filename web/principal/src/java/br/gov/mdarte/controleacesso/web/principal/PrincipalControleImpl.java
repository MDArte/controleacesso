
// license-header java merge-point
package br.gov.mdarte.controleacesso.web.principal;

import org.andromda.presentation.bpm4struts.ViewContainer;

/**
 * @see br.gov.mdarte.controleacesso.web.principal.PrincipalControle
 */
public class PrincipalControleImpl extends PrincipalControle
{
    /**
     * @see br.gov.mdarte.controleacesso.web.principal.PrincipalControle#insereTraceCA(br.gov.mdarte.controleacesso.web.principal.InsereTraceCAForm)
     */
    public final void insereTraceCA(br.gov.mdarte.controleacesso.web.principal.InsereTraceCAForm form, ViewContainer container) throws Exception
    {
    	/*Caso seja necessario usar paginacao		
    		Integer paginacao = ((Double)container.getAttribute(util.Constantes.PARAMETRO_PAGINA)).intValue();
    	*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
