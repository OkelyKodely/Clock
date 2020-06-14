import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;


public class Clock {

    private JFrame j = new JFrame();

    private JPanel p = new JPanel();

    private int hours=0, minutes=0, secs= 0;
    private JavaBean jb = new JavaBean(hours, minutes, secs);

    private Graphics g;
    private JComboBox c = new JComboBox(
            new Object[]{

                "Asia/Seoul",
                "America/Los_Angeles",
                "Etc/GMT+12",
                "Etc/GMT+11",
                "MIT",
                "Pacific/Apia",
                "Pacific/Midway",
                "Pacific/Niue",
                "Pacific/Pago_Pago",
                "Pacific/Samoa",
                "US/Samoa",
                "America/Adak",
                "America/Atka",
                "Etc/GMT+10",
                "HST",
                "Pacific/Fakaofo",
                "Pacific/Honolulu",
                "Pacific/Johnston",
                "Pacific/Rarotonga",
                "Pacific/Tahiti",
                "SystemV/HST10",
                "US/Aleutian",
                "US/Hawaii",
                "Pacific/Marquesas",
                "AST",
                "America/Anchorage",
                "America/Juneau",
                "America/Nome",
                "America/Yakutat",
                "Etc/GMT+9",
                "Pacific/Gambier",
                "SystemV/YST9"
    });

    public Clock() {

        j.setTitle("Clock");

        j.setLayout(null);

        j.setBounds(0, 0, 600, 200);
        p.setBounds(j.getBounds());
        j.add(p);

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.setVisible(true);

        p.setBackground(Color.WHITE);

        g = p.getGraphics();

        getTimeZone();

    }

    public void show() {
        showTime();
    }

