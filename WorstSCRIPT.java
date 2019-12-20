public class WorstSCRIPT
{ 
    // Metodo Worst-Fit para alocacao de memoria
    // algoritimo
    static void worstFit(int blockSize[], int m, int processSize[],  
                                                     int n) 
    { 
        // Armazena a identificação do bloco alocado a um
        // processo 
        int allocation[] = new int[n]; 
       
        // Inicialmente nenhum bloco é atribuído a nenhum processo
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
       
        // escolha cada processo e encontre os blocos adequados
        // de acordo com o tamanho do anúncio atribuído a ele
        for (int i=0; i<n; i++) 
        { 
            // Encontre o melhor bloco de ajuste para o processo atual 
            int wstIdx = -1; 
            for (int j=0; j<m; j++) 
            { 
                if (blockSize[j] >= processSize[i]) 
                { 
                    if (wstIdx == -1) 
                        wstIdx = j; 
                    else if (blockSize[wstIdx] < blockSize[j]) 
                        wstIdx = j; 
                } 
            } 
       
            // Se pudéssemos encontrar um bloco para o processo atual
            if (wstIdx != -1) 
            { 
                // alocar o bloco j ao processo p [i]
                allocation[i] = wstIdx; 
       
                // Reduza a memória disponível neste bloco 
                blockSize[wstIdx] -= processSize[i]; 
            } 
        } 
       
        System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
    } 
      
    // Método Driver
    public static void main(String[] args) 
    { 
         int blockSize[] = {100, 500, 200, 300, 600}; 
         int processSize[] = {212, 417, 112, 426}; 
         int m = blockSize.length; 
         int n = processSize.length; 
           
         worstFit(blockSize, m, processSize, n); 
    } 
} 