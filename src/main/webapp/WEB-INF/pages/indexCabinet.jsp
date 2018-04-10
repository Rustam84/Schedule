<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 3/27/2018
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
    <style type="text/css">
        <%@include file="../resources/css/styleCabinet.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Кабинеты"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowCabinet">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddCabinet">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdateCabinet">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeleteCabinet">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockCabinetShow">
            </div>
            <div id="blockCabinetAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form>
                    <div class="form-group">
                        <label for="number">Введите номер кабинета </label>
                        <input type="text" id="number" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="block">Введите блок </label>
                        <input type="text" id="block" name="block" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="capacity">Введите вместимость кабинета </label>
                        <input type="text" id="capacity" name="capacity" class="form-control">
                    </div>
                    <div class="form-group">
                        Выберите тип кабинета
                        <div class="radio">
                            <label><input type="radio" name="type" value="LAB">Лаборатория</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="type" value="AUD">Аудитория</label>
                        </div>
                    </div>
                </form>
                <button class="btn btn-primary" id="addCabinet">Добавить</button>
            </div>
            <div id="blockCabinetUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updateCabinetTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID кабинета </label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="numberUpdate">Введите название группы </label>
                        <input type="text" id="numberUpdate" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="blockUpdate">Введите блок </label>
                        <input type="text" id="blockUpdate" name="block" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="capacityUpdate">Введите вместимость </label>
                        <input type="number" id="capacityUpdate" name="capacity" class="form-control">
                    </div>
                    <div class="form-group">
                        Выберите язык обучения группы
                        <div class="radio">
                            <label><input type="radio" name="typeUpdate" value="LAB">Лаборатория</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="typeUpdate" value="AUD">Аудитория</label>
                        </div>
                    </div>
                </form>
                <button class="btn btn-primary" id="updateCabinet">Обновить</button>
            </div>
            <div id="blockCabinetDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deleteCabinetTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID кабинета </label>
                        <input type="text" id="idDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="numberDelete">Номер кабинета</label>
                        <input type="text" id="numberDelete" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary" id="deleteCabinet">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptCabinet.js"%>
</script>
</body>
</html>
