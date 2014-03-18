<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<html:html lang="true">

    <head>
        <title>
            <tiles:insert attribute="title" flush="true"/>
        </title>
        <html:base/>
        <meta http-equiv="Content-Type" content="text/html; charset:ISO-8859-1" />

		<c:import url="${localLayoutPath}/conf/include-stylesheets.jsp"/>

		<c:import url="${localLayoutPath}/conf/include-javascripts.jsp"/>
	
	<tiles:insert attribute="style" flush="true"/>
    <tiles:insert attribute="javascript" flush="true"/>
    </head>

    <body onkeypress="keySubmit(event)">
        <div class="container-narrow">
            <tiles:insert attribute="body" flush="true"/>
            <tiles:insert attribute="messages" flush="true"/>
            <c:import url="${localLayoutPath}/conf/rodape.jsp"/>
        </div>
    </body>

</html:html>