/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * @Created : 1/13/2015.
 * Handle functions related to Pattern display
 */




$(function () {
    $("#date").val(moment().format('MMMM Do YYYY'));
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
            text: 'Selected Pattern'
        },
        series: [{
            data: [
                [1,200],
                [2,200],
                [3,200]]
        },{data:[
            [1,500],
            [1.6,500],
            [1.8,500],
            [1.9,500],
            [2,500],
            [2.3,500],
            [2.4,500],
            [3,500]]}]
    });
});
$(function () {<!--from w  w  w .j  ava 2 s  .  c  o m-->
    $('#SubPatternContainer').highcharts({

        plotOptions: {
            series: {
                //events: {
                    update: function (event) {

                    }
               // }

            }
        },
        title: {
            text: 'Selected Pattern'
        },
        series: [{
            data: [
                [1,200],
                [2,200],
                [3,200]]
        },{data:[
            [1,500],
            [1.6,500],
            [1.8,500],
            [1.9,500],
            [2,500],
            [2.3,500],
            [2.4,500],
            [3,500]]}]
    });
});
function loadGraph(patternId,patternName) {
    getPatternData(patternId,patternName);
}
function loadSubGraph(patternId,patternName) {
    getSubPatternData(patternId,patternName);
}
function getSubPatternData(patternId,patternName){
    $.ajax({
        url: "/arcane/patternData1?patternId="+patternId+"&patternName="+patternName,
        type: "get",
        cache: false,

        success: function(data) {
            //var chart = $('#SubPatternContainer').highcharts();
            //chart.series[0].update({
                //data:data
            //var tempdata=String(data);
            //var d = "[{data:[[1,200],[2,200],[3,200]]}]";
            //alert(data+d);
            reloadSubGraph(data);
            //});
        },
        error:function(xhr, status, error){
            alert(xhr.responseText);
        }
    });
}
function getPatternData(patternId,patternName){
    $.ajax({
        url: "/arcane/patternData1?patternId="+patternId+"&patternName="+patternName,
        type: "get",
        cache: false,

        success: function(data) {

            reloadGraph(data);
        },
        error:function(xhr, status, error){
            alert(xhr.responseText);
        }
    });
}


function reloadSubGraph(data){
    $(function () {
        $('#SubPatternContainer').highcharts({

            plotOptions: {
                series: {
                events: {
                    update: function (event) {

                    }
                }

                 }
            },
            title: {
                text: 'Selected Pattern'
            },
            series:[{
                data: data[0]
            },{data:data[1]
            }]
        });
    });
}
function reloadGraph(data){
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
                text: 'Selected Pattern'
            },
            series: [{
                data: data[0]
            },{data:data[1]
            }]
        });
    });
}
function getPatternPage(name)
{

    $.ajax({
        url:"arcane/patternTypeList?patternName="+name,
        success: function(data) {
            $( "#page-wrapper" ).load( "/arcane/patternTypeList?patternName="+name );
           // $("#date").val(moment().format('MMMM Do YYYY, h:mm:ss a'));
        }
    });
}