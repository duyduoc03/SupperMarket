package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CTHDForm {
    public TextField cMSP;
    public TextField cMHD;
    public TextField cSoLuong;
    public TextField cGiamGia;
    public TextField cRHD;
    private ChiTietHD editData;

    public void backChiTietHD() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChiTietHD.fxml"));
        Main.rootStage.setScene(new Scene(root, 700, 500));
    }

    public void submit(ActionEvent event) {
        String msp = this.cMSP.getText();
        String mhd = this.cMHD.getText();
        String sl = this.cSoLuong.getText();
        String gg = this.cGiamGia.getText();
        String nrhd = this.cRHD.getText();

        try {
            String sql_txt = "insert into chitiethoadon (masp,mahd,soluong,giamgia,ngayhd) " +
                    " values('"+msp+"','"+mhd+"','"+sl+"','"+gg+"','"+nrhd+"')";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.execute();
            this.backChiTietHD();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
