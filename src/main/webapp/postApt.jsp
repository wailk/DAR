<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poste Appartement</title>

<!-- Bootstrap core CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/unslider.css">
<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">
</head>
<body>

	<%@ include file="header.jspf" %>

	<div class="container ">
		<form action="apt" method="post" role="form" enctype="multipart/form-data" >
			<fieldset class="form-group">
				<legend>Appartement</legend>
				<div class="form-group">
					<label for="adresse">Adresse</label> <input type="text"
						class="form-control" id="adresse" name="adresse"
						placeholder="adresse">
				</div>

				<div class="form-group">
					<label for="codepostal">code Postal</label> <input type="number"
						class="form-control" id="codepostal" name="codepostal"
						placeholder="code Postal">
				</div>

			</fieldset>
			<div class="form-group">
				<label for="type">Type d'appartement</label> <select
					class="form-control" id="type" name="type">
					<option>F1</option>
					<option>F2</option>
					<option>F3</option>
					<option>F4</option>
					<option>F5</option>
					<option>F6</option>
				</select>
			</div>

			<div class="form-group">
				<label for="superficie">superficie</label> <input
					class="form-control" type="number" value="100" id="superficie"
					name="superficie">
			</div>


			<div class="form-group">
				<label for="loyer">Loyer</label> <input class="form-control"
					type="number" value="500" id="loyer" name="loyer">
			</div>


			<div class="form-group">
				<label for="photo">Image</label> <input type="file"
					class="form-control-file" id="photo" name="photo"
					aria-describedby="fileHelp" accept="image/*">
			</div>


			<div class="form-check">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" id="meuble" name="meuble"> Meubl�
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>