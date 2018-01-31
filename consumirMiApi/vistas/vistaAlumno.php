
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
                            <input type="checkbox" checked="checked">
                        <?php } else { ?>
                            <input type="checkbox"><?php
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
                <td rowspan="3"><button>Añadir Alumnos</button></td>
            </tr>
        </table>
    </body>
</html>

