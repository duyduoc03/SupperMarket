package jp2.SuperMarket;

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

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class NhanVienController implements Initializable {

    public TableView<NhanVien> tbNhanVien;
    public TableColumn<NhanVien,Integer> sMaNV;
    public TableColumn<NhanVien, String> sHoTen;
    public TableColumn<NhanVien,String> sSDT;
    public TableColumn<NhanVien,String> sDiaChi;
    public TableColumn<NhanVien, Button> sSua;
    public TableColumn<NhanVien,Button> sXoa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sMaNV.setCellValueFactory(new  PropertyValueFactory<>("manv"));
        sHoTen.setCellValueFactory(new PropertyValueFactory<>("hoten"));
        sSDT.setCellValueFactory(new PropertyValueFactory<>("sodt"));
        sDiaChi.setCellValueFactory(new PropertyValueFactory<>("diachi"));
        sSua.setCellValueFactory(new PropertyValueFactory<>("Sua"));
        sXoa.setCellValueFactory(new PropertyValueFactory<>("Xoa"));


        try {
            String txt_sql = "select * from nhanvien";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery();

            ObservableList<NhanVien> list = FXCollections.observableArrayList();
            while (rs.next()){
                NhanVien nv = new NhanVien(
                        rs.getInt("manv"),
                        rs.getString("hoten"),
                        rs.getString("sodt"),
                        rs.getString("diachi")
                );
                list.add(nv);
            }
            tbNhanVien.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addNhanVien(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NhanVienFormController.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
