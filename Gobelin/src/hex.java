import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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
        //g2.setColor(hexgame.COLOURCELL);
        //g2.fillPolygon(hexmech.hex(x,y));
        //g2.fillPolygon(poly);
        //g2.setColor(hexgame.COLOURGRID);
        g2.drawPolygon(poly);
        g2.drawString(""+i+j, x+r, y+r+4);
    }

    /***************************************************************************
     * Name: fillHex()
     * Parameters: (i,j) : the x,y coordinates of the initial point of the hexagon
     n   : an integer number to indicate a letter to draw in the hex
     g2  : the graphics context to draw on
     * Return: void
     * Called from:
     * Calls: hex()
     *Purpose: This draws a filled in polygon based on the coordinates of the hexagon.
     The colour depends on whether n is negative or positive.
     The colour is set by hexgame.COLOURONE and hexgame.COLOURTWO.
     The value of n is converted to letter and drawn in the hexagon.
     *****************************************************************************/
    public static void fillHex(int i, int j, int n, Graphics2D g2) {

        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        if (n < 0) {
            g2.setColor(new Color(255, 24, 42,200));
            g2.fillPolygon(hex(x,y));
            g2.drawString("test", x+r, y+r+4);
        }
        if (n > 0) {
            g2.setColor(new Color(19, 28, 187,200));
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
        Panneau(){
            try {
                //String path=new File("").getAbsolutePath();
                //File toto=new File(path+"\\images/map2.png");
                //image = ImageIO.read(new File(System.getProperty("user.dir")+"/images/map2.png"));
                image = ImageIO.read(new File("D:\\projet\\gobelin\\Gobelin\\src\\images\\map2.png"));

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
