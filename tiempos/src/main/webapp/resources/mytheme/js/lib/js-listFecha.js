/**
 * 
 */

function addFecha() {
	$('#fechaDialog').dialog("option", "title", 'Generar dias anualmente');
	$('#fechaDialog').dialog('open');
}


function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#fechaDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#fechaForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#fechaForm'));

			$(this).dialog('close');
		}
	});

});