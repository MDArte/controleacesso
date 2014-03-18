<%@ page session="true" isErrorPage="true" %>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<html:html lang="true">
	<head>
        <title>StackTrace</title>
        <html:base/>
        <c:import url="${localLayoutPath}/conf/include-stylesheets.jsp"/>
        <c:import url="${localLayoutPath}/conf/include-javascripts.jsp"/>
    </head>

    <body>
        <div id="wrap">
            <!-- Begin page content -->
            <div class="container">
                <div class="page-header">
                    <div id="title"><h1>Stacktrace</h1></div>
                </div>
                <div class="error">
                    <pre><%=(String)request.getSession().getServletContext().getContext("/controleacesso").getAttribute("stackTrace")%></pre>
                </div>
            </div>            
        </div>
    </body>
</html:html>    