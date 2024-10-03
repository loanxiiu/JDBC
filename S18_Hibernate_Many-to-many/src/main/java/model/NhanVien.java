package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
public class NhanVien {
    @Id
    private String id;
    private String hoVaTen;
    private Date ngaySinh;

    @ManyToMany(mappedBy = "danhSachNhanVien")
    private Set<CuocHop> danhSachCuocHop = new HashSet<CuocHop>();

    public NhanVien(){}
    public NhanVien(String id, String hoVaTen, Date ngaySinh) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id='" + id + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                '}';
    }
}
