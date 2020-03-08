<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
<c:choose>
          <c:when test="${sessionScope.user != null}">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/add-article.jsp">Dodaj artykuł</a>
            </li>
</c:when>
</c:choose>

            <li class="nav-item">


                <c:choose>
                <c:when test="${sessionScope.user ==null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Log in</a>
                </c:when>
                    <c:otherwise>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<jsp:include page="messages.jsp"/>