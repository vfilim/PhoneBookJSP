<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/phonebook.css"/>
    <title>Phone book</title>
</head>

<body>
<div id="app" class="content">
    <div class="filter-container">
        <form method="get" action="${pageContext.request.contextPath}/phonebook/get/all">
        <label class="mr-1">
            Введите текст:
            <input type="text" class="form-control input-sm"/>
        </label>
        <button class="btn btn-primary" type="submit">Отфильтровать</button>
        <button class="btn btn-primary">Сбросить фильтр</button>
        </form>
    </div>


    <table class="table table-bordered contact-table">
        <thead>
        <tr>
            <th>
                <label class="select-all-label">
                    <input type="checkbox" title="Выбрать"/>
                </label>
            </th>
            <th>№</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Телефон</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <tbody>

        <c:set var="index" value="0"/>
        <c:forEach var="contact" items="${contacts}">
        <tr>
            <c:set var="index" value="${index + 1}"/>
                <td>
                    <label class="select-me-label">
                        <input type="checkbox" class="select-me"/>
                    </label>
                </td>
                <td>${index}</td>
                <td>${contact.getFirstName()}</td>
                <td>${contact.getLastName()}</td>
                <td>${contact.getPhone()}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/phonebook/deleteContact" method="post" id="delete-id">
                        <input name="id" value="${contact.getId()}" class="d-none">
                    <button class="btn btn-primary" type="submit">Удалить</button></form>
                </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <button type="button" class="btn btn-primary">Удалить выбранные</button>

    <br>

    <form class="form" action="${pageContext.request.contextPath}/phonebook/add" method="post">
        <div>
            <label class="form-label">
                <span class="form-field">Фамилия:</span>
                <input type="text" class="form-control input-sm form-input ml-1" name="lastName"/>
            </label>
        </div>
        <div>
            <label class="form-label">
                <span class="form-field">Имя:</span>
                <input type="text" class="form-control input-sm form-input ml-1" name="firstName">
            </label>
        </div>
        <div>
            <label class="form-label">
                <span class="form-field">Телефон:</span>
                <input type="text" class="form-control input-sm form-input ml-1" name="phone"/>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/libs/bootstrap.bundle.js"></script>
</body>
</html>