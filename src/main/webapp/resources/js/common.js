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