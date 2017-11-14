package better.panel;

import better.controler.ViewControler;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard implements ActionListener {

    private ViewControler viewControler;

    private JButton listButton;
    private JButton addEmploye;

    public Dashboard(ViewControler viewControler){

        this.viewControler = viewControler;

        this.viewControler.panel = new JPanel();


        this.addEmploye = new JButton("Ajouter un employé");
        this.addEmploye.addActionListener(this);
        this.listButton = new JButton("Lister les employés");
        this.listButton.addActionListener(this);



        this.viewControler.panel.add(this.addEmploye);
        this.viewControler.panel.add(this.listButton);




    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.listButton){
            System.out.println("list");
            this.viewControler.displayList();
        }

        else if(event.getSource() == this.addEmploye){
            System.out.println("add");
            this.viewControler.displayForm();
        }
    }


}


