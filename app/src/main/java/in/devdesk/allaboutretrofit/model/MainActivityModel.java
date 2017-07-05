package in.devdesk.allaboutretrofit.model;

import java.util.List;

import in.devdesk.allaboutretrofit.presenter.MainActivityPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by richardandrews on 05/07/17.
 */

public class MainActivityModel implements ModelInterface.MainActivityModel {

    MainActivityPresenter mainActivityPresenter = new MainActivityPresenter();
    public List<GitHubRepo> responseList;


    @Override
    public void callGitHubApi(GitHubClient client) {

        Call<List<GitHubRepo>> call = client.reposForUsers("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                responseList = response.body();

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
        mainActivityPresenter.returnCallFromGitHubRepos(responseList);
    }
}
