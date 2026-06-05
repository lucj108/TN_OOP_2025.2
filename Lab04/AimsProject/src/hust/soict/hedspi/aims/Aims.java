package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	// 13.1.
	public static void showMenu() {
	    System.out.println("AIMS: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. View store");
	    System.out.println("2. Update store");
	    System.out.println("3. See current cart");
	    System.out.println("0. Exit");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2-3");
	}

	// 13.2.
	public static void storeMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. See a media's details");
	    System.out.println("2. Add a media to cart");
	    System.out.println("3. Play a media");
	    System.out.println("4. See current cart");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2-3-4");
	}

	// 13.3.
	public static void mediaDetailsMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Add to cart");
	    System.out.println("2. Play");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Filter medias in cart");
	    System.out.println("2. Sort medias in cart");
	    System.out.println("3. Remove media from cart");
	    System.out.println("4. Play a media");
	    System.out.println("5. Place order");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void viewStore(Store store, Cart cart, Scanner scanner) {
		int choice = -1;
		String title;
		Media m;
		
		while (choice != 0) {
			System.out.println("\n--- ITEMS IN STORE ---");		
			store.print();
			storeMenu(); 
			choice = scanner.nextInt();
			scanner.nextLine(); 
			
			switch (choice) {
				case 1:  // see details
					System.out.print("Please enter the title of the media: ");
					title = scanner.nextLine();
					m = store.searchByTitle(title); 
					if (m == null) {
						System.out.println("Media not found!");
					} else {
						System.out.println(m.toString());
						mediaAction(m, cart, scanner); 
					}
					break;
				case 2: // add to cart
					System.out.print("Please enter the title of the media: ");
                    title = scanner.nextLine();
                    m = store.searchByTitle(title);
                    if (m == null) {
                        System.out.println("Media not found!");
                    } else {
                    	try {
                    	    cart.addMedia(m);
                    	} catch (LimitExceededException e) {
                    	    System.err.println(e.getMessage());
                    	}
                    }
                    break;
				case 3: // Play
					System.out.print("Please enter the title of the media: ");
                    title = scanner.nextLine();
                    m = store.searchByTitle(title);
                    if (m == null) {
                        System.out.println("Media not found!");
                    } else if (m instanceof Playable) {
                        try {
                            ((Playable) m).play(); 
                        } catch (PlayerException e) {
                        	System.err.println("Exception: " + e.toString());
                            e.printStackTrace(); 
                            
                            javax.swing.SwingUtilities.invokeLater(() -> {
                                javax.swing.JFrame frame = new javax.swing.JFrame();
                                frame.setAlwaysOnTop(true); 
                                javax.swing.JOptionPane.showMessageDialog(frame, 
                                        e.getMessage(), 
                                        "Playback Error", 
                                        javax.swing.JOptionPane.ERROR_MESSAGE);
                                frame.dispose(); 
                            });        }
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                    break;
				case 4: // Xem giỏ hàng
					viewCart(cart, scanner); 
					System.out.println("Chuyen sang xem gio hang...");
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
	}
	
	public static void mediaAction(Media m, Cart cart, Scanner scanner) {
		int choice = -1;
		while (choice != 0) {
			mediaDetailsMenu();
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
			    try {
			        cart.addMedia(m);
			    } catch (LimitExceededException e) {
			        System.err.println(e.getMessage());
			    }
			    break;
				case 2:
				    if (m instanceof Playable) {
				        try {
				            ((Playable) m).play();
				        } catch (PlayerException e) {
				        	System.err.println("Exception: " + e.toString());
				            e.printStackTrace(); 
				            
				            javax.swing.SwingUtilities.invokeLater(() -> {
				                javax.swing.JFrame frame = new javax.swing.JFrame();
				                frame.setAlwaysOnTop(true); 
				                javax.swing.JOptionPane.showMessageDialog(frame, 
				                        e.getMessage(), 
				                        "Playback Error", 
				                        javax.swing.JOptionPane.ERROR_MESSAGE);
				                frame.dispose(); 
				            });
				        }
				    } else {
				        System.out.println("This media cannot be played!");
				    }
				    break;
			}
		}
	}
	
	public static void updateStore(Store store, Scanner scanner) {
		int choice = -1;
		
		while (choice != 0) {
			System.out.println("\n--- UPDATE STORE ---");
			System.out.println("1. Add a media");
			System.out.println("2. Remove a media");
			System.out.println("0. Back");
			System.out.print("Please choose an option: ");
			
			choice = scanner.nextInt();
			scanner.nextLine(); 

			if (choice == 1) {
				// thêm Media
				System.out.println("\nChoose the type of media to add: ");
				System.out.println("1. Book");
				System.out.println("2. Digital Video Disc (DVD)");
				System.out.println("3. Compact Disc (CD)");
				System.out.println("0. Cancel");
				System.out.print("Your choice: ");
				
				int type = scanner.nextInt();
				scanner.nextLine(); 
				
				if (type == 0) continue; // Hủy thêm mới
				
				if (type >= 1 && type <= 3) {
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter category: ");
					String category = scanner.nextLine();
					System.out.print("Enter cost: ");
					float cost = scanner.nextFloat();
					scanner.nextLine(); 
					
					if (type == 1) { // Thêm Book
						Book book = new Book(title, category, cost);
						store.addMedia(book);
					} 
					else if (type == 2) { // Thêm DVD
						System.out.print("Enter director: ");
						String director = scanner.nextLine();
						System.out.print("Enter length: ");
						int length = scanner.nextInt();
						scanner.nextLine(); 
						
						DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
						store.addMedia(dvd);
					} 
					else if (type == 3) { // Thêm CD
						System.out.print("Enter director: ");
						String director = scanner.nextLine();
						System.out.print("Enter artist: ");
						String artist = scanner.nextLine();
						
						CompactDisc cd = new CompactDisc(title, category, cost, 0, director, artist);
						store.addMedia(cd);
					}
				} else System.out.println("Invalid media type!");
				
				
			} else if (choice == 2) {
				// xóa Media
				System.out.print("Please enter the title of the media to remove: ");
				String title = scanner.nextLine();
				Media m = store.searchByTitle(title);
				
				if (m == null) System.out.println("Media not found in store!");
				else store.removeMedia(m);
	
			} else if (choice != 0) 
				System.out.println("Invalid option! Please choose again.");
			
		}
	}
	
	public static void viewCart(Cart cart, Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- CURRENT CART ---");
            cart.print();
            cartMenu(); 
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: // Filter
                    System.out.println("1. Filter by ID | 2. Filter by Title");
                    int filterType = scanner.nextInt();
                    scanner.nextLine();
                    if (filterType == 1) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        for (Media m : cart.filterById(id)) 
                            System.out.println(m.toString());
                    } else if (filterType == 2) {
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        for (Media m : cart.filterByTitle(title)) {
                            System.out.println(m.toString());
                        }
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. Sort by Title | 2. Sort by Cost");
                    int sortType = scanner.nextInt();
                    scanner.nextLine();
                    if (sortType == 1) cart.sortByTitle(); 
                    else if (sortType == 2) cart.sortByCost();
                    break;
                case 3: // Remove
                    System.out.print("Enter the title to remove: ");
                    String title = scanner.nextLine();
                    Media m = cart.searchByTitle(title);
                    if (m != null) cart.removeMedia(m);
                    else System.out.println("Not found!");
                    break;
                case 4: // Play
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = cart.searchByTitle(playTitle);
                    if (playMedia instanceof Playable) {
                        try {
                            ((Playable) playMedia).play();
                        } catch (PlayerException e) {
                        	System.err.println("Exception: " + e.toString());
                            e.printStackTrace(); 
                            
                            javax.swing.SwingUtilities.invokeLater(() -> {
                                javax.swing.JFrame frame = new javax.swing.JFrame();
                                frame.setAlwaysOnTop(true); 
                                javax.swing.JOptionPane.showMessageDialog(frame, 
                                        e.getMessage(), 
                                        "Playback Error", 
                                        javax.swing.JOptionPane.ERROR_MESSAGE);
                                frame.dispose(); 
                            });
                        }
                    } else {
                        System.out.println("Can't play!");
                    }
                    break;
                case 5: // Place order
                    System.out.println("An order has been created successfully!");
                    cart.emptyCart();
                    choice = 0; 
                    break;
                case 0: break;
            }
        }
    }
	public static void main(String[] args) {
		
		Store store = new Store();
		Cart cart = new Cart();
		Scanner scanner = new Scanner(System.in);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);	
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
       
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
        		"Animation", 18.99f);
        store.addMedia(dvd3);
        
        // Thêm thử một DVD có length = 0 để test ngoại lệ
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("temp", "Animation", "Director X", 0, 10.0f);
        store.addMedia(dvd4);
        
        int choice = -1;
		while (choice != 0) {
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Giữ kí tự Enter lại để ko bị lệch

			switch (choice) {
			case 1:
				viewStore(store, cart, scanner);
				break;
			case 2:
				updateStore(store, scanner);
				break;
			case 3:
				viewCart(cart, scanner); 
				break;
			case 0:
				System.out.println("Tam biet!");
				break;
			default:
				System.out.println("Lua chon khong hop le!");
				break;
		}
		}
		scanner.close(); 
	}
}