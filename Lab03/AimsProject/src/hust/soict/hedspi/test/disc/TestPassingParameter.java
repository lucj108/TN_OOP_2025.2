package hust.soict.hedspi.test.disc;
<<<<<<< HEAD

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // chi doi tham chieu cuc bo
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        
        // hoan doi gia tri thuc su
        System.out.println("\n--- Testing True Swap ---");
        swapAttributes(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title after true swap: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title after true swap: " + cinderellaDVD.getTitle());
    }
    
    // pass by value nen khong thay doi duoc object truyen vao
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    
    // hoan doi thuc su bang cach doi gia tri thuoc tinh
    public static void swapAttributes(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String title1 = dvd1.getTitle();
        String category1 = dvd1.getCategory();
        String director1 = dvd1.getDirector();
        int length1 = dvd1.getLength();
        float cost1 = dvd1.getCost();
        
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setCost(dvd2.getCost());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setTitle(dvd2.getTitle());
        
        dvd2.setCategory(category1);
        dvd2.setCost(cost1);
        dvd2.setDirector(director1);
        dvd2.setLength(length1);
        dvd2.setTitle(title1);
    }
}
=======
import hust.soict.hedspi.aims.disc.*;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) { // Ham Swap da sua de hoan doi dung
		String tmp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(tmp);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
>>>>>>> hotfix/redo-lab03
