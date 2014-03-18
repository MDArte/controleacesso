package br.gov.mdarte.controleacesso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cache.Cache;
import org.hibernate.impl.SessionFactoryImpl;

import accessControl.ControleAcesso;
import br.gov.mdarte.controleacesso.accessControl.ControleAcessoImpl;
import accessControl.Perfil;
import accessControl.ServicosSingleton;

public class UtilServiceHandlerBeanImpl extends UtilServiceHandlerBean {

	private static Log s_log = LogFactory.getLog(UtilServiceHandlerBeanImpl.class);

	public void clearSecondCache() {
		Map cacheRegionsMap = ((SessionFactoryImpl)br.gov.mdarte.controleacesso.cd.AbstractDAO.sessionFactory).getAllSecondLevelCacheRegions();
		Collection<Cache> cacheRegions = cacheRegionsMap.values();
		for (Cache cache : cacheRegions)
			cache.clear();
	}

	public void reloadAccessControl() {

		// clear the cache before reload the access control.
		clearSecondCache();

		try
		{
            ControleAcessoImpl controleAcesso = new ControleAcessoImpl();
            HashMap<String, ControleAcesso> controles = ServicosSingleton.instance().getControles();
            if(controles == null){
            	controles = new HashMap<String, ControleAcesso>();
            }
            controles.put("controleacesso", controleAcesso);
            ServicosSingleton.instance().setControles(controles);
            HashMap listaServicosProjeto = controleAcesso.listaServicos();
            HashMap<String, HashMap<String, java.util.Collection<Perfil>>> listaServicos = ServicosSingleton.instance().getServicos();
            if(listaServicos == null){
            	listaServicos = new HashMap<String, HashMap<String, java.util.Collection<Perfil>>>();
            }
            listaServicos.put("controleacesso", listaServicosProjeto);
            ServicosSingleton.instance().setServicos(listaServicos);
            
            HashMap<String, Boolean> demanda = ServicosSingleton.instance().getDemanda();
            if(demanda == null){
            	demanda = new HashMap<String, Boolean>();
            }
            demanda.put("controleacesso", false);  
            ServicosSingleton.instance().setDemanda(demanda);            
		}
		catch( Exception e )
		{
			s_log.error("Nao foi possivel listar os servicos", e);
		}
	}
}
