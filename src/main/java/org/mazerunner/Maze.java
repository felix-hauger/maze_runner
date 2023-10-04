package org.mazerunner;

import org.mazerunner.interfaces.MazeGenerator;

public class Maze {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("coucou");

        System.out.println(args[2]);
        System.out.println(args[3]);


        try {
            // checking valid integer using parseInt() method
            int width = Integer.parseInt(args[1]);
            int height = Integer.parseInt(args[0]);


            if (height < 5 || width < 5) {
                System.out.println("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5");
                System.out.println("Utilisation : java -jar MazeGenerator [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");
            } else {
                if (args[2].equals("perfect") && args[3].equals("simple")) {
                    MazeGenerator maze = new SimplePerfectMazeGenerator(width, height);

                    maze.generate();
                } else {
                    System.out.println("Sorry, not yet implemented");
                    System.out.println("Utilisation : java -jar MazeGenerator [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");


                    System.out.println("\u001B[32m⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ");
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
                    System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉");

                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5");
        }








    }
}