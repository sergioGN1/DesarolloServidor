
<?php
require '../vendor/autoload.php';

use controller\Alumnos;

$alumno = new Alumnos();

$alumnosLista = $alumno->mostrarAlumnos();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>CRUD Alumnos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../assets/js/modalAdd.js"></script>
        <link rel="stylesheet" href="../assets/css/modales.css">
        <link rel="stylesheet" href="../assets/css/checkboxes.css">
    </head>
    <body>
        <table class="table table-striped">
            <tr class="bg-primary">
                <td>Nombre</td>

                <td>Fecha de Nacimiento</td>

                <td>Mayoria de edad</td>

                <td>Operaciones</td>
            </tr>
            <?php foreach ($alumnosLista as $alumnos) { ?>
                <tr>
                    <td>
                        <?php echo $alumnos->nombre; ?>
                    </td>
                    <td>
                        <?php echo $alumnos->fecha_nacimiento; ?>
                    </td>
                    <td>
                        <?php if ($alumnos->mayor_edad == 1) { ?>
                            <label class="container">
                                <input type="checkbox" checked="checked" disabled>
                                <span class="checkmark"></span>
                            </label>
                        <?php } else { ?>
                            <label class="container">
                                <input type="checkbox" disabled>
                                <span class="checkmark"></span>
                            </label><?php
                        }
                        ?>
                    </td>
                    <td>
                        <div class="row">
                            <div id="edit">&#9998;</div>
                            <div id="delete">&#9746;</div>
                        </div>
                    </td>
                </tr>
            <?php } ?>

            <tr>
                <td colspan="4"><button class="col-12 btn btn-secondary" id="add">Añadir Alumno</button></td>
            </tr>
        </table>    
        <div id="addA" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="../frontController.php" name="addAlumno">
                    <input type="hidden" name="tipo" value="alumno">
                    <input type="text" placeholder="Nombre del Alumno" class="col-12">
                    <input type="date" name="fecha_nacimiento" class="col-12">
                    <label>Mayor Edad<input type="checkbox" name="mayor_edad"></label>
                    <button name="op" value="insertar" required>Enviar</button>
                </form>
            </div>

        </div>


    </body>
</html>
