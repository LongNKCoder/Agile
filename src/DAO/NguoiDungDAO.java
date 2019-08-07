/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.NguoiDung;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class NguoiDungDAO {
    public void insert(NguoiDung model) {
        String sql = "INSERT INTO NguoiDung (Email, password) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getEmail(),
                model.getMatkhau());
    }

    public void update(NguoiDung model) {
        String sql = "UPDATE NguoiDung SET password=? WHERE email=?";
        JdbcHelper.executeUpdate(sql,
                model.getMatkhau(),
                model.getEmail()
        );
    }

    public List<NguoiDung> select() {
        String sql = "SELECT * FROM NguoiDung";
        return select(sql);
    }

    public NguoiDung findByEmail(int manh) {
        String sql = "SELECT * FROM NguoiDung WHERE Id=?";
        List<NguoiDung> list = select(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public NguoiDung findByID(String manh) {
        String sql = "SELECT * FROM NguoiDung WHERE email=?";
        List<NguoiDung> list = select(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NguoiDung> select(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiDung model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
        return list;
    }

    private NguoiDung readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDung model = new NguoiDung();
        model.setId(rs.getInt("id"));
        model.setEmail(rs.getString("email"));
        model.setMatkhau(rs.getString("password"));
        return model;
    }
}
