var max = document.getElementById("stock").value;
var min = 1;

//Función para comprobar la cantidad introducida.
function comprobar(){
	var valorActual = document.getElementById("cantidad").value;
	if(max == 0){
	swal("Producto fuera de stock", `Stock actual:: ${max}`); 
	return false;
	}else 	if (valorActual > max || valorActual < min ) {
		return false;
	}
}

function aumentar() { // se crean la funcion y se agrega al evento onclick en en la etiqueta button con id aumentar

  var inicio = document.getElementById("cantidad").value;
  var incrementado = ++inicio;

  if (incrementado > max) {
	 swal("Máximo permitido alcanzado!!", `Máximo permitido:: ${max}`); 
     return false;
  }
  var cantidad = document.getElementById('cantidad').value = incrementado; //se obtiene el valor del input, y se incrementa en 1 el valor que tenga.
}

//funciones decremento
function disminuir() { // se crean la funcion y se agrega al evento onclick en en la etiqueta button con id disminuir
  var inicio = document.getElementById("cantidad").value;

  var decrementado = --inicio;
  if (decrementado < min) {
	 swal("Mínimo permitido alcanzado!!", `Mínimo permitido:: ${min}`);   
     return false;
  }
  var cantidad = document.getElementById('cantidad').value = decrementado; //se obtiene el valor del input, y se decrementa en 1 el valor que tenga.
}