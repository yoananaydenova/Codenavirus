import java.util.*;

public class Codenavirus {
    public static int[] codenavirus(char[][] world, int[] firstInfected) {

        List<int[]> infected = new ArrayList<>();
        Map<int[], Integer> dataOfPeople = new TreeMap<>(Comparator.
                <int[]>comparingInt(key -> key[0]).thenComparingInt(key -> key[1]));

        int days = 0;
        // first infected
        infected.add(firstInfected);

        while (infected.size() > 0) {
            days++;
            // create and update record in MAP
            for (int i = 0; i < infected.size(); i++) {
                int[] infectedPerson = infected.get(i);
                // add 1 day of existing infected person
                if (dataOfPeople.containsKey(infectedPerson)) {
                    Integer dayOfDisease = dataOfPeople.get(infectedPerson);
                    dataOfPeople.put(infectedPerson, dayOfDisease + 1);
                } else {
                    // create infected person
                    dataOfPeople.putIfAbsent(infectedPerson, 1);
                    world[infectedPerson[0]][infectedPerson[1]] = 'I';
                }
            }

            infected.clear();

            // adding in list
            for (int[] person : dataOfPeople.keySet()) {
                Integer dayOfDisease = dataOfPeople.get(person);
                if (dayOfDisease < 3) {
                    infected.add(person);
                    int[] validNext = getValidNext(world, person[0], person[1]);
                    if (!infected.contains(validNext) && validNext != null) {
                        infected.add(validNext);
                    }
                } else {
                    dataOfPeople.put(person, dayOfDisease + 1);
                    if (dayOfDisease == 4) {
                        world[person[0]][person[1]] = 'R';
                    }
                }

            }

            if (infected.size() == 1 && dataOfPeople.get(infected.get(0)) == 2) {
                break;
            }

        }

        int infectedPeople = countChar(world, 'I');
        int recoveredPeople = countChar(world, 'R');
        int uninfectedPeople = countChar(world, '#');
        return new int[]{days, infectedPeople, recoveredPeople, uninfectedPeople};
    }

    private static int countChar(char[][] mat, char symbol) {
        int result = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                if (mat[r][c] == symbol) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isInBounds(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[] getValidNext(char[][] matrix, int row, int col) {
        int[] next = null;

        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] == '#') {
            next = new int[]{row, col + 1};
        } else if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] == '#') {
            next = new int[]{row - 1, col};
        } else if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] == '#') {
            next = new int[]{row, col - 1};
        } else if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] == '#') {
            next = new int[]{row + 1, col};
        }
        return next;
    }

    public static void main(String[] args) {
        char[][] world = {{'#', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'}};
        int[] firstInfected = {1, 1};

        int[] result = codenavirus(world, firstInfected);
    }
}
