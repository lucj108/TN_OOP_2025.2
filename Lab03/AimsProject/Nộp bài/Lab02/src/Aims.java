public class Aims {
    public static void main(String[] args) {
        //Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        //Tạo và thêm DVD vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

       
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //In ra tổng chi phí lúc đầu
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        //Test chức năng xóa đĩa khỏi giỏ
        System.out.println("\n--- Testing ---");
        anOrder.removeDigitalVideoDisc(dvd2); // Thử xóa đĩa Star Wars
        
        System.out.println("Total Cost after removing Star Wars is: ");
        System.out.println(anOrder.totalCost()); //Giá tiền bị giảm
    }
}