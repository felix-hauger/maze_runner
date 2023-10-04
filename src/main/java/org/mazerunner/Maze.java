package org.mazerunner;

import org.mazerunner.interfaces.MazeGenerator;

public class Maze {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MazeGenerator maze = new SimplePerfectMazeGenerator(9, 9);

        maze.generate();


    }
}