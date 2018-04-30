$(document).ready(
    function() {

        $('.level2').each(
            function () {
                $(this).text('&nbsp;&nbsp;&nbsp;&nbsp;' + $(this).text());
            }
        );

        $('.level3').each(
            function () {
                $(this).text('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp' + $(this).text());
            }
        );

        $('.level4').each(
            function () {
                $(this).text('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp' + $(this).text());
            }
        );

        if( $('#sector_select').length )
        {
            $('#sector_select option').prop('selected', true);
            sendToDatabase();
            $('#sector_select option').prop('selected', false);
            $('#sector_select').scrollTop(1);
        }else{
            document.getElementById("save_btn").value = "Change";
        }

    }
);

function setLevel(text) {
    var count = (text.match(/\u00A0/g) || []).length;
    if(count === 4){
        return 'level2'
    }if(count === 8){
       return 'level3'
    }if(count >= 12){
        return 'level4'
    }
    return 'level1';
}

function sendToDatabase() {

    var sectors = [];
    $("#sector_select").find("option").each(function(){
        var sec = {};
        sec['value'] = $(this).val();
        sec['level'] = setLevel($(this).text());
        sec['name'] = $(this).text().trim();
        sectors.push(sec);
    });

    $.ajax({
        type: "POST",
        url: "/sector",
        data: JSON.stringify(sectors),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });
}