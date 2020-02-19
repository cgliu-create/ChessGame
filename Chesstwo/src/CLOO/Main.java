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
    }
    //test
    public static void main(String[] args) {
        Main run = new Main();
        while (run.play) { //game loop
            run.checkResizing();

        }
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
                grid[y][x].setIcon(new ImageIcon(this.game.getImage(y,x,w,h)));
                int finalR = x;
                int finalC = y;
                grid[y][x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        boolean action = true;
                        if(yp == 21 && xp == 21){
                            yp = finalC;
                            xp = finalR;
                            System.out.println("chose piece");
                            action = false;
                            grid[yp][xp].setBackground(Color.red);
                            ArrayList<int[]> pmove = game.checkMoves(yp,xp);
                            for (int[] move: pmove) {
                                grid[move[0]][move[1]].setBackground(Color.red);
                            }
                        }
                        if(yp != 21 && xp != 21 && action){
                            ys = finalC;
                            xs = finalR;
                            game.changeData(yp,xp,ys,xs);
                            grid[yp][xp].setIcon(new ImageIcon(game.getImage(yp,xp,w,h)));
                            for (JButton[] jButtons : grid) {
                                for (JButton jButton : jButtons) {
                                    jButton.setBackground(Color.black);
                                }
                            }
                            grid[ys][xs].setIcon(new ImageIcon(game.getImage(ys,xs,w,h)));
                            System.out.println("chose spot");
                            yp = xp = ys = xs = 21;
                            revalidate();
                        }
                    }
                });
                this.getContentPane().add(grid[y][x]);
            }
        }
    }
}

