<%-- 
    Document   : FrArtistaCliente
    Created on : 13-11-2013, 01:41:21 PM
    Author     : Abraham
--%>

<%@page import="DAO.DAOArtista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Artista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrGeneroCliente.jsp" method="POST">
        <table border="1">
                <tbody>
                    <tr>
                        <td><input type="submit" value="<- Atrás" name="btAtras" /></td>
                        <td>Nombre: </td>
                        <td><input type="text"  name="txNombre" value="" size="25" maxlength="30"/></td>
                        <td><input type="submit" value="Buscar" name="btBuscar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <%
                String grilla = "";            
                grilla="<table border='1'>";
                grilla+="<thead>";
                grilla+="<tr>";
                grilla+="<th>Codigo</th>";
                grilla+="<th>Nombre</th>";
                //grilla+="<th>Id Artista</th>";
                grilla+="</tr>";
                grilla+="<thead>";
                Artista artista = new Artista(request.getParameter("txNombre"));
                ArrayList<Artista> array = DAOArtista.sqlSelectTodos(artista);
                for (int x=0; x<array.size(); x++)
                {
                    grilla+="<tr>";
                    grilla+="<td><a href=\"discoAdmin.jsp?cod="+array.get(x).getId()+"\">" + array.get(x).getId()+  "</a></td>";
                   // grilla+="<td>" + array.get(x).getId()+  "</td>";
                    grilla+="<td>" + array.get(x).getNombre()+  "</td>";
                    
                    grilla+="</tr>";
                }
                grilla+="</table>";
            %>
            <%=grilla%>
    </body>
</html>
