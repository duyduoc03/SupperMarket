package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HoaDon {
    public Integer mahd;
    public Integer manv;
    public Integer makh;
    public Double tongtien;
    public Button sua;
    public Button xoa;

    public HoaDon(Integer mahd, Integer manv, Integer makh, Double tongtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.tongtien = tongtien;
        this.xoa  = new Button("xoa");
        this.sua = new Button("sua");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HoaDonForm.fxml"));
                Parent root = loader.load();
                HoaDonForm d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }
            catch (Exception ignored){

            }
        });

    }

    public Integer getMahd() {
        return mahd;
    }

    public void setMahd(Integer mahd) {
        this.mahd = mahd;
    }

    public Integer getManv() {
        return manv;
    }

    public void setManv(Integer manv) {
        this.manv = manv;
    }

    public Integer getMakh() {
        return makh;
    }

    public void setMakh(Integer makh) {
        this.makh = makh;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
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
