package org.mazerunner.interfaces;

import java.util.ArrayList;

public interface MazeGenerator {

    public void generateCase();

    public void generateEntrance();

    public void generateExit();

    public void generate(int width, int height);

    public void displayMaze();
}
