<%-- 
    Document   : excluir
    Created on : 30 de set. de 2022, 23:57:26
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Classificacão</title>
        <link rel="stylesheet" href="${cp}/css/styles.css"/>
    </head>
    <body>
        <h1>Excluir Classificação</h1>
        
        <div class="menu">
            <a href="${cp}/index.jsp">
                <svg class="home-new" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
                </svg>
                Home
            </a> &nbsp;
            <a href="${cp}/formularios/classificacoes/listagem.jsp">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                </svg>
                Ver Classificações Cadastradas
            </a>
        </div>
                
                
        <form method="post" action="${cp}/processaClassificacoes">
        
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.classificacao.id}"/>

             <div class="title">Por favor, confirme a exclusão: </div>
             
             
             <div class="input-container ic1">
               <input disabled name="id" class="input" type="text" placeholder=" " value="${requestScope.classificacao.id}"/>
               <div class="cut"></div>
               <label for="id" class="placeholder">ID</label>
             </div>
               
             <div class="input-container ic1">
               <input disabled name="descricao" class="input" type="text" placeholder=" " value="${requestScope.classificacao.descricao}"/>
               <div class="cut"></div>
               <label for="descricao" class="placeholder">Descrição</label>
             </div>
             <button type="text" class="submit">Excluir</button>


       </form>
    </body>
</html>
