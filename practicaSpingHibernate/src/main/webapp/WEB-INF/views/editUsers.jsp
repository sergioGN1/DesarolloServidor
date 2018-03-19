<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring5 MVC Hibernate Demo</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
            .formularioActualizar{
                display: none;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(document).ready(function () {
                $("#update").click(function () {
                    $(".formularioActualizar").toggle();
                });
            });
        </script>
    </head>
    <body>
        <h1>Input Form</h1>
        <form:form action="addUser" method="post" modelAttribute="Alumno">
            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <form:input path="name" /> <br />
                        <form:errors path="name" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <form:input path="email" /> <br />
                        <form:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Fecha Nacimiento</td>
                    <td>
                        <form:input path="fecha" type="date" /> <br />
                        <form:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>

        <h2>Users List</h2>
        <table>
            <tr>
                <td><strong>Name</strong></td>
                <td><strong>Email</strong></td>
                <td><strong>Fecha</strong></td>
                <td><strong>Accion</strong></td>
            </tr>
            <c:forEach items="${alumnos}" var="alumno">
                <tr>
                    <td>${alumno.name}</td>
                    <td>${alumno.email}</td>
                    <td>${alumno.fecha}</td>
                    <td>
                        <form:form action="deleteUser" method="post" modelAttribute="Alumno">
                            <form:input path="id" type="hidden" value="${alumno.id}"/>
                            <form:input path="name" type="hidden" value="${alumno.name}"/>
                            <form:input path="email" type="hidden" value="${alumno.email}"/>
                            <form:input path="email" type="hidden" value="${alumno.fecha}"/>
                            <button type="submit">Borrar</button>
                            <input type="button" value="Actualizar" id="update">
                        </form:form>
                        <form:form action="updateUser" method="post" modelAttribute="Alumno" class="formularioActualizar">
                            <form:input path="id" type="hidden" value="${alumno.id}"/>
                            <form:input path="name" placeholder="Nombre alumno"/>
                            <form:input path="email"  placeholder="Correo alumno" />
                            <form:input path="fecha" type="date" />
                            <button type="submit">Actualizar</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>