#include<stdio.h>
int main(){
    long long int n,k;
    long long int a[201][201];
    scanf("%lld %lld",&n,&k);
    for(int i=0;i<=n;i++)
    {
	    a[1][i]=1;
    }
    for(int i=2;i<=k;i++)
    {
	    for(int j=0;j<=n;j++)
	    {
		    for(int x=0;x<=j;x++)
		    {
			    a[i][j] +=(a[i-1][x]);
			    a[i][j] %=1000000000;
		    }
		
	    }
	    a[i][0]=1;
    }
    printf("%lld\n",(a[k][n])%1000000000);
    return 0;
}