/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soumya
 */
public class MazeSolverProject extends JFrame {

    private int [][] maze =
            {
                    {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,1,1,1,1,1,0,0,0,0,0,1},
                    {1,0,0,1,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
             };

    public List<Integer> path = new ArrayList<>(); // stores the traversal of path to reach destination

    public MazeSolverProject(){
        setTitle("Maze Solver");
        setSize(600,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
//        System.out.println(path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(50,50); // translate the graphics to origin as this point

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
//                        color = Color.getHSBColor(30f, 20f, 58.8f);
                        color = Color.GRAY;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.black);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }

        // show labels
        // for path
        g.setColor(Color.GREEN);
        g.fillRect(0, 30 * 11, 30, 30);
        g.drawRect(0, 30 * 11, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString("Path", 33, 30*12); // 33 = 30*1 + 3

        // for destination
        g.setColor(Color.RED);
        g.fillRect(30 * 5, 30 * 11, 30, 30);
        g.drawRect(30 * 5, 30 * 11, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString("Destination", 183, 30*12); // 183 = 30*6 + 3

        // for blockage
//        g.setColor(Color.getHSBColor(30f, 20f, 58.8f));
        g.setColor(Color.gray);
        g.fillRect(30 * 10, 30 * 11, 30, 30);
        g.drawRect(30 * 10, 30 * 11, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString("Blocked", 333, 30*12); // 333 = 30*11 + 3


        for (int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
//            System.out.println("X coordinates" + pathx);
//            System.out.println("Y coordinates" + pathy);
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
        }

    }
    public static void main(String[] args){
        MazeSolverProject view = new MazeSolverProject();
        view.setVisible(true);
    }
    
}
