import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Clock {

    private JFrame j = new JFrame();
    private JPanel p = new JPanel();
    
    private int secs = 0;
    private int hours = 6;
    private int minutes = 50;
    
    private Graphics g = null;
    
    
    public Clock() {
        Date d = new Date();
        secs = d.getSeconds();
        hours = d.getHours();
        minutes = d.getMinutes();
        j.setLayout(null);
        j.setBounds(0,0,1000,200);
        p.setBounds(j.getBounds());
        j.add(p);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        p.setBackground(Color.WHITE);
        
        g = p.getGraphics();
    }
    
    public void show() {
        showTime();
    }
    
    public void showTime() {
        Thread t = new Thread() {
            public void run() {
                try {
                    g.setColor(Color.WHITE);
                    g.fillRect(0,0,1000,200);
                    int x0 = 120;
                    int y0 = 20;

                    int x1 = 420;
                    int y1 = 20;
                    g.setFont(new Font("arial",Font.BOLD,60));
                    g.setColor(Color.WHITE);
                    g.fillRect(x0,y0,200,100);
                    g.setColor(Color.RED);
                    g.drawString(String.valueOf(hours), x0, y0+100);

                    g.setColor(Color.WHITE);
                    g.fillRect(x1,y1,200,100);
                    g.setColor(Color.RED);
                    g.drawString(String.valueOf(minutes), x1, y1+100);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                showSecs();
                showHours();
                showMinutes();
            }
        };
        t.start();
    }
    
    private void showSecs() {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1*1000);//pause one second before iterating.
                } catch(Exception e) {
                    e.printStackTrace();
                }
                
                int y = 115;
                int x = 300;
                int x2 = 600;
                g.setColor(Color.RED);
                g.setFont(new Font("arial",Font.BOLD,60));
                g.drawString(":", x, y);
                g.drawString(":", x2, y);

                Thread t = new Thread() {
                    public void run() {
                        while(true) {
                            try {
                                Thread.sleep(1*1000);//pause one second
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                            int x0 = 720;
                            int y0 = 20;
                            ++ secs;
                            if (secs > 60)
                                ++ minutes;
                            if (secs > 60)
                                secs = 0;

                            Thread t = new Thread() {
                                public void run() {
                                    g.setColor(Color.WHITE);
                                    g.fillRect(x0,y0,200,100);
                                    g.setColor(Color.RED);
                                    g.drawString(String.valueOf(secs), x0, y0+100);
                                }
                            };
                            t.start();
                        }
                    }
                };
                t.start();
            }
        };
        t.start();
    }
    
    private void showHours() {
        Thread t = new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(60*60*1*1000);//pause 1 hour(s&) second before iterating.

                        int y = 115;
                        int x = 300;
                        int x2 = 600;
                        g.setColor(Color.RED);
                        g.setFont(new Font("arial",Font.BOLD,60));
                        g.drawString(":", x, y);
                        g.drawString(":", x2, y);

                        int x0 = 420;
                        int y0 = 20;
                        ++ hours;
                        if (hours > 24)
                            hours = 0;
                        
                        g.setColor(Color.WHITE);
                        g.fillRect(x0,y0,200,100);
                        g.setColor(Color.RED);
                        g.drawString(String.valueOf(hours), x0, y0+100);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
    
    private void showMinutes() {
        Thread t = new Thread() {
            public void run() {
                boolean tri = true;
                while(true) {
                    try {
                        Thread.sleep(1*1000);//pause one second before iterating.

                        int y = 115;
                        int x = 300;
                        int x2 = 600;
                        g.setColor(Color.RED);
                        g.setFont(new Font("arial",Font.BOLD,60));
                        g.drawString(":", x, y);
                        g.drawString(":", x2, y);

                        if (tri) {
                            tri = false;
                            Thread t = new Thread() {
                                public void run() {
                                    while(true) {
                                        try {
                                            Thread.sleep(1*60*1000);//pause one minute
                                        } catch(Exception e) {
                                            e.printStackTrace();
                                        }
                                        int x0 = 420;
                                        int y0 = 20;
                                        ++ minutes;
                                        if (minutes > 60)
                                            ++ hours;
                                        if (minutes > 60)
                                            minutes = 0;

                                        g.setColor(Color.WHITE);
                                        g.fillRect(x0,y0,200,100);
                                        g.setColor(Color.RED);
                                        g.drawString(String.valueOf(minutes), x0, y0+100);
                                    }
                                }
                            };
                            t.start();
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
    

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock().show();
            }
        });
    }
}