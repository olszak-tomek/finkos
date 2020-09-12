package pl.sda.final_project.model.product;

import pl.sda.final_project.dto.ProductDto;

import javax.persistence.Embeddable;

@Embeddable
public class Author {

    private String authorName;
    private String authorSurname;

    public static Author apply(ProductDto productDto) {
        Author authorToSave = new Author();
        authorToSave.authorName = productDto.getAuthorName();
        authorToSave.authorSurname = productDto.getAuthorSurname();
        return authorToSave;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}
