import java.util.Scanner;

public class cmsc401{
    static boolean Assign_course_to_room(boolean[][] check, int ind,
                                         boolean[] recognized, int[] size,
                                         int count_C, int count_H){
        for(int i = 0; i<count_H; i++){
            if(check[ind][i] && !recognized[i]){
                recognized[i] = true;
                if(size[i] < 0 || Assign_course_to_room(check, size[i], recognized, size, count_C, count_H)) {
                    size[i] = ind;
                    return true;
                }
            }
        }
        return false;
    }

    static int max_flow_match(boolean[][] check, int count_C, int count_H){
        int[] flow_recognized = new int[count_H];
        int increment = 0;
        for(int i = 0; i < count_H; i++){
            flow_recognized[i] = -1;
        }

        for(int i = 0; i < count_C; i++){
            boolean[] recognized = new boolean[count_H];
            for(int j = 0; j < count_H; j++){
                recognized[j] = false;
            }
            if(Assign_course_to_room(check,i,recognized,flow_recognized,count_C,count_H))
                increment++;
        }
        return increment;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int count_C = Integer.parseInt(input.nextLine());
        int count_H = Integer.parseInt(input.nextLine());
        boolean[][] check = new boolean[count_C][count_H];
        for(int i = 0; i < count_C; i++){
            Scanner room_and_course_input = new Scanner(input.nextLine());
            room_and_course_input.useDelimiter("H");
            room_and_course_input.next();
            while(room_and_course_input.hasNext()){
                int curr = Integer.parseInt(room_and_course_input.next().replaceAll("\\s+", ""));
                check[i][curr-1] = true;
            }
        }
        int answer = max_flow_match(check,count_C,count_H);
        System.out.println(answer);
    }
}
