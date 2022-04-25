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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class ChiTietHDController implements Initializable {
    public TableView tbCTHD;
    public TableColumn<ChiTietHD, Integer> cMSP;
    public TableColumn<ChiTietHD, Integer> cMHD;
    public TableColumn<ChiTietHD, Integer> cSoLuong;
    public TableColumn<ChiTietHD, Double> cGiamGia;
    public TableColumn<ChiTietHD, Date> cRHD;
    public TableColumn<ChiTietHD, Button> cXoa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cMSP.setCellValueFactory(new PropertyValueFactory<>("masp"));
        cMHD.setCellValueFactory(new PropertyValueFactory<>("mahd"));
        cSoLuong.setCellValueFactory(new PropertyValueFactory<>("soluong"));
        cGiamGia.setCellValueFactory(new PropertyValueFactory<>("giamgia"));
        cRHD.setCellValueFactory(new PropertyValueFactory<>("ngayhd"));
        cXoa.setCellValueFactory(new PropertyValueFactory<>("Xoa"));
        try {


            String txt_sql = "select * from chitiethoadon";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<ChiTietHD> list = FXCollections.observableArrayList();
            while (rs.next()){
                ChiTietHD h = new ChiTietHD(
                        rs.getInt("masp"),
                        rs.getInt("mahd"),
                        rs.getInt("soluong"),
                        rs.getDouble("giamgia"),
                        Date.valueOf(rs.getString("ngayhd"))
                );
                list.add(h);
            }
            tbCTHD.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addCTHD(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CTHDForm.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }
}