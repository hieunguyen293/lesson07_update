package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookManagement bm = new BookManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show");
            System.out.println("2. Add");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Show types book");
            System.out.println("6. Show by price");
            System.out.println("0. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    bm.showLib();
                    break;
                case 2:
                    System.out.println("Name:");
                    String name = sc.next();
                    System.out.println("Origin:");
                    String origin = sc.next();
                    System.out.println("Type:");
                    String type = sc.next();
                    System.out.println("Price:");
                    int price = sc.nextInt();
                    System.out.println("Number Of Page:");
                    int numberOfPage = sc.nextInt();
                    Book book = new Book(name, origin, type, price, numberOfPage);
                    boolean result = bm.addBook(book);
                    if (result) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
                case 3:
                    System.out.println("Enter name of book you want to delete: ");
                    String nameDeleteBook = new String();
                    nameDeleteBook = sc.next();
                    int resultDelete = bm.deleteBook(nameDeleteBook);
                    if (resultDelete == 1) {
                        System.out.println("Success");
                    }else if (resultDelete == -1) {
                        System.out.println("Fail");
                    }  else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter name of book you want to update: ");
                    String nameUpdateBook = sc.next();
                    if (bm.isExistBook(nameUpdateBook)) {
                        System.out.println("Name:");
                        String newName = sc.next();
                        System.out.println("Origin:");
                        String newOrigin = sc.next();
                        System.out.println("Type:");
                        String newType = sc.next();
                        System.out.println("Price:");
                        int newPrice = sc.nextInt();
                        System.out.println("Number Of Page:");
                        int newNumberOfPage = sc.nextInt();
                        Book newBook = new Book(newName, newOrigin, newType, newPrice, newNumberOfPage);
                        int resultUpdate = bm.updateBook(nameUpdateBook, newBook);
                        if (resultUpdate == 1) {
                            System.out.println("Success");
                        } else {
                            System.out.println("Fail");
                        }
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 5:
                    ArrayList<String> types = bm.filterBook();
                    for (int i = 0; i < types.size(); i++) {
                        System.out.println(types.get(i));
                    }
                    while(true){
                    System.out.println("Chon loai sach muon in ra: ");
                    String input2 = sc.next();
                    if (bm.checkType(input2)) {
                     bm.showByType(input2);
                     break;
                    }
                    }
                    break;
                case 6:
                    bm.listBookByPrice();
                    bm.showLib();
                    break;
                case 0:
                    return;
            }
        }

    }
}
