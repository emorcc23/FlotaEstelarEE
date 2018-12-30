	<section>
		<div id="formulario" class="container login-container">
			<img class="img-salir" id="img-salir" alt="img-salir" src="Front/Imagenes/salir-icon.png">
			<div class="row">
				<div class="col-md-6 login-form-1">
					<h4>¿Eres nuevo?</h4>
					<form action="/FlotaEstelarEE/RegistroUsuario" method="POST">
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Tu Email *" name="email" />
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
					<form action="RegistroNave" method="POST">
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
							<input type="text" class="form-control" placeholder="Pega aquí la ruta de la imagen *" name="imagen" />
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
					<form action="RegistroCuaderno" method="POST">
						<div class="table table-hover">
							<table class="table">
								<tr>
									<th></th>
									<th>Capitán</th>
									<th>Nombre</th>
									<th>Matricula</th>
									<th>Tipo</th>
									<th>Imagen</th>
									<th></th>
								</tr>
								<tr>
									<td></td>
									<td>Alvaro</td>
									<td>Nombre1</td>
									<td>FFH77887H</td>
									<td>Aviador</td>
									<td>iodasfoiajifja</td>
									<td></td>
								</tr>
							</table>
						</div>
					</form>
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
					<form action="ActualizarNave" method="POST">
						<div class="table table-hover">
							<table class="table">
								<tr>
									<th></th>
									<th>Capitán</th>
									<th>Nombre</th>
									<th>Matricula</th>
									<th>Tipo</th>
									<th>Imagen</th>
									<th></th>
								</tr>
								<tr>
									<td></td>
									<td>Alvaro</td>
									<td>Nombre1</td>
									<td>FFH77887H</td>
									<td>Aviador</td>
									<td>iodasfoiajifja</td>
									<td>
										<button>
											<img id="icono-actualizar-nave" alt="icono-actualizar" src="Front/Imagenes/icono-actualizar.png" class="boton-actualizar">
										</button>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>