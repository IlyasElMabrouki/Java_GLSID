public class Questionnaire {
    public String titre;
    public Question[] questions;

    Questionnaire(String titre, Question[] questions){
        this.titre = titre;
        this.questions = new Question[5];
        for (int i=0;i<5;i++){
            this.questions[i] = questions[i];
        }
    }

    public String toString(){
        int finalScore = 0;
        int somme = 0;
        for (int i=0;i<5;i++){
            System.out.println(this.questions[i].toString());
            somme += this.questions[i].getScore();
            if (this.questions[i].enterAnswer()) {
                finalScore += this.questions[i].getScore();
            }
        }
        String result = "Les bonnes réponses sont les suivantes:\n";
        for (Question question : this.questions) {
            result += question.showCorrectAnswer();
        }
        result += "Le score final est: " + (finalScore* 100)/somme + "%";
        return result;
    }

}
