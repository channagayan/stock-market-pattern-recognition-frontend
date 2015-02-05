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
                        getNewPattern();

                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.round(Math.random() * 100);
                            z = parseInt(event.data)+3;
                            a = parseInt(event.data);
                            b = parseInt(event.data)+5;
                            c = parseInt(event.data);
                            series.addPoint([x, y,z,a,c], true, true);
                        }, 1000);
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
            text : 'Live random data'
        },

        exporting: {
            enabled: false
        },

        series : [{
            type: 'candlestick',
            name : 'Random data',
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


function getNewPattern()
{
    $.ajax({
        success: function(data) {
            $("#patternList").empty();
            $( "#patternList" ).load( "/arcane #patternList" );
        }
    });
}