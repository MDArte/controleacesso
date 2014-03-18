<%@ page session="true" isErrorPage="true" %>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>


<html:html lang="true">
	<head>
		<title><bean:message key="error.${param.code}.title"/></title>
		<html:base/>
		<meta http-equiv="Content-Type" content="text/html; charset:utf-8" />
<%-- uncomment this to enable the browser 'favorites' icons
		<link rel="shortcut icon" href="my-custom-image.ico"></link>
		<link rel="icon" type="image/gif" href="my-custom-image.gif"></link>
--%>
		<c:import url="${localLayoutPath}/conf/include-stylesheets.jsp"/>
		<c:import url="${localLayoutPath}/conf/include-javascripts.jsp"/>
	</head>

	<body>
		<div id="wrap">
<!-- Begin page content -->
			<div class="container">
				<div class="page-header">
					<h1><bean:message key="error.${param.code}.title"/></h1>
				</div>
				
				<div id="error-content">
					<p class="lead">
						Message: <br/><bean:message key="error.${param.code}.message"/><br/><hr/>
						
						<logic:messagesPresent message="true" property="org.andromda.bpm4struts.errormessages">
							<html:messages id="error" message="true" property="org.andromda.bpm4struts.errormessages">
								Error: <br/>${error}
							</html:messages> 
						</logic:messagesPresent>
						<logic:messagesPresent message="true" property="org.andromda.bpm4struts.warningmessages">
							<html:messages id="warning" message="true" property="org.andromda.bpm4struts.warningmessages">
								Warning: <br/>${warning}
							</html:messages>
						</logic:messagesPresent>

						<c:if test="${param.exception}">
							<br/><br/>Details: <pre>${requestScope["javax.servlet.error.exception"]}</pre>
						</c:if>
						<c:if test="${param.resource}">
							<br/><br/>Details: <pre>${requestScope["javax.servlet.error.request_uri"]}</pre>
						</c:if>
					</p>
				</div>
				
				<div id="push"></div>
			</div>
			
			<div id="footer">
				<div class="container">
				<div id="link">
					<html:link page="/index.jsp" titleKey="error.link.title"><bean:message key="error.link.text"/></html:link>
				</div>
				<p class="muted credit">&copy; MDArte</a>.</p>
			</div>
		</div>
	</body>
</html:html>
