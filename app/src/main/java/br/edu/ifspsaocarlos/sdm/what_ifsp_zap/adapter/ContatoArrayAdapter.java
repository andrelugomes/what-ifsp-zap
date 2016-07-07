package br.edu.ifspsaocarlos.sdm.what_ifsp_zap.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.what_ifsp_zap.R;
import br.edu.ifspsaocarlos.sdm.what_ifsp_zap.model.Contato;

public class ContatoArrayAdapter extends ArrayAdapter<Contato> {
    private LayoutInflater inflater;

    public ContatoArrayAdapter(Activity activity, List<Contato> objects) {
        super(activity, R.layout.contato_celula, objects);
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //get view é chamado sempre que precisa mostrar. A ListView que o invoca
    //Recicla views para economizar memória.. de acordo com a capacidade de celulas na tela automaticamente
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //CUIDADO: Esse IF e ELSE evita a inflagem de views desnecessárias
        //convertView é o ContatoCelula
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contato_celula, null);
            holder = new ViewHolder();
            holder.idContato = (TextView) convertView.findViewById(R.id.idContato);
            holder.nome = (TextView) convertView.findViewById(R.id.nome);
            holder.apelido = (TextView) convertView.findViewById(R.id.apelido);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Contato c = getItem(position);
        holder.idContato.setText(c.getId().toString());
        holder.nome.setText(c.getNomeCompleto());
        holder.apelido.setText(c.getApelido());
        return convertView;
    }

    static class ViewHolder {
        public TextView idContato;
        public TextView nome;
        public TextView apelido;
    }
}
