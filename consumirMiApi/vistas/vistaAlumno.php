
<?php
require '../vendor/autoload.php';

use controller\Alumnos;

$alumno = new Alumnos();

$alumnosLista = $alumno->mostrarAlumnos();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
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
                        &#9998;
                        &#9746;
                    </td>
                </tr>
            <?php } ?>
        </table>
    </body>
</html>

