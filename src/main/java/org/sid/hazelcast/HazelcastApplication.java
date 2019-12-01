package org.sid.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HazelcastApplication {

    public static void main(String[] args) {

        Config config = new Config();

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        Map<Integer,String> data = null;

        Random random = new Random();

        /*for (int i = 1; i<1000; i++){

            int key = random.nextInt(1000000);
             data.put(key,"Client "+key);

        }*/




        while (true){

            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();

            /*
            *  map clients
            *  set 6 azerty
            *  get 6
            *  size
            * */

            String[] items = command.split(" ");
            if (items[0].equals("map")){
                hazelcastInstance.getMap(items[1]);
                System.out.println("map => "+items[1]);
            }
            else if(items[0].equals("get")){

                String s = data.get(Integer.parseInt(items[1]));
                System.out.println(items[1]+" => "+s);
            }
            else if(items[0].equals("set")){


                data.put(Integer.parseInt(items[1]),items[2]);
                System.out.println(items[1]+" => "+items[2]);
            }
        }


    }

}
