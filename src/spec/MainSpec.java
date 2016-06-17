package spec;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.*;

import com.rokkincat.Network;
import com.rokkincat.Person;

public class MainSpec {

  @Test
  public void friendCountA() throws IOException {
    int[] expectations = {5, 5, 4, 5, 5, 5, 3, 3, 1, 4};
    BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/test_files/a.in"));
    Network n = new Network(br);
    Person[] net = n.network;
    for(int i = 0; i < n.node_count; i++) {
      assertEquals(net[i].friend_count, expectations[i]);
    }
  }

  @Test
  public void mutualFriendCountA() throws IOException {
    int[][] expectations = new int[][] {
      {3, 1, 1, 1},
        {2, 1, 1},
        {2, 1},
        {2, 1, 1},
        {3, 2, 1, 2},
        {2, 1, 2, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {2, 1}
    };

    BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/test_files/a.in"));
    Network n = new Network(br);
    Person[] net = n.network;
    for(int i = 0; i < n.node_count; i++) {
      TreeMap<Integer, Integer> mutual_friends = net[i].countMutuals(n);
      int j = 0;
      for(Entry<Integer, Integer> entry : mutual_friends.entrySet()) {
        assertEquals((int)entry.getValue(), expectations[i][j]);
        j++;
      }
      System.out.println(i + " " + mutual_friends.toString());
    }

  }
}
