package in.devdesk.allaboutretrofit.view;

import java.util.List;

import in.devdesk.allaboutretrofit.model.GitHubRepo;

/**
 * Created by richardandrews on 05/07/17.
 */

public interface ViewInterface {

    public interface MainActivityView
    {
        public void getAllGitHubRepos(List<GitHubRepo> responseList);
    }
}
