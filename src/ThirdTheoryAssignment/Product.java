package ThirdTheoryAssignment;

import java.util.Date;

public class Product {
    private String code;
    private String description;
    private double price;
    private Date productionDate;
    private String shelflife;

    public String getCode() {
        return code;
    }
    public String getDescription(){
        return description;
    }

    public double getPrice() {
        return price;
    }
    public Date getProductionDate(){
        return productionDate;
    }

    public String getShelflife() {
        return shelflife;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Product){
            Product comparableproduct=(Product) object;
            if(this.code.equals(comparableproduct.code)){
                return true;
            }
        }//只有当两个code相等的时候，他们是同一个Product
      return false;
    }
    @Override
    public String toString(){
        return this.code+'_'+this.description+'_'+String.valueOf(this.price)+'_'+String.valueOf(productionDate)+'_'+this.shelflife;
    }
}