    public void getTimeZone() {
        TimeZone timeZone = null;
        switch(c.getSelectedIndex()) {
            case 0:
                timeZone = TimeZone.getTimeZone("Asia/Seoul");
                break;
            case 1:
                timeZone = TimeZone.getTimeZone("America/Los_Angeles");
                break;
            case 2:
                timeZone = TimeZone.getTimeZone("Etc/GMT+12");
                break;
            case 3:
                timeZone = TimeZone.getTimeZone("Etc/GMT+11");
                break;
            case 4:
                timeZone = TimeZone.getTimeZone("MIT");
                break;
            case 5:
                timeZone = TimeZone.getTimeZone("Pacific/Apia");
                break;
            case 6:
                timeZone = TimeZone.getTimeZone("Pacific/Midway");
                break;
            case 7:
                timeZone = TimeZone.getTimeZone("Pacific/Niue");
                break;
            case 8:
                timeZone = TimeZone.getTimeZone("Pacific/Pago_Pago");
                break;
            case 9:
                timeZone = TimeZone.getTimeZone("Pacific/Samoa");
                break;
            case 10:
                timeZone = TimeZone.getTimeZone("US/Samoa");
                break;
            case 11:
                timeZone = TimeZone.getTimeZone("America/Adak");
                break;
            case 12:
                timeZone = TimeZone.getTimeZone("America/Atka");
                break;
            case 13:
                timeZone = TimeZone.getTimeZone("Etc/GMT+10");
                break;
            case 14:
                timeZone = TimeZone.getTimeZone("HST");
                break;
            case 15:
                timeZone = TimeZone.getTimeZone("Pacific/Fakaofo");
                break;
            case 16:
                timeZone = TimeZone.getTimeZone("Pacific/Honolulu");
                break;
            case 17:
                timeZone = TimeZone.getTimeZone("Pacific/Johnston");
                break;
            case 18:
                timeZone = TimeZone.getTimeZone("Pacific/Rarotonga");
                break;
            case 19:
                timeZone = TimeZone.getTimeZone("Pacific/Tahiti");
                break;
            case 20:
                timeZone = TimeZone.getTimeZone("SystemV/HST10");
                break;
            case 21:
                timeZone = TimeZone.getTimeZone("US/Aleutian");
                break;
            case 22:
                timeZone = TimeZone.getTimeZone("US/Hawaii");
                break;
            case 23:
                timeZone = TimeZone.getTimeZone("Pacific/Marquesas");
                break;
            case 24:
                timeZone = TimeZone.getTimeZone("AST");
                break;
            case 25:
                timeZone = TimeZone.getTimeZone("America/Anchorage");
                break;
            case 26:
                timeZone = TimeZone.getTimeZone("America/Juneau");
                break;
            case 27:
                timeZone = TimeZone.getTimeZone("America/Nome");
                break;
            case 28:
                timeZone = TimeZone.getTimeZone("America/Yakutat");
                break;
            case 29:
                timeZone = TimeZone.getTimeZone("Etc/GMT+9");
                break;
            case 30:
                timeZone = TimeZone.getTimeZone("Pacific/Gambier");
                break;
            case 31:
                timeZone = TimeZone.getTimeZone("SystemV/YST9");
                break;
            case 32:
                timeZone = TimeZone.getTimeZone("SystemV/YST9YDT");
                break;
        }
        
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone);
        jb.setHours( calendar.get(Calendar.HOUR_OF_DAY) );
        jb.setMinutes( calendar.get(Calendar.MINUTE) );
        jb.setSecs( calendar.get(Calendar.SECOND) );
        jb.updateAMPM();
    
    }
    

    public void showTime() {

        Thread t = new Thread() {

            public void run() {

                try {
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, 400, 200);
                    c.setBounds(10, 10, 100, 30);

                    p.add(c);

                    p.repaint();
                    c.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            getTimeZone();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Thread tt = new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(500);
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                            int y = 115 + 25;
                            int x = 200 - 25;
                            int x2_ = 300 - 25;

                            g.setColor(Color.RED);
                            g.setFont(new Font("arial", Font.BOLD, 60));

                            g.drawString(":", x, y);
                            g.drawString(":", x2_, y);
                        }
                    }
                };
                tt.start();

                calcSecs();
                
                Thread t = new Thread() {
                
                    public void run() {
                        
                        while (true) {

                            try {
                                Thread.sleep(500);
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                            int x0 = 100;
                            int y0 = 40;
                            int x1 = 200;
                            int y1 = 40;
                            int x2 = 300;
                            int y2 = 40;
                            int x3 = 400;
                            int y3 = 40;


                            g.setColor(Color.WHITE);
                            g.fillRect(x0, y0, 200, 100);
                            g.setColor(Color.RED);
                    
                            g.drawString(jb.getHours() < 10 ? "0" + jb.getHours() : jb.getHours() + "", x0, y0 + 100);

                            g.setColor(Color.WHITE);
                            g.fillRect(x1, y1, 200, 100);
                            g.setColor(Color.RED);
                            
                            g.drawString(jb.getMinutes() < 10 ? "0" + jb.getMinutes() : jb.getMinutes() + "", x1, y1 + 100);

                            g.setColor(Color.WHITE);
                            g.fillRect(x2, y2, 200, 100);
                            g.setColor(Color.RED);
                            
                            g.drawString(jb.getSecs() < 10 ? "0" + jb.getSecs() : jb.getSecs() + "", x2, y2 + 100);

                            g.setColor(Color.WHITE);
                            g.fillRect(x3, y3, 200, 100);
                            g.setColor(Color.RED);
                            
                            g.drawString(jb.getIsAMPM() ? "AM" : "PM", x3, y3 + 100);
                        }
                    }
                };
                t.start();
            }
        };
        t.start();
    }

    private void calcSecs() {
        Thread t = new Thread() {
            public void run() {
 
                jb.updateAMPM();
                
                Thread t = new Thread() {
                    public void run() {
                        while (true) {

                            try {
                                Thread.sleep(1 * 1000);//pause one second
                                jb.setSecs (jb.getSecs() + 1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (jb.getSecs () >= 60) {
                                jb.setMinutes (jb.getMinutes() + 1);
                            }
                            if (jb.getSecs () >= 60) {
                                jb.setSecs ( 0 );
                            }

                            if (jb.getMinutes () >= 60) {
                                jb.setHours ( jb.getHours() + 1 );
                            }
                            if (jb.getMinutes () >= 60) {
                                jb.setMinutes ( 0 );
                            }
                            if (jb.getHours () > 12) {
                                jb.setHours ( jb.getHours () - 12 );
                            }
                        }
                    }
                };
                t.start();
            }
        };
        t.start();
    }

    public static void main(String args[]) {
        new Clock().show();
    }
}