package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Author {
    @Id
    private String author_id;
    private String name;
    private Date date_of_birth;

    public Author(){
        super();// ke thua
    }

    public Author(String author_id, String name, Date date_of_birth) {
        this.author_id = author_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }



    @Override
    public String toString() {
        return "Author{" +
                "author_id='" + author_id + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
