package com.ilyaselmabrouki.examenfinal;

import com.ilyaselmabrouki.examenfinal.dao.Impl.DepartementDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EmployeDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.Impl.EntrepriseDaoImpl;
import com.ilyaselmabrouki.examenfinal.dao.entities.Entreprise;
import com.ilyaselmabrouki.examenfinal.dao.entities.Departement;
import com.ilyaselmabrouki.examenfinal.dao.entities.Employe;
import com.ilyaselmabrouki.examenfinal.metier.Impl.IEntrepriseMetierImpl;

import java.util.ArrayList;

public class Main {
    private static IEntrepriseMetierImpl entrepriseMetier = new IEntrepriseMetierImpl(new EntrepriseDaoImpl(), new DepartementDaoImpl(), new EmployeDaoImpl());

    public static void main(String[] args) {

        //ENTREPRISE
        ArrayList<Entreprise> entreprises = (ArrayList<Entreprise>) entrepriseMetier.getAllEntreprises();
        for (Entreprise entreprise:entreprises) {
            System.out.println(entreprise.toString());
        }

        //System.out.println(entrepriseMetier.getEntreprise(10));


        Entreprise entreprise = new Entreprise();
        entreprise.setNom("Godogi");
        entreprise.setAdresse("Kenitra");
        entreprise.setTelephone("0660982949");
        entreprise.setEmail("godogi@gmail.com");
        //entrepriseMetier.addEntreprise(entreprise);

        //entrepriseMetier.deleteEntreprise(5);

        Entreprise newEntreprise = new Entreprise();
        entreprise.setNom("Sqli");
        entreprise.setAdresse("Kenitra");
        entreprise.setTelephone("0793749238");
        entreprise.setEmail("sqli@gmail.com");

        //entrepriseMetier.updateEntreprise(newEntreprise,1);

        // DEPARTEMENT
        ArrayList<Departement> departements = (ArrayList<Departement>) entrepriseMetier.getAllDepartements();
        for (Departement departement:departements) {
            System.out.println(departement.toString());
        }

        //System.out.println( entrepriseMetier.getDepartement(1));


        Departement departement = new Departement();
        departement.setNom("Informatique");
        departement.setEntreprise(entrepriseMetier.getEntreprise(2));
        entrepriseMetier.addDepartement(departement);

        //entrepriseMetier.deleteDepartement(1);

        //System.out.println(entrepriseMetier.getEntreprise(2));

        Departement newDepartement = new Departement();
        newDepartement.setNom("Maintenance");
        newDepartement.setEntreprise(entrepriseMetier.getEntreprise(2));

        //entrepriseMetier.updateDepartement(newDepartement,1);

        // EMPLOYE
        ArrayList<Employe> employes = (ArrayList<Employe>) entrepriseMetier.getAllEmployes();
        for (Employe employe:employes) {
            System.out.println(employe.toString());
        }

        //System.out.println(entrepriseMetier.getEmploye(1));

        Employe employe = new Employe();
        employe.setNom("Ilyas El Mabrouki");
        employe.setPoste("Ingenieur");
        employe.setSalaire(10000.0);
        employe.setDepartement(entrepriseMetier.getDepartement(5));
        entrepriseMetier.addEmplye(employe);

        //entrepriseMetier.deleteEmploye(1);


        Employe newEmploye = new Employe();
        newEmploye.setNom("Ilyas El Mabrouki");
        newEmploye.setPoste("Ingenieur");
        newEmploye.setSalaire(10000.0);
        newEmploye.setDepartement(entrepriseMetier.getDepartement(5));

        //entrepriseMetier.updateEmploye(newEmploye,1);
    }
}
