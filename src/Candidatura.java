import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Candidatura {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        String [] candidatos = {"Felipe", "Márcia", "Júlia", "Paulo", "Augusto"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);
        //selecaoCandidato();

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continua = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continua = !atendeu;
            if (continua){
                tentativasRealizadas ++;
            }else{
                System.out.println("Contato realizado com sucesso!");
            }
        }while(continua && tentativasRealizadas < 3);
            if(atendeu){
                System.out.println("Conseguimos contato com "+ candidato + " na " + tentativasRealizadas + " tentativa");
            }else{
                System.out.println("não conseguimos contato com " + candidato  + " número máximo de tentativas " + tentativasRealizadas + " realizadas");
            }
        
        

    }
    static void selecaoCandidato(){
        String [] candidatos = {"Felipe", "Márcia", "Júlia", "Paulo", "Augusto", "Mônica", "Fabrício", "Mirela", "Daniela"};
        int candidatoSelecionado = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatoSelecionado <5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido );
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga ");
                candidatoSelecionado++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido ){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para candidato");
        }
        else if( salarioBase == salarioPretendido){
            System.out.println("Ligar para candidato é fazer conta proposta");
        }
        else {
            System.out.println("aguardando o resultado para dos demais candidatos");
        }
    }
}

