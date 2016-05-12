
$(function(){
$( "#createGroup" )
.click(function() {
    $( "#dialog-form" ).dialog({
        height: 140,
        modal: true
    });
           /* $.ajax({
                    url: "createeditgroup.jsp",
                    success: function(data){
                        $('#dialog-modal p').html(data);
                    }
            });*/

    });
    });