$("#button1").click(function () {
    $("#blockLecturer1").css('display', 'block');
    $("#blockLecturer2").css('display', 'none');
    $("#blockLecturer3").css('display', 'none');
    $("#blockLecturer4").css('display', 'none');
});
$("#button2").click(function () {
    $("#blockLecturer1").css('display', 'none');
    $("#blockLecturer2").css('display', 'block');
    $("#blockLecturer3").css('display', 'none');
    $("#blockLecturer4").css('display', 'none');
});
$("#button3").click(function () {
    $("#blockLecturer1").css('display', 'none');
    $("#blockLecturer2").css('display', 'none');
    $("#blockLecturer3").css('display', 'block');
    $("#blockLecturer4").css('display', 'none');
});
$("#button4").click(function () {
    $("#blockLecturer1").css('display', 'none');
    $("#blockLecturer2").css('display', 'none');
    $("#blockLecturer3").css('display', 'none');
    $("#blockLecturer4").css('display', 'block');
});
function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#surnameUpdate").val($("#surnameUpdate" + id).text());
    $("#nameUpdate").val($("#nameUpdate" + id).text());
}
function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#surnameDelete").val($("#surnameDelete" + id).text());
    $("#nameDelete").val($("#nameDelete" + id).text());
}
$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    updateTables();
});
$("#addLecturer").click(function () {
    var surname = $("#surname").val();
    var name = $("#name").val();
    var dataToSend = {
        'surname' : surname,
        'name' : name
    };
    $.ajax({
        type: "GET",
        url: "/lecturer/add",
        data: dataToSend,
        success: function(){
            $("#successAdd").show();
            window.setTimeout(function(){
                $('#successAdd').hide();
            },2300);
            updateTables();
            $("#surname").val("");
            var name = $("#name").val("");
        }
    })
});
$("#updateLecturer").click(function () {
    var id = $("#idUpdate").val();
    var surname = $("#surnameUpdate").val();
    var name = $("#nameUpdate").val();
    var dataToSend = {
        'id' : id,
        'surname' : surname,
        'name' : name
    };
    $.ajax({
        type: "GET",
        url: "/lecturer/update",
        data: dataToSend,
        success: function(){
            $("#successUpdate").show();
            window.setTimeout(function(){
                $('#successUpdate').hide();
            },2300);
            updateTables();
            $("#idUpdate").val("");
            $("#surnameUpdate").val("");
            $("#nameUpdate").val("");
        }
    })
});
$("#deleteLecturer").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id' : id
    };
    $.ajax({
        type: "GET",
        url: "/lecturer/delete",
        data: dataToSend,
        success: function(){
            $("#successDelete").show();
            window.setTimeout(function(){
                $('#successDelete').hide();
            },2300);
            updateTables();
            $("#idDelete").val("");
            $("#surnameDelete").val("");
            $("#nameDelete").val("");
        }
    })
});
function updateTables() {
    $.ajax({
        type: "GET",
        url: "/lecturer/getAll",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Surname</th>\n" +
                "                        <th>Name</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Surname</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Surname</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.surname + "</td><td>" + value.name + "</td></tr>";

                tableUpdate += "<tr><td>" + value.id + "</td><td id = 'surnameUpdate" + value.id + "'>" + value.surname +
                    "</td><td id = 'nameUpdate" + value.id + "'>" + value.name + "</td><td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'surnameDelete" + value.id + "'>" + value.surname +
                    "</td><td id = 'nameDelete" + value.id + "'>" + value.name + "</td><td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockLecturer1").html(tableShow);
            $("#updateLecturerTable").html(tableUpdate);
            $("#deleteLecturerTable").html(tableDelete);
        }
    });
}
