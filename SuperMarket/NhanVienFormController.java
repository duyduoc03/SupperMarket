package jp2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class NhanVienFormController {
    public TextField sHoTen;
    public TextField sSDT;
    public TextField sDiaChi;
    public NhanVien editData;

    public void backNhanVien() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NhanVienForm.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void Submit(ActionEvent event){
        String hoten = this.sHoTen.getText();
        String sdt = this.sSDT.getText();
        String diachi = this.sDiaChi.getText();

        try {
            String sql_txt = "";
            if (this.editData == null){
                sql_txt = "insert into nhanvien ( hoten, sodt, diachi) values(?,?,?)";
            }else {
                sql_txt = "update nhanvien set  hoten = ?, sodt = ?, diachi = ? where manv = "+this.editData.getManv();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,hoten);
            stt.setString(2,sdt);
            stt.setString(3,diachi);
            stt.execute();
            this.backNhanVien();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void setEditData(NhanVien editData){
        this.editData = editData;
        this.sHoTen.setText(editData.getHoten());
        this.sSDT.setText(editData.getSodt());
        this.sDiaChi.setText(editData.getDiachi());
    }
}