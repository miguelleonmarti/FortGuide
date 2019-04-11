package es.ulpgc.miguel.fortguide.menu;


import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class MenuModel implements MenuContract.Model {

  public static String TAG = MenuModel.class.getSimpleName();

  private RepositoryContract repository;

  public MenuModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void fetchData(final RepositoryContract.GetServerStatusCallback callback) {
    // Log.e(TAG, "fetchData()");
    repository.loadServerStatus(new RepositoryContract.FetchServerStatusCallback() {
      @Override
      public void onServerStatusFetch(boolean error) {
        if (!error) {
          repository.getServerStatus(callback);
        }
      }
    });
  }
}
