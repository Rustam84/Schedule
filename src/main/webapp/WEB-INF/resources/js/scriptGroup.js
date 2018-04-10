$( "#buttonShowGroup" ).click(function() {
    $("#blockGroupShow").css('display','block');
    $("#blockGroupAdd").css('display','none');
    $("#blockGroupUpdate").css('display','none');
    $("#blockGroupDelete").css('display','none');
});
$( "#buttonAddGroup" ).click(function() {
    $("#blockGroupShow").css('display','none');
    $("#blockGroupAdd").css('display','block');
    $("#blockGroupUpdate").css('display','none');
    $("#blockGroupDelete").css('display','none');
});
$( "#buttonUpdateGroup" ).click(function() {
    $("#blockGroupShow").css('display','none');
    $("#blockGroupAdd").css('display','none');
    $("#blockGroupUpdate").css('display','block');
    $("#blockGroupDelete").css('display','none');
});
$( "#buttonDeleteGroup" ).click(function() {
    $("#blockGroupShow").css('display','none');
    $("#blockGroupAdd").css('display','none');
    $("#blockGroupUpdate").css('display','none');
    $("#blockGroupDelete").css('display','block');
});
function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#nameUpdate").val($("#nameUpdate" + id).text());
    $("#numberUpdate").val($("#numberUpdate" + id).text());
    $("input[name=languageUpdate][value=" + $("#languageUpdate" + id).text() + "]").prop('checked', true);
}
function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#nameDelete").val($("#nameDelete" + id).text());
}
$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    updateTables();
});
$("#addGroup").click(function () {
    var name = $("#name").val();
    var language = $('input[name=language]:checked').val();
    var number = $("#number").val();
    var dataToSend = {
        'name' : name,
        'language' : language,
        'numberOfStudents' : number
    };
    $.ajax({
        type: "GET",
        url: "/group/add",
        data: dataToSend,
        success: function(){
            $("#successAdd").show();
            window.setTimeout(function(){
                $('#successAdd').hide();
            },2300);
            updateTables();
            $("#name").val("");
            $("#number").val("");
        }
    })
});
$("#updateGroup").click(function () {
    var id = $("#idUpdate").val();
    var name = $("#nameUpdate").val();
    var language = $('input[name=languageUpdate]:checked').val();
    var number = $("#numberUpdate").val();
    var dataToSend = {
        'id' : id,
        'name' : name,
        'language' : language,
        'numberOfStudents' : number
    };
    $.ajax({
        type: "GET",
        url: "/group/update",
        data: dataToSend,
        success: function(){
            $("#successUpdate").show();
            window.setTimeout(function(){
                $('#successUpdate').hide();
            },2300);
            updateTables();
            $("#idUpdate").val("");
            $("#nameUpdate").val("");
            $("#numberUpdate").val("");
        }
    })
});
$("#deleteGroup").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id' : id
    };
    $.ajax({
        type: "GET",
        url: "/group/delete",
        data: dataToSend,
        success: function(){
            $("#successDelete").show();
            window.setTimeout(function(){
                $('#successDelete').hide();
            },2300);
            updateTables();
            $("#idDelete").val("");
            $("#nameDelete").val("");
        }
    })
});
function updateTables(){
    $.ajax({
        type: "GET",
        url: "/group/getAll",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Language</th>\n" +
                "                        <th>Number of students</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Language</th>\n" +
                "                        <th>Number of students</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Language</th>\n" +
                "                        <th>Number of students</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.name + "</td><td>" + value.language + "</td><td>" + value.numberOfStudents + "</td></tr>";

                tableUpdate += "<tr><td>" + value.id + "</td><td id = 'nameUpdate" + value.id + "'>" + value.name +
                    "</td><td id = 'languageUpdate" + value.id + "'>" + value.language + "</td>" +
                    "</td><td id = 'numberUpdate" + value.id + "'>" + value.numberOfStudents + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'nameDelete" + value.id + "'>" + value.name +
                    "</td><td id = 'languageDelete" + value.id + "'>" + value.language + "</td>" +
                    "</td><td id = 'numberDelete" + value.id + "'>" + value.numberOfStudents + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockGroupShow").html(tableShow);
            $("#updateGroupTable").html(tableUpdate);
            $("#deleteGroupTable").html(tableDelete);
        }
    });
}