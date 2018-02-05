import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class hex
{
    public static int BORDERS=50;
    public static int s=0;	// length of one side
    public static int t=0;	// short side of 30o triangle outside of each hex
    public static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    public static int h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
    static int EMPTY = 0;
    static int BSIZE = 26; //board size.
    static int HEXSIZE = 20;	//hex size in pixels
    //int BORDERS = 15;
    static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).

    static int[][] board = new int[BSIZE][BSIZE];
    hex(){
        h = 40;			// h = basic dimension: height (distance between two adj centresr aka size)
        r = h/2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                board[i][j]=EMPTY;
            }
        }
        board[1][0] = (int)'A';
    }



    public static Polygon hex (int x0, int y0) {

        int y = y0 ;//+ BORDERS;
        int x = x0 ;//+ BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true.
        // NO! Done below in cx= section
        if (s == 0  || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx,cy;
        cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point
        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Polygon(cx,cy,6);
    }

    public static void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        Polygon poly = hex(x,y);
        g2.drawPolygon(poly);
        g2.drawString(""+i+j, x+r, y+r+4);
    }


    public static void fillHex(int i, int j, int n, Graphics2D g2) {

        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        if (n < 0) {
            g2.setColor(new Color(0, 0, 0,0));
            g2.fillPolygon(hex(x,y));
            g2.drawString("test", x+r, y+r+4);
        }
        if (n > 0) {
            g2.setColor(new Color(19, 28, 187,200));
            g2.setColor(new Color(0, 0, 0,0));
            g2.fillPolygon(hex(x,y));
            g2.setColor(new Color(80, 0, 65,200));
            g2.drawString(" test1", x+r, y+4);
        }
    }
    public static Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);
        //mx -= BORDERS;
       // my -= BORDERS;
       // mx += t;

        int x = (int) (mx / (s+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        int y = (int) ((my - (x%2)*r)/h); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column

        /******FIX for clicking in the triangle spaces (on the left side only)*******/
        //dx,dy are the number of pixels from the hex boundary. (ie. relative to the hex clicked in)
        int dx = mx - x*(s+t);
        int dy = my - y*h;

        if (my - (x%2)*r < 0) return p; // prevent clicking in the open halfhexes at the top of the screen

        //System.out.println("dx=" + dx + " dy=" + dy + "  > " + dx*r/t + " <");

        //even columns
        if (x%2==0) {
            if (dy > r) {	//bottom half of hexes
                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {	//top half of hexes
                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  // odd columns
            if (dy > h) {	//bottom half of hexes
                if (dx * r/t < dy - h) {
                    x--;
                    y++;
                }
            }
            if (dy < h) {	//top half of hexes
                //System.out.println("" + (t- dx)*r/t +  " " + (dy - r));
                if ((t - dx)*r/t > dy - r) {
                    x--;
                }
            }
        }
        p.x=x;
        p.y=y;
        return p;
    }



    public static Point compare(int mx, int my) {
        Point p = new Point(-1,-1);
        int x = (int) (mx / (s+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        int y = (int) ((my - (x%2)*r)/h); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column

        /******FIX for clicking in the triangle spaces (on the left side only)*******/
        //dx,dy are the number of pixels from the hex boundary. (ie. relative to the hex clicked in)
        int dx = mx - x*(s+t);
        int dy = my - y*h;

        if (my - (x%2)*r < 0) return p; // prevent clicking in the open halfhexes at the top of the screen
        //even columns
        if (x%2==0) {
            if (dy > r) {	//bottom half of hexes
                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {	//top half of hexes
                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  // odd columns
            if (dy > h) {	//bottom half of hexes
                if (dx * r/t < dy - h) {
                    x--;
                    y++;
                }
            }
            if (dy < h) {	//top half of hexes
                //System.out.println("" + (t- dx)*r/t +  " " + (dy - r));
                if ((t - dx)*r/t > dy - r) {
                    x--;
                }
            }
        }
        p.x=x;
        p.y=y;
        return p;
    }


    static class Panneau extends JPanel
    {
        private BufferedImage image;
        private BufferedImage gobelin;
        private BufferedImage gobelin1;
        private BufferedImage gobelin2;
        private BufferedImage gobelin3;
        private BufferedImage gobelin4;
        private BufferedImage gobelin5;

        private BufferedImage leadeargob1;
        private BufferedImage leadeargob2;
        private BufferedImage leadeargob3;
        private BufferedImage leadeargob4;
        private BufferedImage leadeargob5;
        private BufferedImage leadeargob6;
        private BufferedImage leadeargob7;

        private BufferedImage cheval;
        private BufferedImage cheval1;
        private BufferedImage cheval2;

        private BufferedImage infantrie;
        private BufferedImage infantrie1;
        private BufferedImage infantrie2;
        private BufferedImage infantrie3;
        private BufferedImage infantrie4;
        private BufferedImage infantrie5;
        private BufferedImage infantrie6;
        private BufferedImage infantrie7;
        private BufferedImage infantrie8;
        private BufferedImage infantrie9;
        private BufferedImage infantrie10;
        private BufferedImage infantrie11;
        private BufferedImage infantrie12;
        private BufferedImage infantrie13;
        private BufferedImage infantrie14;
        private BufferedImage infantrie15;
        private BufferedImage infantrie16;
        private BufferedImage infantrie17;

        private BufferedImage leaderhumain;
        private BufferedImage leaderhumain1;
        private BufferedImage leaderhumain2;
        private BufferedImage leaderhumain3;
        private BufferedImage leaderhumain4;
        private BufferedImage leaderhumain5;
        private BufferedImage leaderhumain6;
        private BufferedImage leaderhumain7;
        private BufferedImage leaderhumain8;







        Panneau(){
            try {

                image = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\Gobelin\\src\\images\\map2.png"));

                gobelin = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinB_2-3-2X6.PNG"));
                gobelin1 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinB_3-1X3.PNG"));
                gobelin2 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinB_3-2X11.PNG"));
                gobelin3 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinB_4-2X3.PNG"));
                gobelin4 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinC_3-2-2X10.PNG"));
                gobelin5 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\GobelinC_3-3X16.PNG"));

                leadeargob1 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_ArgBarg.PNG"));
                leadeargob2 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_Grimphar.PNG"));
                leadeargob3 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_Kasbosh.PNG"));
                leadeargob4 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_King.PNG"));
                leadeargob5 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_Marglush.PNG"));
                leadeargob6 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_Phinioc.PNG"));
                leadeargob7 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderGobelin_Uglop.PNG"));

                cheval = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\ChevalKP_B_4-2.PNG"));
                cheval1 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\ChevalRE_A_5-1.PNG"));
                cheval2 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\ChevalRE_B_4-2X2.PNG"));


                infantrie = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieA_4-1X3.PNG"));
                infantrie1 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieB_3-2-2X5.PNG"));
                infantrie2 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieB_4-2-2X2.PNG"));
                infantrie3 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieB_4-2X2.PNG"));
                infantrie4 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieB_4-3-2X3.PNG"));
                infantrie5 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_2-2-3X2.PNG"));
                infantrie6 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_2-3-3X2.PNG"));
                infantrie7 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_3-2-3X2.PNG"));
                infantrie8 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_3-3-2X2.PNG"));
                infantrie9 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_3-3-3X3.PNG"));
                infantrie10 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_4-2-2X2.PNG"));
                infantrie11 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_4-2-3X3.PNG"));
                infantrie12 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieC_4-3-3X3.PNG"));
                infantrie13 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieKP_A_4-1X2.PNG"));
                infantrie14 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieKP_A_4-3-1.PNG"));
                infantrie15 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieRE_A_3-3-1X2.PNG"));
                infantrie16 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieRE_A_4-1X2.PNG"));
                infantrie17 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\InfanterieRE_A_4-3-1X2.PNG"));


                leaderhumain = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_Baron.PNG"));
                leaderhumain1 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_Count.PNG"));
                leaderhumain2 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_FrirarSimon.PNG"));
                leaderhumain3 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_JohnGordon.PNG"));
                leaderhumain4 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_RobertKeith.PNG"));
                leaderhumain5 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_SirGodfrey.PNG"));
                leaderhumain6 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_SirHubert.PNG"));
                leaderhumain7 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_SirRandolgh.PNG"));
                leaderhumain8 = ImageIO.read(new File("C:\\Users\\admin1\\Desktop\\cours b3\\java\\projet java\\gobelin\\image\\Pions\\LeaderHumain_ThomasBruce.PNG"));



            } catch (IOException e) {
                e.printStackTrace();
            }
            MyMouseListener ml = new MyMouseListener();
            addMouseListener(ml);
        }

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2);
            g2.drawImage(image, 0, 0, null);


            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    drawHex(i,j,g2);
                }
            }

            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    fillHex(i,j,board[i][j],g2);
                }
            }

            //////////PIONS/////////////////////////////////////////////////////////

            //////////////////Gobelin/////////////////////////
            g2.drawImage(gobelin, 1000, 0,40, 40, null);
            g2.drawImage(gobelin1, 1050, 0,40, 40, null);
            g2.drawImage(gobelin2, 1100, 0,40, 40, null);
            g2.drawImage(gobelin3, 1150, 0,40, 40, null);
            g2.drawImage(gobelin4, 1200, 0,40, 40, null);
            g2.drawImage(gobelin5, 1250, 0, 40, 40,null);

            ///LeaderGobelin///////////////////////////////////////
            g2.drawImage(leadeargob1, 1000, 50,40, 40, null);
            g2.drawImage(leadeargob2, 1050, 50,40, 40, null);
            g2.drawImage(leadeargob3, 1100, 50,40, 40, null);
            g2.drawImage(leadeargob4, 1150, 50,40, 40, null);
            g2.drawImage(leadeargob5, 1200, 50,40, 40, null);
            g2.drawImage(leadeargob6, 1250, 50,40, 40, null);
            g2.drawImage(leadeargob7, 1300, 50,40, 40, null);

            ///////ChevalRe///////////////////////////////////////
            g2.drawImage(cheval, 1000, 150,40, 40, null);
            g2.drawImage(cheval1, 1050, 150,40, 40, null);
            g2.drawImage(cheval2, 1100, 150, 40, 40,null);

            ////////////infanterie/////////////////////////////
            g2.drawImage(infantrie, 1000, 200,40, 40, null);
            g2.drawImage(infantrie1, 1050, 200,40, 40, null);
            g2.drawImage(infantrie2, 1100, 200,40, 40, null);
            g2.drawImage(infantrie3, 1150, 200,40, 40, null);
            g2.drawImage(infantrie4, 1200, 200,40, 40, null);
            g2.drawImage(infantrie5, 1250, 200,40, 40, null);
            g2.drawImage(infantrie6, 1300, 200,40, 40, null);
            g2.drawImage(infantrie7, 1000, 250,40, 40, null);
            g2.drawImage(infantrie8, 1050, 250,40, 40, null);
            g2.drawImage(infantrie9, 1100, 250,40, 40, null);
            g2.drawImage(infantrie10, 1150, 250,40, 40, null);
            g2.drawImage(infantrie11, 1200, 250,40, 40, null);
            g2.drawImage(infantrie12, 1250, 250,40, 40, null);
            g2.drawImage(infantrie13, 1300, 250,40, 40, null);
            g2.drawImage(infantrie14, 1000, 300,40, 40, null);
            g2.drawImage(infantrie15, 1050, 300,40, 40, null);
            g2.drawImage(infantrie16, 1100, 300,40, 40, null);
            g2.drawImage(infantrie17, 1150, 300,40, 40, null);

            /////////////leaderHumain/////////////////////////////////
            g2.drawImage(leaderhumain, 1000, 350,40, 40, null);
            g2.drawImage(leaderhumain1, 1050, 350,40, 40, null);
            g2.drawImage(leaderhumain2, 1100, 350,40, 40, null);
            g2.drawImage(leaderhumain3, 1150, 350,40, 40, null);
            g2.drawImage(leaderhumain4, 1200,350 ,40, 40, null);
            g2.drawImage(leaderhumain5, 1250, 350,40, 40, null);
            g2.drawImage(leaderhumain6, 1300, 350,40, 40, null);
            g2.drawImage(leaderhumain7, 1000, 400,40, 40, null);
            g2.drawImage(leaderhumain8, 1050, 400,40, 40, null);
        }
        class MyMouseListener extends MouseAdapter {	//inner class inside DrawingPanel
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //mPt.x = x;
                //mPt.y = y;
                Point p = new Point(pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

                //DEBUG: colour in the hex which is supposedly the one clicked on
                //clear the whole screen first.
				/* for (int i=0;i<BSIZE;i++) {
					for (int j=0;j<BSIZE;j++) {
						board[i][j]=EMPTY;
					}
				} */

                //What do you want to do when a hexagon is clicked?
                board[p.x][p.y] = (int)'X';
                repaint();
            }
        } //end of MyMouseListener class
    }



}
