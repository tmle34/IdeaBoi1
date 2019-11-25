import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Items {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty quantity;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty discount;
    private SimpleStringProperty type;
    public Items(String i, String n,int q,int p,int d,String t){ //Constructor
        id=new SimpleStringProperty(n);
        name=new SimpleStringProperty(n);
        quantity=new SimpleIntegerProperty(q);
        price=new SimpleIntegerProperty(p);
        discount=new SimpleIntegerProperty(d);
        type=new SimpleStringProperty(t);
    }
    public String getID(){
        return id.get();
    }//getter
    public String getName(){
        return name.get();
    }
    public int getQuantity(){
        return quantity.get();
    }
    public int getPrice(){
        return price.get();
    }
    public int getDiscount(){
        return discount.get();
    }
    public String getType(){
        return type.get();
    }

    public void setID(String i){  //setter
        id.set(i);
    }
    public void setName(String n){
        name.set(n);
    }
    public void setQuantity(int q){
        quantity.set(q);
    }
    public void setPrice(int p){
        price.set(p);
    }
    public void setDiscount(int d){
        discount.set(d);
    }
    public void setType(String t){
        type.set(t);
    }


}

