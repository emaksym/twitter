<%@ page import="pl.sda.twitter.constans.SessionValues" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${sessionScope.messages !=null}">

        <div style="color:red; padding-top: 100px">

        <c:forEach items="${sessionScope.messages}" var="element">
            <div class="alert alert-warning" role="alert">

                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
           </button>
                ${element}


            </div>
    </c:forEach>

    </div>

        <% final String messages = SessionValues.MESSAGES.getValue();
        session.removeAttribute(messages); %>

    </c:when>

</c:choose>