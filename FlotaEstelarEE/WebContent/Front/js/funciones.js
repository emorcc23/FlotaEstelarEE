
/*
		01 iniciar componentes
		02 area usuario
		02.01 abrir area usuario
		02.02 cerrar area usuario
		03 login/nuevo usuario
		04.01	insertar nave
		04.02	ver nave
		04.03	paso 1 actualizar nave
		04.04	paso 2 actualizar nave
		04.05	eliminar nave
		05.01	insertar tripulante
		05.02	ver tripulante
		05.03	paso 1 actualizar tripulante
		05.04	paso 2 actualizar tripulante
		05.05	eliminar tripulante
		06.01	insertar mision 
		06.02	ver mision
		06.03	paso 1 actualizar mision
		06.04	paso 2 actualizar mision
		06.05	eliminar mision
		07.01	insertar cuaderno 
		07.02	ver cuaderno
		07.03	paso 1 actualizar cuaderno
		07.04	paso 2 actualizar cuaderno
		07.05	eliminar cuaderno
 */

var x;
x = $(document);
x.ready(iniciarComponentes);

// 01 iniciar componentes
function iniciarComponentes() {
	var x;
	x = $(document);
	x.ready(abrirAreaUsuario);
	x.ready(abrirRegistroNave);
	x.ready(abrirRegistroTripulante);
	x.ready(abrirRegistroMision);
	x.ready(abrirRegistroCuaderno);
	x.ready(abrirTablaEliminarNave);
	x.ready(abrirTablaEliminarTripulante);
	x.ready(abrirTablaEliminarMision);
	x.ready(abrirTablaEliminarCuaderno);
	x.ready(abrirPasoUnoActualizarNave);
	x.ready(abrirPasoUnoActualizarTripulante);
	x.ready(abrirPasoUnoActualizarMision);
	x.ready(abrirPasoUnoActualizarCuaderno);
	x.ready(listarNaves);
	x.ready(listarTripulantes);
	x.ready(listarMisiones);
	x.ready(listarCuadernos);
	
}

/*- --------------------------------------------------02 area usuario-------------------------------------------- -*/
function abrirAreaUsuario() {
	var x = $("#formulario");
	x.hide();
	x = $("#img-salir");
	x.click(ocultarAreaUsuario);
	x = $("#area-usuarios");
	x.click(mostrarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}


function abrirTablaEliminarCuaderno() {
	var x = $("#tabla-eliminar-cuaderno");
	x = $("#img-salir-eliminar-cuaderno");
	x.click(ocultarEliminarCuaderno);
	x = $("#btn-eliminar-cuaderno");
	x.click(mostrarEliminarCuaderno);
	
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
}

function abrirTablaEliminarMision() {
	var x = $("#tabla-eliminar-mision");
	x = $("#img-salir-eliminar-mision");
	x.click(ocultarEliminarMision);
	x = $("#btn-eliminar-mision");
	x.click(mostrarEliminarMision);
	
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarCuaderno);
}

