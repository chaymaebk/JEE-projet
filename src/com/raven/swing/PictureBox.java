/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing;

/**
 *
 * @author lenovo
 */


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class PictureBox extends JLayeredPane {

    private Object image;

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (image != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            Rectangle size = getAutoSize(image);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(image), size.getLocation().x, size.getLocation().y, size.getSize().width, size.getSize().height, null);
        }
    }

    private Rectangle getAutoSize(Object image) {
        int w = getWidth();
        int h = getHeight();
        int iw, ih;
        if (image instanceof Icon) {
            Icon icon = (Icon) image;
            iw = icon.getIconWidth();
            ih = icon.getIconHeight();
        } else if (image instanceof java.awt.Image) {
            java.awt.Image img = (java.awt.Image) image;
            iw = img.getWidth(null);
            ih = img.getHeight(null);
        } else {
            return new Rectangle(new Dimension(0, 0));
        }
        if (w > iw) {
            w = iw;
        }
        if (h > ih) {
            h = ih;
        }
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = getWidth() / 2 - (width / 2);
        int y = getHeight() / 2 - (height / 2);
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private java.awt.Image toImage(Object image) {
        if (image instanceof ImageIcon) {
            return ((ImageIcon) image).getImage();
        } else if (image instanceof java.awt.Image) {
            return (java.awt.Image) image;
        } else {
            return null;
        }
    }
}

