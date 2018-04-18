$("#buttonShowPair").click(function () {
    $("#blockPairShow").css('display', 'block');
    $("#blockPairAdd").css('display', 'none');
    $("#blockPairUpdate").css('display', 'none');
    $("#blockPairDelete").css('display', 'none');
});
$("#buttonAddPair").click(function () {
    $("#blockPairShow").css('display', 'none');
    $("#blockPairAdd").css('display', 'block');
    $("#blockPairUpdate").css('display', 'none');
    $("#blockPairDelete").css('display', 'none');
});
$("#buttonUpdatePair").click(function () {
    $("#blockPairShow").css('display', 'none');
    $("#blockPairAdd").css('display', 'none');
    $("#blockPairUpdate").css('display', 'block');
    $("#blockPairDelete").css('display', 'none');
});
$("#buttonDeletePair").click(function () {
    $("#blockPairShow").css('display', 'none');
    $("#blockPairAdd").css('display', 'none');
    $("#blockPairUpdate").css('display', 'none');
    $("#blockPairDelete").css('display', 'block');
});
function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#numberUpdate").val($("#numberUpdate" + id).text());
    $("#beginUpdate").val($("#beginUpdate" + id).text());
    $("#endUpdate").val($("#endUpdate" + id).text());

}
function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#numberDelete").val($("#numberDelete" + id).text());
    $("#beginDelete").val($("#beginDelete" + id).text());
    $("#endDelete").val($("#endDelete" + id).text());
}
$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    updateTables();
});
$("#addPair").click(function () {
    var number = $("#number").val();
    var begin = $("#begin").val();
    var end = $("#end").val();
    var dataToSend = {
        'number' : number,
        'begin' : begin,
        'end' : end
    };
    $.ajax({
        type: "GET",
        url: "/pair/add",
        data: dataToSend,
        success: function(){
            $("#successAdd").show();
            window.setTimeout(function(){
                $('#successAdd').hide();
            },2300);
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
        'id' : id,
        'number' : number,
        'begin' : begin,
        'end' : end
    };
    $.ajax({
        type: "GET",
        url: "/pair/update",
        data: dataToSend,
        success: function(){
            $("#successUpdate").show();
            window.setTimeout(function(){
                $('#successUpdate').hide();
            },2300);
            updateTables();
            $("#idUpdate").val("");
            $("#numberUpdate").val("");
            $("#beginUpdate").val("");
            $("#endUpdate").val("");
        }
    })
});
$("#deletePair").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id' : id
    };
    $.ajax({
        type: "GET",
        url: "/pair/delete",
        data: dataToSend,
        success: function(){
            $("#successDelete").show();
            window.setTimeout(function(){
                $('#successDelete').hide();
            },2300);
            updateTables();
            $("#idDelete").val("");
            $("#numberDelete").val("");
            $("#beginDelete").val("");
            $("#endDelete").val("");
        }
    })
});
function updateTables() {
    $.ajax({
        type: "GET",
        url: "/pair/getAll",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Begin</th>\n" +
                "                        <th>End</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Begin</th>\n" +
                "                        <th>End</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Begin</th>\n" +
                "                        <th>End</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.number + "</td><td>" + value.begin + "</td><td>" + value.end + "</td></tr>";

                tableUpdate += "<tr><td>" + value.id + "</td><td id = 'numberUpdate" + value.id + "'>" + value.number +
                    "</td><td id = 'beginUpdate" + value.id + "'>" + value.begin + "</td>" +
                    "</td><td id = 'endUpdate" + value.id + "'>" + value.end + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'numberDelete" + value.id + "'>" + value.number +
                    "</td><td id = 'beginDelete" + value.id + "'>" + value.begin + "</td>" +
                    "</td><td id = 'endDelete" + value.id + "'>" + value.end + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockPairShow").html(tableShow);
            $("#updatePairTable").html(tableUpdate);
            $("#deletePairTable").html(tableDelete);
        }
    });
}
