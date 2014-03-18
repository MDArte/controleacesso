<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<!DOCTYPE html>
<html:html lang="true">
	<head>
		<tiles:insert attribute="head" flush="true"/>
		
		<title>
			<tiles:insert attribute="title" flush="true"/>
		</title>
		<html:base/>
		<meta http-equiv="Content-Type" content="text/html; charset:ISO-8859-1" />
<%-- uncomment this to enable the browser 'favorites' icons
		<link rel="shortcut icon" href="my-custom-image.ico"></link>
		<link rel="icon" type="image/gif" href="my-custom-image.gif"></link>
--%>

			<c:import url="${localLayoutPath}/conf/include-stylesheets.jsp"/>

			<c:import url="${localLayoutPath}/conf/include-javascripts.jsp"/>
	
		<tiles:insert attribute="style" flush="true"/>
		<tiles:insert attribute="javascript" flush="true"/>
	
	</head>

	<body onkeypress="keySubmit(event)">
		<div class="container">
			<c:import url="${localLayoutPath}/conf/cabecalho.jsp" />
			<tiles:insert attribute="menu" flush="true"/>
			<tiles:insert attribute="messages" flush="true"/>
			<tiles:insert attribute="pathway" flush="true"/>
			<tiles:insert attribute="vars" flush="true"/>
			<div class="container">
				<div class="row">
					<div class="span12">
						<div id="form">
							<tiles:insert attribute="body" flush="true"/>
						</div>
						<tiles:insert attribute="tables" flush="true"/>
						<tiles:insert attribute="other" flush="true"/>
					</div>
				</div>
			</div>
			<c:import url="${localLayoutPath}/conf/rodape.jsp"/>
		</div>
	</body>

</html:html>
