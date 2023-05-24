
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOimpl extends ConexionDB implements ProductosDAO {

    @Override
    public void insert(Productos aviso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (descripcion,cantidad,precio,categoria) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
            ps.setInt(2, aviso.getCantidad());
            ps.setFloat(3, aviso.getPrecio());
            ps.setString(4, aviso.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Productos aviso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion=? , cantidad=?, precio=?, categoria=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
            ps.setInt(2, aviso.getCantidad());
            ps.setFloat(3, aviso.getPrecio());
            ps.setString(4, aviso.getCategoria());           
            ps.setInt(5, aviso.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos prod = new Productos();
        try {
            this.conectar();
            String sql = "SELECT *FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prod.setId(rs.getInt("id"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getFloat("precio"));
                prod.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return prod;
    }

    @Override
    public List<Productos> getAll(int id) throws Exception {
        ArrayList<Productos> lista = new ArrayList<Productos>();
        try {
            this.conectar();
            String sql = "SELECT *FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos prod = new Productos();

                prod.setId(rs.getInt("id"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getFloat("precio"));
                prod.setCategoria(rs.getString("categoria"));

                lista.add(prod);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;
    }
    
}
