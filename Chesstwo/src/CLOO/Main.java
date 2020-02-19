package CLOO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Main extends JFrame {
    private Game game = new Game();
    private JButton[][] grid = new JButton[8][8];
    private boolean play;
    private int width = 800;
    private int height = 800;
    private int xp = 21;
    private int yp = 21;
    private int xs = 21;
    private int ys = 21;
    private ArrayList<Point> pmove = new ArrayList<Point>();
    //Constructor
    public Main() {
        super("Chess");
        setSize(width, height + 22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(8, 8));
        play = true;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                grid[y][x] = new JButton();
            }
        }
        addButtons();
        checkResizing();
    }
    //test
    public static void main(String[] args) {
        Main run = new Main();
    }
    //resize frame
    public void checkResizing() {
        int w = this.getSize().width;
        int h = this.getSize().height;
        if (this.width != w || this.height != h) {
            this.width = w;
            this.height = h;
            this.revalidate();
        }
    }
    public void addButtons(){
        int w = this.getSize().width / 8;
        int h = this.getSize().height / 8;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                grid[y][x].setSize(w, h);
                grid[y][x].setOpaque(true);
                grid[y][x].setBackground(Color.black);
                grid[y][x].setIcon(new ImageIcon(game.getImage(y,x,w,h)));
                int finalX = x;
                int finalY = y;
                grid[y][x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        boolean action = true;
                        if(yp == 21 && xp == 21){
                            yp = finalY;
                            xp = finalX;
                            System.out.println("chose piece");
                            action = false;
                            Color x = Color.red;
                            if(game.getData(yp,xp)<0)
                                x = Color.blue;
                            grid[yp][xp].setBackground(x);
                            pmove = game.checkMoves(yp,xp);
                            for (Point move: pmove) {
                                grid[move.getY()][move.getX()].setBackground(x);
                            }
                        }
                        if(yp != 21 && xp != 21 && action){
                            ys = finalY;
                            xs = finalX;
                            boolean yes = false;
                            for (Point move: pmove) {
                                if(move.getY() == ys && move.getX() == xs)
                                    yes = true;
                            }
                            if(yes) {
                                game.changeData(yp, xp, ys, xs);
                                grid[yp][xp].setIcon(new ImageIcon(game.getImage(yp, xp, w, h)));
                                grid[ys][xs].setIcon(new ImageIcon(game.getImage(ys, xs, w, h)));
                                System.out.println("chose spot");
                            }
                            if(!(yes)){
                                System.out.println("Invalid move");
                            }
                            for (JButton[] jButtons : grid) {
                                for (JButton jButton : jButtons) {
                                    jButton.setBackground(Color.black);
                                }
                            }
                            yp = xp = ys = xs = 21;
                            checkResizing();
                            revalidate();
                        }
                    }
                });
                this.getContentPane().add(grid[y][x]);
            }
        }
    }
}

