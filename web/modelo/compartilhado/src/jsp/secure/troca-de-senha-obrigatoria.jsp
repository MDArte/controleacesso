<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="main.layout2">

    <tiles:put name="title" type="string">
        <bean:message key="login.troca.de.senha.obrigatoria.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/secure/troca-de-senha-obrigatoria.css"/>"></link>
    </tiles:put>

    <tiles:put name="javascript" type="string">
        <script type="text/javascript" language="Javascript1.1" src="<html:rewrite page="/form-validation.jsp"/>"></script>
        <html:javascript formName="loginTrocaDeSenhaObrigatoriaProcessarForm" method="validateTrocaDeSenhaObrigatoriaProcessarFormImpl" dynamicJavascript="true" staticJavascript="false" htmlComment="true" cdata="false"/>
    	<script type="text/javascript" language="Javascript1.1">
        //<!--
            var HINTS_ITEMS = {
                'login.troca.de.senha.obrigatoria.param.usuario.title':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.param.usuario.title"/></formatting:escape>',
                'login.troca.de.senha.obrigatoria.param.senha.title':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.param.senha.title"/></formatting:escape>',
                'login.troca.de.senha.obrigatoria.param.nova.senha.title':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.param.nova.senha.title"/></formatting:escape>',
                'login.troca.de.senha.obrigatoria.param.confirmacao.title':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.param.confirmacao.title"/></formatting:escape>',
                'processar':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.processar.title"/></formatting:escape>',
                'processar_no':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.processar.title.notallowed"/></formatting:escape>',
                'processar_reset':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.processar.title.reset"/></formatting:escape>',
                'processar_noreset':'<formatting:escape language="javascript"><bean:message key="login.troca.de.senha.obrigatoria.processar.title.reset.not.allowed"/></formatting:escape>',
                'calendar.popup':'<formatting:escape language="javascript"><bean:message key="calendar.popup"/></formatting:escape>'
            };

            var hints = new Hints (HINTS_ITEMS);
        //-->
    	</script>
    </tiles:put>

    <tiles:put name="body" type="string">
		
		<div id="pathway">
			<h2><bean:message key="login.troca.de.senha.obrigatoria.title"/></h2>
		</div>
		
		<tiles:insert page="/secure/troca-de-senha-obrigatoria-actions.jsp" flush="false"/>
		
		<div id="pageHelpSection">
			<blockquote>
				<bean:message key="required.fields.asterisk"/>
			</blockquote>
		</div>
	</tiles:put>
</tiles:insert>
