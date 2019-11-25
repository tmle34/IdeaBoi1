import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainBoi extends Application {

    private BorderPane bp = new BorderPane();
    private  GridPane g1 = new GridPane();
    private GridPane g2 = new GridPane();
    private FlowPane fp = new FlowPane();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();

    private ObservableList<Items> data;

    public void start(Stage s) {
        TableView<Items> tbl; //table view to store person objects
        tbl = new TableView<>();
        TableView<Items> tb2; //table view to store person objects
        tb2 = new TableView<>();
        Alert alerts = new Alert(Alert.AlertType.INFORMATION); //success message
        Alert alert = new Alert(Alert.AlertType.ERROR); //Error message
        Scene sc1, sc2, sc3,sc4; // scenes
        sc1 = new Scene(new Group()); // main scene
        s.sizeToScene();  //setting stage to size according the scene sizes

        //top pane in the main scene
        Button b2 = new Button("Add");
        Button b3 = new Button("Update");
        Button b4 = new Button("Remove");
        Button b5 = new Button("Print");
        CheckBox yes1 = new CheckBox("25 Off 100 Bedding and Clothing");
        CheckBox yes2 = new CheckBox("10 off 25 Kitchen Items");
        Label phone = new Label("Customer Phone");
        TextField phone1 = new TextField();
        fp.getChildren().addAll(b2, b3, b4,b5,yes1,yes2,phone,phone1);  // menu bar

        data = FXCollections.observableArrayList();

        s.setWidth(900);
        s.setHeight(600);
        final Label l1 = new Label("Items");
        l1.setFont(new Font("Arial", 22));

        String Item[] = {"Clothing","Accessories","Electronics","Kitchen","Bedding"};

        //Column1
        TableColumn idcol = new TableColumn("ID");
        idcol.setMinWidth(100);
        idcol.setCellValueFactory(new PropertyValueFactory<Items, String>("id"));
        //Column2
        TableColumn namecol = new TableColumn("Name");
        namecol.setMinWidth(100);
        namecol.setCellValueFactory(new PropertyValueFactory<Items, String>("name"));
        //Column3
        TableColumn Qcol = new TableColumn("Quantity");
        Qcol.setMinWidth(100);
        Qcol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("quantity"));
        //Column4
        TableColumn Pcol = new TableColumn("Price");
        Pcol.setMinWidth(100);
        Pcol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("price"));
        //Coulumn5
        TableColumn Dcol = new TableColumn("Discount");
        Dcol.setMinWidth(100);
        Dcol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("discount"));
        //Column6
        TableColumn Tcol = new TableColumn("Type");
        Tcol.setMinWidth(100);
        Tcol.setCellValueFactory(new PropertyValueFactory<Items, String>("type"));




        tbl.setEditable(true);
        tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tbl.setItems(data);// table items are getting populated from observable list
        tbl.getColumns().addAll(idcol, namecol, Qcol, Pcol,Dcol,Tcol); // adding columns to table
        vb1.getChildren().addAll(l1, tbl);

        //Left pane with a gridpane and a add button

        Label ln = new Label();
        ln.setText("ID");
        Label l2 = new Label();
        l2.setText("Name");
        Label l3 = new Label();
        l3.setText("Quantity");
        Label l4 = new Label();
        l4.setText("Price");
        Label l5 = new Label();
        l5.setText("Discount");
        Label l6 = new Label();
        l6.setText("Type");

        TextField ti = new TextField();
        TextField tn = new TextField();
        TextField tq = new TextField();
        TextField tp = new TextField();
        TextField td = new TextField();
        ComboBox tt = new ComboBox(FXCollections.observableArrayList(Item));

        Button b1 = new Button("Add");

        g1.add(ln, 0, 0);
        g1.add(ti, 1, 0);
        g1.add(l2, 0, 1);
        g1.add(tn, 1, 1);
        g1.add(l3, 0, 2);
        g1.add(tq, 1, 2);
        g1.add(l4, 0, 3);
        g1.add(tp, 1, 3);
        g1.add(l5, 0, 4);
        g1.add(td,1,4);
        g1.add(l6, 0, 5);
        g1.add(tt,1,5);


        g1.setPadding(new Insets(12, 12, 12, 12));
        g1.setHgap(10);
        g1.setVgap(10);
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(7, 7, 7,7));
        vb2.getChildren().addAll(g1, b1);
        vb2.setVisible(false);
        bp.setPadding(new Insets(12, 12, 12, 12));
        bp.setLeft(vb2);
        bp.setRight(vb1);
        bp.setTop(fp);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb2.setVisible(true); // clicking the new button makes left-side pane visible
            }
        };
        b2.setOnAction(event1);
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //clicking add button causes the data entered in the grid pane
                data.add(new Items(ti.getText(),tn.getText(),Integer.parseInt(tq.getText()),Integer.parseInt(tp.getText()),Integer.parseInt(td.getText()),tt.getSelectionModel().getSelectedItem().toString()));
                ti.clear();
                tn.clear();
                tq.clear();
                tp.clear();
                td.clear();
                tt.setValue(null);

            }

        };
        b1.setOnAction(event2);

        ((Group) sc1.getRoot()).getChildren().add(bp);  //Borderpane is added to the scene
        //sc1= new Scene(bp);
        s.setScene(sc1);
        s.show();
        //*************************************************************************
        //Scene2
        //modify  scene to modify the age given a name
        Label ul2 = new Label("Enter the Name of a Item to update");
        ul2.setFont(new Font("Courier", 14));
        Label ln2 = new Label("ID");
        Label l22 = new Label("Quantity");
        Label l222 = new Label("Price");
        Label ln22 = new Label("Name");
        Label ln222 = new Label("Discount");
        Label ln2222 = new Label("Type");



        TextField ti2 = new TextField();
        TextField tq2 = new TextField();
        TextField tl2 = new TextField();
        TextField tn2 = new TextField();
        TextField td2 = new TextField();
        ComboBox tt2 = new ComboBox(FXCollections.observableArrayList(Item));


        Button b12 = new Button("Update");




        g2.add(ln2, 0, 0);
        g2.add(ti2, 1, 0);
        g2.add(l22, 0, 1);
        g2.add(tq2, 1, 1);
        g2.add(l222, 0, 2);
        g2.add(tl2, 1, 2);
        g2.add(ln22,0,3);
        g2.add(tn2,1,3);
        g2.add(ln222,0,4);
        g2.add(td2,1,4);
        g2.add(ln2222,0,5);
        g2.add(tt2,1,5);




        Label lu= new Label();
        g2.setPadding(new Insets(12, 12, 12, 12));
        g2.setHgap(10);
        g2.setVgap(10);
        vb3.getChildren().addAll(ul2, g2, b12, lu);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(12, 12, 12, 12));
        EventHandler<ActionEvent> event22 = new EventHandler<ActionEvent>() {
            @Override
               /* When the button was clicked, the record with the name that matches with the name  entered in the
               textfield (tn2) will be updated */
            public void handle(ActionEvent event) {
                String sid = ti2.getText();
                boolean f=false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getID()).equals(sid)) {
                        Items p = new Items(ti2.getText(),tn2.getText(),Integer.parseInt(tq2.getText()),Integer.parseInt(tl2.getText()),Integer.parseInt(td2.getText()),tt2.getSelectionModel().getSelectedItem().toString());
                        tbl.getItems().set(i, p); //inserts the Person object at index i
                        f=true;
                    }
                }
                if (f) {
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Update Successful!");
                    alerts.showAndWait();
                }

                else {
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Entered Person's ID not found..");
                    alert.showAndWait();
                }
                ti2.clear();
                tq2.clear();
                tl2.clear();
                tn2.clear();
                tt2.setValue(null);
                td2.clear();
                s.setScene(sc1); //after modification going back to scene1
            }
        };
        b12.setOnAction(event22); // update button

        sc2 = new Scene(vb3, 400, 550);
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sc2); //Clicking the update button causes scene 2
            }
        };
        b3.setOnAction(event3);  // Modify  button
        //*********************************************************************************
        //Scene 3
        // delete a row in the table view
        VBox vb4= new VBox();
        Label rl= new Label("Enter the Item's ID to remove");
        TextField tr= new TextField();
        Button dl= new Button("Delete");
        vb4.getChildren().addAll(rl, tr, dl);
        vb4.setPadding(new Insets(12, 12, 12, 12));
        vb4.setSpacing(12);
        sc3= new Scene(vb4, 300, 300);

        EventHandler<ActionEvent> event23 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sid = tr.getText();
                boolean df =false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getID()).equals(sid)) {
                        tbl.getItems().remove(i); //removes the record at index i
                        df=true;
                    }
                }
                if (df){
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Item Removed!");
                    alerts.showAndWait();
                }

                else {
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Entered ID not found..");
                    alert.showAndWait();
                }
                tn2.clear();
                s.setScene(sc1); //after deletion going back to scene1

            }
        };
        dl.setOnAction(event23); //

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sc3);
            }
        };
        b4.setOnAction(event4); // Remove button

        //*********************************************************************************
        //Scene 4
        VBox vb5= new VBox();
        Label rl1= new Label("Print Out");
        vb5.getChildren().addAll(rl1);
        tb2.setEditable(true);
        tb2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tb2.setItems(data);// table items are getting populated from observable list
        tb2.getColumns().addAll(idcol, namecol, Qcol, Pcol,Dcol,Tcol);
        vb5.getChildren().addAll(l1, tb2);
        vb5.setPadding(new Insets(12, 12, 12, 12));
        vb5.setSpacing(12);
        sc4= new Scene(vb5, 800, 700);
        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>(){
            @Override

            public void handle(ActionEvent event){
                s.setScene(sc4);
                double total = 0;
                double discount = 0;
                System.out.println(tb2.getItems().get(0).getType());
                if(yes1.isSelected()) {
                    for (int i = 0; i < tb2.getItems().size(); i++) {
                        String sid = "Bedding";
                        if (((String)tb2.getItems().get(i).getType()).equals(sid)) {
                            if(tb2.getItems().get(i).getPrice()*tb2.getItems().get(i).getQuantity()>=100){
                                discount = discount +25;
                            }
                            System.out.println(tb2.getItems().get(i).getType());
                        }
                    }
                    for (int i = 0; i < tb2.getItems().size(); i++) {
                        String sis = "Clothing";
                        if (((String)tb2.getItems().get(i).getType()).equals(sis)) {
                            if(tb2.getItems().get(i).getPrice()*tb2.getItems().get(i).getPrice()>=100){
                                discount = discount +25;
                            }
                        }
                    }
                }
                if(yes2.isSelected()) {
                    for (int i = 0; i < tb2.getItems().size(); i++) {
                        String sid = "Kitchen";
                        if (((String)tb2.getItems().get(i).getType()).equals(sid)) {
                            if(tb2.getItems().get(i).getPrice()*tb2.getItems().get(i).getQuantity()>=25){
                                discount = discount +10;
                            }
                            System.out.println(tb2.getItems().get(i).getType());
                        }
                    }

                }
                for(int i=0;i<tbl.getItems().size();i++) {
                    total = tbl.getItems().get(i).getPrice()*tbl.getItems().get(i).getQuantity()+total;
                }
                Label l1 = new Label("Original Price: "+total);
                for(int i=0;i<tbl.getItems().size();i++) {
                    double discounta = tbl.getItems().get(i).getDiscount();
                    discount = ((discounta/100+1)-1)*tbl.getItems().get(i).getPrice()*tbl.getItems().get(i).getQuantity()+discount;
                }
                Label l2 = new Label("Discount Value: "+discount);
                double subtotal = total - discount;
                Label l3 = new Label("Subtotal: "+subtotal);
                Label l4 = new Label("Tax: 8.25%");
                double total1 = subtotal *1.0825;
                Label l5 = new Label("Total: "+total1);
                double points = 0;
                if(total1>=1000){
                    points = 50;
                }
                else{
                    points = 0;
                }
                Label l6 = new Label("Customer #:"+phone1.getText()+" gets "+points+" points");
                vb5.getChildren().addAll(l1,l2,l3,l4,l5,l6);
            }
        };
        b5.setOnAction(event5); // Print Button

    } //end of start

    public static void main (String[]args){
        launch(args);
    }
} //end of class