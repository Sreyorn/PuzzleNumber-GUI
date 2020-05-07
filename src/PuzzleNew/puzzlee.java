package PuzzleNew;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class puzzlee extends JFrame{
    private static final long serialVersionUID = 1L;
    int idx=15;

    puzzlee(){
        ArrayList<Integer> temp=new ArrayList<>();
        int[] arr=new int[15];

        do{
            for(int i=0;i<16;i++){
                int rand=(int)((Math.random()*15)+1);
                if(!temp.contains(rand)) {
                    temp.add(rand);
                }
            }

        }while(temp.size()<15);

        System.out.println();
        for(int k=0;k<15;k++) {
            arr[k]=temp.get(k);
        }
//        Arrays.sort(arr);
        setLayout(new GridLayout(4,4));
        JButton j[] = new JButton[16];
        for (int i=0;i<16;i++) {
            if(i==15)
                j[i] = new JButton("");
            else
                j[i] = new JButton(""+arr[i]);
            j[i].addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    // TODO Auto-generated method stub
                    int key = e.getKeyCode();
                    if (key == 39) {//left
                        if (idx == 0 || idx == 4 || idx == 8 || idx == 12) {
                            System.out.println("");
                        } else {
                            String target = j[idx - 1].getText();
                            j[idx].setText(target);
                            j[idx - 1].setText(" ");
                            idx = idx - 1;
                        }
                    }
                    else if (key == 40) {//down
                        if (idx == 0 || idx == 1 || idx == 2 || idx == 3) {
                            System.out.println("");
                        } else {
                            int curDown = idx - 4;
                            String target = j[idx - 4].getText();
                            j[curDown + 4].setText(target);
                            j[idx - 4].setText("");
                            idx = curDown;
                        }
                    }
                    else if (key == 37) {//left
                        if (idx == 15 || idx == 11 || idx == 7 || idx == 3) {
                            System.out.println("");
                        } else {
                            String target = j[idx + 1].getText();
                            j[idx].setText(target);
                            j[idx + 1].setText("");
                            idx = idx + 1;
                        }
                    }
                    else if (key == 38) {//up
                        if (idx == 12 || idx == 13 || idx == 14 || idx == 15) {
                            System.out.println("");
                        } else {
                            String target = j[idx + 4].getText();
                            j[idx].setText(target);
                            j[idx + 4].setText("");
                            idx = idx + 4;
                        }
                    }
                    else if (key == 27) {
                        System.exit(0);
                    }
                    for(int c=0;c<=15;c++){
                        System.out.print(j[c].getText()+ " ");
                    }
                    System.out.println();
                    boolean winning=false;
                    int c=0;
                    int cc=1;
                    int countTrue=0;
                    int[] compare= new int[15];
                    for(int i=0;i<15;i++)
                        compare[i]=(i+1);
                    for(int m=0;m<15;m++){
                        if(isMatched(j[m].getText(),Integer.toString(compare[m]))) {
                            winning = true;
                            countTrue++;
                        }
                        else
                            break;
                        if(countTrue==15){
                            countTrue++;
                            System.out.println("Winnnnnnn");
                            JOptionPane.showMessageDialog(null,"Congratulations!! YOU WIN!!");
                            System.exit(0);
                        }
                    }
                }
            });


            add(j[i]);

        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,420);
        setVisible(true);


    }
    public boolean isMatched(String num,String c){
        if(num.equals(c))

            return true;
        else
            return false;
    }
    public static void main(String[] args) throws IOException {

        puzzlee p =new puzzlee();
        int i = (int) ((Math.random())*25);
        System.out.println(i);

    }
}
