class Calculation{
public int calculateSum(int n){
  System.out.println("Adding comments");
int sum=0;
for(int i=1;i<=n;i++){
if(i%3==0||i%5==0){
sum+=i;
}
}
return sum;
}
public int calculateDifference(int n){
int sum1=(n*(n+1)*(2*n+1))/6;
int sum2=0;
for(int i=1;i<=n;i++){
sum2+=i;
}
sum2=sum2*sum2;
return (sum2-sum1);
}
public static void main(String[] args){
Calculation c=new Calculation();
int n=Integer.parseInt(args[0]);
int sum=c.calculateSum(n);
System.out.println(sum);
int diff=c.calculateDifference(n);
System.out.println(diff);
}
}
