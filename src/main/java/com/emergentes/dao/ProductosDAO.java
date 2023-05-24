
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import java.util.List;


public interface ProductosDAO {
    public void insert(Productos aviso) throws Exception;
    public void update(Productos aviso) throws Exception;
    public void delete(int id) throws Exception;
    public Productos getById(int id) throws Exception;
    public List<Productos> getAll(int id) throws Exception;
}
