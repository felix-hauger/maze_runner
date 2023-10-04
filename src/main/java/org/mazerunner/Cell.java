package org.mazerunner;

import java.util.ArrayList;

public class Cell {

    private Integer id;

    private ArrayList<ArrayList<Character>> matrice;

    public Cell() {
        this.matrice = new ArrayList<>();

        ArrayList<Character> firstLine = new ArrayList<>();
        ArrayList<Character> secondLine = new ArrayList<>();
        ArrayList<Character> thirdLine = new ArrayList<>();

        firstLine.add('#');
        firstLine.add('#');
        firstLine.add('#');

        secondLine.add('#');
        secondLine.add('.');
        secondLine.add('#');

        thirdLine.add('#');
        thirdLine.add('#');
        thirdLine.add('#');

        this.matrice.add(firstLine);
        this.matrice.add(secondLine);
        this.matrice.add(thirdLine);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ArrayList<Character>> getMatrice() {
        return matrice;
    }

    public void setMatrice(ArrayList<ArrayList<Character>> matrice) {
        this.matrice = matrice;
    }

    public void open(char direction) {
        switch (direction) {
            case 'n':
                this.matrice.get(0).set(1, '.');
                break;

            case 's':
                this.matrice.get(2).set(1, '.');
                break;

            case 'e':
                this.matrice.get(1).set(2, '.');
                break;

            case 'w':
                this.matrice.get(1).set(0, '.');
                break;
        }
    }

    public String getFirstLineString() {
        StringBuilder stringLine = new StringBuilder();

        stringLine.append(this.matrice.get(0).get(0));
        stringLine.append(this.matrice.get(0).get(1));
        stringLine.append(this.matrice.get(0).get(2));

        return stringLine.toString();
    }

    public String getSecondLineString() {
        StringBuilder stringLine = new StringBuilder();

        stringLine.append(this.matrice.get(1).get(0));
        stringLine.append(this.matrice.get(1).get(1));
        //stringLine.append(this.id);
        stringLine.append(this.matrice.get(1).get(2));

        return stringLine.toString();
    }

    public String getThirdLineString() {
        StringBuilder stringLine = new StringBuilder();

        stringLine.append(this.matrice.get(2).get(0));
        stringLine.append(this.matrice.get(2).get(1));
        stringLine.append(this.matrice.get(2).get(2));

        return stringLine.toString();
    }
}
