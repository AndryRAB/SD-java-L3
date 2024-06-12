/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fusion;

import java.util.Arrays;

/**
 *
 * @author ANDRY-PC
 */
public class Fusion {

    public static int[] fusion(int t1[], int t2[]){
        int t[] = new int[t1.length+t2.length];
        int i1=0, i2=0;
        for (int i = 0; i < t.length; i++) {
            if (i2>=t2.length||(i1<t1.length&&t1[i1]<t2[i2]))
                t[i]=t1[i1++];
            else 
                t[i]=t2[i2++];
        }
        return t;    
    }
    
    
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(fusion(new int[]{1,4,7,9}, 
                        new int[]{8,14,17,18}))
                );
    }
    
}
