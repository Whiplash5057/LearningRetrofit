package in.devdesk.allaboutretrofit.presenter;

import java.util.List;

import in.devdesk.allaboutretrofit.model.GitHubRepo;

/**
 * Created by richardandrews on 05/07/17.
 */

public interface ViewPresenter {

    public interface MainActivityView{
        public void returnCallFromGitHubRepos(List<GitHubRepo> responseList);
    }
}
