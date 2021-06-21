package dimigo.EternalStat.domain;



import javax.persistence.*;

@Entity
@Table(name="tips")

public class Tip { //tips 테이블과 연관될 도메인


    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
    int id;
    String ch;
    @Column(columnDefinition = "TEXT")
    String title;
    String type;
    @Column(columnDefinition = "TEXT")
    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
