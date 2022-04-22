package JP2.SuperMarket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SanPhamController implements Initializable {
    public TableView tbSanPham;
    public TableColumn<SanPham,Integer> pMSP;
    public TableColumn<SanPham,String> pTensp;
    public TableColumn<SanPham,String> pMota;
    public TableColumn<SanPham,Integer> pTonkho;
    public TableColumn<SanPham,Integer> pPrice;
    public TableColumn<SanPham,Button> pEdit;
    public TableColumn<SanPham,Button> pDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pMSP.setCellValueFactory(new PropertyValueFactory<>("masp"));
        pTensp.setCellValueFactory(new PropertyValueFactory<>("tensp"));
        pMota.setCellValueFactory(new PropertyValueFactory<>("mota"));
        pTonkho.setCellValueFactory(new PropertyValueFactory<>("tonkho"));
        pPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        pEdit.setCellValueFactory(new PropertyValueFactory<>("Sua"));
        pDelete.setCellValueFactory(new PropertyValueFactory<>("Xoa"));
        try {


            String txt_sql = "select * from quanlysanpham";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<SanPham> list = FXCollections.observableArrayList();
            while (rs.next()){
                SanPham p = new SanPham(
                        rs.getInt("masp"),
                        rs.getString("tensp"),
                        rs.getString("mota"),
                        rs.getInt("tonkho"),
                        rs.getInt("price")
                );
                list.add(p);
            }
            tbSanPham.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addSP(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SanPhamForm.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }
}