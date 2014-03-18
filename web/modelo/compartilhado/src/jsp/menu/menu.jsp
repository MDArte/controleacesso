<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ include file="/taglib-imports.jspf" %>

<% String url = request.getScheme( ) + "://" + request.getServerName( ) + 
	(request.getServerPort( ) != 80 ? ":" + request.getServerPort( ) : "" );   
	url += "/controleacesso"; 
%>

<SCRIPT LANGUAGE="Javascript"> 	 
function sair( )
{
	var msg = <%out.print("\"");%><bean:message key="saida.sistema.confirma.saida"/><%out.print("\"");%>;
	if( confirm( msg ) ) 
		window.location = "<%=url%>/secure/SaidaSistema.do";
}
</script> 


<!--<div id="barraNav1">
	<div id="breadCrumb">
		<%
			Iterator breadCrumbIt = null;
			ArrayList breadCrumbCollection = (ArrayList) session.getAttribute("breadCrumb"); 
			
			if (breadCrumbCollection != null){
				
				breadCrumbIt = breadCrumbCollection.iterator();
				 
				while (breadCrumbIt.hasNext()) {	   
				
	
					out.print(breadCrumbIt.next().toString());
	
	
				} 
			}
		
		%>
	</div>

</div>--> 
<% 
       	java.util.HashMap paramsPrincipal = new java.util.HashMap();
		paramsPrincipal.put("modulo", "");
		paramsPrincipal.put("path","");
		pageContext.setAttribute("paramsPrincipal", paramsPrincipal);
%>
 <div class="masthead">
	<ul class="nav nav-pills pull-right">
		<li class="active"><html:link page="/ForwardAction.do" name="paramsPrincipal" scope="page">Home</html:link></li>
		<li><a href="<%=url%>/secure/TrocaDeSenhaObrigatoriaProcessar.do?menu=true"><bean:message key="login.troca.de.senha.title"/></a></li>
		<li>
			<a href="<%=url%>/secure/NovaConexao.do" >
				<bean:message key="login.sair.link"/>
				<%-- <span class='menuFechar'/> --%>
		    </a>
		</li>
	</ul>
	<h3 class="muted">controleacesso</h3>
	<hr/>
</div>
