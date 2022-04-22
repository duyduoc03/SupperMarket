package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

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
            String sql_txt = "";
            if (this.editData == null){
                sql_txt = "insert into chitiethoadon (masp,mahd,soluong,giamgia,ngayhd) values(?,?,?,?,?)";
            }
            else {
                sql_txt = "update chitiethoadon set masp=?,mahd=?,soluong=?,giamgia=?,ngayhd=?" +
                        " Where mahd=" + this.editData.getMahd();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,msp);
            stt.setString(2,mhd);
            stt.setString(3,sl);
            stt.setString(4,gg);
            stt.setString(5,nrhd);
            stt.execute();
            this.backChiTietHD();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(ChiTietHD editData) {
        this.editData = editData;

        this.cMSP.setText(editData.getMasp().toString());
        this.cMHD.setText(editData.getMahd().toString());
        this.cSoLuong.setText(editData.getSoluong().toString());
        this.cGiamGia.setText(editData.getGiamgia().toString());
        this.cRHD.setText(editData.getNgayhd().toString());
    }
}
