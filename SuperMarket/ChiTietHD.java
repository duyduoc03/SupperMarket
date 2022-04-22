package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Date;

public class ChiTietHD{
    public Integer masp ;
    public Integer mahd ;
    public Integer soluong;
    public Double giamgia;
    public Date ngayhd;
    public Button sua;
    public Button xoa;

    public ChiTietHD(Integer masp, Integer mahd, Integer soluong, Double giamgia, Date ngayhd) {
        this.masp = masp;
        this.mahd = mahd;
        this.soluong = soluong;
        this.giamgia = giamgia;
        this.ngayhd = ngayhd;
        this.sua = new Button("Sua");
        this.xoa = new Button("Xoa");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CTHDForm.fxml"));
                Parent root = loader.load();
                CTHDForm q = loader.getController();
                q.setEditData(this);
                Main.rootStage.setScene(new Scene(root,600,400));
            }
            catch (Exception ignored){

            }
        });
    }

    public Integer getMasp() {
        return masp;
    }

    public void setMasp(Integer masp) {
        this.masp = masp;
    }

    public Integer getMahd() {
        return mahd;
    }

    public void setMahd(Integer mahd) {
        this.mahd = mahd;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Double getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Double giamgia) {
        this.giamgia = giamgia;
    }

    public Date getNgayhd() {
        return ngayhd;
    }

    public void setNgayhd(Date ngayhd) {
        this.ngayhd = ngayhd;
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
