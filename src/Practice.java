import java.util.Scanner;

public class Practice {
Scanner sc = new Scanner(System.in);
    // methodsScope returnType methodsName (params)
    // {
    // methods body
    // }


private void terra () {

}
public void rightTriangle () {
    System.out.println("ВВЕДИТЕ ЗНАЧЕНИЕ: ");
    int size = sc.nextInt();
    for (int i = 1; i <= size; i++){
        for (int j = 1; j <= i; j++){
            System.out.print("*");
        }
        System.out.println();

    }
    sc.close();
}

public  int maxOfThree (int a,int b, int c){
    if (a>b && a>c){
       return a;
    }
    else if (b>a && b>c){
        return b;
    }
    else{
        return c;
    }
}


}
