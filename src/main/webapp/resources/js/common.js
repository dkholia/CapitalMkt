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



