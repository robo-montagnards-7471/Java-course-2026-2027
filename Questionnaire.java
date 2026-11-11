import java.util.Scanner;

public class Questionnaire {
    public static void main(String[] args) {
    Questionnaire quest = new Questionnaire ();
    quest.run();
}
    public void run(){
        Questionnaire quest = new Questionnaire ();
        Scanner sc = new Scanner(System.in);
    
        System.out.print("que est ton prenom?");
        String variable = sc.next();
    
        System.out.print("quand est tu ne?");
        int variable2 = sc.nextInt();
        if (variable2>2026) {
            System.out.println("tu nest pas encore nes");
        } else {
            System.out.print("Bonjour "+variable+", tu as "+(2026-variable2)+" ans");
        }
    }
}
//alllllo
//thou shalt rue the day putrid cheeto