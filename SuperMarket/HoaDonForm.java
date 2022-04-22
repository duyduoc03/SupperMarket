package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;

public  class HoaDonForm {
    public TextField sMaHD;
    public TextField sMaNV;
    public TextField sMaKH;
    public TextField sTongTien;
    private HoaDon editData;

    public void backHoaDon() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
        Main.rootStage.setScene(new Scene(root, 700, 500));
    }

    public void Submit(ActionEvent event) {
        String mahd = this.sMaHD.getText();
        String manv = this.sMaNV.getText();
        String makh = this.sMaKH.getText();
        String tongtien = this.sTongTien.getText();

        try {
            String sql_txt = "";
            if (this.editData == null){
                sql_txt = "insert into quanlyhoadon (mahd,manv,makh,tongtien) values(?,?,?,?)";
            }
            else {
                sql_txt = "update quanlyhoadon set mahd=?,manv=?, makh=?, tongtien=?" + " Where mahd=" + this.editData.getMahd();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,mahd);
            stt.setString(2,manv);
            stt.setString(3,makh);
            stt.setString(4,tongtien);
            stt.execute();
            this.backHoaDon();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(HoaDon editData) {
        this.editData = editData;

        this.sMaHD.setText(editData.getMahd().toString());
        this.sMaNV.setText(editData.getManv().toString());
        this.sMaKH.setText(editData.getMakh().toString());
        this.sTongTien.setText(editData.getTongtien().toString());
    }
}
