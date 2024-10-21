import java.util.ArrayList;
import java.util.List;

public class RallyDakar {
    static int operationCount = 0;
    public static void main(String[] args) {
        int L = 20;
        int d = 1;
        int x[] = new int[1];

        for(int i = 0; i < 2; i++){
            L = L*10;
            d = d*5;
            x = new int[x.length*3];
            for(int j = 0; j < x.length; j++){
                int point = (int) (Math.random() * d) + x[j - 1 < 0 ? 0 : j - 1];
                
            }
            for(int num : x){
                System.out.print(num + " ");
            }
            long startTime = System.nanoTime();
            List<Integer> paradas = calcularMinimoParadas(L, d, x);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            
            if (paradas != null) {
                System.out.println("Paradas: " + paradas);
            } else {
                System.out.println("Não é possível completar o rally com as condições dadas.");
            }
            System.out.println("Tempo de execução: " + executionTime + " nanosegundos");
            System.out.println("Número de operações: " + operationCount);
        }

    }

    public static List<Integer> calcularMinimoParadas(int L, int d, int[] x) {
        int n = x.length;
        int[] pontos = new int[n + 2];
        pontos[0] = 0;
        System.arraycopy(x, 0, pontos, 1, n);
        pontos[n + 1] = L;
        n = pontos.length;

        List<Integer> paradas = new ArrayList<>();

        for (int i = 0; i < n - 1; ) {
            int proximoPonto = i;

            while (proximoPonto + 1 < n && pontos[proximoPonto + 1] - pontos[i] <= d) {
                proximoPonto++;
                operationCount++;
            }

            if (proximoPonto == i) {
                return null;
            }

            if (proximoPonto < n - 1) {
                paradas.add(pontos[proximoPonto]);
                System.out.println("Ponto escolhido: " + pontos[proximoPonto]);
            }

            i = proximoPonto;
        }

        return paradas;
    }
}
