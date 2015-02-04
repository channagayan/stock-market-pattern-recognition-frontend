/**
 * Created by Chann on 12/18/2014.
 */
/**
 * Created by Chann on 12/18/2014.
 */

$(function () {
    $(document).ready(function () {
        chart = new Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });


        $('#container').highcharts({
                chart: {
                    type: 'spline',
                    animation: Highcharts.svg, // don't animate in old IE
                    marginRight: 10,
                    events: {
                        load: function () {
                            var series = this.series[0];
                            var connection = new WebSocket('ws://localhost:8091');
                            connection.onmessage = function (event) {
                                var x = (new Date()).getTime(), // current time
                                    y = parseInt(event.data);
                                series.addPoint([x, y], true, true);
                                getNewPattern();
                            };

                        }
                    }
                },
                title: {
                    text: 'Stock Price'
                },
                xAxis: {
                    type: 'datetime',
                    tickPixelInterval: 150
                },
                yAxis: {
                    title: {
                        text: 'Value'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.series.name + '</b><br/>' +
                            Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                            Highcharts.numberFormat(this.y, 2);
                    }
                },
                legend: {
                    enabled: false
                },
                exporting: {
                    enabled: false
                },
                series: [{
                    name: 'Company ABC1 Pvt Ltd',
                    data: (function () {
                        var data = [],
                            time = (new Date()).getTime(),
                            i;

                        for (i = -19; i <= 0; i += 1) {
                            data.push({
                                x: time + i * 1000,
                                y: 5
                            });
                        }
                        return data;
                    }())
                }]

            }
        );
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