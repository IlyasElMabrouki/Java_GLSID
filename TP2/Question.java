import java.util.Scanner;

public class Question {
    private String titre;
    private String description;

    private Reponse[] reponses;

    private int score;

    Question(String titre, String description, Reponse[] reponses, int score){
        this.titre = titre;
        this.description = description;
        this.reponses = new Reponse[3];
        for (int i=0;i<3;i++){
            this.reponses[i] = reponses[i];
        }
        this.score= score;
    }

    public String toString(){
        String question = titre + " " + description + " (" + score + ")\n";
        for (int i=0;i<3;i++){
            question += i+1 + ". " + this.reponses[i].toString();
        }
        return question;
    }

    public boolean enterAnswer(){
        System.out.println("Entrer votre réponse:");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        sc.close();
        if (answer > this.reponses.length || answer <=0) {
            return false;
        }
        return this.reponses[answer - 1].getCorrecte();
    }

    public String showCorrectAnswer(){
        String bonneReponse = "";
        for(Reponse reponse:reponses){
            if(reponse.getCorrecte()) {
                bonneReponse = "La bonne réponse est: " + reponse;
            }
        }
        return bonneReponse;
    }

    public int getScore(){return this.score;}
}
