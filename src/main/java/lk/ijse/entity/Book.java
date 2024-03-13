package lk.ijse.entity;

import lk.ijse.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @Column(name="b_Id")
    private long b_Id;

    @Column
    private String b_Name;

    @Column
    private String b_Autor;

    @Column
    private String gener;

    @Column
    private String publicationDate;

    @Column
    private double b_Price;

    @Column
    private String availability;

    public Book(String b_Name, String b_Autor, String gener, String publicationDate, double b_Price, String availability) {
        this.b_Name = b_Name;
        this.b_Autor = b_Autor;
        this.gener = gener;
        this.publicationDate = publicationDate;
        this.b_Price = b_Price;
        this.availability = availability;
    }


    public BookDto toDto() {
        BookDto bookDto=new BookDto();
        bookDto.setB_Id(this.b_Id);
        bookDto.setB_Name(this.b_Name);
        bookDto.setB_Autor(this.b_Autor);
        bookDto.setGener(this.gener);
        bookDto.setPublicationDate(this.publicationDate);
        bookDto.setB_Price(this.b_Price);
        bookDto.setAvailability(this.availability);
        return bookDto;
    }
}
