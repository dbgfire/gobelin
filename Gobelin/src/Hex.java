import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class Hex
{
    private static int BORDERS = 260; // Bordures de chaque côté de la grille (centrage)
    private static int s = 0;	// Longueur d'un côté
    private static int t = 0;	// Côté le plus court de chaque triangle extérieur à l'hexagone
    private static int r = 0;	// Rayon du cercle circonscrit à l'hexagone
    private static int h = 0;	// Longueur totale d'un hexagone
    private static double deg = Math.toRadians(30); // Valeur de l'angle d'un triangle rectangle extérieur à l'hexagone
    private static int BSIZE = 27; //Nombres d'hexagone en longueur
    private static int LSIZE = 20;	//Nombres d'hexagone en hauteur
    private static int EMPTY = 0;
    private static int[][] board = new int[BSIZE][BSIZE];
    private static int[][] memories = new int[BSIZE][BSIZE];

    //Fonction pour calculer l'hexagone
    Hex(){
        h = 42;
        r = h / 2;
        s = (int) (r / Math.cos(deg));
        t = (int) (r * Math.tan(deg));
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<LSIZE;j++) {

                board[i][j]=EMPTY;
            }
        }
        board[10][10] = (int)'A';

    }

    //Fonction permettant de tracer un hexagone
    private static Polygon Hexagone(int x0, int y0) {
        int x = x0 + BORDERS; //Décalage horizontale de la grille
        if (s == 0  || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }
        int[] cx,cy;
        cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};
        cy = new int[] {y0, y0, y0 +r, y0 +r+r, y0 +r+r, y0 +r};
        return new Polygon(cx,cy,6);
    }

    //Tracer du texte et de la grille
    static void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        Polygon poly = Hexagone(x,y);
        g2.drawPolygon(poly);
        g2.drawString(""+i+j, x+r-6+BORDERS, y+r+4);
    }

    //contenu de la grille
    static void fillHex(int i, int j, int n,Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;

        if (n < 0) {
            g2.setColor(new Color(255, 24, 42, 247));
            g2.fillPolygon(Hexagone(x+r,y));
            g2.drawString("test", x+r, y);
        }
        if (n > 0) {
           // g2.setColor(new Color(19, 28, 187,200));
            g2.setColor(new Color(0, 0, 0,0));
            g2.fillPolygon(Hexagone(x,y));
            g2.setColor(new Color(80, 0, 65,0));
            g2.drawString(" test1", x+BORDERS+10, y+20);
        }
    }

    //Permet de tracer les points qui forment le contour de l'hexagone
     static Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);

         mx -= BORDERS;
        int x = mx / (s+t); //Permet de tracer les points en X
        int y = (my - (x%2)*r)/h; //Permet de tracer les points en Y
        int dx = mx - x*(s+t);
        int dy = my - y*h;
        if (my - (x%2)*r < 0) return p;
        if (x%2==0) {
            if (dy > r) {
                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {
                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {
            if (dy > h) {
                if (dx * r/t < dy - h) {
                    x--;
                    y++;
                }
            }
            if (dy < h) {
                if ((t - dx)*r/t > dy - r) {
                    x--;
                }
            }
        }
        p.x=x;
        p.y=y;
        return p;
    }

    //Le JPanel
    static class Panneau extends JPanel {
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
        public MyMouseListener ml = new MyMouseListener();
        private int choix=0;
        private BufferedImage test[]=new BufferedImage[10];

        JLabel gobelin_1;
        Icon gobelin_img_1;
        JLabel gobelin_2;
        Icon gobelin_img_2;
        JLabel gobelin_3;
        Icon gobelin_img_3;
        
        Panneau(){
            gobelin_1=new JLabel("");
            gobelin_2=new JLabel("");
            gobelin_3=new JLabel("");
            try {
                image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\map.png"));

                gobelin_img_1 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_2-3-2X6.PNG");
                gobelin_img_2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-1X3.PNG");
                gobelin_img_3 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-2X11.PNG");

                test[1]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_2-3-2X6.PNG"));
                test[2]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-1X3.PNG"));
                test[3]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-2X11.PNG"));

                gobelin3 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_4-2X3.PNG"));
                gobelin4 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-2-2X10.PNG"));
                gobelin5 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-3X16.PNG"));

                cheval = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\ChevalKP_B_4-2.PNG"));
                cheval1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\ChevalRE_A_5-1.PNG"));
                cheval2 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\ChevalRE_B_4-2X2.PNG"));
                
                infantrie = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieA_4-1X3.PNG"));
                infantrie1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_3-2-2X5.PNG"));
                infantrie2 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2-2X2.PNG"));
                infantrie3 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2X2.PNG"));
                infantrie4 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-3-2X3.PNG"));
                infantrie5 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-2-3X2.PNG"));
                infantrie6 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-3-3X2.PNG"));
                infantrie7 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-2-3X2.PNG"));
                infantrie8 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-2X2.PNG"));
                infantrie9 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-3X3.PNG"));
                infantrie10 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-2X2.PNG"));
                infantrie11 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-3X3.PNG"));
                infantrie12 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-3-3X3.PNG"));
                infantrie13 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-1X2.PNG"));
                infantrie14 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-3-1.PNG"));
                infantrie15 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_3-3-1X2.PNG"));
                infantrie16 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-1X2.PNG"));
                infantrie17 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-3-1X2.PNG"));


                leaderhumain = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Baron.PNG"));
                leaderhumain1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Count.PNG"));
                leaderhumain2 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_FrirarSimon.PNG"));
                leaderhumain3 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_JohnGordon.PNG"));
                leaderhumain4 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_RobertKeith.PNG"));
                leaderhumain5 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirGodfrey.PNG"));
                leaderhumain6 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirHubert.PNG"));
                leaderhumain7 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirRandolgh.PNG"));
                leaderhumain8 = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_ThomasBruce.PNG"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            addMouseListener(ml);

            this.setLayout(new BorderLayout());

            gobelin_1.setBounds(2,0,50,50);
            gobelin_1.setIcon(gobelin_img_1);
            gobelin_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay you ");
                    choix=1;

                }

            });
            gobelin_2.setBounds(55,0,50,50);
            gobelin_2.setIcon(gobelin_img_2);
            gobelin_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=2;
                }

            });
            this.add(gobelin_1);
            this.add(gobelin_2);


        }

        //Affichage
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2);
            g2.drawImage(image, 0, 0, (this.getWidth()-30), (this.getHeight()-10), null);
            g2.drawImage(test[choix], ml.x-20, ml.y-20,40, 40, null);
//                    memories[ml.x][ml.y]=choix;
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    drawHex(i,j,g2);
                }
            }
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    fillHex(i,j,board[i][j],g2);
                   // fillHex(i,j,memories[i][j],g2);
                        if(memories[i][j]!=0 &&memories[i][j] != choix )
                    g2.drawImage(test[choix], i* (s+t), j* h + (i%2) * h/2,40, 40, null);
                }
            }

        }
        class MyMouseListener extends MouseAdapter {
            int x=10,y=10;
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                //mPt.x = x;
                //mPt.y = y;
                Point p = new Point(pxtoHex(e.getX(), e.getY()));
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

                //DEBUG: colour in the hex which is supposedly the one clicked on
                //clear the whole screen first.
                for (int i = 0; i < BSIZE; i++) {
                    for (int j = 0; j < BSIZE; j++) {
                        board[i][j] = EMPTY;
                        if (memories[i][j] != choix && memories[i][j]!=0){
                            //board[i][j] = choix;
                            memories[i][j] = choix;
                        }
                    }
                }



                //What do you want to do when a hexagon is clicked?
                board[p.x][p.y] = (int)'X';
                repaint();
            }
        }
    }
}
