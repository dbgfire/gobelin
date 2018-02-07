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
            g2.setColor(new Color(255, 0, 7, 193));
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
        public MyMouseListener ml = new MyMouseListener();
        private int choix=0;
        private BufferedImage test[]=new BufferedImage[43];

        ///////Gobelin////////////////////
        JLabel gobelin_1;
        Icon gobelin_img_1;
        JLabel gobelin_2;
        Icon gobelin_img_2;
        JLabel gobelin_3;
        Icon gobelin_img_3;
        JLabel gobelin_4;
        Icon gobelin_img_4;
        JLabel gobelin_5;
        Icon gobelin_img_5;
        JLabel gobelin_6;
        Icon gobelin_img_6;

        ///////LeaderGobelin////////////////////

        JLabel leader_gobelin_1;
        Icon leader_gobelin_img_1;
        JLabel leader_gobelin_2;
        Icon leader_gobelin_img_2;
        JLabel leader_gobelin_3;
        Icon leader_gobelin_img_3;
        JLabel leader_gobelin_4;
        Icon leader_gobelin_img_4;
        JLabel leader_gobelin_5;
        Icon leader_gobelin_img_5;
        JLabel leader_gobelin_6;
        Icon leader_gobelin_img_6;
        JLabel leader_gobelin_7;
        Icon leader_gobelin_img_7;


        //////infanterie///////////
        JLabel infanterie_1;
        Icon infanterie_img_1;
        JLabel infanterie_2;
        Icon infanterie_img_2;
        JLabel infanterie_3;
        Icon infanterie_img_3;
        JLabel infanterie_4;
        Icon infanterie_img_4;
        JLabel infanterie_5;
        Icon infanterie_img_5;
        JLabel infanterie_6;
        Icon infanterie_img_6;
        JLabel infanterie_7;
        Icon infanterie_img_7;
        JLabel infanterie_8;
        Icon infanterie_img_8;
        JLabel infanterie_9;
        Icon infanterie_img_9;
        JLabel infanterie_10;
        Icon infanterie_img_10;
        JLabel infanterie_11;
        Icon infanterie_img_11;
        JLabel infanterie_12;
        Icon infanterie_img_12;
        JLabel infanterie_13;
        Icon infanterie_img_13;
        JLabel infanterie_14;
        Icon infanterie_img_14;
        JLabel infanterie_15;
        Icon infanterie_img_15;
        JLabel infanterie_16;
        Icon infanterie_img_16;
        JLabel infanterie_17;
        Icon infanterie_img_17;
        JLabel infanterie_18;
        Icon infanterie_img_18;

        //////LeaderHumain////////////
        JLabel Leader_Humain_1;
        Icon Leader_Humain_img_1;
        JLabel Leader_Humain_2;
        Icon Leader_Humain_img_2;
        JLabel Leader_Humain_3;
        Icon Leader_Humain_img_3;
        JLabel Leader_Humain_4;
        Icon Leader_Humain_img_4;
        JLabel Leader_Humain_5;
        Icon Leader_Humain_img_5;
        JLabel Leader_Humain_6;
        Icon Leader_Humain_img_6;
        JLabel Leader_Humain_7;
        Icon Leader_Humain_img_7;
        JLabel Leader_Humain_8;
        Icon Leader_Humain_img_8;
        JLabel Leader_Humain_9;
        Icon Leader_Humain_img_9;
        JLabel visible;
        private boolean v=false;

        Panneau(){
            visible=new JLabel("visible");
            gobelin_1=new JLabel("");
            gobelin_2=new JLabel("");
            gobelin_3=new JLabel("");
            gobelin_4=new JLabel("");
            gobelin_5=new JLabel("");
            gobelin_6=new JLabel("");

            /////LeaderGobelin////////////
            leader_gobelin_1=new JLabel("");
            leader_gobelin_2=new JLabel("");
            leader_gobelin_3=new JLabel("");
            leader_gobelin_4=new JLabel("");
            leader_gobelin_5=new JLabel("");
            leader_gobelin_6=new JLabel("");
            leader_gobelin_7=new JLabel("");

            ////infanterie////////////////////

            infanterie_1=new JLabel("");
            infanterie_2=new JLabel("");
            infanterie_3=new JLabel("");
            infanterie_4=new JLabel("");
            infanterie_5=new JLabel("");
            infanterie_6=new JLabel("");
            infanterie_7=new JLabel("");
            infanterie_8=new JLabel("");
            infanterie_9=new JLabel("");
            infanterie_10=new JLabel("");
            infanterie_11=new JLabel("");
            infanterie_12=new JLabel("");
            infanterie_13=new JLabel("");
            infanterie_14=new JLabel("");
            infanterie_15=new JLabel("");
            infanterie_16=new JLabel("");
            infanterie_17=new JLabel("");
            infanterie_18=new JLabel("");

            ////LeaderHumain////////////////////
            Leader_Humain_1=new JLabel("");
            Leader_Humain_2=new JLabel("");
            Leader_Humain_3=new JLabel("");
            Leader_Humain_4=new JLabel("");
            Leader_Humain_5=new JLabel("");
            Leader_Humain_6=new JLabel("");
            Leader_Humain_7=new JLabel("");
            Leader_Humain_8=new JLabel("");
            Leader_Humain_9=new JLabel("");
            try {
                image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\map_3.png"));


                gobelin_img_1 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_2-3-2X6.PNG");
                gobelin_img_2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-1X3.PNG");
                gobelin_img_3 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-2X11.PNG");
                gobelin_img_4 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_4-2X3.PNG");
                gobelin_img_5 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-2-2X10.PNG");
                gobelin_img_6 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-3X16.PNG");

                ////////////LeaderGoblein //////////// //////////// //////////// //////////// //////////// //////////// ////////////
                leader_gobelin_img_1 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_ArgBarg.PNG");
                leader_gobelin_img_2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Grimphar.PNG");
                leader_gobelin_img_3 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Kasbosh.PNG");
                leader_gobelin_img_4 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_King.PNG");
                leader_gobelin_img_5 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Marglush.PNG");
                leader_gobelin_img_6 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Phinioc.PNG");
                leader_gobelin_img_7 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Uglop.PNG");

                //////////////////////////infanterie////////////////////////////////////////////////////////////////////////////////
                infanterie_img_1 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieA_4-1X3.PNG");
                infanterie_img_2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_3-2-2X5.PNG");
                infanterie_img_3 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2-2X2.PNG");
                infanterie_img_4 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2X2.PNG");
                infanterie_img_5 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-3-2X3.PNG");
                infanterie_img_6 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-2-3X2.PNG");
                infanterie_img_7 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-3-3X2.PNG");
                infanterie_img_8 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-2-3X2.PNG");
                infanterie_img_9 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-2X2.PNG");
                infanterie_img_10 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-3X3.PNG");
                infanterie_img_11= new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-2X2.PNG");
                infanterie_img_12 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-3X3.PNG");
                infanterie_img_13 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-3-3X3.PNG");
                infanterie_img_14 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-1X2.PNG");
                infanterie_img_15 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-3-1.PNG");
                infanterie_img_16 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_3-3-1X2.PNG");
                infanterie_img_17 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-1X2.PNG");
                infanterie_img_18 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-3-1X2.PNG");

                //////////////////////LeaderHumain////////////////////////////////////////////////////////////////////////////////////
                Leader_Humain_img_1 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Baron.PNG");
                Leader_Humain_img_2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Count.PNG");
                Leader_Humain_img_3 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_FrirarSimon.PNG");
                Leader_Humain_img_4 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_JohnGordon.PNG");
                Leader_Humain_img_5 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_RobertKeith.PNG");
                Leader_Humain_img_6 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirGodfrey.PNG");
                Leader_Humain_img_7 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirHubert.PNG");
                Leader_Humain_img_8 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirRandolgh.PNG");
                Leader_Humain_img_9 = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_ThomasBruce.PNG");

                test[1]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_2-3-2X6.PNG"));
                test[2]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-1X3.PNG"));
                test[3]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_3-2X11.PNG"));
                test[4]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinB_4-2X3.PNG"));
                test[5]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-2-2X10.PNG"));
                test[6]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\GobelinC_3-3X16.PNG"));

                test[7]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_ArgBarg.PNG"));
                test[8]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Grimphar.PNG"));
                test[9]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Kasbosh.PNG"));
                test[10]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_King.PNG"));
                test[11]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Marglush.PNG"));
                test[12]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Phinioc.PNG"));
                test[13]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderGobelin_Uglop.PNG"));

                test[14]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieA_4-1X3.PNG"));
                test[15]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_3-2-2X5.PNG"));
                test[16]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2-2X2.PNG"));
                test[17]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-2X2.PNG"));
                test[18]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieB_4-3-2X3.PNG"));
                test[19]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-2-3X2.PNG"));
                test[20]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_2-3-3X2.PNG"));
                test[21]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-2-3X2.PNG"));
                test[22]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-2X2.PNG"));
                test[23]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_3-3-3X3.PNG"));
                test[24]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-2X2.PNG"));
                test[25]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-2-3X3.PNG"));
                test[26]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieC_4-3-3X3.PNG"));
                test[27]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-1X2.PNG"));
                test[28]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieKP_A_4-3-1.PNG"));
                test[29]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_3-3-1X2.PNG"));
                test[30]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-1X2.PNG"));
                test[31]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\InfanterieRE_A_4-3-1X2.PNG"));

                test[32]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Baron.PNG"));
                test[33]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_Count.PNG"));
                test[34]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_FrirarSimon.PNG"));
                test[35]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_JohnGordon.PNG"));
                test[36]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_RobertKeith.PNG"));
                test[37]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirGodfrey.PNG"));
                test[38]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirHubert.PNG"));
                test[39]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_SirRandolgh.PNG"));
                test[40]=ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\images\\Pions\\LeaderHumain_ThomasBruce.PNG"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            addMouseListener(ml);

            this.setLayout(new BorderLayout());

            gobelin_1.setBounds(0,0,45,45);
            gobelin_1.setIcon(gobelin_img_1);
            gobelin_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay you ");
                    choix=1;

                }

            });
            gobelin_2.setBounds(50,0,45,45);
            gobelin_2.setIcon(gobelin_img_2);
            gobelin_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=2;
                }

            });
            gobelin_3.setBounds(100,0,45,45);
            gobelin_3.setIcon(gobelin_img_3);
            gobelin_3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=3;
                }

            });

            gobelin_4.setBounds(150,0,45,45);
            gobelin_4.setIcon(gobelin_img_4);
            gobelin_4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=4;
                }

            });
            gobelin_5.setBounds(0,50,45,45);
            gobelin_5.setIcon(gobelin_img_5);
            gobelin_5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=5;
                }

            });
            gobelin_6.setBounds(50,50,45,45);
            gobelin_6.setIcon(gobelin_img_6);
            gobelin_6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=6;
                }

            });



            //////////////LeaderGobelib/////////////////////////////////

            leader_gobelin_1.setBounds(0,150,45,45);
            leader_gobelin_1.setIcon(leader_gobelin_img_1);
            leader_gobelin_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=7;
                }

            });
            leader_gobelin_2.setBounds(50,150,45,45);
            leader_gobelin_2.setIcon(leader_gobelin_img_2);
            leader_gobelin_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=8;
                }

            });

            leader_gobelin_3.setBounds(100,150,45,45);
            leader_gobelin_3.setIcon(leader_gobelin_img_3);
            leader_gobelin_3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=9;
                }

            });
            leader_gobelin_4.setBounds(150,150,45,45);
            leader_gobelin_4.setIcon(leader_gobelin_img_4);
            leader_gobelin_4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=10;
                }

            });
            leader_gobelin_5.setBounds(0,200,45,45);
            leader_gobelin_5.setIcon(leader_gobelin_img_5);
            leader_gobelin_5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=11;
                }

            });

            leader_gobelin_6.setBounds(50,200,45,45);
            leader_gobelin_6.setIcon(leader_gobelin_img_6);
            leader_gobelin_6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=12;
                }

            });
            leader_gobelin_7.setBounds(100,200,45,45);
            leader_gobelin_7.setIcon(leader_gobelin_img_7);
            leader_gobelin_7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=13;
                }

            });

            ///////infanterie////////////////////
            infanterie_1.setBounds(0,300,45,45);
            infanterie_1.setIcon(infanterie_img_1);
            infanterie_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=14;
                }

            });

            infanterie_2.setBounds(50,300,45,45);
            infanterie_2.setIcon(infanterie_img_2);
            infanterie_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("TEST");

                    choix=15;
                }

            });
            infanterie_3.setBounds(100,300,45,45);
            infanterie_3.setIcon(infanterie_img_3);
            infanterie_3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=16;
                }

            });
            infanterie_4.setBounds(150,300,45,45);
            infanterie_4.setIcon(infanterie_img_4);
            infanterie_4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=17;
                }

            });
            infanterie_5.setBounds(0,350,45,45);
            infanterie_5.setIcon(infanterie_img_5);
            infanterie_5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=18;
                }

            });

            infanterie_6.setBounds(50,350,45,45);
            infanterie_6.setIcon(infanterie_img_6);
            infanterie_6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("test");

                    choix=19;
                }

            });
            infanterie_7.setBounds(100,350,45,45);
            infanterie_7.setIcon(infanterie_img_7);
            infanterie_7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=20;
                }

            });
            infanterie_8.setBounds(150,350,45,45);
            infanterie_8.setIcon(infanterie_img_8);
            infanterie_8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=21;
                }

            });
            infanterie_9.setBounds(0,400,45,45);
            infanterie_9.setIcon(infanterie_img_9);
            infanterie_9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=22;
                }

            });
            infanterie_10.setBounds(50,400,45,45);
            infanterie_10.setIcon(infanterie_img_10);
            infanterie_10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=23;
                }

            });
            infanterie_11.setBounds(100,400,45,45);
            infanterie_11.setIcon(infanterie_img_11);
            infanterie_11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=24;
                }

            });
            infanterie_12.setBounds(150,400,45,45);
            infanterie_12.setIcon(infanterie_img_12);
            infanterie_12.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=25;
                }

            });
            infanterie_13.setBounds(0,450,45,45);
            infanterie_13.setIcon(infanterie_img_13);
            infanterie_13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=26;
                }

            });
            infanterie_14.setBounds(50,450,45,45);
            infanterie_14.setIcon(infanterie_img_14);
            infanterie_14.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=27;
                }

            });
            infanterie_15.setBounds(100,450,45,45);
            infanterie_15.setIcon(infanterie_img_15);
            infanterie_15.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=28;
                }

            });
            infanterie_16.setBounds(150,450,45,45);
            infanterie_16.setIcon(infanterie_img_16);
            infanterie_16.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=29;
                }

            });
            infanterie_17.setBounds(0,500,45,45);
            infanterie_17.setIcon(infanterie_img_17);
            infanterie_17.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=30;
                }

            });
            infanterie_18.setBounds(50,500,45,45);
            infanterie_18.setIcon(infanterie_img_18);
            infanterie_18.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=31;
                }

            });
