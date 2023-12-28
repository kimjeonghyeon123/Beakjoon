package 문제;

import java.util.*;

public class 리눅스 {
    public static void main(String[] args) {
        String[] directory = {
                "/",
                "/hello",
                "/hello/tmp",
                "/root",
                "/root/abcd",
                "/root/abcd/etc",
                "/root/abcd/hello"
        };
        String[] command = {
                "mkdir /root/tmp",
                "cp /hello /root/tmp",
                "rm /hello"
        };

        Set<String> set = new HashSet<>();
        for(String d : directory) {
            set.add(d);
        }

        for(int i = 0; i < command.length; i++) {
            String[] tokens = command[i].split(" ");
            String operation = tokens[0];
            String source = tokens[1];
            String destination = null;

            if(operation.equals("mkdir")) {
                set.add(source);
            }
            else if(operation.equals("rm")) {
                set.remove(source);
            }
            else if(operation.equals("cp")) {
                destination = tokens[2];

                for(String d : set) {
                    if(d.startsWith(source)) {
                        String s = d.substring(source.length());
                        set.add(destination + s);
                    }
                }
            }
        }
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr);


    }
}
