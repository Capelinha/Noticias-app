package br.com.fiap.noticias.views;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.noticias.R;
import br.com.fiap.noticias.components.NoticiaAdapter;
import br.com.fiap.noticias.models.NoticiaModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;
    NoticiaAdapter adapter;
    ArrayList<NoticiaModel> itensN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        itensN = new ArrayList<>();

        NewsApiClient newsApiClient = new NewsApiClient("b87bf755168047a981f361ad11b5c250");

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .category("technology")
                        .pageSize(50)
                        .country("br")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {

                    @Override
                    public void onSuccess(ArticleResponse response) {
                        itensN.addAll(parse(response.getArticles()));
                        adapter.notifyDataSetChanged();
                    }

                    public List<NoticiaModel> parse(List<Article> lista) {
                        List<NoticiaModel> parsed = new ArrayList<>();
                        for(Article a : lista){
                            try {
                                parsed.add(new NoticiaModel(a.getAuthor(), a.getTitle(), a.getDescription(), a.getUrl(), a.getUrlToImage(), new SimpleDateFormat("yyyy-MM-dd'T'k:mm:ss'Z'").parse(a.getPublishedAt()), a.getSource().getName()));
                            } catch (ParseException e) {
                                Log.e("ERRO", e.toString());
                            }
                        }

                        return parsed;
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.e("ERRO", throwable.getMessage());
                    }
                }
        );

        adapter = new NoticiaAdapter(MainActivity.this, itensN);

        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                itensN.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                adapter.notifyItemRangeChanged(viewHolder.getAdapterPosition(), itensN.size());
            }
        });

        itemTouchHelper.attachToRecyclerView(lista);

    }
}
