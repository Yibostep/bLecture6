package enshu6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.ArrayList;

class OthelloPanel extends JPanel {
    private double cx=0, cy=0;
    ArrayList<Integer> array_a = new ArrayList<Integer>();
    ArrayList<Integer> array_b = new ArrayList<Integer>();
    
    public OthelloPanel() {
        super();
        this.setPreferredSize(new Dimension(550, 550)); 
        this.addMouseListener(new MouseListener() {

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) { 
        Point mp = e.getPoint();
        Rectangle r = getBounds();
        System.out.println("mp=" + mp);
        System.out.println("r=" + r);
        if (r.width != 0 && r.height != 0) { 
            cx = (double) mp.x / (double) r.width; 
            cy = (double) mp.y / (double) r.height;
            System.out.printf("(cx,cy)=(%.2f,%.2f)", cx, cy);
                    repaint(); 
            }
        }
        public void mouseReleased(MouseEvent e) {}
        });
    }
    
    public void paint(Graphics g){
        
        System.out.println("Lets Paint!");
        Rectangle r = this.getBounds();
        g.setColor(Color.green);
        g.fillRect(r.x, r.y, r.width, r.height);
        
        g.setColor(Color.black);
        for(int i = 0; i <= 10; i++)
                g.drawLine(25, 25+50*i, 525, 25+50*i);
        for(int i = 0; i <= 10; i++)
                g.drawLine(25+50*i, 25, 25+50*i, 525);
        
        g.setColor(Color.black);
        int x = (int) (r.width * cx);
        int y = (int) (r.height * cy);
        //System.out.println("-------x="+(x-25)+" y="+(y-25));
        double a = Math.floor(((x-25)/50));
        double b = Math.floor(((y-25)/50));
        //System.out.println("-------a="+a+" b="+b);
        
        g.fillOval( (int)((a*50)+25), (int)((b*50)+25), 50, 50);
        
        array_a.add((int)((a*50)+25));
        array_b.add((int)((b*50)+25));
        
        for (int i = 0; i < array_a.size(); i++) {
            System.out.println(array_a.get(i));
            System.out.println(array_b.get(i));
            g.fillOval( array_a.get(i), array_b.get(i), 50, 50);
            }
        }
    }    
    
    

