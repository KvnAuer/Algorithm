import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Algorithm {

   

   public static void main(String[] args) {
   
      try {
      
         File myFile = new File("Project1.txt");
         FileWriter fw = new FileWriter(myFile);
      
         int[] arrayG = new int[1000001];
         int[] arrayA = new int[1000001];
      
         for (int i = 1; i < 1000001; i++) {
            arrayG[i] = (int) (Math.random() * 1000);
            //System.out.println(arrayG[i]);
         }
      
         int n = 1000;
         
         while (n <= 1000001) {
         
            for (int j = 1; j <= 1000000; j++) {
               arrayA[j] = arrayG[j];
            } 
            n = n + 1000;
            long startTime = System.nanoTime();
            Algorithm.MergeSort(arrayA, 0, n-1);
            long endTime = System.nanoTime();
            
            double tn = (endTime - startTime) / 1000000;
            //double tn_logn = tn / 
            
            fw.write(n + "," + tn);
            fw.flush();
            
            
            System.out.println(n);
         } 
         //for (int n = 1000; n <= 50000; n + 1000) {
         
         //}
         
      } catch (IOException e) {
         System.out.println(e);
      }
      
   }
   
   public static void MergeSort(int[] A,int p,int r) {
   
      if (p < r) {
         int q = (int) Math.floor((p + r)/2);
         MergeSort(A, p, q);
         MergeSort(A, q + 1, r);
         Algorithm.Merge(A, q, p, r);
      }
   
   }
   
   public static void Merge(int[] A, int p, int q, int r) {
   
      int n1 = q - p + 1;
      int n2 = r - q;
      int[] L = new int[(n1 + 1)];
      int[] R =  new int[(n2 + 1)];
      for (int i = 1; i <= n1; i++) {
         L[i] = A[p + i -1];
      }
      for (int j = 1; j <= n2; j++) {
         R[j] = A[q + j];
      }
      L[n1 + 1] = Integer.MAX_VALUE;
      R[n2 + 1] = Integer.MAX_VALUE;
      int i = 1;
      int j = 1;
      for (int k = p; k <= r; k++) {
         if (L[i] <= R[j]) {
            A[k] = L[i];
            i = i + 1;
         } else {
            j = j + 1;
         }
      }
   
   }

}