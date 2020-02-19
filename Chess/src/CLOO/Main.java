package CLOO;

import javax.swing.*;
import java.util.Scanner;

public class Main extends JFrame {
    private Game game = new Game();
    private boolean play;
    private int width;
    private int height;
    //Constructor
    public Main() {
        super("Chess");
        setSize(game.getWIDTH(), game.getHEIGHT() + 22);
        getContentPane().add(game);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        play = true;
    }
    //test
    public static void main(String[] args) {
        Main run = new Main();
        while (run.play) { //game loop
            //resizable frame
            int w = run.getSize().width;
            int h = run.getSize().height;
            if (run.width!=w){
                run.game.setWIDTH(w);
                run.repaint();
                run.width=w;
            }
            if (run.height!=h){
                run.game.setHEIGHT(h-22);
                run.repaint();
                run.height=w;
            }
            run.MakeMove(1);
            run.MakeMove(2);
        }
    }
    public void MakeMove(int player){
     /*
     a2 -) 1,2 -) 8,7  // a = 97, 0 = 48
     {-2,-1,0,0,0,0,1,2},
     {-3,-1,0,0,0,0,1,3},
     {-4,-1,0,0,0,0,1,4},
     {-5,-1,0,0,0,0,1,5},
     {-6,-1,0,0,0,0,1,6},
     {-4,-1,0,0,0,0,1,4},
     {-3,-1,0,0,0,0,1,3},
     {-2,-1,0,0,0,0,1,2}
     */
        Scanner kb = new Scanner(System.in);
        System.out.println("To make a move:" +
                "\nFirst, enter the position of the Chess piece" +
                "\nSecond, enter the desired position");
        String message="";
        if (player==1) { message="Player One's turn"; }
        if (player==2) { message="Play Two's turn"; }
        System.out.println(message);
        System.out.println("Enter spot of Chess piece LetterNumber");
        String pp = kb.nextLine();
        int ppc = pp.charAt(0)-97;
        int ppr = 7-(pp.charAt(1)-49);
        System.out.println("Enter desired spot LetterNumber");
        String ps = kb.nextLine();
        int psc = ps.charAt(0)-97;
        int psr = 7-(ps.charAt(1)-49);
        this.game.changeBackBone(ppc,ppr,psc,psr);
        this.repaint();
    }
    public void GameOver(int player, JFrame p, Main m){
        if (player==1)
        JOptionPane.showMessageDialog(p,"Player One won");
        if (player==2)
        JOptionPane.showMessageDialog(p,"Player Two won");
        String again = JOptionPane.showInputDialog(p, "Play again?");
        if(again.equalsIgnoreCase("n")||again.equalsIgnoreCase("no"))
        m.play=false; System.exit(0);
    }
}
