$(document).ready(function () {
    fillCells();
    createTable();
});
function fillCells() {
    $.ajax({
        type: "GET",
        url: "/cell/getCellsWithoutDay",
        success: function (result) {
            var cells = "";
            $.each(result, function (key, value) {
                cells += "<div class ='border border-primary cell' id='" + value.id + " ' draggable='true' ondragstart='drag(event)'>";
                cells += value.name + "<br />";
                cells += value.subject + "<br />";
                cells += value.groups;
                cells += "</div>";
            });
            $("#cells").html(cells);
        }
    });
}
function createTable(){
    var groupsArray = [];
    var pairsArray = [];
    var daysArray = [];
    var table = "<table class='table table-bordered'><thead><tr><th></th><th></th>";
    $.ajax({
        type: "GET",
        url: "/group/getAll",
        success: function (result) {
            $.each(result, function (key, value) {
                table += "<th>" + value.name + "</th>";
                groupsArray.push(value);
            });
            table += "</tr></thead><tbody>";
            $.ajax({
                type: "GET",
                url: "/pair/getAll",
                success: function (result) {
                    $.each(result, function (key, value) {
                        pairsArray.push(value);
                    });
                    $.ajax({
                        type: "GET",
                        url: "/day/getAll",
                        success: function (result) {
                            $.each(result, function (key, value) {
                                daysArray.push(value);
                            });
                            for(var i = 0; i < daysArray.length; i++){
                                for(var j = 0; j < pairsArray.length; j++){
                                    table += "<tr>";
                                    if(j == 0){
                                        table += "<td rowspan = '" + pairsArray.length + "'>" + daysArray[i].name + "</td>";
                                    }
                                    table += "<td>" + pairsArray[j].begin + " - " + pairsArray[j].end + "</td>"
                                    for(var k = 0 ; k < groupsArray.length; k++){
                                        table += "<td ondrop='dropOnCell(event)' ondragover='allowDrop(event)' type='working' pair='" + pairsArray[j].id + "' day='" + daysArray[i].id + "' group='" + groupsArray[k].name + "'></td>";
                                    }
                                    table += "</tr>";
                                }
                            }
                            table += "</tbody></table";
                            $("#table").html(table);
                            fillTable();
                        }
                    })
                }
            })
        }
    });
}
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function dropOnMain(ev) {
    ev.preventDefault();
    var idCell = ev.dataTransfer.getData("text");
    var dataToSend = {
        "idCell" : idCell
    };
    $.ajax({
        type: "POST",
        url: "/cell/removeDayAndPair",
        data: dataToSend,
        success: function (result) {
            fillTable();
            fillCells();
        }
    });
}
function dropOnCell(ev) {
    ev.preventDefault();
    var idCell = ev.dataTransfer.getData("text");
    var idDay = ev.target.getAttribute("day");
    var idPair = ev.target.getAttribute("pair");
    var dataToSend = {
        "idCell" : idCell,
        "idDay" : idDay,
        "idPair" : idPair
    };
    $.ajax({
        type: "POST",
        url: "/cell/updateDayAndPair",
        data: dataToSend,
        success: function (result) {
            fillTable();
            fillCells();
        }
    });
}
function fillTable(){
    $.ajax({
        type: "GET",
        url: "/cell/getFilledCells",
        success: function (result) {
            $('td[type="working"]').each(function(){
                $(this).text("");
            });
            $.each(result, function (key, value) {
                var cell = "";
                cell += "<div class ='border border-primary tableCell' id='" + value.id + " ' draggable='true' ondragstart='drag(event)'>";
                cell += value.name + "<br />";
                cell += value.subject + "<br />";
                cell += value.groups;
                cell += "</div>";
                var groups = value.groups.trim().split(" ");
                for(var i = 0; i < groups.length; i++) {
                    $('td[day="' + value.day + '"][pair="' + value.pair + '"][group="' + groups[i] + '" ]').each(function () {
                        $(this).append(cell);
                    });
                }
            });
        }
    });
}
