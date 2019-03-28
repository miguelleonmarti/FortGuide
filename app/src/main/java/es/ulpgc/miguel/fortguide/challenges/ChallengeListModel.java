package es.ulpgc.miguel.fortguide.challenges;

import android.util.Log;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengeListModel implements ChallengeListContract.Model {

    public static String TAG = ChallengeListModel.class.getSimpleName();

    private RepositoryContract repository;

    public ChallengeListModel(RepositoryContract repository) {
this.repository = repository;
    }

    @Override
    public List<ChallengeItem> fetchChallengeListData() {
         Log.e(TAG, "fetchChallengeListData()");
      return repository.getChallengeList();
    }
}
