package jp2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class NhanVien {
    public Integer manv;
    public String hoten;
    public String sodt;
    public String diachi;
    public Button sua;
    public Button xoa;

    public NhanVien(Integer manv, String hoten, String sodt, String diachi) {
        this.manv = manv;
        this.hoten = hoten;
        this.sodt = sodt;
        this.diachi = diachi;
        this.sua = new Button("sua");
        this.xoa = new Button("xoa");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NhanVienFormController.fxml"));
                Parent root = loader.load();
                NhanVienFormController d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }
            catch (Exception ignored){

            }
        });


    }

    public Integer getManv() {
        return manv;
    }

    public void setManv(Integer manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Button getSua() {
        return sua;
    }

    public void setSua(Button sua) {
        this.sua = sua;
    }

    public Button getXoa() {
        return xoa;
    }

    public void setXoa(Button xoa) {
        this.xoa = xoa;
    }
}
