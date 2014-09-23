<%@ include file="/WEB-INF/layout/header.jsp" %>

<div id="content">
    <h1>Pet Details</h1>
    <table class="petDetails">
        <tr>
            <th scope="row">Name</th>
            <td>${pet.name}</td>
        </tr>
        <tr>
            <th scope="row">Owner</th>
            <td>${pet.owner.name}</td>
        </tr>
        <tr>
            <th scope="row">Date Born</th>
            <td><fmt:formatDate value="${pet.dateBorn}" pattern="dd.MM.yyyy" /></td>
        </tr>
        <tr>
            <th scope="row">Alive</th>
            <td>${pet.alive}</td>
        </tr>
    </table>    
    
    <div class="photos">
        <c:forEach items="${pet.pics}" var="pic">
            <div class="pic">
                <div class="del"><a href="/next/deletePic/${pic.id}">x</a></div>
                <img class="img" src="/next/img/${pic.id}.jpg" alt="${pic.title}" />
                <h2>${pic.title}</h2>
                <p>${pic.description}</p>
            </div>     
         
        </c:forEach>
        <div style="clear:both">&nbsp;</div>
    </div>
    
</div>

<%@include file="/WEB-INF/layout/footer.jsp" %>
