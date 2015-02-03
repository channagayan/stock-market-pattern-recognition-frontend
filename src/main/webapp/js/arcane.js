/**
 * Created by DELL on 11/24/2014.
 */
function test() {
    alert("name");
}
$(function() {
    $('#pattern').multipleSelect({
        placeholder: "Select Patterns",
        width: '100%',
        filter: true
    });
    $("#company").multipleSelect({
        placeholder: "Select a Company",
        single: true,
        width: '100%',
        filter: true
    });
});