<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
<body>
<div class="container h-100">
    <div class="row justify-content-md-center">
        <div class="col-6">
            <form action="mainRedirect">
                <fieldset class="form-group">
                    <legend></legend>
                    <h1>Выберите таблицу для работы:</h1><br>
                    <button name="table" value="lecturer" class="btn btn-primary btn-lg btn-block">Преподаватели</button> <br />
                    <button name="table" value="subject" class="btn btn-primary btn-lg btn-block">Предметы</button> <br />
                    <button name="table" value="schedule" class="btn btn-primary btn-lg btn-block">Пары</button> <br />
                    <button name="table" value="cabinet" class="btn btn-primary btn-lg btn-block">Кабинеты</button> <br />
                    <button name="table" value="group" class="btn btn-primary btn-lg btn-block">Группы</button> <br />
                    <button name="table" value="cell" class="btn btn-primary btn-lg btn-block">Ячейки</button> <br />
                </fieldset>
            </form>
        </div>
    </div>
</div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
