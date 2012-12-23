$(function() {


    $('input[name^="existing.piirivalvur["]').change(function(){
        var elementName = $(this).attr("name");
        var bracket1 = elementName.indexOf("[");
        var bracket2 = elementName.indexOf("]");
        var counter = elementName.substr(bracket1+1, bracket2-bracket1-1);
        $('input[name="existing.piirivalvur['+counter+']"]').val("changed");
    });

    $('input[name^="existing.tyyp["]').change(function(){
        var elementName = $(this).attr("name");
        var bracket1 = elementName.indexOf("[");
        var bracket2 = elementName.indexOf("]");
        var counter = elementName.substr(bracket1+1, bracket2-bracket1-1);
        $('input[name="existing.tyyp['+counter+']"]').val("changed");
    });

    $('input[name^="existing.auaste["]').change(function(){
        console.log("asd");
        var elementName = $(this).attr("name");
        var bracket1 = elementName.indexOf("[");
        var bracket2 = elementName.indexOf("]");
        var counter = elementName.substr(bracket1+1, bracket2-bracket1-1);
        $('input[name="existing.auaste['+counter+']"]').val("changed");
    });

    $('a[id^="toggle-pv-"]').click(function(e){
        e.preventDefault();
        console.log("click");
        var count = $(this).attr("rel");
        $("#pv-table-"+count).toggle();
    });

});