
#include<stdio.h>
#include<math.h>
/*
Geeks for geeks problem

solved using recursion/backtracking:

Input:
1
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
*/
int mat[9][9];
flag=0;
//check block
void playSudoku(int row,int col)
{
    int nextrow,nextcol,i;
    if(flag==1)
    {
        return;
    }
    if(col==8)
    {
      nextcol=0;
      nextrow=row+1;

    }else{
      nextrow=row;
      nextcol=col+1;
    }
    //printf("nextrow:%d nextcol:%d\n",nextrow,nextcol);
    if(mat[row][col]!=0)
    {

      playSudoku(nextrow,nextcol);
       if(row==8 && col ==8)
        {
            flag=1;
            printmat();
            return;
        }
    }else{
        for(i=1;i<=9;i++)
        {

           // printf("\n%d %d",checkBlock(row,col,i), checkLine(row,col,i));
            if(checkBlock(col,row,i) && checkLine(row,col,i))
            {

                if(row==8 && col ==8)
                {
                 mat[row][col]=i;
                 flag=1;
                 printmat();
                 return;
                }else{
                 mat[row][col]=i;
                 playSudoku(nextrow,nextcol);
                 if(flag==1)
                 {
                     return;
                 }
                 mat[row][col]=0;
                }



            }
        }
        return ;
    }
}
void printmat()
{

    int i,j;
    for(i=0;i<9;i++)
    {
      for(j=0;j<9;j++)
      {
        printf("%d ",mat[i][j]);
      }
      printf("\n");
    }


}
int checkAllFill()
{
    int i,j;
    for(i=0;i<9;i++)
    {
      for(j=0;j<9;j++)
      {
          if(mat[i][j]==0)
          {
              return 0;
          }
      }
    }
    return 1;
}
int checkBlock(int row,int col,int val)
{
    int i,j;
    for(i=(col/3)*3;i<3*((col/3)+1);i++)
    {
        for(j=(row/3)*3;j<3*((row/3)+1);j++)
        {
          // printf("%d ",mat[i][j]);
            if(mat[i][j]==val)
            {
                return 0;
            }
        }
        //printf("\n");
    }
    return 1;
}


int checkLine(int row,int col,int val)
{
    int i=0;
   // printf("checking for mat[%d][%d]",row,col);
    for(int i=0;i<9;i++)
    {
      //  printf("%d ",mat[row][i]);
        if(mat[row][i]==val)
        {
        return 0;
        }
    }
    //printf("\n");
    for(int i=0;i<9;i++)
    {
      //printf("%d ",mat[i][col]);
        if(mat[i][col]==val)
        {
            return 0;
        }
    }
    return 1;
}
int main1()
{
	//code
	int i,t,j,k;
	scanf("%d",&t);

	//getting the input to mat
	for(i=0;i<t;i++)
	{
	    for(j=0;j<9;j++)
	    {
	        for(k=0;k<9;k++)
	        {
	            scanf("%d",&mat[j][k]);
	        }
	    }
        playSudoku(0,0);
        flag=0;
	}



	return 0;
}

