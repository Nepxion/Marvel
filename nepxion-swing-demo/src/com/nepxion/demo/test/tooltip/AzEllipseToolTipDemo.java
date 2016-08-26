package com.nepxion.demo.test.tooltip;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AzEllipseToolTipDemo extends JFrame {
    public AzEllipseToolTipDemo() {
        init();
    }

    public void init() {
        HalfOpaqueToolTip tooltip = new HalfOpaqueToolTip("��������һ���������",
                new Color(250, 250, 200), Color.RED, new Color(95, 145, 145),
                this);
        JButton button = new JButton("swing");
        button.addMouseListener(tooltip);

        this.setLayout(new FlowLayout());
        this.add(new JButton("��"));
        this.add(new JButton("ľ"));
        this.add(new JButton("ˮ"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("��"));
        this.add(new JButton("Ǭ"));
        this.add(new JButton("��"));
        this.add(button);
        this.add(new JButton("��"));
        this.add(new JButton("��"));

        this.setSize(380, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        new AzEllipseToolTipDemo();
    }

    class HalfOpaqueToolTip extends JPanel implements MouseListener {
        private Color backGroundCol = null;

        private Color foregroundColorCol = null;

        private Color borderCol = null;

        private String content = null;

        private JFrame frame = null;

        private int contentEllipseX = 30;

        private int contentEllipseY = 20;

        private int contentEllipseW = 0;

        private int contentEllipseH = 0;

        private int LEFT = 1;

        private int RIGHT = 2;

        private int direction = 2;

        public HalfOpaqueToolTip(String tooltipContent, Color backGroundColor,
                Color foregroundColor, Color borderColor, JFrame frame) {
            content = tooltipContent;
            backGroundCol = backGroundColor;
            foregroundColorCol = foregroundColor;
            borderCol = borderColor;
            /*
             * ����tooltip�Ĵ�С
             */
            content = tooltipContent;
            contentEllipseW = tooltipContent.getBytes().length * 6 + 10;
            contentEllipseH = 40;
            this.setSize(contentEllipseX + contentEllipseW + 1, 90);

            this.setOpaque(false);
            this.setVisible(false);
            // �����ؼ����ڽ�������
            frame.getLayeredPane().add(this, JLayeredPane.POPUP_LAYER);
            this.frame = frame;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(backGroundCol);
            AlphaComposite composite = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 70 / 100.0F);
            g2d.setComposite(composite);
            g2d.fill(getArea());
            // �ָ���Ĭ�����
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);

            g2d.setColor(foregroundColorCol);
            if (direction == LEFT) {
                g2d.drawString(content, (int) this.getSize().getWidth()
                        - contentEllipseX - contentEllipseW + 10,
                        contentEllipseY + contentEllipseH / 2 + 5);
            } else {
                g2d.drawString(content, contentEllipseX + 10, contentEllipseY
                        + contentEllipseH / 2 + 5);
            }
        }

        protected void paintBorder(Graphics g) {
            super.paintBorder(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(borderCol);
            g2d.draw(getArea());
        }

        private Area getArea() {
            if (direction == LEFT) {
                return getLeftArea();
            } else {
                return getRightArea();
            }
        }

        private Area getLeftArea() {
            Area area = new Area(new Ellipse2D.Float((int) this.getSize()
                    .getWidth() - 6 - 1, (int) this.getSize().getHeight() - 20,
                    6, 6));
            area.add(new Area(new Ellipse2D.Float((int) this.getSize()
                    .getWidth() - 10 - 30 + 1,
                    (int) this.getSize().getHeight() - 35, 30, 15)));
            area.add(new Area(new Ellipse2D.Float((int) this.getSize()
                    .getWidth()
                    - contentEllipseX - contentEllipseW + 1, contentEllipseY,
                    contentEllipseW, contentEllipseH)));
            return area;
        }

        private Area getRightArea() {
            Area area = new Area(new Ellipse2D.Float(0, (int) this.getSize()
                    .getHeight() - 20, 6, 6));
            area.add(new Area(new Ellipse2D.Float(10, (int) this.getSize()
                    .getHeight() - 35, 30, 15)));
            area.add(new Area(new Ellipse2D.Float(contentEllipseX,
                    contentEllipseY, contentEllipseW, contentEllipseH)));

            return area;
        }

        public void mouseEntered(MouseEvent e) {
            Point p = e.getLocationOnScreen();
            SwingUtilities.convertPointFromScreen(p, e.getComponent()
                    .getParent());
            if (p.x + this.getWidth() > frame.getX()) {
                direction = LEFT;
                this.setLocation(new Point(p.x - this.getWidth(), p.y
                        - this.getHeight()));
            } else {
                direction = RIGHT;
                this.setLocation(new Point(p.x, p.y - this.getHeight()));
            }
            this.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            this.setVisible(false);
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

    }
}