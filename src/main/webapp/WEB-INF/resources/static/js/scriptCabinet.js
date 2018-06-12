$("#buttonShowCabinet").click(function () {
    $("#blockCabinetShow").css('display', 'block');
    $("#blockCabinetAdd").css('display', 'none');
    $("#blockCabinetUpdate").css('display', 'none');
    $("#blockCabinetDelete").css('display', 'none');
});
$("#buttonAddCabinet").click(function () {
    $("#blockCabinetShow").css('display', 'none');
    $("#blockCabinetAdd").css('display', 'block');
    $("#blockCabinetUpdate").css('display', 'none');
    $("#blockCabinetDelete").css('display', 'none');
});
$("#buttonUpdateCabinet").click(function () {
    $("#blockCabinetShow").css('display', 'none');
    $("#blockCabinetAdd").css('display', 'none');
    $("#blockCabinetUpdate").css('display', 'block');
    $("#blockCabinetDelete").css('display', 'none');
});
$("#buttonDeleteCabinet").click(function () {
    $("#blockCabinetShow").css('display', 'none');
    $("#blockCabinetAdd").css('display', 'none');
    $("#blockCabinetUpdate").css('display', 'none');
    $("#blockCabinetDelete").css('display', 'block');
});

function fillUpdateInputs(id) {
    $("#idUpdate").val(id);
    $("#numberUpdate").val($("#numberUpdate" + id).text());
    $("#blockUpdate").val($("#blockUpdate" + id).text());
    $("#capacityUpdate").val($("#capacityUpdate" + id).text());
    $("input[name=typeUpdate][value=" + $("#typeUpdate" + id).text() + "]").prop('checked', true);
}

function fillDeleteInputs(id) {
    $("#idDelete").val(id);
    $("#numberDelete").val($("#numberDelete" + id).text() + "/" + $("#blockDelete" + id).text());
}

$(document).ready(function () {
    $("#successAdd").hide();
    $("#successUpdate").hide();
    $("#successDelete").hide();
    updateTables();
});
$("#addCabinet").click(function () {
    var number = $("#number").val();
    var block = $("#block").val();
    var capacity = $("#capacity").val();
    var type = $('input[name=type]:checked').val();
    var dataToSend = {
        'number': number,
        'block': block,
        'capacity': capacity,
        'type': type
    };
    $.ajax({
        type: "GET",
        url: "/cabinet/add",
        data: dataToSend,
        success: function () {
            $("#successAdd").show();
            window.setTimeout(function () {
                $('#successAdd').hide();
            }, 2300);
            updateTables();
            $("#number").val("");
            $("#block").val("");
            $("#capacity").val("");
        }
    })
});
$("#updateCabinet").click(function () {
    var id = $("#idUpdate").val();
    var number = $("#numberUpdate").val();
    var block = $("#blockUpdate").val();
    var capacity = $("#capacityUpdate").val();
    var type = $('input[name=typeUpdate]:checked').val();
    var dataToSend = {
        'id': id,
        'number': number,
        'block': block,
        'capacity': capacity,
        'type': type
    };
    $.ajax({
        type: "GET",
        url: "/cabinet/update",
        data: dataToSend,
        success: function () {
            $("#successUpdate").show();
            window.setTimeout(function () {
                $('#successUpdate').hide();
            }, 2300);
            updateTables();
            $("#idUpdate").val("");
            $("#numberUpdate").val("");
            $("#blockUpdate").val("");
            $("#capacityUpdate").val("");
        }
    })
});
$("#deleteCabinet").click(function () {
    var id = $("#idDelete").val();
    var dataToSend = {
        'id': id
    };
    $.ajax({
        type: "GET",
        url: "/cabinet/delete",
        data: dataToSend,
        success: function () {
            $("#successDelete").show();
            window.setTimeout(function () {
                $('#successDelete').hide();
            }, 2300);
            updateTables();
            $("#idDelete").val("");
            $("#numberDelete").val("");
        }
    })
});

function updateTables() {
    $.ajax({
        type: "GET",
        url: "/cabinet/getAll",
        success: function (result) {
            var tableShow = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Block</th>\n" +
                "                        <th>Type</th>\n" +
                "                        <th>Capacity</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableUpdate = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Block</th>\n" +
                "                        <th>Type</th>\n" +
                "                        <th>Capacity</th>\n" +
                "                        <th>Update</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            var tableDelete = "<table class=\"table table-bordered\">\n" +
                "                    <thead class=\"thead-dark\">\n" +
                "                    <tr>\n" +
                "                        <th>ID</th>\n" +
                "                        <th>Number</th>\n" +
                "                        <th>Block</th>\n" +
                "                        <th>Type</th>\n" +
                "                        <th>Capacity</th>\n" +
                "                        <th>Delete</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>";

            $.each(result, function (key, value) {
                tableShow += "<tr><td>" + value.id + "</td><td>" + value.number + "</td><td>" + value.block + "</td><td>" + value.type + "</td><td>" + value.capacity + "</td></tr>";

                tableUpdate += "<tr><td>" + value.id + "</td><td id = 'numberUpdate" + value.id + "'>" + value.number +
                    "</td><td id = 'blockUpdate" + value.id + "'>" + value.block + "</td>" +
                    "</td><td id = 'typeUpdate" + value.id + "'>" + value.type + "</td>" +
                    "</td><td id = 'capacityUpdate" + value.id + "'>" + value.capacity + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillUpdateInputs(" + value.id + ")' type='radio' name='update' value='" + value.id + "'> Update</label></td></tr>";

                tableDelete += "<tr><td>" + value.id + "</td><td id = 'numberDelete" + value.id + "'>" + value.number +
                    "</td><td id = 'blockDelete" + value.id + "'>" + value.block + "</td>" +
                    "</td><td id = 'typeDelete" + value.id + "'>" + value.type + "</td>" +
                    "</td><td id = 'capacityDelete" + value.id + "'>" + value.capacity + "</td>" +
                    "<td><label class='btn btn-secondary btn-sm'>" +
                    " <input onchange='fillDeleteInputs(" + value.id + ")' type='radio' name='update'  value='" + value.id + "'> Delete</label></td></tr>";
            });
            tableShow += "</tbody></table>";
            tableUpdate += "</tbody></table>";
            tableDelete += "</tbody></table>";
            $("#blockCabinetShow").html(tableShow);
            $("#updateCabinetTable").html(tableUpdate);
            $("#deleteCabinetTable").html(tableDelete);
        }
    });
}