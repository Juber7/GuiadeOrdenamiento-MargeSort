public class App {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("---Arreglo ordenado---");
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // tamaño de los subarreglos a fusionar
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // arreglos temporales para almacenar los subarreglos
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        // copia los datos a arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        // fusiona los arreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; // índice inicial para el arreglo fusionado

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        // copia elementos restantes de tempLeft[] si los hay
        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        //copia elementos restantes de tempRight[] si los hay 
        while (j < sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // encuentra el punto medio del arreglo
            int mid = (left + right) / 2;

            // ordena recursivamente la mitad de la izquierda
            mergeSort(arr, left, mid);
            // ordena recursivamente la mitad de la derecha
            mergeSort(arr, mid + 1, right);

            // combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }
}