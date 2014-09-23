<%@ include file="/WEB-INF/layout/header.jsp" %>

<div id="content">
    <h1>Pet Owners</h1>
    <table id="petowners">
        <tr>
            <th>Name</th>
            <th>Pets</th>
        </tr>
        <c:forEach items="${owners}" var="owner">
            <tr>
                <td>${owner.name}</td>
                <td>                    
                    <c:forEach items="${owner.pets}" var="pet"><a href="pet/${pet.id}">${pet.name}</a> &nbsp; </c:forEach>
                </td>
            </tr>
        </c:forEach>            
    </table>
    <!-- <button onclick="window.location='addOwner'">Add Owner</button> -->
    <button onclick="window.location='addPet'">Add Pet</button>
</div>

<%@include file="/WEB-INF/layout/footer.jsp" %>
