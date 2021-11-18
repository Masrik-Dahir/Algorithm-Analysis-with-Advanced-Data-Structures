import java.util.Scanner;

public class cmsc401{

    //This function is placing courses in rooms. It checks if the course
    //can be in the room, and if the room is not already taken. If the room is
    //already taken, the function should check if the current occupier can move
    //to a different room. This can be recursive such that multiple rooms can
    //be swapped.
    static boolean Assign_course_to_room(boolean[][] big_bool, int course_index,
                                         boolean[] seenByCourse, int[] currMatch,
                                         int numCourses, int numRooms){
        for(int i = 0; i<numRooms; i++){
            if(big_bool[course_index][i] && !seenByCourse[i]){
                seenByCourse[i] = true;
                if(currMatch[i] < 0 || Assign_course_to_room(big_bool, currMatch[i], seenByCourse,
                        currMatch, numCourses, numRooms)) {
                    currMatch[i] = course_index;
                    return true;
                }
            }
        }
        return false;
    }

    //this function is kind of the controller of the place class function.
    //it iterates through each class and sends that class to the place place
    //class method. upon a successful place, the result is incremented.
    static int maxMatch(boolean[][] big_bool, int numCourses, int numRooms){
        int[] currMatch = new int[numRooms];
        int result = 0;
        for(int i = 0; i < numRooms; i++){
            currMatch[i] = -1;
        }

        for(int i = 0; i < numCourses; i++){
            boolean[] seenByCourse = new boolean[numRooms];
            for(int j = 0; j < numRooms; j++){
                seenByCourse[j] = false;
            }
            if(Assign_course_to_room(big_bool,i,seenByCourse,currMatch,numCourses,numRooms))
                result++;
        }
        return result;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string_Test;
        int numCourses = Integer.parseInt(sc.nextLine());
        int numRooms = Integer.parseInt(sc.nextLine());

        //auto-initialized to falses
        boolean[][] big_bool = new boolean[numCourses][numRooms];

        //this loop scans each line of the input and then scans that line again
        //after the first string "cx:" the loop begins reading in the hall values
        //and triggers the corresponding boolean flag to be changed
        for(int i = 0; i < numCourses; i++){
            Scanner sc_line_by = new Scanner(sc.nextLine());
            sc_line_by.useDelimiter("H");
            sc_line_by.next();
            while(sc_line_by.hasNext()){
                int curr = Integer.parseInt(sc_line_by.next().replaceAll("\\s+", ""));
                big_bool[i][curr-1] = true;
            }
        }

        System.out.println(maxMatch(big_bool,numCourses,numRooms));

    }
}
