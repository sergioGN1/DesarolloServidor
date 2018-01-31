<?php
require '../vendor/autoload.php';

use controller\Alumnos;
use controller\Asignaturas;
use controller\Notas;

$alumnoOb = new Alumnos();
$asignaturasOb = new Asignaturas();
$notasOb = new Notas();

$op = $_REQUEST["op"];
$tipo = $_REQUEST["tipo"];

if($tipo == "alumno"){
    $alumnoRecogido = $alumnoOb->recogerParametros($_REQUEST["id"], $_REQUEST["nombre"], $_REQUEST["fecha_nacimiento"], $_REQUEST["mayor_edad"]);
    
    if($op == "insertar"){
        $alumnoOb->insertarAlumnos($alumnoRecogido);
    } else if($op == "borrar"){
        $alumnoOb->borrarAlumnos($alumnoRecogido);
    } else if($op == "actualizar"){
        $alumnoOb->updateAlumno($alumnoRecogido);
    }
}else if ($tipo=="asignatura"){
    $asignaturaRecogido = $asignaturasOb->recogerParametros($_REQUEST["id"], $_REQUEST["nombre"], $_REQUEST["curso"], $_REQUEST["ciclo"]);
    
    if($op == "insertar"){
        $asignaturasOb->insertarAsignaturas($asignaturaRecogido);
    } else if($op == "borrar"){
        $asignaturasOb->borrarAsignaturas($asignaturaRecogido);
    } else if($op == "actualizar"){
        $asignaturasOb->updateAsignaturas($asignaturaRecogido);
    }
}else if ($tipo=="notas"){
    $notaRecogida = $notasOb->recogerParametros($_REQUEST["id_alumno"], $_REQUEST["id_asignatura"], $_REQUEST["nota"]);
    
    if($op == "insertar"){
        $notasOb->insertarNotas($notaRecogida);
    } else if($op == "borrar"){
        $notasOb->borrarNotas($notaRecogida);
    } else if($op == "actualizar"){
        $notasOb->updateNotas($notaRecogida);
    }
}
?>