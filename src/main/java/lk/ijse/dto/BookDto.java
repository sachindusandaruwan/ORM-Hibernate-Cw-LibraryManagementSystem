package lk.ijse.dto;

import lk.ijse.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class BookDto {
    private long b_Id;
    private String b_Name;
    private String b_Autor;
    private String gener;
    private String publicationDate;
    private double b_Price;
    private String availability;

    public BookDto(String b_Name, String b_Autor, String gener, String publicationDate, double b_Price, String availability) {
        this.b_Name = b_Name;
        this.b_Autor = b_Autor;
        this.gener = gener;
        this.publicationDate = publicationDate;
        this.b_Price = b_Price;
        this.availability = availability;
    }


    public Book toEntity() {
        Book book=new Book();
        book.setB_Id(this.b_Id);
        book.setB_Name(this.b_Name);
        book.setB_Autor(this.b_Autor);
        book.setGener(this.gener);
        book.setPublicationDate(this.publicationDate);
        book.setB_Price(this.b_Price);
        book.setAvailability(this.availability);
        System.out.println("Bettak");
        return book;
    }
}
