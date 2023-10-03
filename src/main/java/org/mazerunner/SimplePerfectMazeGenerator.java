package org.mazerunner;

import org.mazerunner.interfaces.MazeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
                Case mazeCase = new Case();

                mazeCase.setId(height * i + j);

                this.maze.add(mazeCase);
            }
        }

        /*this.maze.get(0).open('n');
        this.maze.get(0).open('e');
        this.maze.get(8).open('w');
        this.maze.get(8).open('e');*/
        //System.out.println(this.maze.get(1).getMatrice());

        this.randomMerge();

        //System.out.println(this.maze);
        this.displayMaze();
    }

    public void randomMerge() {
        ArrayList<Case> mazeRandomizedForIteration = new ArrayList<>(this.maze);

        Collections.shuffle(mazeRandomizedForIteration);

        int cellId = 5;

        Case neighbourCellNorth = this.findNeighbourCell(cellId, Direction.NORTH);
        Case neighbourCellSouth = this.findNeighbourCell(cellId, Direction.SOUTH);
        Case neighbourCellEast = this.findNeighbourCell(cellId, Direction.EAST);
        Case neighbourCellWest = this.findNeighbourCell(cellId, Direction.WEST);

        System.out.println("NORTH : " + neighbourCellNorth.getId());
        System.out.println("SOUTH : " + neighbourCellSouth.getId());
        System.out.println("EAST : " + neighbourCellEast.getId());
        System.out.println("WEST : " + neighbourCellWest.getId());

        for (Case randomMazeCell : mazeRandomizedForIteration) {
            int id = randomMazeCell.getId();

            //System.out.println(randomMazeCell.getId());
        }

    }

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public Case findNeighbourCell(int cellId, Direction direction) {

        int x = cellId % this.width; // X axis
        int y = cellId / this.width; // Y axis

        //System.out.println(this.maze.size());
        //System.out.println(this.width);
        System.out.println("cell : " + cellId);
        System.out.println("x : " + x);
        System.out.println("y : " + y);



        switch (direction) {
            case NORTH:
                if (y > 0) {
                    int neighbourId = (y - 1) * this.width + x;

                    return this.maze.get(neighbourId);
                }

                break;

            case SOUTH:
                if (y < this.height - 1) {
                    int neighbourId = (y + 1) * this.width + x;

                    return this.maze.get(neighbourId);
                }

                break;

            case EAST:
                if (x < this.width - 1) {
                    int neighbourId = cellId + 1;

                    return this.maze.get(neighbourId);
                }

                break;

            case WEST:
                if (x > 0) {
                    int neighbourId = cellId - 1;

                    return this.maze.get(neighbourId);
                }

                break;
        }
        // If no neighbour in the chosen direction has been found
        return null;

    }

    @Override
    public void displayMaze() {
       for (Case mazeCase : this.maze) {
           //System.out.println(mazeCase.getMatrice());
           //System.out.println(mazeCase.getId());

            //ArrayList<ArrayList<Character>> matrice = mazeCase.getMatrice();
        }
       //Collections.shuffle(this.maze);

        for (int i = 0; i < this.height; i++) {

            //Create one line to print for each maze cell of the line
            StringBuilder line1 = new StringBuilder();
            StringBuilder line2 = new StringBuilder();
            StringBuilder line3 = new StringBuilder();

            for (int j = 0; j < this.width; j++) {
                // Target correct cell with current iteration to get the current line
                Case mazeCell = this.maze.get(i * this.width + j);

                line1.append(mazeCell.getFirstLineString());
                line2.append(mazeCell.getSecondLineString());
                line3.append(mazeCell.getThirdLineString());
            }

            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }


        /*System.out.println("\u001B[32m⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ ");
        System.out.println("⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ ");
        System.out.println("⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ ");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉");*/

    }
}
