/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Project;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class ProjectDAO {
    public void insert(Project model){
        String sql="INSERT INTO Project (ten,nguoidung_id) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql, 
                model.getTenProject(),
                model.getNguoiDung()
        );
    }
    
    public void update(Project model){
        String sql="UPDATE Project SET ten=?, nguoidung_id=?,  WHERE id=?";
        JdbcHelper.executeUpdate(sql, 
                model.getTenProject(),
                model.getNguoiDung(),
                model.getId());
    }
    
    public void delete(String id){
        String sql="DELETE FROM Project WHERE id=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    
    public List<Project> select(){
        String sql="SELECT * FROM Project";
        return select(sql);
    }
    
    public Project findById(String masp) {
        String sql = "SELECT * FROM Project WHERE id=?";
        List<Project> list = select(sql, masp);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Project> findByNguoidung(int manh){
        String sql="SELECT * FROM Project WHERE nguoidung_id=?";
        return select(sql, manh);
    }
    
    private List<Project> select(String sql, Object...args){
        List<Project> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    Project model=readFromResultSet(rs);
                    list.add(model);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private Project readFromResultSet(ResultSet rs) throws SQLException{
        Project model=new Project();
        model.setId(rs.getInt("id"));
        model.setNguoiDung(rs.getInt("nguoidung_id"));
        model.setTenProject(rs.getString("ten"));
        model.setHoanthanh(rs.getBoolean("hoanthanh"));
        return model;
    }
}
