package better.panel;

import better.domain.*;
import better.controler.ViewControler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmploye implements ActionListener{

    private ViewControler viewControler;
    private JButton returnButton;
    private JButton submit;

    private String[] jobList = {
            "Manutention",
            "Manutention à risque",
            "Production",
            "Production à risque",
            "Représentant"

    };

    private JComboBox <String> comboRole;
    private JTextField firstname;
    private JTextField lastname;
    private JSpinner age;
    private JSpinner year;
    private JSpinner unit;


    public AddEmploye(ViewControler viewControler){

        this.viewControler = viewControler;
        this.viewControler.panel = new JPanel();
        this.comboRole = new JComboBox<>(this.jobList);
        this.firstname = new JTextField();
        this.lastname = new JTextField();
        this.age = new JSpinner();
        this.year = new JSpinner();
        this.unit = new JSpinner();


        this.returnButton = new JButton("Retour ");
        this.returnButton.addActionListener(this);

        this.submit = new JButton("Submit");
        this.submit.addActionListener(this);

        this.viewControler.panel.setLayout(new GridLayout(7,2));


        this.viewControler.panel.add(new JLabel("Roles"));
        this.viewControler.panel.add(this.comboRole);

        this.viewControler.panel.add(new JLabel("Firstname"));
        this.viewControler.panel.add(this.firstname);

        this.viewControler.panel.add(new JLabel("Lastname"));
        this.viewControler.panel.add(this.lastname);

        this.viewControler.panel.add(new JLabel("Age"));
        this.viewControler.panel.add(this.age);

        this.viewControler.panel.add(new JLabel("Entry year"));
        this.viewControler.panel.add(this.year);

        this.viewControler.panel.add(new JLabel("Unité"));
        this.viewControler.panel.add(this.unit);

        this.viewControler.panel.add(this.submit);
        this.viewControler.panel.add(this.returnButton);


    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.returnButton){
            System.out.println("dashboard");
            this.viewControler.displayDashboard();
        }

        else if(event.getSource() == this.submit){

            String jobs = String.valueOf(this.comboRole.getSelectedItem());
            String nom = this.firstname.getText();
            String prenom = this.lastname.getText();
            int ageEmploye = (int)this.age.getValue();
            String annee = String.valueOf(this.year.getValue());
            int uniteText = (int)this.unit.getValue();

            Employee e;

            switch (jobs){
                case  ("Manutention"):
                    e = new Manutentionnaire(prenom,nom, ageEmploye, annee,uniteText);
                    break;

                case  ("Manutention à risque"):
                    e = new ManutARisque(prenom,nom, ageEmploye, annee,uniteText);
                    break;

                case  ("Production"):
                    e = new Technicien(prenom,nom, ageEmploye, annee,uniteText);
                    break;

                case  ("Production à risque"):
                    e = new TechnARisque(prenom, nom, ageEmploye, annee,uniteText);
                    break;

                case  ("Représentant"):
                    e = new Representant(prenom,  nom, ageEmploye, annee, uniteText);
                    break;

                default:
                    e = null;
                    break;


            }
            if (e != null ){
                this.viewControler.personnel.ajouterEmploye(e);
                this.viewControler.displayDashboard();
            }





        }
    }


}
