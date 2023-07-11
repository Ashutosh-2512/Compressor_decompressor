/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane; 

/**
 *
 * @author ashut
 */
public class AppFrame extends JFrame implements ActionListener{ 
    JButton ButtonCompress;
    JButton ButtonDecompress;
    
    AppFrame(){
        this.setLayout(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonCompress = new JButton("Select the file to Compress");
        ButtonCompress.setBounds(200,200,300,50);
        ButtonCompress.addActionListener(this);
        
        ButtonDecompress = new JButton("Select the file to Decompress");
        ButtonDecompress.setBounds(550,200,300,50);
        ButtonDecompress.addActionListener(this);
        
        this.add(ButtonCompress);
        this.add(ButtonDecompress);
        
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.blue);
        
        this.setVisible(true);
        
    }    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ButtonCompress){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        if(e.getSource()==ButtonDecompress){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
