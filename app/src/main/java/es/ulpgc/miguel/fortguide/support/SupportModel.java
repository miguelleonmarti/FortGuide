package es.ulpgc.miguel.fortguide.support;

import java.util.ArrayList;

import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportModel implements SupportContract.Model {

    public static String TAG = SupportModel.class.getSimpleName();

    private ArrayList<SupportItem> supportItems;

    public SupportModel() {
        this.supportItems = new ArrayList<>();
    }

    String text = "Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba." +
            " Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es " +
            "un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba." +
            " Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba." +
            "Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba.";
    String text1 = "Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba." +
            " Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es " +
            "un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba. Esto es un texto de prueba.";

    @Override
    public ArrayList<SupportItem> fetchData() {
        // Log.e(TAG, "fetchData()");
        SupportItem categoryItem1 = new SupportItem(0,text);
        SupportItem categoryItem2 = new SupportItem(1,text1);
        SupportItem categoryItem3 = new SupportItem(2,text);
        SupportItem categoryItem4 = new SupportItem(3,text1);
        SupportItem categoryItem5 = new SupportItem(4,text);
        SupportItem categoryItem6 = new SupportItem(5,text1);
        SupportItem categoryItem7 = new SupportItem(6,text);
        SupportItem categoryItem8 = new SupportItem(7,text1);

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
