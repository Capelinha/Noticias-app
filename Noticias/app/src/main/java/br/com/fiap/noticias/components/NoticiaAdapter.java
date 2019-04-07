package br.com.fiap.noticias.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.fiap.noticias.R;
import br.com.fiap.noticias.models.NoticiaModel;


public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaViewHolder> {

    ArrayList<NoticiaModel> lista;
    Context context;

    public NoticiaAdapter(Context context, ArrayList<NoticiaModel> lista) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NoticiaViewHolder(LayoutInflater.from(context).inflate(R.layout.noticia, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiaViewHolder noticiaViewHolder, int i) {
        NoticiaModel n = lista.get(i);

        Picasso.get().load(n.getUrlImg()).into(noticiaViewHolder.imagem);

        noticiaViewHolder.titulo.setText(n.getTitulo());
        noticiaViewHolder.subtitulo.setText(String.format("%s - %s", n.getFonte(), new SimpleDateFormat("dd MMM").format(n.getDataPublicacao())));
        noticiaViewHolder.texto.setText(n.getDescricao());
        noticiaViewHolder.url = n.getUrl();

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
