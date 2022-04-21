package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class KhachHang {
    public Integer makh ;
    public String hoten;
    public String sodt;
    public Button sua;
    public Button xoa;

    public KhachHang(Integer makh, String hoten, String sodt) {
        this.makh = makh;
        this.hoten = hoten;
        this.sodt = sodt;
        this.sua = new Button("Sua");
        this.xoa = new Button("Xoa");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("KhachHangForm.fxml"));
                Parent root = loader.load();
                KhachHangForm d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }
            catch (Exception ignored){

            }
        });
    }

    public Integer getMakh() {
        return makh;
    }

    public void setMakh(Integer makh) {
        this.makh = makh;
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
