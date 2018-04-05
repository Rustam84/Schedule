$( "#buttonShowSubject" ).click(function() {
    $("#blockSubjectShow").css('display','block');
    $("#blockSubjectAdd").css('display','none');
    $("#blockSubjectUpdate").css('display','none');
    $("#blockSubjectDelete").css('display','none');
});
$( "#buttonAddSubject" ).click(function() {
    $("#blockSubjectShow").css('display','none');
    $("#blockSubjectAdd").css('display','block');
    $("#blockSubjectUpdate").css('display','none');
    $("#blockSubjectDelete").css('display','none');
});
$( "#buttonUpdateSubject" ).click(function() {
    $("#blockSubjectShow").css('display','none');
    $("#blockSubjectAdd").css('display','none');
    $("#blockSubjectUpdate").css('display','block');
    $("#blockSubjectDelete").css('display','none');
});
$( "#buttonDeleteSubject" ).click(function() {
    $("#blockSubjectShow").css('display','none');
    $("#blockSubjectAdd").css('display','none');
    $("#blockSubjectUpdate").css('display','none');
    $("#blockSubjectDelete").css('display','block');
});
function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#nameUpdate").val($("#nameUpdate" + id).text());
    $("#abbreviationUpdate").val($("#abbreviationUpdate" + id).text());
}
function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#nameDelete").val($("#nameDelete" + id).text());
    $("#abbreviationDelete").val($("#abbreviationDelete" + id).text());
}
$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    updateTables();
});
$("#addSubject").click(function () {
    var name = $("#name").val();
    var abbreviation = $("#abbreviation").val();
    var dataToSend = {
        'name' : name,
        'abbreviation' : abbreviation
    };
    $.ajax({
        type: "GET",
        url: "/subject/add",
        data: dataToSend,
        success: function(){
            $("#successAdd").show();
            window.setTimeout(function(){
                $('#successAdd').hide();
            },2300);
            updateTables();
            $("#name").val("");
            $("#abbreviation").val("");
        }
    })
});
$("#updateSubject").click(function () {
    var id = $("#idUpdate").val();
    var name = $("#nameUpdate").val();
    var abbreviation = $("#abbreviationUpdate").val();
    var dataToSend = {
        'id' : id,
        'name' : name,
        'abbreviation' : abbreviation
    };
    $.ajax({
        type: "GET",
        url: "/subject/update",
        data: dataToSend,
        success: function(){
            $("#successUpdate").show();
            window.setTimeout(function(){
                $('#successUpdate').hide();
            },2300);
            updateTables();
            $("#idUpdate").val("");
            $("#nameUpdate").val("");
            $("#abbreviationUpdate").val("");
        }
    })
});
$("#deleteSubject").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id' : id
    };
    $.ajax({
        type: "GET",
        url: "/subject/delete",
        data: dataToSend,
        success: function(){
            $("#successDelete").show();
            window.setTimeout(function(){
                $('#successDelete').hide();
            },2300);
            updateTables();
            $("#idDelete").val("");
            $("#nameDelete").val("");
            $("#abbreviationDelete").val("");
        }
    })
});
function updateTables(){
    $.ajax({
        type: "GET",
        url: "/subject/getAll",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Abbreviation</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Abbreviation</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Name</th>\n" +
                "                        <th>Abbreviation</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.name + "</td><td>" + value.abbreviation + "</td></tr>";

                tableUpdate += "<tr><td>" + value.id + "</td><td id = 'nameUpdate" + value.id + "'>" + value.name +
                    "</td><td id = 'abbreviationUpdate" + value.id + "'>" + value.abbreviation + "</td><td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'nameDelete" + value.id + "'>" + value.name +
                    "</td><td id = 'abbreviationDelete" + value.id + "'>" + value.abbreviation + "</td><td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockSubjectShow").html(tableShow);
            $("#updateSubjectTable").html(tableUpdate);
            $("#deleteSubjectTable").html(tableDelete);
        }
    });
}