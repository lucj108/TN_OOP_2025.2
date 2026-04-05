public class Cart {
    //Sức chứa tối đa của giỏ hàng là 20
    public static final int MAX_NUMBERS_ORDERED = 20;

    //Mảng chứa DVD
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    //Biến đếm số lượng đĩa thực tế
    private int qtyOrdered = 0;

    //Thêm DVD vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc; // Bỏ đĩa vào vị trí trống tiếp theo
            qtyOrdered++; // Tăng số lượng lên 1
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    //Hàm xóa DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) { 
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa vị trí cuối cùng bị thừa
                qtyOrdered--; // Giảm tổng số lượng đi 1
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    //Hàm tính tổng chi phí
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost(); 
        }
        return sum;
    }
}