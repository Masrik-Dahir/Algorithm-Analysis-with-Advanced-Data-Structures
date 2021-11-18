import java.util.Scanner;

public class cmsc401{
    static boolean Assign_course_to_room(boolean[][] check, int ind,
                                         boolean[] recognized, int[] size,
                                         int count_course, int count_room){
        for(int i = 0; i<count_room; i++){
            if(check[ind][i] && !recognized[i]){
                recognized[i] = true;
                if(size[i] < 0 || Assign_course_to_room(check, size[i], recognized, size, count_course, count_room)) {
                    size[i] = ind;
                    return true;
                }
            }
        }
        return false;
    }

    static int max_flow_match(boolean[][] check, int count_course, int count_room){
        int[] flow_recognized = new int[count_room];
        int increment = 0;
        for(int i = 0; i < count_room; i++){
            flow_recognized[i] = -1;
        }

        for(int i = 0; i < count_course; i++){
            boolean[] recognized = new boolean[count_room];
            for(int j = 0; j < count_room; j++){
                recognized[j] = false;
            }
            if(Assign_course_to_room(check,i,recognized,flow_recognized,count_course,count_room))
                increment++;
        }
        return increment;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int count_course = Integer.parseInt(input.nextLine());
        int count_room = Integer.parseInt(input.nextLine());
        boolean[][] check = new boolean[count_course][count_room];
        for(int i = 0; i < count_course; i++){
            Scanner room_and_course_input = new Scanner(input.nextLine());
            room_and_course_input.useDelimiter("H");
            room_and_course_input.next();
            while(room_and_course_input.hasNext()){
                int curr = Integer.parseInt(room_and_course_input.next().replaceAll("\\s+", ""));
                check[i][curr-1] = true;
            }
        }
        int answer = max_flow_match(check,count_course,count_room);
        System.out.println(answer);
    }
}
