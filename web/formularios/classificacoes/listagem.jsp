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
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        
        <h1>Classificações Cadastradas</h1>
        
        <a href="${cp}/index.jsp">Home</a>
        <a href="${cp}/formularios/classificacoes/novo.jsp">Cadastrar nova classificação</a>
        
        <table>
            
            <thead>
                <th>Id</th>
                <th>Descrição</th>
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
                                Alterar
                            </a>
                        </td>
                        <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${classif.id}">
                                Excluir
                            </a>
                        </td>
                        
                    </tr>
                    
                </c:forEach>
                
            </tbody>
            
            
        </table>
        
        
    </body>
</html>
