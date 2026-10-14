package shiyan3;
public class shiyanneiron1 {
    public static void main(String[] args) {
        double[] array = {9.6, 9.9, 64.2, -3.1, -8, 33.7, 42.1, -56, 2, 0};       
        System.out.println("The elements in this array are:");
        printArray(array);
        System.out.println();
        double max = array[0];
        double min = array[0];
        int maxPos = 0;
        int minPos = 0;
        int index = 0;
        
        for (double num : array) {
            if (num > max) {
                max = num;
                maxPos = index;
            }
            if (num < min) {
                min = num;
                minPos = index;
            }
            index++;
        }
        
        System.out.printf("The max value is %.1f in position %d\n", max, maxPos);
        System.out.printf("The min value is %.1f in position %d\n", min, minPos);
        
        selectionSortDescending(array);
        
        System.out.println("After sorting");
        printArray(array);
    }
    
    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.printf("%8.2f", num);
        }
        System.out.println();
    }
    
    public static void selectionSortDescending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] > arr[maxIndex]) 
                {
                    maxIndex = j;
                }
            }
            double temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}