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
    <title>Pair</title>
    <style type="text/css">
        <%@include file="../resources/css/stylePair.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Пары"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowPair">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddPair">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdatePair">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeletePair">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockPairShow">
            </div>
            <div id="blockPairAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form>
                    <div class="form-group">
                        <label for="number">Введите номер пары </label>
                        <input type="number" id="number" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="begin">Введите начало пары </label>
                        <input type="text" id="begin" name="begin" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="end">Введите конец пары </label>
                        <input type="text" id="end" name="end" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="addPair">Добавить</button>
            </div>
            <div id="blockPairUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updatePairTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID пары</label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="numberUpdate">Введите номер пары </label>
                        <input type="text" id="numberUpdate" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="beginUpdate">Введите начало пары </label>
                        <input type="text" id="beginUpdate" name="begin" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="endUpdate">Введите конец пары </label>
                        <input type="text" id="endUpdate" name="end" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="updatePair">Обновить</button>
            </div>
            <div id="blockPairDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deletePairTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID пары</label>
                        <input type="text" id="idDelete" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="numberDelete">Номер пары </label>
                        <input type="text" id="numberDelete" name="number" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="beginDelete">Начало пары </label>
                        <input type="text" id="beginDelete" name="begin" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="endDelete">Конец пары </label>
                        <input type="text" id="endDelete" name="end" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary" id="deletePair">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptPair.js"%>
</script>
</body>
</html>
