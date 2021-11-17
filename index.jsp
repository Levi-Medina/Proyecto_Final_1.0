<%-- 
    Document   : index
    Created on : 31/10/2021, 09:51:23 AM
    Author     : LeviM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/styles.css"/>
        <link type="text/css" rel="stylesheet" href="css/bulma.css"/>
        
        <link rel="shortcut icon" href="images/logo.jpg" sizes="48x48">
        <title>Login | Dyjamir</title>
    </head>
    <body>
        <br><br><br>
        <!--logo-->
        <div class="container">
            <div class="valign-wrapper">
                <div class="row">
                    <div class="col s12 m12">
                        <div class="card">
                            <div class="card-image">
                                <img src="images/logo.jfif">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--formulario-->
            <div class="valign-wrapper">
                <div class="row">
                    <form action="Login" method="POST" class="col s11">
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">account_circle</i>
                                <input id="icon_prefix" type="text" name="user" class="validate">
                                <label for="icon_prefix">Usuario</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">lock</i>
                                <input id="icon_telephone" type="password" name="pwd" class="validate">
                                <label for="icon_telephone">Contraseña</label>
                            </div>
                        </div>
                        <button id="buttonEnter" value="Entrar" class="btn waves-effect waves-green btn-large" type="submit" name="action">Entrar
                            <i class="material-icons right" >send</i>
                        </button>
                        <br>          
                    </form>
                </div>
            </div>
            <div class="center-align">
                ¿Ha olvidado su <a href="recuperarPassword.jsp">contraseña</a>?
            </div>
        </div>
        <%
            if (request.getParameter("error") != null){
        %>
                <div class="notification is-warning">
                    <button class="delete"></button>
                    El Usuario y/o Contraseña es Invalida
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
        <script type="text/javascript" src="js/events.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    </body>
</html>
