package es.ulpgc.miguel.fortguide.challenge;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeAbstract;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengeRepository implements RepositoryContract {

    private static ChallengeRepository INSTANCE;

    private final List<ChallengeItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public static RepositoryContract getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChallengeRepository();
        }
        return INSTANCE;
    }


    private ChallengeRepository() {
        //Add some objects.
        for (int index = 1; index <= COUNT; index++) {
            addChallenge(createChallenge(index));
        }
    }

    @Override
    public List<ChallengeItem> getChallengeList(int id) {
        for (int index = 1; index <= COUNT; index++) {
            ChallengeItem item = itemList.get(index - 1);

            if (item.id == id) {
                return item.items;
            }
        }
        return new ArrayList<>();
    }


    @Override
    public List<ChallengeItem> getChallengeList() {
        return itemList;
    }


    private void addChallenge(ChallengeItem item) {
        itemList.add(item);
    }


    private ChallengeItem createChallenge( int position) {
        String content = "Semana " + position;

        return new ChallengeItem(
                position, content);
    }
    }

