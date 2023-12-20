package hello.core.Order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int disountPrcie;

    public Order(Long memberId, String itemName, int itemPrice, int disountPrcie) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.disountPrcie = disountPrcie;
    }

    public int calculatePrcie(){
        return itemPrice-disountPrcie;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDisountPrcie() {
        return disountPrcie;
    }

    public void setDisountPrcie(int disountPrcie) {
        this.disountPrcie = disountPrcie;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", disountPrcie=" + disountPrcie +
                '}';
    }
}
