package PodcastDB;

import model.Podcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeDB implements PodcastDao {
    public static List<Podcast> PodcastList;

    public FakeDB() {
        if(PodcastList==null){
            PodcastList=new ArrayList<>();
        }
    }

    @Override
    public void addPodcast(Podcast p) {
        PodcastList.add(p);
    }

    @Override
    public Podcast getPodcast(int id) {
        int index = new Random().nextInt(PodcastList.size() - 1);
        if (index < 0) {
            index = 0;
        }
        return PodcastList.get(index);
    }

    @Override
    public List<Podcast> getAllPodcast() {
        return PodcastList;
    }

    @Override
    public void addAllPodcast(List<Podcast> podcastList) {
        PodcastList.addAll(podcastList);
    }
}
