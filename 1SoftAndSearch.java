public class AllSortsAndSearches {

    // === 1. MinSorter (Selection Sort) ===
    public static class MinSorter {
        public static void runSort(int[] data) {
            for (int i = 0; i < data.length; i++) {
                int minPos = i;
                for (int j = i + 1; j < data.length; j++) {
                    if (data[j] < data[minPos]) {
                        minPos = j;
                    }
                }
                int hold = data[i];
                data[i] = data[minPos];
                data[minPos] = hold;
            }
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {77, 29, 51, 18, 93};
            System.out.print("Исходные данные: ");
            display(testArray);
            runSort(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 2. SwapSorter (Bubble Sort) ===
    public static class SwapSorter {
        public static void order(int[] data) {
            int size = data.length;
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        int hold = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = hold;
                    }
                }
            }
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {88, 42, 31, 15, 26, 13, 95};
            System.out.print("Исходные данные: ");
            display(testArray);
            order(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 3. InsertSorter (Insertion Sort) ===
    public static class InsertSorter {
        public static void arrange(int[] data) {
            for (int i = 1; i < data.length; i++) {
                int current = data[i];
                int prev = i - 1;
                while (prev >= 0 && data[prev] > current) {
                    data[prev + 1] = data[prev];
                    prev--;
                }
                data[prev + 1] = current;
            }
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {11, 6, 2, 9, 4};
            System.out.print("Исходные данные: ");
            display(testArray);
            arrange(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 4. CombineSorter (Merge Sort) ===
    public static class CombineSorter {
        public static void divideSort(int[] data) {
            if (data.length < 2) return;
            int mid = data.length / 2;
            int[] left = new int[mid];
            int[] right = new int[data.length - mid];

            System.arraycopy(data, 0, left, 0, mid);
            System.arraycopy(data, mid, right, 0, data.length - mid);

            divideSort(left);
            divideSort(right);
            join(data, left, right);
        }

        private static void join(int[] data, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    data[k++] = left[i++];
                } else {
                    data[k++] = right[j++];
                }
            }
            while (i < left.length) data[k++] = left[i++];
            while (j < right.length) data[k++] = right[j++];
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {61, 19, 85, 7, 14, 99, 33};
            System.out.print("Исходные данные: ");
            display(testArray);
            divideSort(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 5. GappedSorter (Shell Sort) ===
    public static class GappedSorter {
        public static void process(int[] data) {
            int n = data.length;
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i++) {
                    int temp = data[i];
                    int j = i;
                    while (j >= gap && data[j - gap] > temp) {
                        data[j] = data[j - gap];
                        j -= gap;
                    }
                    data[j] = temp;
                }
            }
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {55, 23, 3, 11, 72, 81, 4, 6};
            System.out.print("Исходные данные: ");
            display(testArray);
            process(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 6. TreeSorter (Heap Sort) ===
    public static class TreeSorter {
        public static void sort(int[] data) {
            int n = data.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(data, n, i);
            }
            for (int i = n - 1; i > 0; i--) {
                int temp = data[0];
                data[0] = data[i];
                data[i] = temp;
                heapify(data, i, 0);
            }
        }

        private static void heapify(int[] data, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && data[left] > data[largest]) largest = left;
            if (right < n && data[right] > data[largest]) largest = right;

            if (largest != i) {
                int temp = data[i];
                data[i] = data[largest];
                data[largest] = temp;
                heapify(data, n, largest);
            }
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {9, 22, 7, 13, 5};
            System.out.print("Исходные данные: ");
            display(testArray);
            sort(testArray);
            System.out.print("Отсортированные данные: ");
            display(testArray);
            System.out.println();
        }
    }

    // === 7. SequentialSearch (Linear Search) ===
    public static class SequentialSearch {
        public static int locate(int[] data, int target) {
            int index = 0;
            while (index < data.length) {
                if (data[index] == target) {
                    return index;
                }
                index++;
            }
            return -1;
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {4, 9, 16, 25, 33, 47, 66, 81};
            int target = 33;
            System.out.print("Исходные данные: ");
            display(testArray);
            int result = locate(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 100;
            result = locate(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 8. MidSearch (Binary Search) ===
    public static class MidSearch {
        public static int find(int[] data, int target) {
            int low = 0;
            int high = data.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (data[mid] == target) return mid;
                else if (data[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            return -1;
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {4, 11, 18, 26, 35, 51, 78, 93, 110, 135};
            int target = 51;
            System.out.print("Исходные данные: ");
            display(testArray);
            int result = find(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 9. EstimateSearch (Interpolation Search) ===
    public static class EstimateSearch {
        public static int predict(int[] data, int target) {
            int low = 0;
            int high = data.length - 1;

            while (low <= high && target >= data[low] && target <= data[high]) {
                if (low == high) {
                    if (data[low] == target) return low;
                    return -1;
                }

                int pos = low + (int)(((double)(target - data[low]) / (data[high] - data[low])) * (high - low));

                if (data[pos] == target) return pos;
                else if (data[pos] < target) low = pos + 1;
                else high = pos - 1;
            }
            return -1;
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {12, 24, 36, 48, 60, 72, 84, 96, 108, 120};
            int target = 72;
            System.out.print("Исходные данные: ");
            display(testArray);
            int result = predict(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 50;
            result = predict(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 10. FibSearcher (Fibonacci Search) ===
    public static class FibSearcher {
        public static int locate(int[] data, int target) {
            int n = data.length;
            int f2 = 0, f1 = 1, f = f2 + f1;

            while (f < n) {
                f2 = f1;
                f1 = f;
                f = f2 + f1;
            }

            int offset = -1;

            while (f > 1) {
                int i = Math.min(offset + f2, n - 1);

                if (data[i] < target) {
                    f = f1;
                    f1 = f2;
                    f2 = f - f1;
                    offset = i;
                } else if (data[i] > target) {
                    f = f2;
                    f1 = f1 - f2;
                    f2 = f - f1;
                } else {
                    return i;
                }
            }

            if (f1 == 1 && data[offset + 1] == target) return offset + 1;
            return -1;
        }

        public static void display(int[] data) {
            System.out.print("[");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if (i < data.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testArray = {15, 27, 39, 44, 51, 63, 88, 91, 97, 103, 115};
            int target = 97;
            System.out.print("Исходные данные: ");
            display(testArray);
            int result = locate(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 39;
            result = locate(testArray, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === Main для запуска всех классов ===
    public static void main(String[] args) {
        System.out.println("=== MinSorter (Selection Sort) ===");
        MinSorter.main(args);

        System.out.println("=== SwapSorter (Bubble Sort) ===");
        SwapSorter.main(args);

        System.out.println("=== InsertSorter (Insertion Sort) ===");
        InsertSorter.main(args);

        System.out.println("=== CombineSorter (Merge Sort) ===");
        CombineSorter.main(args);

        System.out.println("=== GappedSorter (Shell Sort) ===");
        GappedSorter.main(args);

        System.out.println("=== TreeSorter (Heap Sort) ===");
        TreeSorter.main(args);

        System.out.println("=== SequentialSearch (Linear Search) ===");
        SequentialSearch.main(args);

        System.out.println("=== MidSearch (Binary Search) ===");
        MidSearch.main(args);

        System.out.println("=== EstimateSearch (Interpolation Search) ===");
        EstimateSearch.main(args);

        System.out.println("=== FibSearcher (Fibonacci Search) ===");
        FibSearcher.main(args);
    }
}

=== MinSorter (Selection Sort) ===
Исходные данные: [77, 29, 51, 18, 93]
Отсортированные данные: [18, 29, 51, 77, 93]

=== SwapSorter (Bubble Sort) ===
Исходные данные: [88, 42, 31, 15, 26, 13, 95]
Отсортированные данные: [13, 15, 26, 31, 42, 88, 95]

=== InsertSorter (Insertion Sort) ===
Исходные данные: [11, 6, 2, 9, 4]
Отсортированные данные: [2, 4, 6, 9, 11]

=== CombineSorter (Merge Sort) ===
Исходные данные: [61, 19, 85, 7, 14, 99, 33]
Отсортированные данные: [7, 14, 19, 33, 61, 85, 99]

=== GappedSorter (Shell Sort) ===
Исходные данные: [55, 23, 3, 11, 72, 81, 4, 6]
Отсортированные данные: [3, 4, 6, 11, 23, 55, 72, 81]

=== TreeSorter (Heap Sort) ===
Исходные данные: [9, 22, 7, 13, 5]
Отсортированные данные: [5, 7, 9, 13, 22]

=== SequentialSearch (Linear Search) ===
Исходные данные: [4, 9, 16, 25, 33, 47, 66, 81]
Результат поиска: элемент 33 найден на позиции: 4
Результат поиска: элемент 100 найден на позиции: -1

=== MidSearch (Binary Search) ===
Исходные данные: [4, 11, 18, 26, 35, 51, 78, 93, 110, 135]
Результат поиска: элемент 51 найден на позиции: 5

=== EstimateSearch (Interpolation Search) ===
Исходные данные: [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]
Результат поиска: элемент 72 найден на позиции: 5
Результат поиска: элемент 50 найден на позиции: -1

=== FibSearcher (Fibonacci Search) ===
Исходные данные: [15, 27, 39, 44, 51, 63, 88, 91, 97, 103, 115]
Результат поиска: элемент 97 найден на позиции: 8
Результат поиска: элемент 39 найден на позиции: 2