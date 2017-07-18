package br.com.alura.agenda;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.com.alura.agenda.modelo.Prova;


public class DetalhesProvaFragment extends android.support.v4.app.Fragment {

    private TextView materia;
    private TextView data;
    private ListView topicos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhes_prova, container, false);

        materia = (TextView) view.findViewById(R.id.detalhes_prova_materia);
        data = (TextView) view.findViewById(R.id.detalhes_prova_data);
        topicos = (ListView) view.findViewById(R.id.detalhes_prova_topicos);

        Bundle bd = getArguments();
        if(bd != null) {
            Prova prova = (Prova) bd.getSerializable("prova");
            populaCampos(prova);
        }



        return view;
    }

    public void populaCampos(Prova prova) {
        materia.setText(prova.getMateria());
        data.setText(prova.getData());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, prova.getTopicos());
        topicos.setAdapter(adapter);

    }

}
