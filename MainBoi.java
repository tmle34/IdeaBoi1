import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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

import java.util.concurrent.atomic.AtomicBoolean;

public class MainBoi extends Application {

    private BorderPane bp = new BorderPane();
    private  GridPane g1 = new GridPane();
    private GridPane g2 = new GridPane();
    private FlowPane fp = new FlowPane();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();

    // ObservableList is a list that enables listeners to track changes when they occur
    private ObservableList<Items> data;

    public void start(Stage s) {
        TableView<Items> tbl; //table view to store person objects
        tbl = new TableView<>();
        Alert alerts = new Alert(Alert.AlertType.INFORMATION); //success message
        Alert alerte = new Alert(Alert.AlertType.ERROR); //Error message
        Scene sc1, sc2, sc3; // scenes
        sc1 = new Scene(new Group()); // main scene
        s.sizeToScene();  //setting stage to size acording the scene sizes

        //top pane in the main scene
        Button b2 = new Button("New");
        Button b3 = new Button("Modify");
        Button b4 = new Button("Remove");
        Button b5 = new Button("Print");
        fp.getChildren().addAll(b2, b3, b4,b5);  // menubar


        //Right Pane with a title and tableview

       /* FXCollections is A utility class that consists of static methods
        that are one-to-one copies of java.util.Collections methods */

        dataid = FXCollections.observableArrayList();
        dataname = FXCollections.observableArrayList();
        dataQ = FXCollections.observableArrayList();
        dataprice = FXCollections.observableArrayList();
        datadiscount = FXCollections.observableArrayList();
        datatype = FXCollections.observableArrayList();

        s.setWidth(800);
        s.setHeight(500);
        final Label l1 = new Label("Items");
        l1.setFont(new Font("Arial", 20));
        //Column1
        TableColumn idcol = new TableColumn("ID");
        idcol.setMinWidth(100);
       /* A TableColumn must have a cell value factory set on it.
       The cell value factory extracts the value to be displayed in each cell
       (on each row) in the column.
        The PropertyValueFactory factory can extract a property value (field value) from a Java object.
        The name of the property is passed as a parameter to the PropertyValueFactory constructor
        */
        idcol.setCellValueFactory(new PropertyValueFactory<Items, String>("id"));

        /*The property name "name" will match the getter method getName() of the Person
        objects which returns the name values and are displayed on each row.
         */
        //Column2
        TableColumn namecol = new TableColumn("Name");
        namecol.setMinWidth(100);
        namecol.setCellValueFactory(new PropertyValueFactory<Items, String>("Name"));
        //Column3
        TableColumn Qcol = new TableColumn("Quantity");
        namecol.setMinWidth(100);
        Qcol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("Quantity"));
        //Column4

        tbl.setEditable(true);
        tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tbl.setItems(data);// table items are getting populated from observable list
        tbl.getColumns().addAll(idcol, namecol); // adding columns to table
        vb1.getChildren().addAll(l1, tbl);

        //Left pane with a gridpane and a add button

        Label ln = new Label();
        ln.setText("Name");
        Label l2 = new Label();
        l2.setText("Age");

        TextField tn = new TextField();
        TextField ta = new TextField();
        Button b1 = new Button("Add");

        g1.add(ln, 0, 0);
        g1.add(tn, 1, 0);
        g1.add(l2, 0, 1);
        g1.add(ta, 1, 1);

        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setHgap(10);
        g1.setVgap(10);
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(5, 5, 5,5));
        vb2.getChildren().addAll(g1, b1);
        vb2.setVisible(false);
        bp.setPadding(new Insets(10, 10, 10, 10));
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
            public void handle(ActionEvent event) { //clicking add button causes the data enetred in the grid pane
                //data.add(new Items(tn.getText(), Integer.parseInt(ta.getText()))); //to be populated in the Table view
                //add() method appends to list.
                // it is method a declared in the java.util.List interface that was inherited by ObservableList interface
                tn.clear();
                ta.clear();
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
        Label ul2 = new Label("Enter the Name of a person to update");
        ul2.setFont(new Font("Courier", 14));
        Label ln2 = new Label("Name");
        Label l22 = new Label("Age");
        TextField tn2 = new TextField();
        TextField ta2 = new TextField();
        Button b12 = new Button("Update");
        g2.add(ln2, 0, 0);
        g2.add(tn2, 1, 0);
        g2.add(l22, 0, 1);
        g2.add(ta2, 1, 1);
        Label lu= new Label();
        g2.setPadding(new Insets(10, 10, 10, 10));
        g2.setHgap(10);
        g2.setVgap(10);
        vb3.getChildren().addAll(ul2, g2, b12, lu);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(10, 10, 10, 10));
        EventHandler<ActionEvent> event22 = new EventHandler<ActionEvent>() {
            @Override
               /* When the button was clicked, the record with the name that matches with the name  entered in the
               textfield (tn2) will be updated */
            public void handle(ActionEvent event) {
                String sid = tn2.getText();
                boolean f=false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getName()).equals(sid)) {
                        Items p = new Items(tn2.getText(), ta2.getText()/*Integer.parseInt(ta2.getText())*/);
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
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Enetered Person's ID not found..");
                    alerte.showAndWait();
                }
                tn2.clear();
                ta2.clear();
                s.setScene(sc1); //after modification going back to scene1
            }
        };
        b12.setOnAction(event22); // update button

        sc2 = new Scene(vb3, 400, 200);
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
        Label rl= new Label("Enter the Person's name to remove");
        TextField tr= new TextField();
        Button dl= new Button("Delete");
        vb4.getChildren().addAll(rl, tr, dl);
        vb4.setPadding(new Insets(10, 10, 10, 10));
        vb4.setSpacing(10);
        sc3= new Scene(vb4, 300, 200);

        EventHandler<ActionEvent> event23 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sid = tr.getText();
                boolean df =false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getName()).equals(sid)) {
                        tbl.getItems().remove(i); //removes the record at index i
                        df=true;
                    }
                }
                if (df){
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Deletion Successful!");
                    alerts.showAndWait();
                }

                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Entered Person's ID not found..");
                    alerte.showAndWait();
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

    } //end of start

    public static void main (String[]args){
        launch(args);
    }
} //end of class