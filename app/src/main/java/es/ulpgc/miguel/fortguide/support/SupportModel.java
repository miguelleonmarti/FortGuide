package es.ulpgc.miguel.fortguide.support;

import java.util.ArrayList;

import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportModel implements SupportContract.Model {

    public static String TAG = SupportModel.class.getSimpleName();

    private ArrayList<SupportItem> supportItems;

    public SupportModel() {
        this.supportItems = new ArrayList<>();
    }


    @Override
    public ArrayList<SupportItem> fetchData() {
        // Log.e(TAG, "fetchData()");
        SupportItem categoryItem1 = new SupportItem(0,"111111111111111111111111111111111");
        SupportItem categoryItem2 = new SupportItem(1,"22222222222222222");
        SupportItem categoryItem3 = new SupportItem(2,"33333333333333333");
        SupportItem categoryItem4 = new SupportItem(3,"444444444444444444444444444444444");
        SupportItem categoryItem5 = new SupportItem(4,"555555555555555555555555555555555");
        SupportItem categoryItem6 = new SupportItem(5,"666666666666666666666666666666666");
        SupportItem categoryItem7 = new SupportItem(6,"77777777777777777");
        SupportItem categoryItem8 = new SupportItem(7,"888888888888888888888888888888888");

        this.supportItems.add(categoryItem1);
        this.supportItems.add(categoryItem2);
        this.supportItems.add(categoryItem3);
        this.supportItems.add(categoryItem4);
        this.supportItems.add(categoryItem5);
        this.supportItems.add(categoryItem6);
        this.supportItems.add(categoryItem7);
        this.supportItems.add(categoryItem8);

        return supportItems;
    }
}
