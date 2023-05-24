
package com.emergentes.controlador;

import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        int id;
        Productos prod = new Productos();
        ProductosDAO dao = new ProductosDAOimpl();
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        
        
        switch(action){
            case "add":
                request.setAttribute("productos",prod);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                prod = dao.getById(id);
                
                request.setAttribute("productos", prod);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                response.sendRedirect("Main");
                break;
            case "view":
                List<Productos> lista = dao.getAll(1);        
                request.setAttribute("productos",lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                break;
        }
        }catch(Exception ex){
            System.out.println("ERROR: "+ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO dao = new ProductosDAOimpl();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        
        Productos pd = new Productos();
        pd.setId(id);
        pd.setDescripcion(descripcion);
        pd.setCantidad(cantidad);
        pd.setPrecio(precio);
        pd.setCategoria(categoria);
        
        try {
        if(id == 0){
            
                //insertar registro
                dao.insert(pd);
             
            
        }
        else{
            //actualizar registro
            dao.update(pd);
        }
        }catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("Main");
    }


}
