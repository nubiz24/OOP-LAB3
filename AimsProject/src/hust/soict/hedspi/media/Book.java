package hust.soict.hedspi.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
    private List <String> authors = new ArrayList<String>();
    public Book(String bookTitle, String bookCategory, float bookCost) {
        super();
    }
    public Book(int id, String title, String category, float cost,String author) {
        super(id,title,category,cost);
        this.authors = new ArrayList<String>(); // Khoi tao lai Array list
        this.authors.add(author);     //them author vao list
    }
    //Phuong thuc them tac gia
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Author " + authorName + " added.");
        }else{
            System.out.println("Author " + authorName + " is already in the list.");
        }
    }
    //Phuong thuc xoa tac gia
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed.");
        }else{
            System.out.println("Author " + authorName + " not found in the list.");
        }
    }
    @Override
    public String toString() {
        String authorString = String.join(", ",this.authors); // ket hop cac danh sach author
        return "Book - " + this.getTitle() + " - " + authorString + ": " + this.getCost() + " $";
    }
}