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
public class Todos {

    @Override
    public String toString() {
        return "Todos{" + "id=" + id + ", noiDung=" + noiDung + ", project=" + project + ", nguoiDung=" + nguoiDung + ", hoanthanh=" + hoanthanh + '}';
    }
    private int id;
    private String noiDung;
    private int project;
    private int nguoiDung;
    private Boolean hoanthanh = false;
    //false là chưa hoàn thành

    public Todos() {
    }

    public Todos(int id, String noiDung, int project, int nguoiDung) {
        this.id = id;
        this.noiDung = noiDung;
        this.project = project;
        this.nguoiDung = nguoiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
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
