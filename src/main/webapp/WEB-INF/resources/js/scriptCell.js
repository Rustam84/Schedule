$("#buttonShowCell").click(function () {
    $("#blockCellShow").css('display', 'block');
    $("#blockCellAdd").css('display', 'none');
    $("#blockCellUpdate").css('display', 'none');
    $("#blockCellDelete").css('display', 'none');
});
$("#buttonAddCell").click(function () {
    $("#blockCellShow").css('display', 'none');
    $("#blockCellAdd").css('display', 'block');
    $("#blockCellUpdate").css('display', 'none');
    $("#blockCellDelete").css('display', 'none');
});
/*$("#buttonUpdateCell").click(function () {
    $("#blockCellShow").css('display', 'none');
    $("#blockCellAdd").css('display', 'none');
    $("#blockCellUpdate").css('display', 'block');
    $("#blockCellDelete").css('display', 'none');
});*/
$("#buttonDeleteCell").click(function () {
    $("#blockCellShow").css('display', 'none');
    $("#blockCellAdd").css('display', 'none');
    $("#blockCellUpdate").css('display', 'none');
    $("#blockCellDelete").css('display', 'block');
});

/*function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#numberUpdate").val($("#numberUpdate" + id).text());
    $("#beginUpdate").val($("#beginUpdate" + id).text());
    $("#endUpdate").val($("#endUpdate" + id).text());

}*/

function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#nameDelete").val($("#nameDelete" + id).text());
    $("#subjectDelete").val($("#subjectDelete" + id).text());
    $("#groupsDelete").val($("#groupsDelete" + id).text());
}

$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    fillForms();
    updateTables();
});
$("#addCell").click(function () {
    var lecturer = $("#addCellLecturer").val();
    var subject = $("#addCellSubject").val();
    var group = $("#addCellGroup").val();
    var dataToSend = {
        'lecturer': lecturer,
        'subject': subject,
        'group': group.toString()
    };
    $.ajax({
        type: "GET",
        url: "/cell/add",
        data: dataToSend,
        success: function () {
            $("#successAdd").show();
            window.setTimeout(function () {
                $('#successAdd').hide();
            }, 2300);
            updateTables();
            $("#number").val("");
            $("#begin").val("");
            $("#end").val("");
        }
    })
});
$("#updatePair").click(function () {
    var id = $("#idUpdate").val();
    var number = $("#numberUpdate").val();
    var begin = $("#beginUpdate").val();
    var end = $("#endUpdate").val();
    var dataToSend = {
        'id': id,
        'number': number,
        'begin': begin,
        'end': end
    };
    $.ajax({
        type: "GET",
        url: "/pair/update",
        data: dataToSend,
        success: function () {
            $("#successUpdate").show();
            window.setTimeout(function () {
                $('#successUpdate').hide();
            }, 2300);
            updateTables();
            $("#idUpdate").val("");
            $("#numberUpdate").val("");
            $("#beginUpdate").val("");
            $("#endUpdate").val("");
        }
    })
});
$("#deleteCell").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id': id
    };
    $.ajax({
        type: "GET",
        url: "/cell/delete",
        data: dataToSend,
        success: function () {
            $("#successDelete").show();
            window.setTimeout(function () {
                $('#successDelete').hide();
            }, 2300);
            updateTables();
            $("#idDelete").val("");
            $("#nameDelete").val("");
            $("#subjectDelete").val("");
            $("#groupsDelete").val("");
        }
    })
});

function updateTables() {
    $.ajax({
        type: "GET",
        url: "/cell/getCellsWithoutDay",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Lecturer</th>\n" +
                "                        <th>Subject</th>\n" +
                "                        <th>Groups</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

           /* var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Begin</th>\n" +
                "                        <th>End</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";*/

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Lecturer</th>\n" +
                "                        <th>Subject</th>\n" +
                "                        <th>Groups</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.name + "</td><td>" + value.subject + "</td><td>" + value.groups + "</td></tr>";

               /* tableUpdate += "<tr><td>" + value.id + "</td><td id = 'numberUpdate" + value.id + "'>" + value.number +
                    "</td><td id = 'beginUpdate" + value.id + "'>" + value.begin + "</td>" +
                    "</td><td id = 'endUpdate" + value.id + "'>" + value.end + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";*/

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'nameDelete" + value.id + "'>" + value.name +
                    "</td><td id = 'subjectDelete" + value.id + "'>" + value.subject + "</td>" +
                    "</td><td id = 'groupsDelete" + value.id + "'>" + value.groups + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            //tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockCellShow").html(tableShow);
            //$("#updatePairTable").html(tableUpdate);
            $("#deleteCellTable").html(tableDelete);
        }
    });
}

function fillForms() {
    $.ajax({
        type: "GET",
        url: "/lecturer/getAll",
        success: function (result) {
            var selectLecturers = "<select class='form-control' id='addCellLecturer'>";
            var selectLecturersUpdate = "<select class='form-control' id='updateCellLecturer'>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.surname + " " + value.name + "</option>"
                selectLecturers += option;
                selectLecturersUpdate += option;
            });
            selectLecturers += "</select>";
            selectLecturersUpdate += "</select>";
            $("#addLecturerList").html(selectLecturers);
            $("#updateLecturerList").html(selectLecturers);
        }
    });
    $.ajax({
        type: "GET",
        url: "/subject/getAll",
        success: function (result) {
            var selectSubjects = "<select class='form-control' id='addCellSubject'>";
            var selectSubjectsUpdate = "<select class='form-control' id='updateCellSubject'>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.name + "</option>"
                selectSubjects += option;
                selectSubjectsUpdate += option;
            });
            selectSubjects += "</select>";
            selectSubjectsUpdate += "</select>";
            $("#addSubjectList").html(selectSubjects);
            $("#updateSubjectList").html(selectSubjects);
        }
    });
    $.ajax({
        type: "GET",
        url: "/group/getAll",
        success: function (result) {
            var selectGroups = "<select class='form-control' id='addCellGroup' multiple>";
            var selectGroupsUpdate = "<select class='form-control' id='updateCellGroup' multiple>";
            $.each(result, function (key, value) {
                var option = "<option value = '" + value.id + "'>" + value.name + "</option>"
                selectGroups += option;
                selectGroupsUpdate += option;
            });
            selectGroups += "</select>";
            selectGroupsUpdate += "</select>";
            $("#addGroupList").html(selectGroups);
            $("#updateGroupList").html(selectGroups);
        }
    });
}
