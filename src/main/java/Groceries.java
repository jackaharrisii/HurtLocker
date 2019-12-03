import java.util.HashMap;

public class Groceries {

    private String name;
    private String price;
    private String type;
    private String expiration;
    private Integer multiples;

    public Groceries(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public Groceries(String name, String price, String type, String expiration, Integer multiples) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
        this.multiples = multiples;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public Integer getMultiples() {
        return multiples;
    }

    public void setMultiples(Integer multiples) {
        this.multiples = multiples;
    }

    @Override
    public String toString(){
        if (this.getMultiples() == null){
            return String.format("\nName: %s\nPrice: %s\nType: %s\nExpiration: %s\n********************\n",
            this.getName(), this.getPrice(), this.getType(), this.getExpiration());
        } else {
            return String.format("\nName: %s\nPrice: %s\nType: %s\nExpiration: %s\nMultiples: %s\n********************\n",
            this.getName(), this.getPrice(), this.getType(), this.getExpiration(), this.getMultiples());
        }
    }

}
