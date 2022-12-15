import java.util.Scanner;

public class Praktika {

    static int[][] matrixCreate() {
        System.out.print("Введите кол-во строк: ");
        int n = inputInteger();

        System.out.print("Введите кол-во столбцов: ");
        int m = inputInteger();

        return new int[n][m];
    }

    static void fillMatrix(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("Введите значение:");
                a[i][j] = inputInteger();

            }
        }
    }

    static void printMatrix(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void transponirovanie(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }

        }

    }

    static int[][] sloshenie(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;


    }

    static int[][] vishitanie(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }


    static int[][] multiplication(int[][] a, int[][] b) {
        int m = a.length;
        int n = b[0].length;
        int o = b.length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {

                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    static boolean ravenstvo(int[][] a, int[][] b) {
        boolean count = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                if (a[i][j] == b[i][j]) {
                    count = false;
                    break;
                }
            }

        }
        return count;

    }



    static int[][] multiplication(int[][] a, int k) {
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                b[i][j] = a[i][j] * k;
            }
        }
        return b;
    }

    static int inputInteger(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true){
            try{
                number = scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Введите целое число ");
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int action = 0;
        do {

            System.out.println("1.Транспонирование матрицы А");
            System.out.println("2.Сложение матриц А и В");
            System.out.println("3.Вычитание матриц А и В");
            System.out.println("4.Умножение матриц А и В");
            System.out.println("5.Проверка равенства матриц А и В");
            System.out.println("6.Умножение всех элементов матрицы А на число х");
            System.out.println("0.Выход");
            try {
                action = inputInteger();
                if (action == 1 || action == 6) {

                    int[][] a = matrixCreate();
                    fillMatrix(a);
                    System.out.println("Исходная матрица принимает вид:");
                    printMatrix(a);
                    if (action == 1) {
                        System.out.println("Транспонированная матрица принимает вид: ");
                        transponirovanie(a);
                        printMatrix(a);
                    } else {

                        System.out.print("Введите число на которое хотите умножить: ");
                        int k = inputInteger();
                        System.out.println("Матрица, в которой все элементы умножены на число Х принимает вид: ");
                        int[][] c = multiplication(a, k);
                        printMatrix(c);

                    }

                } else if (action == 2 || action == 3 || action == 4 || action == 5) {
                    int[][] a = matrixCreate();
                    fillMatrix(a);
                    System.out.println("Матрица А принимает вид:");
                    printMatrix(a);
                    int[][] b = matrixCreate();
                    fillMatrix(b);
                    System.out.println("Матрица В принимает вид:");
                    printMatrix(b);

                    if (action == 2) {
                        if (a[0].length != b[0].length || a.length != b.length) {
                            System.out.print("Ошибка: Сложение матриц невозможно, т.к матрицы не одинаковой размерности ");
                        } else {
                            int[][] c = sloshenie(a, b);
                            System.out.println("Матрица сложения принимает вид:");
                            printMatrix(c);

                        }
                    } else if (action == 3) {
                        if (a[0].length != b[0].length || a.length != b.length) {
                            System.out.print("Ошибка: Вычитание матриц невозможно, т.к матрицы не одинаковой размерности ");
                        } else {
                            System.out.println("1.Вычисть матрицу В из матрицы А");
                            System.out.println("2.Вычисть матрицу А из матрицы В");
                            int key = inputInteger();
                            int[][] c;
                            if (key == 1) {
                                c = vishitanie(a, b);
                            } else {
                                c = vishitanie(b, a);
                            }
                            printMatrix(c);

                        }
                    } else if (action == 4) {
                        if (a[0].length != b.length || b[0].length != a.length) {
                            System.out.print("Ошибка: Умножение матриц невозможно, т.к число столбцов первого " +
                                    "множителя не равно числу строк второго ");
                        } else {

                            int[][] c = multiplication(a, b);
                            printMatrix(c);
                        }
                    } else {
                        if (a[0].length != b[0].length || a.length != b.length) {
                            System.out.print(" Матрицы не равны, т.к они не одинаковой размерности ");
                        } else {

                            if (ravenstvo(a, b)){
                                System.out.print(" Матрицы равны ");
                            }
                            else{
                                System.out.print(" Матрицы не равны ");
                            }
                        }
                    }
                }

            }
            catch (Exception exc) {
                System.out.println("Неверно введенные данные");
            }
        }
            while (action != 0) ;
        }
    }
