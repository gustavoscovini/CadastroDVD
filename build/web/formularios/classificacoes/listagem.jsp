<%-- 
    Document   : listagem
    Created on : 29 de set. de 2022, 22:32:29
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaClassificacoes?acao=preparar"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classificacoes Cadastradas</title>
        <link rel="stylesheet" href="${cp}/css/styles.css"/>
    </head>
    <body class="bodylistagem">
        
        <h1>Classificações Cadastradas</h1>
        
        <div class="menu">
            <a href="${cp}/index.jsp">
                <svg class="home-new" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
                </svg>
                Home
            </a> &nbsp;
            <a href="${cp}/formularios/classificacoes/novo.jsp">
                <svg class="home-new" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                </svg>
                Cadastrar nova classificação
            </a>
        </div>
        
        <table class="tabelaListagem">
            
            <thead>
                <th>ID</th>
                <th>DESCRIÇÃO</th>
            </thead>
            
            <tbody>
                <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="cadastrodvds.servicos.ClassificacaoServices"/>
                
                <c:forEach items="${servicos.todos}" var="classif">
                    
                    <tr>
                        <td>${classif.id}</td>
                        <td>${classif.descricao}</td>
                        <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${classif.id}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="#009BFF" class="bi bi-arrow-repeat" viewBox="0 0 16 16">
                                    <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"/>
                                    <path fill-rule="evenodd" d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"/>
                                </svg>
                            </a>
                        </td>
                        <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${classif.id}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="red" class="bi bi-chevron-contract" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M3.646 13.854a.5.5 0 0 0 .708 0L8 10.207l3.646 3.647a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 0 0 0 .708zm0-11.708a.5.5 0 0 1 .708 0L8 5.793l3.646-3.647a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 0-.708z"/>
                                </svg>
                            </a>
                        </td>
                        
                    </tr>
                    
                </c:forEach>
                
            </tbody>
            
            
        </table>
        
        
    </body>
</html>
