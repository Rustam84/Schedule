<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 3/27/2018
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer</title>
    <style type="text/css">
        <%@include file="../resources/css/styleLecturer.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Преподаватели"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="button1">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="button2">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="button3">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="button4">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockLecturer1">
            </div>
            <div id="blockLecturer2">
                <form action="lecturer/add">
                    <div class="form-group">
                        <label for="surname">Введите фамилию преподавателя </label>
                        <input type="text" id="surname" name="surname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="name">Введите имя преподавателя </label>
                        <input type="text" id="name" name="name" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="addLecturer">Добавить</button>
            </div>
            <div id="blockLecturer3">
                <div id="updateLecturerTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID преподавателя </label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="surnameUpdate">Введите фамилию преподавателя </label>
                        <input type="text" id="surnameUpdate" name="surname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="nameUpdate">Введите имя преподавателя </label>
                        <input type="text" id="nameUpdate" name="name" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary">Обновить</button>
            </div>
            <div id="blockLecturer4">
                <table class="table table-bordered">
                    <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Фамилия преподавателя</th>
                        <th>Имя преподавателя</th>
                        <th>Обновить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td id="surnameDelete1">Епифанова</td>
                        <td id="nameDelete1">Ирина</td>
                        <td>
                            <label class="btn btn-secondary">
                                <input type="radio" name="delete" value="1"> Удалить
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td id="surnameDelete2">Латул</td>
                        <td id="nameDelete2">Георгий</td>
                        <td>
                            <label class="btn btn-secondary">
                                <input type="radio" name="delete" value="2"> Удалить
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID преподавателя </label>
                        <input type="text" id="idDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="surnameDelete">Фамилия преподавателя </label>
                        <input type="text" id="surnameDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameDelete">Имя преподавателя </label>
                        <input type="text" id="nameDelete" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary">Удалить</button>
            </div>
        </div>
    </div>
</div>
<!--script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script-->
<script>
    <%@include file="../resources/js/scriptLecturer.js"%>
</script>
</body>
</html>
