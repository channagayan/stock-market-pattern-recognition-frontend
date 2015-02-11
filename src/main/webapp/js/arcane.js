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
 * @Created : 11/24/2014.
 * Handle functions in ARCANE Dashboard
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
    alert("hello");
    $("#date").val(moment().format('MMMM Do YYYY, h:mm:ss a'));
    alert("hello here out");
});


function getPatternPage(name)
{
    document.getElementById("active").innerHTML = "whatever";
    $.ajax({
        url:"arcane/patternTypeList?patternName="+name,
        success: function(data) {
            $( "#page-wrapper" ).load( "/arcane/patternTypeList?patternName="+name );
        }
    });
}

