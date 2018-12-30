<%@page import="modelo.Tripulante"%>
<%@page import="modelo.Nave"%>
<%@page import="modelo.Mision" %>
<%@page import="modelo.Cuaderno" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
Nave nave = new Nave();
Tripulante tripulante = new Tripulante();
Mision mision = new Mision();
Cuaderno cuaderno = new Cuaderno();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Flota Estelar EE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="Front/Css/estilos.css" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="Front/js/funciones.js"></script>
</head>
<body>
	<!-- --------------------------------------------------------------------------01 HEADER NAVEGADOR----------------------------------------------------------------------------------- -->
		<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<img id="icono" alt="icono" src="Front/Imagenes/icon-logo.png">
			<a class="navbar-brand" href="index.jsp">Flota Estelar EE</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">
							Home
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li id="area-usuarios" class="nav-item">
						<a class="nav-link" href="#">Área de usuarios</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Nave </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" id="btn-anadir-nave">Añadir una nueva nave</a>
							<a class="dropdown-item" id="btn-listar-nave">Ver naves</a>
							<a class="dropdown-item" id="btn-actualizar-nave">Actualizar una nave</a>
							<a class="dropdown-item" id="btn-eliminar-nave">Eliminar una nave</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Tripulante </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" id="btn-anadir-tripulante">Añadir un nuevo tripulante</a>
							<a class="dropdown-item" id="btn-listar-tripulante">Ver tripulantes</a>
							<a class="dropdown-item" id="btn-actualizar-tripulante">Actualizar un tripulante</a>
							<a class="dropdown-item" id="btn-eliminar-tripulante">Eliminar a un tripulante</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Misión </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" id="btn-anadir-mision">Añadir una nueva misión</a>
							<a class="dropdown-item" id="btn-listar-mision">Ver misiones</a>
							<a class="dropdown-item" id="btn-actualizar-mision">Actualizar una misión</a>
							<a class="dropdown-item" id="btn-eliminar-mision">Eliminar una misión</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Cuaderno de bitácora </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" id="btn-anadir-cuaderno">Añadir un nuevo cuaderno</a>
							<a class="dropdown-item" id="btn-listar-cuaderno">Ver cuadernos</a>
							<a class="dropdown-item" id="btn-actualizar-cuaderno">Actualizar un cuaderno</a>
							<a class="dropdown-item" id="btn-eliminar-cuaderno">Eliminar un cuaderno</a>
						</div>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- ---------------------------------------------------------------------------02 BACKGROUND IMAGEN----------------------------------------------------------------------------------- -->
	<img id="img-fondo" alt="img-fondo" src="Front/Imagenes/background-image.jpg">
	<!-- ---------------------------------------------------------------------------03 LOGIN/NUEVO USUARIO--------------------------------------------------------------------------------- -->


	<!-- -----------------------------------------------------------------04.04 PASO 2 ACTUALIZAR NAVE------------------------------------------------------------------------------ -->
	<section>
		<div id="formulario" class="container login-container">
			<img class="img-salir" id="img-salir" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>¿Eres nuevo?</h4>
					<form action="/FlotaEstelarEE/RegistroUsuario" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Tu Nombre *" name="nombre" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Tu Nombre de Usuario *" name="usuario" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Tu Contraseña *" name="pass" />
						</div>
						<div class="form-group">

							<button type="submit" class="btn btn-secondary btnSubmit">Registrar</button>
						</div>
					</form>
				</div>
				<div class="col-md-6 login-form-2">
					<h4>Entrar en mi cuenta</h4>
					<form action="/FlotaEstelarEE/LoginUsuario" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Tu nombre de usuario *" name="usuario">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Tu Contraseña *" name="pass" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btnSubmit">Login</button>
						</div>
						<div class="form-group">
							<a href="#" class="ForgetPwd">¿Olvidaste tu contraseña?</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------------04.01 INSERTAR NAVE----------------------------------------------------------------------------------- -->
	<section>
		<div class="form-registro" id="form-registro-nave" class="container login-container">
			<img class="img-salir" id="img-salir-nueva-nave" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Registrar nave</h4>
					<form action="/FlotaEstelarEE/ServNave2" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Capitán de la Nave" name="capitan">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Nombre de la Nave *" name="nombre" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Matrícula de la nave *" name="matricula" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Tipo de Nave *" name="tipo" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btnSubmit">Registrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------------04.02 VER NAVE----------------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-listar" id="tabla-listar-nave" class="container login-container">
			<img class="img-salir" id="img-salir-listar-nave" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<%
					out.println(nave.mostrarTablaNaves());
					%>
				</div>
			</div>
		</div>
	</section>
	<!-- -----------------------------------------------------------------04.03 PASO-1 ACTUALIZAR NAVE------------------------------------------------------------------------------ -->
	<section>
		<div class="tabla-actualizar" id="tabla-actualizar-nave" class="container login-container">
			<img class="img-salir" id="img-salir-actualizar-nave" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres actualizar:</h4>
					<% out.println(nave.mostrarTablaActualizarNavesPasoUno()); %>
				</div>
			</div>
		</div>
	</section>
	
	
	<!-- --------------------------------------------------------------------------04.05 ELIMINAR NAVE------------------------------------------------------------------------------ -->
	<section>
		<div class="tabla-eliminar" id="tabla-eliminar-nave" class="container login-container">
			<img class="img-salir" id="img-salir-eliminar-nave" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres eliminar:</h4>
					<%
					out.println(nave.mostrarTablaEliminarNaves());
					%>
				</div>
			</div>
		</div>
	</section>
	<!-- ----------------------------------------------------------------------05.01 INSERTAR TRIPULANTE------------------------------------------------------------------------------ -->
	<section>
		<div class="form-registro" id="form-registro-tripulante" class="container login-container">
			<img class="img-salir" id="img-salir-nuevo-tripulante" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Registrar Tripulante</h4>
					<form action="/FlotaEstelarEE/ServTripulante2" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Nombre del Tripulante *" name="nombre" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Cargo del Tripulante *" name="cargo" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Genero del tripulante *" name="genero" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" placeholder="Experiencia del tripulante *" name="experiencia" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Origen del tripulante *" name="origen" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Raza del tripulante *" name="raza" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" placeholder="Edad del tripulante *" name="edad" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" placeholder="ID de la nave del tripulante *" name="id_nave" />
						</div>						
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btnSubmit">Registrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------------05.02 VER TRIPULANTE---------------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-listar" id="tabla-listar-tripulante" class="container login-container">
			<img class="img-salir" id="img-salir-listar-tripulante" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<%
					out.println(tripulante.mostrarTablaTripulantes());
					%>
				</div>
			</div>
		</div>
	</section>
	<!-- --------------------------------------------------------------------05.03 PASO 1 ACTUALIZAR TRIPULANTE----------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-actualizar" id="tabla-actualizar-tripulante" class="container login-container">
			<img class="img-salir" id="img-salir-actualizar-tripulante" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres actualizar:</h4>
					<form action="ActualizarTripulante" method="POST">
					<% out.println(tripulante.mostrarTablaActualizarTripulantesPasoUno()); %>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- -----------------------------------------------------------------------05.04 PASO 2 ACTUALIZAR NAVE------------------------------------------------------------------------------ -->

	<!-- ---------------------------------------------------------------------------05.05 ELIMINAR TRIPULANTE----------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-eliminar" id="tabla-eliminar-tripulante" class="container login-container">
			<img class="img-salir" id="img-salir-eliminar-tripulante" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres eliminar:</h4>
					<% out.println(tripulante.mostrarTablaEliminarTripulantes()); %>
				</div>
			</div>
		</div>
	</section>
	<!-- ------------------------------------------------------------------------06.01-INSERTAR-MISION----------------------------------------------------------------------------- -->
	<section>
		<div class="form-registro" id="form-registro-mision" class="container login-container">
			<img class="img-salir" id="img-salir-nuevo-mision" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Registrar una nueva Misión</h4>
					<form action="/FlotaEstelarEE/ServMision2" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Nombre de la Misión *" name="nombre" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Introduce aquí una breve descripción de la Misión *" name="descripcion" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" placeholder="ID de la nave" name="id_nave" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btnSubmit">Registrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------------06.02 VER MISION----------------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-listar" id="tabla-listar-mision" class="container login-container">
			<img class="img-salir" id="img-salir-listar-mision" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">

				<%
					out.println(mision.mostrarTablaMision());
				%>
					
				</div>
			</div>
		</div>
	</section>
	<!-- -------------------------------------------------------------------------06.03 PASO 1 ACTUALIZAR MISION------------------------------------------------------------------------------ -->
	<section>
		<div class="tabla-actualizar" id="tabla-actualizar-mision" class="container login-container">
			<img class="img-salir" id="img-salir-actualizar-mision" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres actualizar:</h4>
					<form action="ActualizarMision" method="POST">
						<% out.println(mision.mostrarTablaActualizarMision()); %>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- -------------------------------------------------------------------------06.04 PASO 2 ACTUALIZAR MISION------------------------------------------------------------------------------ -->

	<!-- ---------------------------------------------------------------------------06.05 ELIMINAR MISION------------------------------------------------------------------------------ -->
	<section>
		<!-- Eliminar Mision -->
		<div class="tabla-eliminar" id="tabla-eliminar-mision" class="container login-container">
			<img class="img-salir" id="img-salir-eliminar-mision" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres eliminar:</h4>
					<form action="EliminarMision" method="POST">
					<% out.println(mision.mostrarTablaEliminarMision()); %>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- ---------------------------------------------------------------------------07.01 INSERTAR CUADERNO------------------------------------------------------------------------------ -->
	<section>
		<div class="form-registro" id="form-registro-cuaderno" class="container login-container">
			<img class="img-salir" id="img-salir-nuevo-cuaderno" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Registrar un nuevo Cuaderno</h4>
					<form action="/FlotaEstelarEE/ServCuaderno2" method="POST">
						<div class="form-group">
							<input type="date" class="form-control" placeholder="Introduce la fecha: " name="fecha">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Descripción del Cuaderno *" name="descripcion" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Audio del Cuaderno *" name="audio">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="ID de la Nave a la que pertenece * " name="id_nave">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btnSubmit">Registrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------------07.02 LISTAR CUADERNO-------------------------------------------------------------------------------- -->
	<section>
		<div class="tabla-listar" id="tabla-listar-cuaderno" class="container login-container">
			<img class="img-salir" id="img-salir-listar-cuaderno" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<%
					out.println(cuaderno.mostrarTablaCuaderno());
					%>
				</div>
			</div>
		</div>
	</section>
	<!-- -------------------------------------------------------------------07.03 PASO 1 ACTUALIZAR CUADERNO------------------------------------------------------------------------------ -->
	<section>
		<div class="tabla-actualizar" id="tabla-actualizar-cuaderno" class="container login-container">
			<img class="img-salir" id="img-salir-actualizar-cuaderno" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres actualizar:</h4>
					<form action="ActualizarCuaderno" method="POST">
					<% out.println(cuaderno.mostrarTablaActualizarCuaderno()); %>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- -------------------------------------------------------------------07.04 PASO 2 ACTUALIZAR CUADERNO------------------------------------------------------------------------------ -->

	<!-- ---------------------------------------------------------------------------07.05 ELIMINAR CUADERNO------------------------------------------------------------------------------ -->
	<section>
		<div class="tabla-eliminar" id="tabla-eliminar-cuaderno" class="container login-container">
			<img class="img-salir" id="img-salir-eliminar-cuaderno" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Selecciona cual quieres eliminar:</h4>
					<form action="EliminarCuaderno" method="POST">
					<% out.println(cuaderno.mostrarTablaEliminarCuaderno()); %>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------------------------08 LINKS FOOTER------------------------------------------------------------------------------ -->
		<footer>
		<div id="contenedor">
			<div id="links">
				<a href="mailto:alvaro.santoscc@gmail.com">
					<img class="iconos-footer" alt="icono-gmail" src="Front/Imagenes/gmail-icon.png">
				</a>
				<img class="iconos-footer" alt="icono-whatsapp" src="Front/Imagenes/whatsapp-icon.png">
				<a href="https://www.linkedin.com/in/alvaro-santos-salas/">
					<img class="iconos-footer" alt="icono-linkedin" src="Front/Imagenes/linkedin-icon.png">
				</a>
				<a href="https://www.imf-formacion.com/">
					<img class="iconos-footer" alt="icono-estudios" src="Front/Imagenes/estudios-icon.png">
				</a>
				<a href="https://www.vilt-group.com/es/">
					<img class="iconos-footer" alt="icono-trabajo" src="Front/Imagenes/trabajo-icon.png">
				</a>
			</div>
		</div>
	</footer>
</body>
<html>