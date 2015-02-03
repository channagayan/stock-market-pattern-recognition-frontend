/**
 * Created by Chann on 1/13/2015.
 */




$(function () {<!--from w  w  w .j  ava 2 s  .  c  o m-->
    $('#patternContainer').highcharts({

        plotOptions: {
            series: {
                events: {
                    update: function (event) {

                    }
                }

            }
        },
        title: {
            text: 'Current Pattern'
        },
        series: [{
            data: [20, 200, 100]
        }]
    });
});
function loadGraph(patternId,patternName) {
    //alert(patternId+" "+patternName);
    getPatternData(patternId,patternName);
}
function getPatternData(patternId,patternName){
    $.ajax({
        url: "/arcane/patternData?patternId="+patternId+"&patternName="+patternName,
        type: "get",
        cache: false,

        success: function(data) {
            //alert(data);
            var chart = $('#patternContainer').highcharts();
            chart.series[0].update({
                data:data
                //data: [0.0, 6.9, 9.5, 14.5, 18.2, 100, 25.2, 0.5, 23.3, 18.3, 13.9, 0.6]
            });
        },
        error:function(xhr, status, error){
            alert(xhr.responseText);
        }
    });
}