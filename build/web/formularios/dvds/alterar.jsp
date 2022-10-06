<%-- 
    Document   : alterar
    Created on : Oct 5, 2022, 1:55:42 PM
    Author     : gusta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar DVD</title>
        <link rel="stylesheet" href="${cp}/css/styles.css"/>
    </head>
    <body>
        <h1>Alterar DVD</h1>
        
        <div class="menu">
            <a href="${cp}/index.jsp">
                <svg class="home-new" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
                </svg>
                Home
            </a> &nbsp;
            <a href="${cp}/formularios/dvds/listagem.jsp">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                </svg>
                Ver DVDs Cadastrados
            </a>
        </div>
                
        <form method="post" action="${cp}/processaDVDS">
        
            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.dvd.id}"/>

             <div class="title">Insira o novo título: </div>

             <div class="input-container ic1">
                <input name="titulo" class="input" type="text" placeholder=" " value="${requestScope.dvd.titulo}"/>
                <div class="cut"></div>
                <label for="titulo" class="placeholder">Título</label>
             </div>
            <div class="input-container ic1">
                <input name="dataLancamento" class="input" type="date" placeholder=" " value="${requestScope.dvd.dataLancamento}"/>
                <div class="cut"></div>
                <label for="titulo" class="placeholder">Data de lançamento</label>
            </div>
            <div class="input-container ic1">
                <input name="anoLancamento" class="input" type="text" placeholder=" " value="${requestScope.dvd.anoLancamento}"/>
                <div class="cut"></div>
                <label for="titulo" class="placeholder">Ano de lançamento</label>
            </div>
            <div class="input-container ic1">
                <input name="duracao" class="input" type="text" placeholder=" " value="${requestScope.dvd.duracao}"/>
                <div class="cut"></div>
                <label for="titulo" class="placeholder">Duração do filme(minutos)</label>
            </div>
                
            <div class="input-container ic2">

             <jsp:useBean
                 id="servicosG"
                 scope="page"
                 class="cadastrodvds.servicos.GeneroServices"/>

             <select name="genero" id="idGenero" required placeholder="">
                 <c:forEach items="${servicosG.todos}" var="genero">
                    <c:choose>
                        <c:when test="${requestScope.dvd.genero.id eq
                        genero.id}">
                            <option value="${genero.id}" selected>
                                ${genero.descricao}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${genero.id}">
                            ${genero.descricao}
                            </option>
                        </c:otherwise>
                    </c:choose>
                 </c:forEach>
             </select>
             <div class="cut-grande"></div>
             <label for="genero" class="placeholder">Gênero</label>
           </div>
             
            <div class="input-container ic2">

             <jsp:useBean
                 id="servicosC"
                 scope="page"
                 class="cadastrodvds.servicos.ClassificacaoServices"/>

             <select name="classificacao" id="classificacao" required placeholder="">
                 <c:forEach items="${servicosC.todos}" var="classificacao">
                     <c:choose>
                        <c:when test="${requestScope.dvd.classificacao.id eq
                        classificacao.id}">
                            <option value="${classificacao.id}" selected>
                                ${classificacao.descricao}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${classificacao.id}">
                            ${classificacao.descricao}
                            </option>
                        </c:otherwise>
                    </c:choose>
                 </c:forEach>
             </select>
             <div class="cut-grande"></div>
             <label for="genero" class="placeholder">Classificação</label>
           </div>
             
            <div class="input-container ic2">

              <jsp:useBean
                  id="servicosAP"
                  scope="page"
                  class="cadastrodvds.servicos.AtorServices"/>

              <select name="atorp" id="atorp" required placeholder="">
                  <c:forEach items="${servicosAP.todos}" var="atorp">
                      <c:choose>
                        <c:when test="${requestScope.dvd.atorp.id eq
                        atorp.id}">
                            <option value="${atorp.id}" selected>
                                ${atorp.nome} ${atorp.sobrenome}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${atorp.id}">
                                ${atorp.nome} ${atorp.sobrenome}
                            </option>
                        </c:otherwise>
                    </c:choose>
                  </c:forEach>
              </select>
              <div class="cut-grande"></div>
              <label for="atorp" class="placeholder">Ator Principal</label>
            </div>
              
            <div class="input-container ic2">

              <jsp:useBean
                  id="servicosAC"
                  scope="page"
                  class="cadastrodvds.servicos.AtorServices"/>

              <select name="atorc" id="atorc" required placeholder="">
                  <c:forEach items="${servicosAC.todos}" var="atorc">
                      <c:choose>
                        <c:when test="${requestScope.dvd.atorc.id eq
                        atorc.id}">
                            <option value="${atorc.id}" selected>
                                ${atorc.nome} ${atorc.sobrenome}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${atorc.id}">
                                ${atorc.nome} ${atorc.sobrenome}
                            </option>
                        </c:otherwise>
                    </c:choose>
                  </c:forEach>
              </select>
              <div class="cut-grande"></div>
              <label for="ator" class="placeholder">Ator coadjuvante</label>
            </div>
              
            <button type="text" class="submit">Atualizar</button>

       </form>
    </body>
</html>
