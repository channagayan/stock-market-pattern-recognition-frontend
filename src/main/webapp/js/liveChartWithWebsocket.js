/**
 * Created by Chann on 12/18/2014.
 */
/**
 * Created by Chann on 12/18/2014.
 */

$(function () {

    Highcharts.setOptions({
        global : {
            useUTC : false
        }
    });

    // Create the chart
    $('#container').highcharts('StockChart', {
        chart : {
            events : {
                load : function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    var connection = new WebSocket('ws://localhost:8091');
                    connection.onmessage = function (event) {
                        var active=$("#active").text();
                        if(active==="yes"){
                        getNewPattern();
                        }

                        var json=JSON.parse(event.data);

                        var company =getSelectedCompany();
                        if(json.stock===company){
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = parseInt(json.open);
                            z = parseInt(json.high);
                            a = parseInt(json.low);
                            b = parseInt("4");
                            c = parseInt(json.close);
                            series.addPoint([x, y,z,a,c], true, true);
                        }, 10000);
                        }else{
                        //recieved data is from other company, do nothing
                        }
                    }
                }
            }
        },

        rangeSelector: {
            buttons: [{
                count: 1,
                type: 'minute',
                text: '1M'
            }, {
                count: 5,
                type: 'minute',
                text: '5M'
            }, {
                type: 'all',
                text: 'All'
            }],
            inputEnabled: false,
            selected: 0
        },

        title : {
            text : 'Live Stock Price'
        },

        exporting: {
            enabled: false
        },

        series : [{
            type: 'candlestick',
            name : 'Stock Data',
            data : (function () {
                // generate an array of random data
                var data = [], time = (new Date()).getTime(), i;

                for (i = -999; i <= 0; i += 1) {
                    data.push([
                            time + i * 1000,
                        Math.round(Math.random() * 100),
                        Math.round(Math.random() * 100),
                        Math.round(Math.random() * 100),
                        Math.round(Math.random() * 100),
                        Math.round(Math.random() * 100)
                    ]);
                }
                return data;
            }())
        }]
    });

});



function getNewPattern()
{

    $.ajax({
        success: function(data) {
            $("#patternList").empty();
            $( "#patternList" ).load( "/arcane #patternList" );
        }
    });
}
function getSelectedCompany(){
    var companySelect = document.getElementById("company");
    var company =companySelect.options[companySelect.selectedIndex].value;
    return company;
}

