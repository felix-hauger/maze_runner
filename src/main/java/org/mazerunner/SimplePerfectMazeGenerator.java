package org.mazerunner;

import org.mazerunner.interfaces.MazeGenerator;

import java.util.ArrayList;
import java.util.Collections;

public class SimplePerfectMazeGenerator implements MazeGenerator {
    private ArrayList<Cell> maze = new ArrayList<>();

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
                Cell mazeCell = new Cell();

                mazeCell.setId(height * i + j);

                this.maze.add(mazeCell);
            }
        }


        this.randomMerge();

        this.displayMaze();
    }

    public void randomMerge() {
        ArrayList<Cell> mazeRandomizedForIteration = new ArrayList<>(this.maze);

        int remainingWalls = (this.width - 1) * this.height + (this.height - 1) * this.width;


        System.out.println("murs : " + remainingWalls);

        // To iterate randomly on every maze cell
        Collections.shuffle(mazeRandomizedForIteration);
        int i = 0;

        while (remainingWalls > 0) {

            if (i > this.width * this.height * 100000) break;
            i++;


            int randomMazeCellId = (int) Math.floor(Math.random() * this.maze.size());

            Cell randomMazeCell = this.maze.stream().filter(cell -> cell.getId() == randomMazeCellId).findFirst().orElse(null);


            //int cellId = randomMazeCell.getId();

            //System.out.println(randomMazeCellId);

            if (randomMazeCell != null) {
                // Select a random direction
                Direction direction = Direction.values()[(int) (Math.random() * Direction.values().length)];

                Cell neighbourCell = this.findNeighbourCell(randomMazeCellId, direction);

                if (neighbourCell != null) {
                    System.out.println();

                    System.out.println("Id : " + randomMazeCellId);
                    System.out.println("Direction : " + direction);
                    System.out.println("Neighbour Id : " + neighbourCell.getId());

                    int neighbourCellId = neighbourCell.getId();

                    // Remove wall between cells that have different ids,
                    // which means they are not yet linked to the rest.
                    // Next give them the same id when merging paths.
                    // Must be done until no wall remains
                    if (randomMazeCellId != neighbourCellId) {

                        System.out.println("merged");


                        this.mergeCells(this.maze.get(randomMazeCellId), neighbourCell, direction);

                        for (Cell cell : this.maze) {
                            System.out.println("maze cell id : " + cell.getId() + " ; neighbour cell id : " + neighbourCellId);


                            if (cell.getId() == neighbourCellId) {
                                cell.setId(randomMazeCellId);
                                System.out.println("switch id");
                            }
                            //System.out.println("maze cell id : " + cell.getId());

                        }

                        //neighbourCell.setId(randomMazeCellId);

                        remainingWalls -= 1;

                        //System.out.println("FUSE");
                        this.displayMaze();
                        System.out.println();

                    }
                }
            }


        }



       /* Cell neighbourCellNorth = this.findNeighbourCell(cellId, Direction.NORTH);
        Cell neighbourCellSouth = this.findNeighbourCell(cellId, Direction.SOUTH);
        Cell neighbourCellEast = this.findNeighbourCell(cellId, Direction.EAST);
        Cell neighbourCellWest = this.findNeighbourCell(cellId, Direction.WEST);

        System.out.println("NORTH : " + neighbourCellNorth.getId());
        System.out.println("SOUTH : " + neighbourCellSouth.getId());
        System.out.println("EAST : " + neighbourCellEast.getId());
        System.out.println("WEST : " + neighbourCellWest.getId());*/



    }

    public void mergeCells(Cell cell1, Cell cell2, Direction direction) {
        switch (direction) {
            case NORTH:
                cell1.open('n');
                cell2.open('s');
                break;
            case SOUTH:
                cell1.open('s');
                cell2.open('n');
                break;
            case EAST:
                cell1.open('e');
                cell2.open('w');
                break;
            case WEST:
                cell1.open('w');
                cell2.open('e');
                break;
        }
    }

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public Cell findNeighbourCell(int cellId, Direction direction) {

        int x = cellId % this.width; // X axis
        int y = cellId / this.width; // Y axis

        //System.out.println(this.maze.size());
        //System.out.println(this.width);
//        System.out.println("cell : " + cellId);
//        System.out.println("x : " + x);
//        System.out.println("y : " + y);



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
       for (Cell mazeCell : this.maze) {
           //System.out.println(mazeCell.getMatrice());
           //System.out.println(mazeCell.getId());

            //ArrayList<ArrayList<Character>> matrice = mazeCell.getMatrice();
        }
       //Collections.shuffle(this.maze);

        for (int i = 0; i < this.height; i++) {

            //Create one line to print for each maze cell of the line
            StringBuilder line1 = new StringBuilder();
            StringBuilder line2 = new StringBuilder();
            StringBuilder line3 = new StringBuilder();

            for (int j = 0; j < this.width; j++) {
                // Target correct cell with current iteration to get the current line
                Cell mazeCell = this.maze.get(i * this.width + j);

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
