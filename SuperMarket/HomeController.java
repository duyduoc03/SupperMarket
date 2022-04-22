package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void nhanvienModule(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NhanVien.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
    public void khachhangModule(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("KhachHang.fxml"));
        Main.rootStage.setScene(new Scene(root,700,500));
    }

    public void sanphamModule(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SanPham.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void qlhdModule(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
        Main.rootStage.setScene(new Scene(root,700,500));
    }

    public void cthdModule(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ChiTietHD.fxml"));
        Main.rootStage.setScene(new Scene(root,700,500));
    }
}
