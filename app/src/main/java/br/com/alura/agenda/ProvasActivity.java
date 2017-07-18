package br.com.alura.agenda;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.alura.agenda.modelo.Prova;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_provas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();
        tx.replace(R.id.frame_principal, new ListaProvaFragment());
        if(isaBoolean()) {
            tx.replace(R.id.frame_secundario, new DetalhesProvaFragment());
        }
        tx.commit();

    }

    private boolean isaBoolean() {
        return getResources().getBoolean(R.bool.modoPaisagem);
    }

    public void selecioneProva(Prova prova) {
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        if(isaBoolean()) {
            DetalhesProvaFragment detalhesFragment = (DetalhesProvaFragment) fragmentManager2.findFragmentById(R.id.frame_secundario);
            detalhesFragment.populaCampos(prova);
        } else {
            FragmentTransaction tx = fragmentManager2.beginTransaction();
            DetalhesProvaFragment detalhesFragment = new DetalhesProvaFragment();
            Bundle bd = new Bundle();
            bd.putSerializable("prova", prova);
            detalhesFragment.setArguments(bd);

            tx.replace(R.id.frame_principal, detalhesFragment);
            tx.addToBackStack(null);
            tx.commit();
        }
    }
}
