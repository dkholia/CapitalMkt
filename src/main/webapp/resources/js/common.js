var endDate = new Date();

$(function(){
	$("#dialog-div").dialog({  //create dialog, but keep it closed
		autoOpen: false,
		height: 300,
		width: 350,
		modal: true
	});
});

function showDialog(url){  //load content and open dialog
	$("#dialog-div").load(url);
	$("#dialog-div").dialog("open");         
}

$(window).load(function(){
	(function ($, window) {

	    $.fn.contextMenu = function (settings) {

	        return this.each(function () {

	            // Open context menu
	            $(this).on("contextmenu", function (e) {
	                // return native menu if pressing control
	                if (e.ctrlKey) return;
	                
	                //open menu
	                var $menu = $(settings.menuSelector)
	                    .data("invokedOn", $(e.target))
	                    .show()
	                    .css({
	                        position: "absolute",
	                        left: getMenuPosition(e.clientX, 'width', 'scrollLeft'),
	                        top: getMenuPosition(e.clientY, 'height', 'scrollTop')
	                    })
	                    .off('click')
	                    .on('click', 'a', function (e) {
	                        $menu.hide();
	                
	                        var $invokedOn = $menu.data("invokedOn");
	                        var $selectedMenu = $(e.target);
	                        
	                        settings.menuSelected.call(this, $invokedOn, $selectedMenu);
	                    });
	                
	                return false;
	            });

	            //make sure menu closes on any click
	            $('body').click(function () {
	                $(settings.menuSelector).hide();
	            });
	        });
	        
	        function getMenuPosition(mouse, direction, scrollDir) {
	            var win = $(window)[direction](),
	                scroll = $(window)[scrollDir](),
	                menu = $(settings.menuSelector)[direction](),
	                position = mouse + scroll;
	                        
	            // opening menu would pass the side of the page
	            if (mouse + menu > win && menu < mouse) 
	                position -= menu;
	            
	            return position;
	        }    

	    };
	})(jQuery, window);
	
	$(".contextMenu").contextMenu({
	    menuSelector: "#contextMenu",
	    menuSelected: function (invokedOn, selectedMenu) {
	       /* var msg = "You selected the menu item '" + selectedMenu.text() +
	            "' on the value '" + invokedOn.text() + "'";
	        alert(msg);*/
	    }
	});
	
	$('.selectAll').click(function(e){
		var table= $(e.target).closest('table');
		$('td input:checkbox',table).prop('checked',e.target.checked);
	});
	
});

$(function() {
	$('#main-menu').smartmenus({
		subMenusSubOffsetX : 10,
		subMenusSubOffsetY : -80
	});
	$('.table').css("width","100%");
	$('.table-striped').addClass("table-hover");
	$('.table-striped').DataTable( {
		  "lengthMenu": [ [5,10, 25, 50, -1], [5,10, 25, 50, "All"] ]
	});
	
});

$(function() {
    $( ".datepicker" ).datepicker({
    	  changeMonth: true,
    	  changeYear: true,
    	  yearRange: "c-100:c",
    	  altFormat: "MM/dd/yyyy",
    	  gotoCurrent: true,
    	  showButtonPanel: true,
    	  endDate:'+0d'
    });
  });

$('form,input,select,textarea').attr("autocomplete", "off");

$( ".reset" ).click(function() {
    $(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio').val('');
    $(':checkbox, :radio').prop('checked', false);
});

function logout() {
	document.getElementById("logoutForm").submit();
}

function deleteUser(userid) {
	//$( "#mainform").trigger( "submit");
	var jqxhr = $.post( "http://localhost:18080/CapitalMkt/home/channeluser/"+userid+"/deleteUser", function() {
		})
		  .done(function() {
		  })
		  .fail(function() {
		  })
		  .always(function() {
			  $( "#message-div" ).css("color","green").text( "User deleted successfully" ).show().fadeOut( 2000 );
		  });
	/*$.ajax({
		  type: "POST",
		  url: "./home/channeluser/"+userid+"/deleteUser"
	});*/
	//$( "#mainform").trigger( "submit");
}

function showWaitScreen(formname){
	var msg="Please wait ...";
	$(document).ready(function() {
 		$("body").prepend('<div id="overlay"  style="z-index: 5000; opacity:0.1; background-color:#ccc;position:fixed;width:100%;height:100%;top:0px;left:0px;z-index:5000;filter:alpha(opacity=5);"></div>');
 		$("body").prepend("<div id='PleaseWaitText' style='z-index: 5500; position:absolute;top:50%;left:45%;opacity:0.5;'><center>"+msg+"</center></img></center></div>");
 		$("body").prepend("<div id='PleaseWait' style='z-index: 6000; position:absolute;top:35%;left:44%;'><center><img src='/CapitalMkt/resources/images/loading.gif'></img></center></div>");
   	});
	$("#"+formname).submit(function() {
		var pass = true;
		if(pass == false){
		   return false;
		}
		$("#overlay, #PleaseWait , #PleaseWaitText").show();
		return true;
	});
}

function getStates(element) {

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/CapitalMkt/states?countryCode="+ $("#"+element).val(),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			$('#states')[0].options.length = 0;
			 $('#states').append('<option value="">--Select Please--</option>');
			$.each( data.result, function( key, value ) {
				 $('#states').append('<option value="' + value.id + '">' + value.value + '</option>');
			});
		},
		error : function(e) {
			alert("ERROR: "+ e.errText);
		}
	});
}

function moveRight(){
	$('#servicesassoc :selected').each(function(i, sel){ 
	    $(sel).remove();
	    $('#linkedServices').append( $(sel));
	});
}

function moveAllRight(){
	selectAll('servicesassoc');
	moveRight();
}

function moveLeft(){
	$('#linkedServices :selected').each(function(i, sel){ 
	    $(sel).remove();
	    $('#servicesassoc').append( $(sel));
	});
}

function moveAllLeft(){
	selectAll('linkedServices');
	moveLeft();
}

function selectAll(id){
	 $('select#'+id+ '> option').prop('selected', 'selected');
}