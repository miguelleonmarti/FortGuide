package es.ulpgc.miguel.fortguide.challenge;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengeRepository implements RepositoryContract {

private static ChallengeRepository INSTANCE;

    private final List<ChallengeItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

public static  RepositoryContract getInstance(){
    if(INSTANCE == null){
        INSTANCE = new ChallengeRepository();
    }
    return INSTANCE;
}

    @Override
    public List<ChallengeItem> getChallengeList() {
        return null;
    }
}
