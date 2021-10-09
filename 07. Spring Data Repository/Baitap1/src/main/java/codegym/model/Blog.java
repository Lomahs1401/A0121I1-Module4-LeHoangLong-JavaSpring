package codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private String context;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;


    public Blog(int id, String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;
    }

    public Blog() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
