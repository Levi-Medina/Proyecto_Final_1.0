<%-- 
    Document   : recuperarPassword
    Created on : 31/10/2021, 09:51:23 AM
    Author     : LeviM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Dyjamir | Recuperación de Contraseña</title>
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/styles.css"/>
        <link type="text/css" rel="stylesheet" href="css/bulma.min.css"/>
    </head>
    <body>
        <br><br><br><br><br><br><br>
        <div class="row">
            <div class="col s4"></div>
            <div class="col s4 z-depth-4">
                <div class="card">
                    <div class="card-content">
                        <span class="card-title">Recuperación de Contraseña</span>
                        <p>
                            Por favor, ingrese los datos que el sistema requiere para
                            la recuperación de su contraseña
                        </p>
                    </div>
                    <div class="card-tabs">
                        <ul class="tabs tabs-fixed-width">
                            <li class="tab"><a href="#test4">Info. General</a></li>
                            <li class="tab disabled"><a class="" href="#test5">Datos de Usuarios</a></li>
                        </ul>
                    </div>
                    <div class="card-content grey lighten-4">
                        <div id="test4">
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="first_name" type="text" required>
                                    <label for="first_name">Nombre</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="last_name" type="text" required>
                                    <label for="last_name">Apellido</label>
                                </div>
                                <div class="center-align">
                                    <a href="recovering.jsp" class="btn-small buttonOk">Aceptar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% 
            if (request.getParameter("error") != null){
        %>
                <div class="notification is-danger">
                    <button class="delete"></button>
                    Usuario no encontrado 
                </div> 
        <%
            }
        %>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                (document.querySelectorAll('.delete') || []).forEach(($delete) => {
                  $notification = $delete.parentNode;

                  $delete.addEventListener('click', () => {
                    $notification.parentNode.removeChild($notification);
                  });
                });
              });
        </script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/events.js"></script>
        <script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
    </body>
</html> 
