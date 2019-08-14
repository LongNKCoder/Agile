/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Todos;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class todoDAO {
    public void insert(Todos model){
        String sql="INSERT INTO Todos (noidung, nguoidung_id, project_id) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, 
                model.getNoiDung(),
                model.getNguoiDung(),
                model.getProject()
                );
    }
    
    public void update(Todos model){
        String sql="UPDATE Todos SET noidung=?, nguoidung_id=?, project_id=?, hoanthanh=?  WHERE id=?";
        JdbcHelper.executeUpdate(sql, 
                model.getNoiDung(),
                model.getNguoiDung(),
                model.getProject(),
                model.getHoanthanh(),
                model.getId()
        );
    }
    
    public void delete(String id){
        String sql="DELETE FROM Todos WHERE id=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    
    public List<Todos> select(){
        String sql="SELECT * FROM Todos";
        return select(sql);
    }
    
//    public List<Todos> selectByCourse(Integer makh){
//        String sql="SELECT * FROM NHANVUEN WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
//        return select(sql, makh);
//    }
    
    public Todos findById(String manh){
        String sql="SELECT * FROM Todos WHERE id=? order by hoanthanh";
        List<Todos> list = select(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Todos> findByProject(int manh){
        String sql="SELECT * FROM todos WHERE project_id=? and hoanthanh=0 order by hoanthanh";
        return select(sql, manh);
    }
    
    public List<Todos> findByNguoidung(int manh){
        String sql="SELECT * FROM todos WHERE nguoidung_id=? order by hoanthanh";
        return select(sql, manh);
    }
    
    private List<Todos> select(String sql, Object...args){
        List<Todos> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    Todos model=readFromResultSet(rs);
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
    
    private Todos readFromResultSet(ResultSet rs) throws SQLException{
        Todos model=new Todos();
        model.setId(rs.getInt("id"));
        model.setNoiDung(rs.getString("noidung"));
        model.setNguoiDung(rs.getInt("nguoidung_id"));
        model.setProject(rs.getInt("project_id"));
        model.setHoanthanh(rs.getBoolean("hoanthanh"));
        return model;
    }
}
