<%@ include file="/taglib-imports.jspf" %>
<% 
  String nomeProjeto = request.getContextPath(); 
  out.println("<script>");
  out.println("function getPath(){return \""+nomeProjeto+"\";}");
  out.println("</script>");
%>

<script>
	function setaAcao(nomeAcao, fcValidacao, valida){
		if (nomeAcao.indexOf("/") == 0) {
			document.forms[0].action = getPath() + nomeAcao + '.do';
		}else{
			document.forms[0].action = getPath() + '/' + nomeAcao + '.do';
		}
		if(true && valida){
			if(eval(fcValidacao + '(document.forms[0])')){
				if(document.getElementById("processarNovaSenha").value == document.getElementById("processarConfirmacao").value){
					document.forms[0].submit();
				}else{
					alert(<%out.print("\"");%><bean:message key="login.troca.de.senha.obrigatoria.validwhen"/><%out.print("\"");%>);
				}
			}
		}else{
			document.forms[0].submit();
		}
	}
</script>

<div class="container">
        <html:form action="/secure/TrocaDeSenhaObrigatoriaProcessar" method="post" enctype="multipart/form-data" >
            <div class="row form-group">
                <label class="control-label col-sm-2">
                	<bean:message key="login.troca.de.senha.obrigatoria.param.usuario"/>
                </label>
                <div class="col-xs-4">
                	<html:text name="form" property="usuario" styleClass="form-control" readonly="true" styleId="processarUsuario"/>
            	</div>
            </div>
            <div class="row form-group">
                <label class="control-label col-sm-2">
                	<bean:message key="login.troca.de.senha.obrigatoria.param.senha"/> *
                </label>
                <div class="col-xs-4">
                	<html:password name="form" property="senha" styleClass="form-control"  styleId="processarSenha"/>
            	</div>
           	</div>
            <div class="row form-group">
                <label class="control-label col-sm-2">
                 	<bean:message key="login.troca.de.senha.obrigatoria.param.nova.senha"/> *
				</label>
                <div class="col-xs-4">
                	<html:password name="form" property="novaSenha" styleClass="form-control"  styleId="processarNovaSenha"/>
            	</div>
            </div>
            <div class="row form-group">
            	<label class="control-label col-sm-2">
                	<bean:message key="login.troca.de.senha.obrigatoria.param.confirmacao"/> *
                </label>
                <div class="col-xs-4">
                	<html:password name="form" property="confirmacao" styleClass="form-control"  styleId="processarConfirmacao"/>
                </div>
           </div>   
           <html:hidden property="button" value="ok" />             
           <html:button   styleId="form_submit" styleClass="btn btn-primary" onclick="setaAcao('/secure/TrocaDeSenhaObrigatoriaProcessar', 'validateTrocaDeSenhaObrigatoriaProcessarFormImpl', true)" property="loginTrocaDeSenhaObrigatoriaProcessarForm">
           		<bean:message key="login.troca.de.senha.obrigatoria.processar"/>
           </html:button>
        </html:form>
</div>
