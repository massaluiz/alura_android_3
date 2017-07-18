package br.com.alura.agenda;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.modelo.Prova;

/**
 * Created by luiz.massa on 17/07/17.
 */

public class ListaProvaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_provas, container, false);

        List<String> topicosPort = Arrays.asList("Sujeito Direto", "Objeto Direto", "Objeto Indireto");
        Prova provaPortugues = new Prova("Portugês", "25/05/2016", topicosPort);

        List<String> topicosMate = Arrays.asList("Equações de Segundo Grau", "Trigonometria", "Logaritmo");
        Prova provaMatematica = new Prova("Matemática", "27/05/2016", topicosMate);

        List<Prova> provas = Arrays.asList(provaPortugues, provaMatematica);

        ArrayAdapter adpter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, provas);

        ListView lista = (ListView) view.findViewById(R.id.provas_lista);

        lista.setAdapter(adpter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Prova prova = (Prova) adapterView.getItemAtPosition(position);
                Toast.makeText(getContext(), "clicou na prova de " + prova, Toast.LENGTH_LONG).show();


                ProvasActivity provasActivity = (ProvasActivity) getActivity();
                provasActivity.selecioneProva(prova);

                //Intent goToDetail = new Intent(getContext(), DetalhesProvaActivity.class);
                //goToDetail.putExtra("prova", prova);
                //startActivity(goToDetail);
            }
        });



        return view;
    }
}
