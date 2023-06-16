const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const valido = false;



const expresiones = {
	username: /^[a-zA-Z0-9\_\-]{4,20}$/, // Letras, numeros, guion y guion_bajo
	nombre: /^[a-zA-ZÀ-ÿ\s]{4,40}$/, // Letras y espacios, pueden llevar acentos.
	apellidos: /^[a-zA-ZÀ-ÿ\s]{4,40}$/, // Letras y espacios, pueden llevar acentos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^(\(\+?\d{2,3}\)[\*|\s|\-|\.]?(([\d][\*|\s|\-|\.]?){7})(([\d][\s|\-|\.]?){2})?|(\+?[\d][\s|\-|\.]?){9}(([\d][\s|\-|\.]?){2}(([\d][\s|\-|\.]?){2})?)?)$/, // 7 a 14 numeros.
	direccion: /^[A-Za-z0-9'\.\-\s\,]+$/, //Sin caracteres especiales.
	password: /^.{4,12}$/ // 4 a 12 digitos.
}

const campos = {
	username: false,
	nombre: false,
	apellidos: false,
	correo: false,
	telefono: false,
	direccion: false,
	password: false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "username":
			validarCampo(expresiones.username, e.target, 'username');
		break;
		case "nombre":
			validarCampo(expresiones.nombre, e.target, 'nombre');
		break;
		case "apellidos":
			validarCampo(expresiones.apellidos, e.target, 'apellidos');
		break;		
		case "email":
			validarCampo(expresiones.correo, e.target, 'correo');
		break;
		case "telefono":
			validarCampo(expresiones.telefono, e.target, 'telefono');
		break;
		case "direccion":
			validarCampo(expresiones.direccion, e.target, 'direccion');
		break;
		case "password":
			validarCampo(expresiones.password, e.target, 'password');
			validarPassword2();
		break;
		case "password2":
			validarPassword2();
		break;
	}
}

const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
}

const validarPassword2 = () => {
	const inputPassword1 = document.getElementById('password');
	const inputPassword2 = document.getElementById('password2');

	if(inputPassword1.value !== inputPassword2.value){
		document.getElementById(`grupo__password2`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__password2`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__password2 i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__password2 i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__password2 .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos['password'] = false;
	} else {
		document.getElementById(`grupo__password2`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__password2`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__password2 i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__password2 i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__password2 .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos['password'] = true;
	}
}

function check(){	
	if(campos.username && campos.nombre && campos.apellidos && campos.telefono && campos.correo && campos.direccion && campos.password && terminos.checked ){
		//document.getElementById('submit').removeAttribute('disabled');
		document.getElementById('submit').classList.remove('disabled');
		document.getElementById('formulario__mensaje').classList.remove('formulario__mensaje-activo');
	}else{
		//document.getElementById('submit').setAttribute("disabled", "");
		document.getElementById('submit').classList.add('disabled');
		document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
	}	
}

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('keyup', check);
	input.addEventListener('blur', validarFormulario);
});

var eventcheck = document.querySelector("input[name=terminos]");
    eventcheck.addEventListener( 'change', function() {
	    if(this.checked) {
	        check();
	    }
});

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

