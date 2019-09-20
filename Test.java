class Test{
public boolean checkNumber(int n){
int rem=0,flag=0;
if(n==0){return false;}
while(n!=1){
if(n%2!=0){return false;}
n=n/2;
}
return true;
}
public static void main(String[] args){
Test t=new Test();
int n=Integer.parseInt(args[0]);
boolean flag=t.checkNumber(n);
if(flag){System.out.println("Power of 2");}
else{System.out.println("Not power of 2");}
}
}