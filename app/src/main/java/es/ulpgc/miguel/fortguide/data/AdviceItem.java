package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;

@Entity(tableName = "advice")
public class AdviceItem extends Item{

    public AdviceItem(int id, String content, String details){
        super(id, content, details);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getContent() {
        return super.getContent();
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
}
