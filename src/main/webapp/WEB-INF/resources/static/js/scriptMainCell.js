$(document).ready(function () {
    fillCells();
    createTable();
    createLecturersList();
    createSubjectsList();
    createCabinetsList();
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

function createTable() {
    var groupsArray = [];
    var pairsArray = [];
    var daysArray = [];
    var table = "<table class='table table-bordered'><thead><tr><th><button id='showFilters' class='btn btn-primary'>Фильтры</button></th><th></th>";
    $.ajax({
        type: "GET",
        url: "/group/getAll",
        success: function (result) {
            $.each(result, function (key, value) {
                table += "<th group='" + value.name + "'>" + value.name + "(" + value.language + ")</th>";
                groupsArray.push(value);
            });
            fillGroupFilters(groupsArray);
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
                            for (var i = 0; i < daysArray.length; i++) {
                                for (var j = 0; j < pairsArray.length; j++) {
                                    table += "<tr>";
                                    if (j == 0) {
                                        table += "<td rowspan = '" + pairsArray.length + "'>" + daysArray[i].name + "</td>";
                                    }
                                    table += "<td>" + pairsArray[j].begin + " - " + pairsArray[j].end + "</td>"
                                    for (var k = 0; k < groupsArray.length; k++) {
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
        "idCell": idCell
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
        "idCell": idCell,
        "idDay": idDay,
        "idPair": idPair
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

function fillTable() {
    $.ajax({
        type: "GET",
        url: "/cell/getFilledCells",
        success: function (result) {
            $('td[type="working"]').each(function () {
                $(this).text("");
            });
            $.each(result, function (key, value) {
                var cell = "";
                cell += "<div class ='border ";
                if (value.status == "ok") {
                    cell += "tableSuccessCell";
                } else {
                    cell += "tableFailCell";
                }
                cell += "' id='" + value.id + " ' draggable='true' ondragstart='drag(event)' ondblclick='editingCell(event, " + value.id + ")'>";
                var lecturerAndCabinet = "";
                lecturerAndCabinet += value.name;
                if (value.cabinet != null) {
                    lecturerAndCabinet += " " + value.cabinet;
                }
                var subject = "";
                subject += value.subject + "(" + value.type;
                if (value.parity == 1) {
                    subject += ", пар";
                } else if (value.parity == 2) {
                    subject += ", непар";
                }
                subject += ")<br />"
                cell += subject;
                cell += lecturerAndCabinet + "<br />";
                cell += value.groups;
                cell += "</div>";
                var groups = value.groups.trim().split(" ");
                for (var i = 0; i < groups.length; i++) {
                    $('td[day="' + value.day + '"][pair="' + value.pair + '"][group="' + groups[i] + '" ]').each(function () {
                        $(this).append(cell);
                    });
                }
            });
        }
    });
}

function editingCell(ev, value) {
    $("#cellInfo").modal();
    var id = ev.target.id;
    $.ajax({
        type: "GET",
        url: "/cell/getById?id=" + id,
        success: function (result) {
            $("#idInModal").text(id);
            var lecturer = result.name;
            $("#listOfLecturers option").attr('selected', false);
            $("#listOfLecturers option").filter(function () {
                return this.text === lecturer;
            }).attr('selected', true);

            var groups = result.groups;
            $("#groupsInModal").text(groups);

            var subject = result.subject;
            $("#listOfSubjects option").attr('selected', false);
            $("#listOfSubjects option").filter(function () {
                return this.text === subject;
            }).attr('selected', true);

            $("#typeInModal").val(result.type);

            console.log(result.parity);
            $("#parityInModal").val(result.parity);

            var cabinet = result.cabinet;
            $("#listOfCabinets option").attr('selected', false);
            if (cabinet != null) {
                $("#listOfCabinets option").filter(function () {
                    return this.text === cabinet;
                }).attr('selected', true);
            } else {
                $("#listOfCabinets").val(0);
            }

            var comment = "<div class = 'alert ";
            if (result.status === 'ok') {
                comment += "alert-success'>";
            } else {
                comment += "alert-danger'>";
            }
            comment += result.comment + "</div>";
            $("#currentStatus").html(comment);
        }
    });
}

$("#updateCellInfo").click(function () {
    var idCell = $("#idInModal").text().trim();
    var idLecturer = $("#lecturerInModal").find(":selected").val();
    var idSubject = $("#subjectInModal").find(":selected").val();
    var type = $("#typeInModal").val();
    var idParity = $("#parityInModal").find(":selected").val();
    var idCabinet = $("#cabinetInModal").find(":selected").val();
    var data = {
        'idCell': idCell,
        'idLecturer': idLecturer,
        'idSubject': idSubject,
        'type': type,
        'parity': idParity,
        'idCabinet': idCabinet
    };
    $.ajax({
        type: "POST",
        url: "/cell/updateFullCell",
        data: data,
        success: function () {
            fillTable();
            $("#cellInfo").modal('hide');
        }
    });
});

function createLecturersList() {
    $.ajax({
        type: "GET",
        url: "/lecturer/getAll",
        success: function (result) {
            var selectLecturers = "<select class='form-control' id='listOfLecturers'>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.surname + " " + value.name + "</option>"
                selectLecturers += option;
            });
            selectLecturers += "</select>";
            $("#lecturerInModal").html(selectLecturers);
        }
    });
}

function createSubjectsList() {
    $.ajax({
        type: "GET",
        url: "/subject/getAll",
        success: function (result) {
            var selectSubjects = "<select class='form-control' id='listOfSubjects'>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.name + "</option>"
                selectSubjects += option;
            });
            selectSubjects += "</select>";
            $("#subjectInModal").html(selectSubjects);
        }
    });
}

function createCabinetsList() {
    $.ajax({
        type: "GET",
        url: "/cabinet/getAll",
        success: function (result) {
            var selectCabinets = "<select class='form-control' id='listOfCabinets'>";
            selectCabinets += "<option value='0'></option>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.number + "/" + value.block + "</option>"
                selectCabinets += option;
            });
            selectCabinets += "</select>";
            $("#cabinetInModal").html(selectCabinets);
        }
    });
}

function hideGroup(groupName) {
    $("td[group='" + groupName + "'],th[group='" + groupName + "']").each(function () {
        $(this).css('display', 'none');
    });
}

function showGroup(groupName) {
    $("td[group='" + groupName + "'],th[group='" + groupName + "']").each(function () {
        $(this).css('display', 'table-cell');
    });
}

function fillGroupFilters(groupsArray) {
    var result = "Группы:";
    var closedRow = false;
    result += "<div class='container'>";
    for (var index in groupsArray) {
        if (index % 4 === 0) {
            result += "<div class='row'>";
            closedRow = false;
        }
        result += "<div class='col-3'>";
        result += "<input class='form-check-input' type='checkbox' name='groupToShow' value='" + groupsArray[index].name + "' id=checkbox'" + groupsArray[index].name + "' checked>";
        result += "<label class='form-check-label' for='" + groupsArray[index].name + "'>" + groupsArray[index].name + "</label>";
        result += "</div>";
        if (index % 4 === 3) {
            result += "</div>";
            closedRow = true;
        }
    }
    if (!closedRow) {
        result += "</div>";
    }
    result += "</div>";
    $("#groupFilterInModal").html(result);
}

$("#updateFilter").click(function () {
    $("input[name='groupToShow']").each(function () {
        if ($(this).is(":checked")) {
           showGroup($(this).val());
        } else {
            hideGroup($(this).val());
        }
    });
});

$(document).on('click', '#showFilters', function () {
    console.log('click');
    $("#modalFilter").modal('show');
});