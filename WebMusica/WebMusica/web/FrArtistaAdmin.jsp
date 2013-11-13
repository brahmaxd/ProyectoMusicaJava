
<%@page import="DAO.DAOArtista"%>
<%@page import="Entity.Artista"%>
<%
    int frId=0;
    String frNombre="";
    //int frCantidadJugadores=0;
    if (request.getParameter("txId") != null){
        frId= Integer.parseInt(request.getParameter("txId"));
        frNombre=request.getParameter("txNombre");
       // frCantidadJugadores= Integer.parseInt(request.getParameter("txCantidadJugadores"));
    }
    %>
    
<%
    if (request.getParameter("btLeer") != null){
        Artista artista = new Artista(frId);
        if (DAOArtista.sqlLeer(artista)){
            frNombre = artista.getNombre();
           // frCantidadJugadores = artista.getCantidad_jugadores();
            frId = artista.getId();
        }       
    }
    if (request.getParameter("btGrabar") != null){
        Artista artista1 = new Artista(frId, frNombre);
        Artista artista = new Artista(frId);
        if (DAOArtista.sqlLeer(artista)){
            DAOArtista.sqlUpdate(artista1);
            %> Equipo actualizado<%
        }
        else{
            DAOArtista.sqlInsertar(artista1);
            %> Equipo agregado<%
        }
            
    }
    if (request.getParameter("btEliminar") != null){
        Artista artista = new Artista(frId);
        DAOArtista.sqlEliminar(artista);
        %> Artista eliminado<%
    }

%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="FrArtistaAdmin.jsp">
        <table border="1">
            <tbody>
                <tr>
                    <td>ID Artista: </td>
                    <td><input type="text" id="txId" name="txId" value="<%=frId%>" /><input type="button" value="?" name="btHelp" onclick="fuBusqueda()"/></td>
                    <td><input type="submit" value="Leer" name="btLeer" /></td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" id="txNombre" name="txNombre" value="<%=frNombre%>" /></td>
                    <td></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Grabar" name="btGrabar" /></td>
                    <td><input type="submit" value="Eliminar" name="btEliminar" /></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        </form>
    </body>
</html>
<script>
    // Crear una funcion que llama al formulario  FrPaisHelp.jsp
  function fuBusqueda(){
        document.location.href="FrArtistaCliente.jsp";
    }
</script>