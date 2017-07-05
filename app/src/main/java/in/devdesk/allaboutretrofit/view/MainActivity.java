package in.devdesk.allaboutretrofit.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import in.devdesk.allaboutretrofit.R;
import in.devdesk.allaboutretrofit.model.GitHubRepo;
import in.devdesk.allaboutretrofit.presenter.GitHubRepoAdapter;
import in.devdesk.allaboutretrofit.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements ViewInterface.MainActivityView{

    ListView listView;
    MainActivityPresenter mainActivityPresenter = new MainActivityPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.pagination_list);

        mainActivityPresenter.createCallForGitHubRepos();
    }

    @Override
    public void getAllGitHubRepos(List<GitHubRepo> responseList) {
        listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, responseList));
    }
}
