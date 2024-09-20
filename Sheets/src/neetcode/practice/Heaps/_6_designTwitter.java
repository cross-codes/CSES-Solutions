package neetcode.practice.Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

class Twitter {
  private TreeMap<Integer, Integer> tweets;
  private HashMap<Integer, HashSet<Integer>> users;

  public Twitter() {
    this.tweets = new TreeMap<>();
    this.users = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    this.tweets.put(tweetId, userId);
  }

  public List<Integer> getNewsFeed(int userId) {
    ArrayList<Integer> res = new ArrayList<>();
    NavigableSet<Integer> tweetIds = this.tweets.descendingKeySet();
    for (Integer tweetId : tweetIds) {
      if (res.size() == 10) break;

      int tweetUserId = this.tweets.get(tweetId);
      HashSet<Integer> followers = this.users.get(tweetUserId);
      if ((followers != null && followers.contains(userId)) || tweetUserId == userId)
        res.add(tweetId);
    }
    return res;
  }

  public void follow(int followerId, int followeeId) {
    HashSet<Integer> followers;
    if (!this.users.containsKey(followeeId)) {
      followers = new HashSet<Integer>();
      this.users.put(followeeId, followers);
    } else followers = this.users.get(followeeId);
    followers.add(followerId);
  }

  public void unfollow(int followerId, int followeeId) {
    HashSet<Integer> followers = this.users.get(followeeId);
    followers.remove(followerId);
  }
}