function abrirTablaEliminarTripulante() {
	var x = $("#tabla eliminar-tripulante");
	x = $("#img-salir-eliminar-tripulante");
	x.click(ocultarEliminarTripulante);
	x = $("#btn-eliminar-tripulante");
	x.click(mostrarEliminarTripulante);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirTablaEliminarNave() {
	var x = $("#tabla eliminar-nave");
	x = $("#img-salir-eliminar-nave");
	x.click(ocultarEliminarNave);
	x = $("#btn-eliminar-nave");
	x.click(mostrarEliminarNave);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirRegistroCuaderno() {
	var x = $("#form-registro-cuaderno");
	x = $("#img-salir-nuevo-cuaderno");
	x.click(ocultarRegistroCuaderno);
	x = $("#btn-anadir-cuaderno");
	x.click(mostrarRegistroCuaderno);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirRegistroMision() {
	var x = $("#form-registro-mision");
	x = $("#img-salir-nuevo-mision");
	x.click(ocultarRegistroMision);
	x = $("#btn-anadir-mision");
	x.click(mostrarRegistroMision);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirRegistroTripulante() {
	var x = $("#form-registro-tripulante");
	x = $("#img-salir-nuevo-tripulante");
	x.click(ocultarRegistroTripulante);
	x = $("#btn-anadir-tripulante");
	x.click(mostrarRegistroTripulante);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirRegistroNave() {
	var x = $("#form-registro-nave");
	x = $("#img-salir-nueva-nave");
	x.click(ocultarRegistroNave);
	x = $("#btn-anadir-nave");
	x.click(mostrarRegistroNave);
	x.click(ocultarAreaUsuario);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}



function abrirPasoUnoActualizarCuaderno() {
	var x = $("#tabla-actualizar-cuaderno");
	x.hide();
	x = $("#img-salir-actualizar-cuaderno");
	x.click(ocultarTablaPasoUnoActualizarCuaderno);
	x = $("#btn-actualizar-cuaderno");
	x.click(mostrarTablaPasoUnoActualizarCuaderno);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirPasoUnoActualizarMision() {
	var x = $("#tabla-actualizar-mision");
	x.hide();
	x = $("#img-salir-actualizar-mision");
	x.click(ocultarTablaPasoUnoActualizarMision);
	x = $("#btn-actualizar-mision");
	x.click(mostrarTablaPasoUnoActualizarMision);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirPasoUnoActualizarTripulante() {
	var x = $("#tabla-actualizar-tripulante");
	x.hide();
	x = $("#img-salir-actualizar-tripulante");
	x.click(ocultarTablaPasoUnoActualizarTripulante);
	x = $("#btn-actualizar-tripulante");
	x.click(mostrarTablaPasoUnoActualizarTripulante);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirPasoUnoActualizarNave() {
	var x = $("#tabla-actualizar-nave");
	x.hide();
	x = $("#img-salir-actualizar-nave");
	x.click(ocultarTablaPasoUnoActualizarNave);
	x = $("#btn-actualizar-nave");
	x.click(mostrarTablaPasoUnoActualizarNave);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function abrirPasoDosActualizarNave() {
	var x = $("#tabla-actualizar-nave-dos");
	x.hide();
	x = $("#img-salir-actualizar-nave-dos");
	x.click(ocultarTablaPasoDosActualizarNave);
	x = $("#btn-paso1-actualizar-nave");
	x.click(mostrarTablaPasoDosActualizarNave);
}

function mostrarTablaPasoUnoActualizarCuaderno() {
	var x = $("#tabla-actualizar-cuaderno");
	x.show("fast");
}

function ocultarTablaPasoUnoActualizarCuaderno() {
	var x = $("#tabla-actualizar-cuaderno");
	x.hide("fast");
}

function mostrarTablaPasoUnoActualizarMision() {
	var x = $("#tabla-actualizar-mision");
	x.show("fast");
}

function ocultarTablaPasoUnoActualizarMision() {
	var x = $("#tabla-actualizar-mision");
	x.hide("fast");
}

function mostrarTablaPasoUnoActualizarTripulante() {
	var x = $("#tabla-actualizar-tripulante");
	x.show("fast");
}

function ocultarTablaPasoUnoActualizarTripulante() {
	var x = $("#tabla-actualizar-tripulante");
	x.hide("fast");
}

function mostrarTablaPasoUnoActualizarNave() {
	var x = $("#tabla-actualizar-nave");
	x.show("fast");
}

function ocultarTablaPasoUnoActualizarNave() {
	var x = $("#tabla-actualizar-nave");
	x.hide("fast");
}

function mostrarTablaPasoDosActualizarNave() {
	var x = $("#form-actualizar-nave");
	x.show("fast");
}

function ocultarTablaPasoDosActualizarNave() {
	var x = $("#form-actualizar-nave-dos");
	x.hide("fast");
}

function mostrarTablaPasoDosActualizarNave() {
	var x = $("#form-actualizar-nave-dos");
	x.show("fast");
}

function ocultarTablaPasoDosActualizarNave() {
	var x = $("#form-actualizar-nave");
	x.hide("fast");
}

function mostrarAreaUsuario() {
	var x = $("#formulario");
	x.show("fast");
}

function ocultarAreaUsuario() {
	var x = $("#formulario");
	x.hide("fast");
}

function mostrarRegistroNave() {
	var x = $("#form-registro-nave");
	x.show("fast");
}

function ocultarRegistroNave() {
	var x = $("#form-registro-nave");
	x.hide("fast");
}

function mostrarRegistroTripulante() {
	var x = $("#form-registro-tripulante");
	x.show("fast");
}

function ocultarRegistroTripulante() {
	var x = $("#form-registro-tripulante");
	x.hide("fast");
}

function mostrarRegistroMision() {
	var x = $("#form-registro-mision");
	x.show("fast");
}

function ocultarRegistroMision() {
	var x = $("#form-registro-mision");
	x.hide("fast");
}

function mostrarRegistroCuaderno() {
	var x = $("#form-registro-cuaderno");
	x.show("fast");
}

function ocultarRegistroCuaderno() {
	var x = $("#form-registro-cuaderno");
	x.hide("fast");
}

function mostrarEliminarNave() {
	var x = $("#tabla-eliminar-nave");
	x.show("fast");
}

function ocultarEliminarNave() {
	var x = $("#tabla-eliminar-nave");
	x.hide("fast");
}

function mostrarEliminarTripulante() {
	var x = $("#tabla-eliminar-tripulante");
	x.show("fast");
}

function ocultarEliminarTripulante() {
	var x = $("#tabla-eliminar-tripulante");
	x.hide("fast");
}

function mostrarEliminarMision() {
	var x = $("#tabla-eliminar-mision");
	x.show("fast");
}

function ocultarEliminarMision() {
	var x = $("#tabla-eliminar-mision");
	x.hide("fast");
}

function mostrarEliminarCuaderno() {
	var x = $("#tabla-eliminar-cuaderno");
	x.show("fast");
}

function ocultarEliminarCuaderno() {
	var x = $("#tabla-eliminar-cuaderno");
	x.hide("fast");
}

function mostrarNaves() {
	var x = $("#tabla-listar-nave");
	x.show("fast");
}

function ocultarNaves() {
	var x = $("#tabla-listar-nave");
	x.hide("fast");
}

function mostrarTripulantes() {
	var x = $("#tabla-listar-tripulante");
	x.show("fast");
}

function ocultarTripulantes() {
	var x = $("#tabla-listar-tripulante");
	x.hide("fast");
}

function mostrarMisiones() {
	var x = $("#tabla-listar-mision");
	x.show("fast");
}

function ocultarMisiones() {
	var x = $("#tabla-listar-mision");
	x.hide("fast");
}

function mostrarCuadernos() {
	var x = $("#tabla-listar-cuaderno");
	x.show("fast");
}

function ocultarCuadernos() {
	var x = $("#tabla-listar-cuaderno");
	x.hide("fast");
}

function listarNaves() {
	var x = $("#tabla-listar-nave");
	x.hide();
	x = $("#img-salir-listar-nave");
	x.click(ocultarNaves);
	x = $("#btn-listar-nave");
	x.click(mostrarNaves);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function listarTripulantes() {
	var x = $("#tabla-listar-tripulante");
	x.hide();
	x = $("#img-salir-listar-tripulante");
	x.click(ocultarTripulantes);
	x = $("#btn-listar-tripulante");
	x.click(mostrarTripulantes);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function listarMisiones() {
	var x = $("#tabla-listar-mision");
	x.hide();
	x = $("#img-salir-listar-mision");
	x.click(ocultarMisiones);
	x = $("#btn-listar-mision");
	x.click(mostrarMisiones);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

function listarCuadernos() {
	var x = $("#tabla-listar-cuaderno");
	x.hide();
	x = $("#img-salir-listar-cuaderno");
	x.click(ocultarCuadernos);
	x = $("#btn-listar-cuaderno");
	x.click(mostrarCuadernos);
	x.click(ocultarRegistroNave);
	x.click(ocultarRegistroTripulante);
	x.click(ocultarRegistroMision);
	x.click(ocultarRegistroCuaderno);
	x.click(ocultarEliminarNave);
	x.click(ocultarEliminarTripulante);
	x.click(ocultarEliminarMision);
	x.click(ocultarEliminarCuaderno);
}

