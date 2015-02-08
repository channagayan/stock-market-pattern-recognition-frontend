/**
 * Created by DELL on 11/24/2014.
 */

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

function getPatternPage(name)
{

    $.ajax({
        url:"arcane/patternTypeList?patternName="+name,
        success: function(data) {
            $( "#page-wrapper" ).load( "/arcane/patternTypeList?patternName="+name );
        }
    });
}
