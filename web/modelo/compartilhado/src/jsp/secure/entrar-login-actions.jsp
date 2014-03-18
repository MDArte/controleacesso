<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<script type="text/javascript" src="/controleacesso/layout/${layout}/javaScripts/jstorage.js"></script>

<!--<div class="container">-->
	<html:form action="/secure/EntrarLoginValidar" styleClass="form-signin"  method="post" enctype="multipart/form-data" >
		<h2 class="form-signin-heading"><bean:message key="login.entrar.login.title"/></h2>
			
		<input type="text" id="login" name="login"  property="login" class="form-control" autofocus="" placeholder="<bean:message key="login.entrar.login.param.login"/>"/>

		<input type="password" id="senha" name="senha" property="senha" class="form-control" required="" placeholder="<bean:message key="login.entrar.login.param.senha"/>"/>

		<label class="checkbox">
			<input id="remember" type="checkbox" value="remember-me" onchange="clearForm();" >
			Remember me
		</label>
			
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in" name="commit" onclick="saveUsername();setaAcao('/secure/EntrarLoginValidar', 'validateEntrarLoginValidarFormImpl', true);" property="loginEntrarLoginValidarForm"/>

		<html:hidden property="parametrosLogin" styleId="parametrosLogin"/> 

		<% if (request.getParameter("nextPath") != null) { %>
			<html:hidden property="nextPath" styleId="nextPath" value="<%= request.getParameter("nextPath") %>"/>
		<% } %>
	</html:form>
<!-- </div> -->

<script type="text/javascript" src="entrar-login.js"></script>
