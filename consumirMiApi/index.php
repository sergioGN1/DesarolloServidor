<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        require 'vendor/autoload.php';

        use GuzzleHttp\Client;

        $client = new Client();

        echo "GET" . "<br>";
        $uri = 'http://localhost:8080/baseDatos/rest/alumnos';
        //$header = array('headers' => array('X-Auth-Token' => '447878d6ad3e4da7bc65bac030cd061e'));
        $response = $client->get($uri);

        $alumnos = json_decode($response->getBody());
        foreach ($alumnos as $alumno) {
            echo $alumno->id . " " . $alumno->nombre . "<br>";
        }
        ?>
    </body>
</html>
