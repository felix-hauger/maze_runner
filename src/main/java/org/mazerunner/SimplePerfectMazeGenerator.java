package org.mazerunner;

import org.mazerunner.interfaces.MazeGenerator;

import java.util.ArrayList;

public class SimplePerfectMazeGenerator implements MazeGenerator {
    private ArrayList<Case> maze = new ArrayList<>();

    private Integer width;

    private Integer height;

    public SimplePerfectMazeGenerator(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void generateCase() {

    }

    @Override
    public void generateEntrance() {

    }

    @Override
    public void generateExit() {

    }

    public void openCase(String direction) {

    }

    @Override
    public void generate() {
        for (int i = 0; i < this.width; i++) {

            for (int j = 0; j < this.height; j++) {
                //this.maze.add(-1);
                //ArrayList<String> caseLine = new ArrayList<>();

                Case mazeCase = new Case();

                this.maze.add(mazeCase);


            }
        }
        System.out.println(this.maze);
        this.displayMaze();
    }

    @Override
    public void displayMaze() {
       // Integer lineLength = this.width;

       /* for (int i = 0; i < this.height; i++) {
            for (int j= 0; j < this.width; i++) {


            }
        }*/


       for (Case mazeCase : this.maze) {


            System.out.println(mazeCase.getMatrice());

            //ArrayList<ArrayList<Character>> matrice = mazeCase.getMatrice();

        }

        for (int i = 0; i < this.height; i++) {
            Case mazeCell = this.maze.get(i);

            /*System.out.println("hmm");
            System.out.println(mazeCell);*/

            StringBuilder line1 = new StringBuilder();
            StringBuilder line2 = new StringBuilder();
            StringBuilder line3 = new StringBuilder();

            for (int j = 0; j < this.width; j++) {
                line1.append(mazeCell.getFirstLineString());
                line2.append(mazeCell.getSecondLineString());
                line3.append(mazeCell.getThirdLineString());
            }

            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }

    }
}
