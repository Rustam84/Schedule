$( "#button1" ).click(function() {
    $("#blockSubject1").css('display','block');
    $("#blockSubject2").css('display','none');
    $("#blockSubject3").css('display','none');
    $("#blockSubject4").css('display','none');
});
$( "#button2" ).click(function() {
    $("#blockSubject1").css('display','none');
    $("#blockSubject2").css('display','block');
    $("#blockSubject3").css('display','none');
    $("#blockSubject4").css('display','none');
});
$( "#button3" ).click(function() {
    $("#blockSubject1").css('display','none');
    $("#blockSubject2").css('display','none');
    $("#blockSubject3").css('display','block');
    $("#blockSubject4").css('display','none');
});
$( "#button4" ).click(function() {
    $("#blockSubject1").css('display','none');
    $("#blockSubject2").css('display','none');
    $("#blockSubject3").css('display','none');
    $("#blockSubject4").css('display','block');
});
$("input[type=radio][name=update]").change(function()
{
    var id = this.value;
    $("#idUpdate").val(id);
    $("#nameUpdate").val($("#nameUpdate" + id).text());
    $("#abbrUpdate").val($("#abbrUpdate" + id).text());
});
$("input[type=radio][name=delete]").change(function()
{
    var id = this.value;
    $("#idDelete").val(id);
    $("#nameDelete").val($("#nameDelete" + id).text());
    $("#abbrDelete").val($("#abbrDelete" + id).text());
});