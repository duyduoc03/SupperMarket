package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SanPham {
    public Integer masp ;
    public String tensp;
    public String mota;
    public Integer tonkho;
    public Integer price;
    public Button sua;
    public Button xoa;

    public SanPham(Integer masp, String tensp, String mota, Integer tonkho, Integer price) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.tonkho = tonkho;
        this.price = price;
        this.sua = new Button("Sua");
        this.xoa = new Button("Xoa");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SanPhamForm.fxml"));
                Parent root = loader.load();
                SanPhamForm q = loader.getController();
                q.setEditData1(this);
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

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getTonkho() {
        return tonkho;
    }

    public void setTonkho(Integer tonkho) {
        this.tonkho = tonkho;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
