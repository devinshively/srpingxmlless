<%@ include file="/WEB-INF/layout/header.jsp" %>


<div id="content">
    <h1>Add Pet</h1>
        <form:form action="addPet" method="POST" modelAttribute="petForm">
            <div>       
                <label>Owner</label>
                <form:select path="owner" items="${owners}" itemValue="id" itemLabel="name" />
            </div>
            <div>
                <label>Name</label>                
                <form:input path="name" cssErrorClass="error" />
            </div>
            <div>
                <label>Date Born</label>
                <form:input path="dayBorn" size="2" cssErrorClass="error" />
                <form:select path="monthBorn" items="${monthNames}" itemValue="id" itemLabel="label" />
                <form:input path="yearBorn" size="4" cssErrorClass="error" />                
                <form:errors path="yearBorn"><span class="error">Illegal value</span></form:errors>
                <form:errors path="dateBorn" cssClass="error" />
            </div>
            <div>
                <label>&nbsp;</label><form:checkbox path="alive"/><label>alive</label>
            </div>
            
            <button type="button" onclick="window.location='owners'">Back</button>
            <form:button value="Save" name="add">Save</form:button>
        </form:form> 
</div>

<%@include file="/WEB-INF/layout/footer.jsp" %>