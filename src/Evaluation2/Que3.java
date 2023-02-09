package Evaluation2;

public class Que3 {

    public static void main(String[] args){
        int a[]= {1,3,5,2,7,9,4};
        int sum=0,mul=1;
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                sum = sum+a[i];
            }
            if(a[i]%2!=0){
                mul =mul*a[i];
            }
        }
        System.out.println(sum);
        System.out.println(mul);
    }
}
