<%@ page session="false" %>

<%
pageContext.setAttribute("layout",
org.andromda.presentation.bpm4struts.LayoutConfiguration.instance().getLayoutConfiguration());
%>

<!-- 
Adicionar css usando o seguinte formato:
<link rel="stylesheet" type="text/css" media="screen" href="/contexto/layout/${layout}/<nome_arquivo>.css"/>"></link>
-->

<link rel="stylesheet" type="text/css" media="screen" href="/controleacesso/layout/${layout}/dimming/dimming.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/controleacesso/layout/${layout}/css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/controleacesso/layout/${layout}/css/style-default.css"></link>
<link rel="stylesheet" type="text/css" media="screen" href="/controleacesso/layout/${layout}/css/datepicker.css"></link>