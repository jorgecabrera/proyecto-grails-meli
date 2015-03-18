$(document).ready(function(){
	var val = "";
	var link="/proyecto-grails-meli/cumpleanios/verCumpleanios";
	var apagarBoton=function(){
		$('#verCumpleanios').click(function() {
			if($('#empresasid').val()==""){

				$("#errorMessage").html("Por favor, ingrese su empresa");
				$("#divError").show();
				return false;
			}
			return true;
		});
	};
	apagarBoton();
	$("#divError").hide();
	$('#empresasid').change(function() {

    val = $(this).val();

    $("#verCumpleanios").attr('href', function(i, h) {
		if(val==""){
			
			apagarBoton();
			return;
		}
		$('#verCumpleanios').click(function() {
			return false;	
		});
		$('#verCumpleanios').off("click")
        return link+"/"+val;

	    });
	});
});