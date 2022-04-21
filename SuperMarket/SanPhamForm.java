package JP2.SuperMarket;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class SanPhamForm {
    public TextField pTensp;
    public TextField pMota;
    public TextField pTonkho;
    public TextField pPrice;
    private SanPham editData1;

    public void setEditData1(SanPham editData1) {
        this.editData1 = editData1;
        this.pTensp.setText(editData1.getTensp());
        this.pMota.setText(editData1.getMota());
        this.pTonkho.setText(editData1.getTonkho().toString());
        this.pPrice.setText(editData1.getPrice().toString());
    }

    public void backSanPham() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SanPham.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit1(ActionEvent event) {
        String tensanpham = this.pTensp.getText();
        String motasanpham = this.pMota.getText();
        String sanphamtonkho = this.pTonkho.getText();
        String giasanpham = this.pPrice.getText();
        try {
            String sql_txt1 = "";
            if (this.editData1 == null){
                sql_txt1 = "insert into quanlysanpham (tensp,mota,tonkho,price) values(?,?,?,?)";
            }
            else {
                sql_txt1 = "update quanlysanpham set tensp=?,mota=?, tonkho=?, price=? Where masp=" + this.editData1.getMasp();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt1);
            stt.setString(1,tensanpham);
            stt.setString(2,motasanpham);
            stt.setString(3, sanphamtonkho.toString());
            stt.setString(4, giasanpham.toString());
            stt.execute();
            this.backSanPham();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}