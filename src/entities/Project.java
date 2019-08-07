/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Long
 */
public class Project {
    private int id;
    private String tenProject;
    private int nguoiDung;
    private Boolean hoanthanh = false;

    public Project() {
    }

    public Project(int id, String tenProject, int nguoiDung) {
        this.id = id;
        this.tenProject = tenProject;
        this.nguoiDung = nguoiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenProject() {
        return tenProject;
    }

    public void setTenProject(String tenProject) {
        this.tenProject = tenProject;
    }

    public int getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(int nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public Boolean getHoanthanh() {
        return hoanthanh;
    }

    public void setHoanthanh(Boolean hoanthanh) {
        this.hoanthanh = hoanthanh;
    }
    
    
}
