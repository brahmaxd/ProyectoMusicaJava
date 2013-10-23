

<%-- 
    Document   : FrDiscoCliente
    Created on : 22-10-2013, 11:33:09 PM
    Author     : 
--%>

<%@page import="DAO.DAODisco"%>
<%@page import="Entity.Disco"%>
<%@page import="java.util.ArrayList"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="DiscoCliente.jsp" method="POST">
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
                grilla+="</tr>";
                grilla+="<thead>";
                Disco disco = new Disco(request.getParameter("txNombre"));
                ArrayList<Disco> array = DAODisco.sqlSelectTodos(disco);
                for (int x=0; x<array.size(); x++)
                {
                    grilla+="<tr>";
                    grilla+="<td><a href=\"discoAdmin.jsp?cod="+array.get(x).getId()+"\">" + array.get(x).getId()+  "</a></td>";
                    grilla+="<td>" + array.get(x).getNombre()+  "</td>";
                    grilla+="</tr>";
                }
                grilla+="</table>";
            %>
            <%=grilla%>
    </body>
</html>
