//Funcion para controlar el input de cantidad de producto en el proceso de compra.
//Function to control the product quantity input in the purchasing process.
var max = document.getElementById("stock").value;
var min = 1;

//Función para comprobar la cantidad introducida.
//Function to check the quantity entered.
function comprobar(){
	var valorActual = document.getElementById("cantidad").value;
	if(max == 0){
	swal("Producto fuera de stock", `Stock actual:: ${max}`); 
	return false;
	}else 	if (valorActual > max || valorActual < min ) {
		return false;
	}
}

// se crean la funcion y se agrega al evento onclick en en la etiqueta button con id aumentar
// create the function and add it to the onclick event in the button tag with id increase
function aumentar() { 

  var inicio = document.getElementById("cantidad").value;
  var incrementado = ++inicio;

  if (incrementado > max) {
	 swal("Máximo permitido alcanzado!!", `Máximo permitido:: ${max}`); 
     return false;
  }
  //se obtiene el valor del input, y se incrementa en 1 el valor que tenga.
  //the value of the input is obtained, and its value is incremented by 1.
  var cantidad = document.getElementById('cantidad').value = incrementado;
}

//funciones decremento
//functions decrease

// se crean la funcion y se agrega al evento onclick en en la etiqueta button con id disminuir
// the function is created and added to the onclick event in the button tag with id decrease
function disminuir() { 
  var inicio = document.getElementById("cantidad").value;

  var decrementado = --inicio;
  if (decrementado < min) {
	 swal("Mínimo permitido alcanzado!!", `Mínimo permitido:: ${min}`);   
     return false;
  }
  //se obtiene el valor del input, y se decrementa en 1 el valor que tenga.
  //the value of the input is obtained, and its value is decremented by 1.
  var cantidad = document.getElementById('cantidad').value = decrementado; 
}