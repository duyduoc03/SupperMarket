package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class KhachHangForm {
    public TextField sTen;
    public TextField sSDT;
    private KhachHang editData;

    public void backKhachHang() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("KhachHang.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit(ActionEvent event) {
        String name = this.sTen.getText();
        String phone = this.sSDT.getText();

        try {
            String sql_txt = "";
            if (this.editData == null){
                sql_txt = "insert into khachhang (hoten,sodt) values(?,?)";
            }
            else {
                sql_txt = "update khachhang set hoten=?,sodt=?" + " Where makh=" + this.editData.getMakh();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,name);
            stt.setString(2,phone);
            stt.execute();
            this.backKhachHang();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(KhachHang editData) {
        this.editData = editData;

        this.sTen.setText(editData.getHoten());
        this.sSDT.setText(editData.getSodt());
    }
}

