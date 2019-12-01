package org.sid.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


import java.util.Map;
import java.util.Random;

public class HazelcastApplicationClient {

    public static void main(String[] args) {


        ClientConfig config = new ClientConfig();

        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(config);

        Map<Integer,String> data = hazelcastInstance.getMap("clients");



        System.out.println("Client 3 => "+data.get(3));
        System.out.println("Client 4 => "+data.get(4));
        System.out.println("Size=> "+data.size());
    }

}
