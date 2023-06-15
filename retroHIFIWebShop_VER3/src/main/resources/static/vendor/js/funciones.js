
function confirm(orden_total) {
	var totalOrden = orden_total;
	/*swal({
		title: "Enhorabuena!",
		text: "Su pedido por un importe de" + totalOrden + ", ha sido confirmado.",
		icon: "success",
		buttons: true,
		dangerMode: true,
	}).then((OK) => {
		if (OK) {
			location.href = "/usuario/home";
		}
	});*/
	swal({
		title: "Enhorabuena!",
		text: "Su pedido por un importe de " + totalOrden + " €, ha sido confirmado.",
		icon: "success",		
		/*buttons: ["Cancelar", true],*/
		dangerMode: true,
	}).then((OK) => {
		if (OK) {
				$.ajax({
				//url: "/productos/delete/" + id,
				success: function(res) {
					console.log(res);
				}
				}).then((ok) => {
				if (ok) {
					location.href = "/usuario/home";
					}
				});
				
			}		
	});
}

//Función para mostrar mensaje de confirmación antes de eliminar un registro.
function eliminar(producto_id) {
	var id = producto_id;
	console.log(id);
	swal({
		title: "¿Esta seguro que quiere eliminar este producto?",
		icon: "warning",
		buttons: ["Cancelar", true],
		dangerMode: true,
	}).then((OK) => {
		if (OK) {
			$.ajax({
				url: "/productos/delete/" + id,
				success: function(res) {
					console.log(res);
				}
			});
			swal("El producto se ha borrado con éxito.", {
				icon: "success",
			}).then((ok) => {
				if (ok) {
					location.href = "/productos";
				}
			});
		} else {
			swal("Operacion de borrado cancelada.");
		}
	});
}

function deshabilitarProduc(producto_id, producto_enabled) {
	var id = producto_id;
	var enabled = producto_enabled;
	var txtEnabled = "deshabilitar";
	var txtEnabled2 = "deshabilitado";
	console.log(enabled);
	if (enabled) {
		txtEnabled = "deshabilitar";
		txtEnabled2 = "deshabilitado";
	} else {
		txtEnabled = "habilitar";
		txtEnabled2 = "habilitado";
	}

	console.log(id);
	swal({
		title: "¿Esta seguro que quiere " + txtEnabled + " este producto?",
		icon: "warning",
		buttons: ["Cancelar", true],
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/productos/deshabilitar/" + id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("El producto se ha " + txtEnabled2 + " con éxito.", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/productos";
					}
				});
			} else {
				swal("Operacion  cancelada.");
			}
		});
}

function deshabilitarUser(usuario_id, usuario_enabled) {
	var id = usuario_id;
	var enabled = usuario_enabled;
	var txtEnabled = "deshabilitar";
	var txtEnabled2 = "deshabilitado";
	console.log(enabled);
	if (enabled) {
		txtEnabled = "deshabilitar";
		txtEnabled2 = "deshabilitado";
	} else {
		txtEnabled = "habilitar";
		txtEnabled2 = "habilitado";
	}

	console.log(id);
	swal({
		title: "¿Esta seguro que quiere " + txtEnabled + " este usuario?",
		icon: "warning",
		buttons: ["Cancelar", true],
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/usuario/deshabilitar/" + id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("El usuario se ha " + txtEnabled2 + " con éxito.", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/administrador/usuarios";
					}
				});
			} else {
				swal("Operacion  cancelada.");
			}
		});
}

function cerrar() {
	var close = document.getElementsByClassName("closebtn");
	var i;

	for (i = 0; i < close.length; i++) {
		close[i].onclick = function() {
			var div = this.parentElement;
			div.style.opacity = "0";
			setTimeout(function() { div.style.display = "none"; }, 600);
		}
	}
}

var seleccion = 0;

$("input[name='filtro']").on('change', function() {
	seleccion = $(this).val();
	/*alert(seleccion);*/
});



function filtro() {
	// Accede al texto de entrada y a varios elementos del DOM
	let valor = document.getElementById("searchInput").value.toUpperCase();
	let nombres = document.getElementById("names");
	let filas = nombres.getElementsByTagName("tr");

	console.log(valor);

	// Iteramos el arreglo de filas
	for (let i = 0; i < filas.length; i++) {
		// Por cada fila se obtiene la referencia a la columna lenguaje
		let columnaLenguaje = filas[i].getElementsByTagName("td")[seleccion];
		// Se extrae el texto de la columna lenguaje
		let lenguaje = columnaLenguaje.textContent;
		// Se muestra u oculta la fila si la entrada de texto
		// coincide con el texto de la columna lenguaje
		filas[i].style.display = lenguaje.toUpperCase().indexOf(valor) > -1 ? "" : "none";
	}
}
// Se agrega un escuchador de eventos a la entrada de texto
// para activar la función de filtrado cada vez que el usuario
// ingresa texto en la entrada
document.getElementById("searchInput").addEventListener("keyup", filtro);


var ShowCells = function() {
	var tbody = jQuery('tbody');
	var row = jQuery('tbody > tr');
	row.addClass('closed');
	row.click(function() {
		if ((!jQuery(this).hasClass('closed')) && (jQuery(this).parent().is("tbody"))) {
			jQuery(this).attr('class', 'closed');
		}
		else {
			row.addClass('closed');
			jQuery(this).removeClass('closed');
		}
	});
}

jQuery(document).ready(function() {
	ShowCells();
});