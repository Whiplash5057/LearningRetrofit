package in.devdesk.allaboutretrofit.presenter;

import java.util.List;

import in.devdesk.allaboutretrofit.model.GitHubClient;
import in.devdesk.allaboutretrofit.model.GitHubRepo;
import in.devdesk.allaboutretrofit.model.MainActivityModel;
import in.devdesk.allaboutretrofit.view.MainActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static in.devdesk.allaboutretrofit.Utils.Const.BASE_URL_GITHUB;

/**
 * Created by richardandrews on 05/07/17.
 */

public class MainActivityPresenter implements ModelPresenter.MainActivityModel, ViewPresenter.MainActivityView{

    MainActivityModel mainActivityModel = new MainActivityModel();
    MainActivity mainActivity = new MainActivity();

    @Override
    public void createCallForGitHubRepos() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL_GITHUB)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);

        mainActivityModel.callGitHubApi(client);
    }

    @Override
    public void returnCallFromGitHubRepos(List<GitHubRepo> responseList) {
        mainActivity.getAllGitHubRepos(responseList);
    }
}
