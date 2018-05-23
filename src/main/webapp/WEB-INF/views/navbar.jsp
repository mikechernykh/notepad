<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="nav-bar">
    <div class="container">
        <a href="${pageContext.request.contextPath}/notes" class="brand"><spring:message code="app.title"/></a>
        <ul class="nav-bar-links">
            <li>
                <a href="${pageContext.request.contextPath}/notes/create">
                    <spring:message code="navbar.create"/>
                </a>
            </li>
            <li class="dropdown">
                <button><spring:message code="app.language"/>&nbsp;</button>
                <div class="langs">
                    <a href="?locale=en">English</a>
                    <a href="?locale=ru">Русский</a>
                </div>
            </li>
        </ul>
    </div>
</nav>