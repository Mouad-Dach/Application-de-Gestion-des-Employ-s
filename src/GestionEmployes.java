import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class GestionEmployes{
    private static Employe[] employes = new Employe[50];
    private static int employeCount = 0; //Nmobres d'employés actuels

     //Menu
     public static void printMenu(){
         System.out.println("-----Menu Principal-----");
         System.out.println("1. Ajouter un employé");
         System.out.println("2. Modifier un employé");
         System.out.println("3. Supprimer un employé");
         System.out.println("4. Afficher tous les employés");
         System.out.println("5. Rechercher un employé");
         System.out.println("6. Calculer la masse salariale");
         System.out.println("7. Trier les employés par salaire");
         System.out.println("0. Quitter");
         System.out.print("Choisissez une option : ");
     }

     //Ajouter un employé
    public static void ajouterEmploye(Employe employe){
         if(employeCount >= 50){
             System.out.println("Le tableau est plein. Impossible d'ajouter plus d'employés");
             return;
         }
         employes[employeCount++] = employe;
        System.out.println("Employé ajouté avec succes ");
     }
     //modifier un employé
    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire){
         for(int i=0; i<employeCount; i++){
             if(employes[i].getId() == id){
                 employes[i].setNom(nouveauNom);
                 employes[i].setPoste(nouveauPoste);
                 employes[i].setSalaire(nouveauSalaire);
                 System.out.println("Employé modifie avec succes ");
                 return;
             }
         }
        System.out.println("Employ& introuvable");
     }
     //Supprimer un employé
     public static void supprimerEmploye(int id) {
         for (int i = 0; i < employeCount; i++) {
             if (employes[i].getId() == id) {
                 // Décaler les employés restants vers la gauche
                 System.arraycopy(employes, i + 1, employes, i, employeCount - i - 1);
                 employes[--employeCount] = null; // Supprimer la dernière référence
                 System.out.println("Employé supprimé avec succès !");
                 return;
             }
         }
         System.out.println("Employé introuvable.");
     }
    //afficher tous les employés
    public static void afficherEmployes(){
         if(employeCount == 0){
             System.out.println("Aucun employé trouvé");
             return;
         }
         for(int i=0; i<employeCount; i++){
             System.out.println(employes[i]);
         }
    }
    //Rechercher un employé
    public static void rechercherEmploye(String critere){
         boolean found = false;
         for(int i=0; i<employeCount; i++){
             if(employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)){
                 System.out.println(employes[i]);
                 found = true;
             }
         }
         if(!found){
             System.out.println("Aucun Employé trouvé");
         }
    }
    //Calculer la masse salariale
    public static void calculerMasseSalariale(){
         double total = 0;
         for(int i=0; i<employeCount; i++){
             total += employes[i].getSalaire();
         }
        System.out.println("Total de la masse salariale : " + total);
    }
    //Trier les employés par salaire
    public static void trierEmployesParSalaire(boolean ordreCroissant){
         Arrays.sort(employes, 0, employeCount, (e1, e2) ->
                 ordreCroissant ? Employe.compareParSalaire(e1 ,e2) : Employe.compareParSalaire(e2 ,e1));
              afficherEmployes();
    }



   //MAIN METHOD
  public static void main(String[] args){
   Scanner scanner = new Scanner(System.in);
   int choix;
       do {
           printMenu();
           choix = scanner.nextInt();
           scanner.nextLine();
           switch(choix){
               case 1:
                   System.out.println("ID : ");
                   int id = scanner.nextInt();
                   scanner.nextLine();
                   System.out.println("Nom : ");
                   String nom = scanner.nextLine();
                   System.out.println("Poste : ");
                   String poste = scanner.nextLine();
                   System.out.println("Salaire : ");
                   double salaire = scanner.nextDouble();
                   ajouterEmploye(new Employe (id, nom, poste, salaire));
                   break;
                   case 2:
                       System.out.println("ID à modifier : ");
                       id = scanner.nextInt();
                       scanner.nextLine();
                       System.out.println("Nouveau Nom : ");
                       String nouveauNom = scanner.nextLine();
                       System.out.println("Nouveau Poste : ");
                       String nouveauPoste = scanner.nextLine();
                       System.out.println("Nouveau Salaire : ");
                       double nouveauSalaire = scanner.nextDouble();
                       modifierEmploye(id ,nouveauNom, nouveauPoste, nouveauSalaire);
                       break;
                       case 3:
                           System.out.println("ID à supprimer : ");
                           id = scanner.nextInt();
                           supprimerEmploye(id);
                           break;
                           case 4:
                               afficherEmployes();
                               break;
                               case 5:
                                   System.out.println("Critere de recherche (Nom ou Poste) : ");
                                   String critere = scanner.nextLine();
                                   rechercherEmploye(critere);
                                   break;
                                   case 6:
                                       calculerMasseSalariale();
                                       break;
                                       case 7:
                                           System.out.print("Trier les employés par salaire (true = croissant / false = décroissant) : ");
                                           boolean ordreCroissant = scanner.nextBoolean();
                                           trierEmployesParSalaire(ordreCroissant);
                                       break;
                                              case 0:
                                              System.out.println("Au revoir ");
                                              break;
                                              default:
                                                  System.out.println("Option invalide");

           }
       }while (choix != 0);

       scanner.close();
  }

}

