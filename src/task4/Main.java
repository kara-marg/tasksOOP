package task4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(ReflectionAPI.getInformationAboutClass(ArrayList.class));
        // System.out.println(ReflectionAPI.getInformationAboutClass(A.class));
//        String s = "";
//        String res="";
//        Scanner scanner=new Scanner(System.in);
//        while(!s.equals("1")){
//            s=scanner.nextLine();
//            s=s.replace("(", "[");
//            s=s.replace(")", "],");
//            res=res+s+"\n";
//        }
//        System.out.println(res);
    }
}
class  B{
    int a;
}
class A extends B{
    private  static int f;
    int l;
    public final String q="3";
    private A(int f){
        this.f=a;
    }
    public A(){

    }
    public int method1(int a, float b){
        return 4;
    }
}