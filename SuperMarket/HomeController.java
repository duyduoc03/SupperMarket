package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void nhanvienModule(ActionEvent event) {
    }
    public void khachhangModule(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("KhachHang.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void sanphamModule(ActionEvent event) {
    }

    public void qlhdModule(ActionEvent event) {
    }

    public void cthdModule(ActionEvent event) {
    }
}
