package PodcastDB;

import model.Podcast;

import java.util.List;

public interface PodcastDao {
   void addPodcast(Podcast podcast);
   Podcast getPodcast(int id);
   List<Podcast> getAllPodcast();
   void addAllPodcast(List<Podcast>podcastList);
}
