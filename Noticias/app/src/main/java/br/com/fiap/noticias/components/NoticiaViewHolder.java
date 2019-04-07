package br.com.fiap.noticias.components;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fiap.noticias.R;
import br.com.fiap.noticias.views.MainActivity;
import br.com.fiap.noticias.views.WebViewActivity;

public class NoticiaViewHolder extends RecyclerView.ViewHolder {

    ImageView imagem;
    TextView titulo;
    TextView subtitulo;
    TextView texto;
    CardView card;
    String url;

    public NoticiaViewHolder(View itemView) {
        super(itemView);

        imagem = itemView.findViewById(R.id.imagem);
        titulo = itemView.findViewById(R.id.titulo);
        subtitulo = itemView.findViewById(R.id.subtitulo);
        texto = itemView.findViewById(R.id.texto);
        card = itemView.findViewById(R.id.cardView);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl((Activity) v.getContext(), Uri.parse(url));

                //Intent i = new Intent(v.getContext(), WebViewActivity.class);
                //i.putExtra(WebViewActivity.WEBSITE_ADDRESS, url);
                //v.getContext().startActivity(i);
            }
        });

    }


}
