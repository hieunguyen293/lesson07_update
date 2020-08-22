package Test;

import java.util.ArrayList;

public class BookManagement {

    ArrayList<Book> library = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();

    // Show Library
    public void showLib() {
        for (int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i).toString());
        }
    }

    // Add Book
    public boolean addBook(Book book) {
        try {
            library.add(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Delete Book
    public int deleteBook(String nameBook) {  // 1: Thanh cong, -1: Xoa that bai, 0: Khong tim thay sach
        Book book = new Book();
        boolean isBookExist = false;

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameBook)) {
                book = library.get(i);
                isBookExist = true;
            }
        }

        if (isBookExist) {
            boolean resultDelete = library.remove(book);
            if (resultDelete) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    // Update Book
    public int updateBook(String nameOldBook, Book newBook) { // 1: Thanh cong, -1: Update that bai, 0: Khong tim thay sach
        int isBookExist = -1;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameOldBook)) {
                isBookExist = i;
            }
        }
        if (isBookExist != -1) {
            library.set(isBookExist, newBook);
            if (library.get(isBookExist).getName().equals(newBook.getName())) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    // Check Book Exist
    public boolean isExistBook(String nameBook) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameBook)) {
                return true;
            }
        }
        return false;
    }

    // Show filter Book
    public ArrayList<String> filterBook() {

        for (int i = 0; i < library.size(); i++) {
            String currentBookType = library.get(i).getType();
            boolean isNewType = true;
            for (int j = 0; j < type.size(); j++) {
                if (currentBookType.equals(type.get(j))) {
                    isNewType = false;
                }
            }
            if (isNewType) {
                type.add(currentBookType);
            }
        }
        return type;
    }

    // List Book by Price
    public ArrayList<Book> listBookByPrice() {
        Book temp = new Book();
        temp.setPrice(0);
        for (int i = 0; i < library.size() - 1; i++) {
            for (int j = 0; j < library.size() - 1 - i; j++) {
                if (library.get(j).getPrice() > library.get(j + 1).getPrice()) {
                    temp.setName(library.get(j).getName());
                    temp.setOrigin(library.get(j).getOrigin());
                    temp.setType(library.get(j).getType());
                    temp.setNumberOfPage(library.get(j).getNumberOfPage());
                    temp.setPrice(library.get(j).getPrice());

                    library.get(j).setName(library.get(j + 1).getName());
                    library.get(j).setName(library.get(j + 1).getName());
                    library.get(j).setPrice(library.get(j + 1).getPrice());
                    library.get(j).setOrigin(library.get(j + 1).getOrigin());
                    library.get(j).setType(library.get(j + 1).getType());
                    library.get(j).setNumberOfPage(library.get(j + 1).getNumberOfPage());

                    library.get(j + 1).setName(temp.getName());
                    library.get(j + 1).setPrice(temp.getPrice());
                    library.get(j + 1).setOrigin(temp.getOrigin());
                    library.get(j + 1).setType(temp.getType());
                    library.get(j + 1).setNumberOfPage(temp.getNumberOfPage());
                }
            }

        }
        return library;
    }
    
    // Check Type
    public boolean checkType(String nameType){
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getType().equals(nameType)) {
                return true;
            }
        }
        return false;
    }
    
    // Show by Type
    public void showByType(String nameType){
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getType().equals(nameType)) {
                System.out.println(library.get(i).toString());
            }
        }
    }
    
}
