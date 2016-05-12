$(function(){
	$( "#createGroup" ).click(function() {
		showDialog("http://localhost:18080/CapitalMkt/group/1/detail");
		return false;
		/* $.ajax({
                    url: "createeditgroup.jsp",
                    success: function(data){
                        $('#dialog-modal p').html(data);
                    }
            });*/
	});
});