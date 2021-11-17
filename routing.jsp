<%-- 
    Document   : routing
    Created on : 31/10/2021, 09:51:23 AM
    Author     : LeviM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    if (request.getParameter("menu") != null){
        int smenu = Integer.parseInt(request.getParameter("menu"));
        switch (smenu) {
            //case "calculo" :
            case 1:
%>
                <%@include file='calculos.jsp' %>
<%
                break;
            //case "inventario" :
            case 2 :
%>
                <%@include file='inventario.jsp' %>
<%
                break;
            //case "addinventario"
            case 3:
%>
                <%@include file='addInventario.jsp' %>
<%
                break;
            //case "presupuesto"
            case 4:
%>
                <%@include file='presupuesto.jsp'%>         
<%
                break;
            //case "presupuesto para usuarios normales"
            case 5:
%>
                <%@include file='presupuestoUser.jsp'%>        
<%
                break;
            //case "documentos"
            case 6:
%>
                <%@include file='documentos.jsp' %>                      
<%
                break;
            //case selección de inventario   
            case 7: 
%>
                <%@include file='seleccionarInventario.jsp' %>
<%
                break;
            //case "agregar usuarios"
            case 8:
%>                          
                <%@include file='addUsuarios.jsp' %>
<%
            break; //generar
            case 9:
%>
                <%@include file='generarPresupuesto.jsp' %>
<%
            break;
            case 10: //historial
%>
                <%@include file='historialPresupuestos.jsp' %>
<%
            break;
            
            case 11: //documentos usuarios
%>
                <%@include file='documentosUsers.jsp' %>
<%
            break;
            
            case 12:
%>
                <%@include file='bienvenida.jsp' %>
<%
            break;
            
            case 13:
%>
                <%@include file='bienvenida.jsp' %>
<%
            break;
            case 14:
%>
                <%@include file='directorio.jsp' %>
<%
            break;
        }
    } else {
%>
        <%@include file='bienvenida.jsp'%>
<%
    }
%>