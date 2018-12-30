<%@page import="modelo.Tripulante"%>
<%@page import="modelo.Nave"%>
<%@page import="modelo.Mision"%>
<%@page import="modelo.Cuaderno"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
	Nave nave = new Nave();
	Tripulante tripulante = new Tripulante();
	Mision mision = new Mision();
	Cuaderno cuaderno = new Cuaderno();
%>
<html>
<head>
<meta charset="UTF-8">
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
						<a class="nav-link" href="index.jsp">
							Home
							<span class="sr-only">(current)</span>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- ---------------------------------------------------------------------------02 BACKGROUND IMAGEN----------------------------------------------------------------------------------- -->
	<img id="img-fondo" alt="img-fondo" src="Front/Imagenes/background-image.jpg">

	<section>
		<div class="form-actualizar" id="form-actualizar-nave-dos" class="container login-container">
			<img class="img-salir" id="img-salir-actualizar-nave-dos" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>Rellena los datos para actualizar tu nave</h4>
					<%
						System.out.println("Llegamoooos al jsp de actualizar");
					%>

					<form action='/FlotaEstelarEE/ServActNave' method="POST">
						<div class="form-group">
							<input type="text" class="form-control" name="capitan" id="capitan" value="${nave.capitan}">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="nombre" id="nombre" value="${nave.nombre}">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="matricula" id="matricula" value="${nave.matricula}">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="tipo" id="tipo" value="${nave.tipo}">
						</div>
						<div class='form-group'>
							<button type='submit' class='btn btn-secondary btnSubmit'>Actualizar</button>
						</div>
						<input type="hidden" name="id_nave" id="id_nave" value="${nave.id_nave}">
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
</html>