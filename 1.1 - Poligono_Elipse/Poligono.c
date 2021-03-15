#include <stdlib.h>
#include <stdio.h>
//Acredito que seja mais facil criar uma struct especifica para pontos e ter um vetor de pontos dentro da struct poligono mas me enrolei mto ao tentar fazer assim. Se puder dar alguma dica agradeço.
typedef struct 
{
	int nLados;
	int vertices[100];
}poligono;

void print (poligono *r, int n)
{
	int i, posX=0, posY=1;
	for(i=0; i<n; i++)
	{
		printf("O vertice de numero %d esta na posicao ( %d, %d )\n", i+1, r->vertices[posX], r->vertices[posY]);
		posX = posX + 2;
		posY = posY + 2;
	}
}

void main(void)
{
	int n,i, cont=0;
	poligono p1;
	printf("total de lados do poligono: ");
	scanf("%d", &p1.nLados);
	n = p1.nLados;
	for (i=0; i<n; i++)
	{
		printf("Valor de X para o vertice %d: ", i+1 );
		scanf("%d", &p1.vertices[cont]);
		cont++;
		printf("Valor de Y para o vertice %d: ", i+1);
		scanf("%d", &p1.vertices[cont]);
		cont++;
	}
	print(&p1, n);
}
