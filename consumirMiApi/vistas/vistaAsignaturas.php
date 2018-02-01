
<?php
require '../vendor/autoload.php';

use controller\Asignaturas;

$asignatura = new Asignaturas();

$asignaturaLista = $asignatura->mostrarAsignaturas();
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>CRUD Asignaturas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <table class="table table-striped">
            <tr class="bg-primary">
                <td>Nombre</td>

                <td>Curso</td>

                <td>Ciclo</td>

                <td>Operaciones</td>
            </tr>
            <?php foreach ($asignaturaLista as $asignaturasMostrar) { ?>
                <tr>
                    <td>
                        <?php echo $asignaturasMostrar->nombre; ?>
                    </td>
                    <td>
                        <?php echo $asignaturasMostrar->curso; ?>
                    </td>
                    <td>
                        <?php $asignaturasMostrar->ciclo; ?>
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
                <td colspan="4"><button class="col-12 btn btn-secondary" id="add">Añadir Asignatura</button></td>
            </tr>
        </table>
    </body>
</html>

