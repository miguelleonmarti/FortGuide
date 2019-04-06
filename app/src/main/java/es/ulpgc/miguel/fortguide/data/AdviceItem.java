package es.ulpgc.miguel.fortguide.data;


public class AdviceItem {
    public int id;
    public String content;
    public String details;

    public AdviceItem(int id, String content, String details){
        this.id=id;
        this.content=content;
        this.details=details;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDetails() {
        return details;
    }
}
