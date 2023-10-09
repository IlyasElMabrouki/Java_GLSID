public class Main {
    public static void main(String[] args) {
        Reponse r1 = new Reponse("Langage OOP", true);
        Reponse r2 = new Reponse("Langage structurale",false);
        Reponse r3 = new Reponse("Aucune des 2 réponses",false);

        Reponse r4 = new Reponse("Lanage compilé", false);
        Reponse r5 = new Reponse("Langage interprété", false);
        Reponse r6 = new Reponse("Les deux", true);

        Reponse r7 = new Reponse("super", false);
        Reponse r8 = new Reponse("public", true);
        Reponse r9 = new Reponse("global", false);

        Reponse r10 = new Reponse("private ou public", false);
        Reponse r11 = new Reponse("public ou protected", true);
        Reponse r12 = new Reponse("private ou protected", false);

        Reponse r13 = new Reponse("de définir une classe prioritaire", false);
        Reponse r14 = new Reponse("d'accéder aux membres d'une classe mère", true);
        Reponse r15 = new Reponse("de définir une méthode prioritaire", false);

        Question q1 = new Question("Question 1:", "Le langage Java est-il un langage OOP ou structurale?", new Reponse[]{r1, r2,r3}, 2);
        Question q2 = new Question("Question 2:", "Le langage Java est-il compilé, interpreté ou les deux?", new Reponse[]{r4,r5,r6},2);
        Question q3 = new Question("Question 3:", "Quel mot clé permet de rendre une classe accessible à l'extérieur de son package ?", new Reponse[]{r7,r8,r9},2);
        Question q4 = new Question("Question 4:", "Quelles méthodes et variables peuvent être utilisées dans une classe héritée ?", new Reponse[]{r10,r11,r12},2);
        Question q5 = new Question("Question 5:", "Le mot clé super permet ", new Reponse[]{r13,r14,r15},2);

        Questionnaire qu1 = new Questionnaire("Java", new Question[]{q1,q2,q3,q4,q5});
        System.out.println(qu1);
    }
}
