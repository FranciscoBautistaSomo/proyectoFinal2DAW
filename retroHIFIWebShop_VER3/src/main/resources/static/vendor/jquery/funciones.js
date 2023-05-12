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