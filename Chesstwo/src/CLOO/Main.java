package CLOO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame {
    private Game game = new Game();
    private JButton[][] grid = new JButton[8][8];
    private boolean play;
    private int width = 800;
    private int height = 800;
    private int rp = 21;
    private int cp = 21;
    private int rs = 21;
    private int cs = 21;
    //Constructor
    public Main() {
        super("Chess");
        setSize(width, height + 22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(8, 8));
        play = true;
        for (int c = 0; c < grid.length; c++) {
            for (int r = 0; r < grid[c].length; r++) {
                grid[c][r] = new JButton();
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
        for (int c = 0; c < grid.length; c++) {
            for (int r = 0; r < grid[c].length; r++) {
                grid[c][r].setSize(w, h);
                grid[c][r].setOpaque(true);
                grid[c][r].setBackground(Color.black);
                grid[c][r].setIcon(new ImageIcon(this.game.getImage(c,r,w,h)));
                int finalR = r;
                int finalC = c;
                grid[c][r].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        boolean action = true;
                        if(cp == 21 && rp == 21){
                            cp = finalC;
                            rp = finalR;
                            System.out.println("chose piece");
                            action = false;
                            grid[cp][rp].setBackground(Color.red);
                        }
                        if(cp != 21 && rp != 21 && action){
                            cs = finalC;
                            rs = finalR;
                            game.changeData(cp,rp,cs,rs);
                            grid[cp][rp].setIcon(new ImageIcon(game.getImage(cp,rp,w,h)));
                            grid[cp][rp].setBackground(Color.black);
                            grid[cs][rs].setIcon(new ImageIcon(game.getImage(cs,rs,w,h)));
                            System.out.println("chose spot");
                            cp = rp = cs = rs = 21;
                            revalidate();
                        }
                    }
                });
                this.getContentPane().add(grid[c][r]);
            }
        }
    }
}

