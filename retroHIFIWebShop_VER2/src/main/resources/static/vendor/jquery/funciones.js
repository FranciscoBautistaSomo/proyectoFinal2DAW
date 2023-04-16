function eliminar(producto_id) {
	var id = producto_id;
	console.log(id);
	swal({
	  title: "¿Esta seguro que quiere eliminar este producto?",
	  icon: "warning",
	  buttons: ["Cancelar", true],
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
	  	$.ajax({
	  		url:"/productos/delete/"+id,
	  		success: function(res){
	  			console.log(res);
	  		}
	  	});
	    swal("El producto se ha borrado con éxito.", {
	      icon: "success",
	    }).then((ok)=>{
	    	if(ok){
	    		location.href="/productos";
	    	}
	    });
	  } else {
		  swal("Operacion de borrado cancelada.");
	  }
	});
}