<%-- 
    Document   : directorio
    Created on : 31/10/2021, 09:51:23 AM
    Author     : LeviM
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
       
        <title>Directorio | Dyjamir</title>
    </head>
    <body>
        <h1>Directorio de Archivos:</h1>
        
        <div class="table">
            
            <table class="table-bordered" style="width:70%" align="center">
                <thead>
                <th>Archivo</th>
                <th>Borrar</th>
                <th>Ver</th> 
                </thead>
                <tbody>
                    <%;
        
        File[]directorio=(File[])request.getSession().getAttribute("Directorio");
        
        for(int x=0; x<directorio.length;x++)
        {
          out.print("<tr>");   
        out.print("<td>");    
        out.print(directorio[x].getName());
        out.print("</td>");
        
        out.print("<td>");    
        out.print("<button class='btn btn-info' onclick='location.href=\"Delete?file="+directorio[x].getName()+"\"'><span class=\"glyphicon glyphicon-trash\"></span></button> ");
        
        out.print("</td>");
        
        out.print("<td>");  
        out.print("<button class='btn btn-info' onclick='location.href=\"ArchivoDownload?file="+directorio[x].getName()+"\"'><span class=\"glyphicon glyphicon-download-alt\"></span></button> ");
       //out.print("<a href='ArchivoDownload?file="+directorio[x].getName()+"'>"+directorio[x].getName()+"</a>");
        out.print("</td>");
        out.print("</tr>"); 
        }
        
         
        
        %>
                    
                </tbody> 
            </table> 
            
        </div>
             
        <div class="container">
            <%
            String type=request.getParameter("type");
            String ruta="index.jsp";
            if (type.equals("1")){
            ruta="homeAdmin.jsp?menu=6";
            }else{
            if(type.equals("2")){
            ruta="homeUser.jsp?menu=11";
            }
            }
            %>
            <button class="btn btn-success" onclick="location.href='<%out.print(ruta);%>'">Regresar</button>
        </div>
            
        
       
    </body>
</html>
