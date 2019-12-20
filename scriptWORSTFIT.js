#include<stdio.h>
#include<stdlib.h>
typedef struct best_choice{
	int start, end, total;
}b_choice;
void worst_fit(int *memory, int space, int total_space, b_choice *bc){
	bool valid = false;//flag
	int size_bc=0;// variável usada para armazenar o tamanho do vetor bc, com os dados de onde começa cada lacuna
	int bigger = 0;// variável usada para armazenar o maior espaço encontrado
	for(int i=0; i<total_space; i++){//percorremos toda memória armazenando as lacunas livres
		if(memory[i]==0){
			if(valid==false){
				bc[size_bc].start = i;//armazenamos onde começa uma lacuna livre
				
			}			
			valid = true;
		}
		else{
			if(valid==true){//armazenamos onde a lacuna livre termina
				bc[size_bc].end = i;
				bc[size_bc].total = bc[size_bc].end - bc[size_bc].start;
				size_bc++;
			}	
			valid = false;
		}	
	}
	valid = false;
	for(int i=0; i<size_bc; i++){//agora percorremos o vetor que possui os dados sobre as lacunas livres
		if(bc[i].total>=space){//procuramos pela maior lacuna
			if(bc[i].total>bigger){
				
				bigger = bc[i].start;//caso o elemento atual seja maior, bigger recebe esse elemento
				valid = true;
			}
		}
	}
	if(valid==true){//se a flag é true, quer dizer que existe espaço para essa alocação
		printf("\nposição: %d\n", bigger);
		for(int i=bigger; i<(bigger+space); i++)//preenchemos as posições do vetor memória, dada a maior lacuna
			memory[i] = 1;		
		printf("\n************Espaço alocado com SUCESSO**************\n");
	}	
	else//caso false, não existe espaço para esta alocação
		printf("\n************Espaço insuficiente**************\n");
}
//AMNC