public class Employe {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    //Constructeur avec attributs
    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }
    //Constructeur par défaut
    public Employe() {
    }
     //Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

   //Méthode toString()
    @Override
    public String toString() {
        return "Employe{id=" + id +", nom=" + nom + ", poste=" + poste + ", salaire=" + salaire + "}";

    }
    //Méthode statique compareParSalaire
    public static int compareParSalaire(Employe emp1, Employe emp2) {
        return Double.compare(emp1.getSalaire(), emp2.getSalaire());
    }
}
