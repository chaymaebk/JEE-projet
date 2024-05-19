package com.raven.model;

import javax.swing.Icon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

   

    public Model_Card(Icon icon, String title, int values) {
        this.icon = icon;
        this.title = title;
        this.values = values;
       
    }

    public Model_Card() {
    }

    private Icon icon;
    private String title;
    private int values;
   
}
