package com.example.laborator4;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Adidas implements Serializable {
    private String model;
    private int marime;
    private String culoare;
    private double pret;
    private String categorie;
    private String material;
    private boolean inStoc;
    private boolean editieLimitata;
    private int gradConfort;

    public Adidas(String model, int marime, String culoare, double pret, String categorie, String material, boolean inStoc, boolean editieLimitata, int gradConfort) {
        this.model = model;
        this.marime = marime;
        this.culoare = culoare;
        this.pret = pret;
        this.categorie = categorie;
        this.material = material;
        this.inStoc = inStoc;
        this.editieLimitata = editieLimitata;
        this.gradConfort = gradConfort;
    }

    public String getModel() {
        return model;
    }

    public int getMarime() {
        return marime;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getPret() {
        return pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isInStoc() {
        return inStoc;
    }

    public boolean isEditieLimitata() {
        return editieLimitata;
    }

    public int getGradConfort() {
        return gradConfort;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Model: " + model + "\n" +
                "Preț: " + df.format(pret) + " RON\n" +
                "Mărime: " + marime + "\n" +
                "Culoare: " + culoare + "\n" +
                "Categorie: " + categorie + "\n" +
                "Material: " + material + "\n" +
                "Stoc: " + (inStoc ? "Disponibil" : "Indisponibil") + "\n" +
                "Ediție Limitată: " + (editieLimitata ? "Da" : "Nu") + "\n" +
                "Confort: " + gradConfort + "/5";
    }
}