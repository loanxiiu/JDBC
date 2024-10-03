package detam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "tenSach", length = 45)
    private String tenSach;

    @Column(name = "giaBan", length = 50)
    private String giaBan;

    @Column(name = "namXuatBan")
    private Integer namXuatBan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(Integer namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

}