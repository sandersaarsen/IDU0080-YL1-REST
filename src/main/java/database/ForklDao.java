/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Fork;
import java.util.ArrayList;

public interface ForklDao {
    public ArrayList<Fork> findAll();
    public Fork findById(String id);
    public void update(Fork k);
    public void save(Fork k);
    public void delete(String id);
    public ArrayList<Fork> findByParam(String field, String string);
}
