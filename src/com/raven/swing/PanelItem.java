/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class PanelItem extends JPanel {
    public PanelItem (){
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT,10,10));
    }
}
