$(document).ready(function () {
    fillForms();
    createTableHeader();
});

function fillForms() {
    $.ajax({
        type: "GET",
        url: "/lecturer/getAll",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#lecturer').append($('<option>', {
                    value: value.id,
                    text: value.surname + " " + value.name
                }));
            });
        }
    });

    $.ajax({
        type: "GET",
        url: "/group/getAll",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#group').append($('<option>', {
                    value: value.id,
                    text: value.name
                }));
            });
        }
    });
}

$("#lecturer").change(function () {
    var dataToSend = {
        'idLecturer': $("#lecturer").val()
    };
    var lecturer = $("#lecturer option:selected").text();
    $.ajax({
        type: "GET",
        url: "/cell/getCellsByLecturer",
        data: dataToSend,
        success: function (result) {
            $("#header").text("Расписание для преподавателя " + lecturer);
            $('td[type="content"]').each(function(){
                $(this).text("");
            });
            $.each(result, function (key, value) {
                var cell = "";
                cell += "<div class ='rounded cell'>";
                cell += value.subject + "<br />";
                cell += value.groups;
                cell += "</div>";
                    $('td[day="' + value.day + '"][pair="' + value.pair + '"]').each(function () {
                        $(this).append(cell);
                    });

            });
        }
    });
});

$("#group").change(function () {
    var dataToSend = {
        'idLecturer': $("#group").val()
    };
    var group = $("#group option:selected").text();
    $.ajax({
        type: "GET",
        url: "/cell/getCellsByLecturer",
        data: dataToSend,
        success: function (result) {
            $("#header").text("Расписание для группы " + group);
            $('td[type="content"]').each(function(){
                $(this).text("");
            });
            $.each(result, function (key, value) {
                var cell = "";
                cell += "<div class ='rounded cell'>";
                cell += value.name + "<br />";
                cell += value.subject + "<br />";
                cell += value.groups;
                cell += "</div>";
                $('td[day="' + value.day + '"][pair="' + value.pair + '"]').each(function () {
                    $(this).append(cell);
                });

            });
        }
    });
});

function createTableHeader() {
    var daysArray = [];
    $.ajax({
        type: "GET",
        url: "/day/getAll",
        success: function (result) {
            var row = "<tr><th></th>";
            $.each(result, function (key, value) {
                row += "<th>" + value.name + "</th>";
                daysArray.push(value);
            });
            row += "</tr>";
            ($("#schedule thead")).append(row);
            createTableBody(daysArray);
        }
    });
}

function createTableBody(daysArray) {
    $.ajax({
        type: "GET",
        url: "/pair/getAll",
        success: function (result) {
            $.each(result, function (key, value) {
                var row = "<tr><td>" + value.begin + " - " + value.end + "</td>";
                for(var i = 0; i < daysArray.length; i++){
                    row += "<td type='content' day='" + daysArray[i].id + "' pair='" + value.id +"'></td>";
                }
                row += "</tr>";
                ($("#schedule tbody")).append(row);
            });
        }
    });
}