///////////////////LeaderHumain//////////////////////////////////////////////
            Leader_Humain_1.setBounds(0,600,45,45);
            Leader_Humain_1.setIcon(Leader_Humain_img_1);
            Leader_Humain_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=32;
                }

            });
            Leader_Humain_2.setBounds(50,600,45,45);
            Leader_Humain_2.setIcon(Leader_Humain_img_2);
            Leader_Humain_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=33;
                }

            });
            Leader_Humain_3.setBounds(100,600,45,45);
            Leader_Humain_3.setIcon(Leader_Humain_img_3);
            Leader_Humain_3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=34;
                }

            });
            Leader_Humain_4.setBounds(150,600,45,45);
            Leader_Humain_4.setIcon(Leader_Humain_img_4);
            Leader_Humain_4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=35;
                }

            });
            Leader_Humain_5.setBounds(0,650,45,45);
            Leader_Humain_5.setIcon(Leader_Humain_img_5);
            Leader_Humain_5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=36;
                }

            });
            Leader_Humain_6.setBounds(50,650,45,45);
            Leader_Humain_6.setIcon(Leader_Humain_img_6);
            Leader_Humain_6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=37;
                }

            });
            Leader_Humain_7.setBounds(100,650,45,45);
            Leader_Humain_7.setIcon(Leader_Humain_img_7);
            Leader_Humain_7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=38;
                }

            });
            Leader_Humain_8.setBounds(150,650,45,45);
            Leader_Humain_8.setIcon(Leader_Humain_img_8);
            Leader_Humain_8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=39;
                }

            });
            Leader_Humain_9.setBounds(0,700,45,45);
            Leader_Humain_9.setIcon(Leader_Humain_img_9);
            Leader_Humain_9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay");

                    choix=40;
                }

            });


            visible.setBounds(150,700,45,45);
            visible.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("visible");
                    if(v == true){
                    v=false;}else
                    {
                        v=true;
                    }
                }

            });



            this.add(gobelin_1);
            this.add(gobelin_2);
            this.add(gobelin_3);
            this.add(gobelin_4);
            this.add(gobelin_5);
            this.add(gobelin_6);

            this.add(leader_gobelin_1);
            this.add(leader_gobelin_2);
            this.add(leader_gobelin_3);
            this.add(leader_gobelin_4);
            this.add(leader_gobelin_5);
            this.add(leader_gobelin_6);
            this.add(leader_gobelin_7);

            this.add(Leader_Humain_1);
            this.add(Leader_Humain_2);
            this.add(Leader_Humain_3);
            this.add(Leader_Humain_4);
            this.add(Leader_Humain_5);
            this.add(Leader_Humain_6);
            this.add(Leader_Humain_7);
            this.add(Leader_Humain_8);
            this.add(Leader_Humain_9);

            this.add(infanterie_1);
            this.add(infanterie_2);
            this.add(infanterie_3);
            this.add(infanterie_4);
            this.add(infanterie_5);
            this.add(infanterie_6);
            this.add(infanterie_7);
            this.add(infanterie_8);
            this.add(infanterie_9);
            this.add(infanterie_10);
            this.add(infanterie_11);
            this.add(infanterie_12);
            this.add(infanterie_13);
            this.add(infanterie_14);
            this.add(infanterie_15);
            this.add(infanterie_16);
            this.add(infanterie_17);
            this.add(infanterie_18);

            this.add(visible);



        }

        //Affichage
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2);
            g2.drawImage(image, BORDERS-3, 0, 989/*(this.getWidth()-30)*/, 745/*(this.getHeight()-10)*/, null);
            g2.drawImage(test[choix], ml.x-20, ml.y-20,45, 45, null);
//                    memories[ml.x][ml.y]=choix;
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    drawHex(i,j,g2);
                }
            }
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    if(v==true){
                    fillHex(i-1,j,board[i][j],g2);
                    //fillHex(i+1,j+1,board[i][j],g2);
                    fillHex(i+1,j,board[i][j],g2);
                    fillHex(i,j+1,board[i][j],g2);
                    fillHex(i,j-1,board[i][j],g2);
                    fillHex(i+1,j-1,board[i][j],g2);
                    fillHex(i-1,j-1,board[i][j],g2);}
                    //fillHex(i,j,board[i][j],g2);
                   // fillHex(i,j,memories[i][j],g2);
                        //if(memories[i][j]!=0 &&memories[i][j] != choix )
                   //g2.drawImage(test[choix], i* (s+t), j* h + (i%2) * h/2,45, 45, null);
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
